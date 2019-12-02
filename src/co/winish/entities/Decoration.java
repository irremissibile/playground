package co.winish.entities;

public class Decoration extends Item {
    private String name;


    public Decoration(double price, String name) {
        //this.price = price;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
