package co.winish;

import co.winish.controller.Controller;
import co.winish.entities.Bouquet;
import co.winish.entities.Decoration;
import co.winish.entities.Flower;
import co.winish.entities.Item;
import co.winish.model.Model;
import co.winish.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Adding some stuff to our "flower shop"
        Flower f0 = new Flower(4.0, "Pink tulip", 25, Flower.Freshness.BAD);
        Flower f1 = new Flower(3.5, "Yellow tulip", 20, Flower.Freshness.NOTBAD);
        Flower f2 = new Flower(7.5, "Red rose", 45, Flower.Freshness.GOOD);
        Flower f3 = new Flower(9.5, "Black rose", 40, Flower.Freshness.AWESOME);
        Flower f4 = new Flower(10.5, "White orchid", 30, Flower.Freshness.GOOD);
        Flower f5 = new Flower(13.3, "Black orchid", 30, Flower.Freshness.AWESOME);
        Decoration w1 = new Decoration(5.4, "wrap1");
        Decoration w2 = new Decoration(7.8, "wrap2");
        Decoration d1 = new Decoration(3.2, "decoration1");
        Decoration d2 = new Decoration(4.2, "decoration2");

        List<Item> l1 = new ArrayList<>();
        l1.add(f1);
        l1.add(f2);
        l1.add(w2);
        l1.add(d2);
        l1.add(f5);
        List<Item> l2 = new ArrayList<>();
        l2.add(f0);
        l2.add(f3);
        l2.add(w1);
        l2.add(d1);
        l2.add(f4);
        List<Bouquet> bouquetList = new ArrayList<>();
        bouquetList.add(new Bouquet(l1));
        bouquetList.add(new Bouquet(l2));
        //********************************


        Model model = new Model(bouquetList);
        Controller controller = new Controller(model, new View());
        controller.process();
    }
}
