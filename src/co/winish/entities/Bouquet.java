package co.winish.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bouque is one of the core entities of our flower shop
 * @author self_affected
 */



public class Bouquet {
    private List<Item> items;
    private double price;


    public Bouquet() {
        items = new ArrayList<>();
    }

    /**
     * Parameterized constructor
     * @param bouquet List of Item's to store in a bouquet
     */
    public Bouquet(List<Item> bouquet) {
        this.items = bouquet;
        this.price = bouquet.stream()
                            .mapToDouble(item -> item.getPrice())
                            .sum();
    }



    @Override
    public String toString() {
        return "  price: " + price + items.toString();
    }

    /**
     * Sort a particular bouquet by Freshness
     */
    public void sort() {
        items = items.stream()
                     .sorted(Comparator.comparingInt(Bouquet::calcFreshness))
                     .collect(Collectors.toList());
    }

    /**
     * Firstly, filters only Flowers from Bouquet
     * Secondly, filters Flowers by length
     * @param min minimum length
     * @param max maximum length
     * @return List of filtered Flowers from a Bouquet
     */
    public List<Flower> filterFlowersByLength(double min, double max) {
        return items.stream()
                    .filter(item -> item instanceof Flower)
                    .map(item -> (Flower)item)
                    .filter(flower -> flower.getLength() >= min && flower.getLength() <= max)
                    .collect(Collectors.toList());
    }

    /**
     * Calculates an int representing Freshness
     * If the Item is not a Flower, returns 0
     * @param item Item which Freshness is needed to be calculated
     * @return int
     */
    private static int calcFreshness(Item item) {
        if(item instanceof Flower) {
            return ((Flower)item).getFreshness();
        } else {
            return 0;
        }
    }

    /**
     * Method from past implementations
     * @deprecated
     * @param min minimum length
     * @param max maximum length
     * @return returns the first Flower
     */
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

    public void addItem(Item item) {
        items.add(item);
        price += item.getPrice();
    }

    public void removeItem(int itemIndex) {
        items.remove(itemIndex);
    }
}
