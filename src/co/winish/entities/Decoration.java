package co.winish.entities;

public class Decoration extends Item {
    private String name;


    public Decoration(double price, String name) {
        super(price);
        this.name = name;
    }


    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Decoration: " + name + " (" + price + ")";
    }
}
