package co.winish.model;

import co.winish.entities.Bouquet;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Bouquet> availableBouquets;

    public Model() {
        availableBouquets = new ArrayList<>();
    }
    public Model(List<Bouquet> bouquets) {
        this.availableBouquets = bouquets;
    }


    public List<Bouquet> getAvailableBouquets() {
        return availableBouquets;
    }

    public Bouquet getBouquet(int bouqueIndex) {
        return availableBouquets.get(bouqueIndex);
    }

    public void addBouquet(Bouquet bouquet) {
        availableBouquets.add(bouquet);
    }



    /*public void addItemToBouquet(Item item, int bouquetIndex) {
        availableBouquets.get(bouquetIndex).addItem(item);
    }

    public void sortBouquet(int bouquetIndex) {
        availableBouquets.get(bouquetIndex).sort();
    }

    public Flower getFlowerByLength(int bouquetIndex, double min, double max) {
        return availableBouquets.get(bouquetIndex).getFlower(min, max);
    }*/
}
