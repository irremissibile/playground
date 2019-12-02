package co.winish.entities;

public abstract class Item {
    protected double price;

    public Item(double price) {
        this.price = price;
    }

    /*public void setPrice(double price) {
        this.price = price;
    }*/

    /*public double getPrice() {
        return price;
    }*/

    public abstract double getPrice();
    public abstract void setPrice(double price);
}
