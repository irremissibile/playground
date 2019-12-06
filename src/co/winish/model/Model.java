package co.winish.model;

import co.winish.entities.Bouquet;
import co.winish.entities.Flower;

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

    public boolean isEmpty() {
        return availableBouquets.isEmpty();
    }

    public int getSize() {
        return availableBouquets.size();
    }

    public void sortBouque(int index) {
        availableBouquets.get(index).sort();
    }

    public void addBouquet(Bouquet bouquet) {
        availableBouquets.add(bouquet);
    }

    public List<Flower> filterFlowers(int bouqueIndex, double minLength, double maxLength) {
        return availableBouquets.get(bouqueIndex).filterFlowersByLength(minLength, maxLength);
    }
}
