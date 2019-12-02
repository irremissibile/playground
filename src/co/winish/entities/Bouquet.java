package co.winish.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bouquet {
    private List<Item> items;
    private double price;


    public Bouquet() {
        items = new ArrayList<>();
    }

    public Bouquet(List<Item> bouquet) {
        this.items = bouquet;
        this.price = bouquet.stream()
                            .mapToDouble(item -> item.getPrice())
                            .sum();
    }



    public void addItem(Item item) {
        items.add(item);
        price += item.getPrice();
    }

    public void removeItem(int itemIndex) {
        items.remove(itemIndex);
    }



    public void sort() {
        items = items.stream()
                         .sorted(Comparator.comparingInt(Bouquet::calcFreshness))
                         .collect(Collectors.toList());
    }

    private static int calcFreshness(Item item) {
        if(item instanceof Flower) {
            return ((Flower)item).getFreshness();
        } else {
            return 0;
        }
    }



    public List<Flower> filterFlowersByLength(double min, double max) {
        return items.stream()
                    .filter(item -> item instanceof Flower)
                    .map(item -> (Flower)item)
                    .filter(flower -> flower.getLength() >= min && flower.getLength() <= max)
                    .collect(Collectors.toList());
    }


    public Flower getFlower(double min, double max) {
        return (Flower) items.stream()
                .filter(item -> item instanceof Flower)
                .filter(flower -> ((Flower)flower).getLength() >= min)
                .filter(flower -> ((Flower)flower).getLength() <= max)
                .findFirst()
                .get();
    }



    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "  price: " + price + items.toString();
    }
}
