package co.winish.entities;

public class Flower extends Item {
    private String name;
    private double length;
    private Freshness freshness;


    public Flower(double price, String name, double length, Freshness freshness) {
        super(price);
        this.name = name;
        this.length = length;
        this.freshness = freshness;
    }



    @Override
    public double getPrice() {
        return super.price;
    }

    @Override
    public void setPrice(double price) {
        super.price = price;
    }

    @Override
    public String toString() {
        return "Flower: " + name + freshness.toString();
    }

    public double getLength() {
        return length;
    }

    public int getFreshness() {
        return freshness.daysOld();
    }


    public enum Freshness {
        BAD     (4),
        NOTBAD  (3),
        GOOD    (2),
        AWESOME (1);

        private final int daysOld;

        Freshness(int daysOld) {
            this.daysOld = daysOld;
        }

        int daysOld() {
            return daysOld;
        }

        @Override
        public String toString() {
            return " is " + daysOld + " days old";
        }
    }


}
