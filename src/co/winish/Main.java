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
        Model model = new Model();
        Controller controller = new Controller(model, new View());

        Flower f1 = new Flower(1.5, "tyulpan", 20, Flower.Freshness.AWESOME);
        Flower f2 = new Flower(2.5, "tyulpan2", 25, Flower.Freshness.AWESOME);
        Flower f3 = new Flower(1.5, "tyulpan3", 20, Flower.Freshness.BAD);
        Flower f4 = new Flower(1.5, "tyulpan4", 20, Flower.Freshness.NOTBAD);
        Flower f5 = new Flower(10.0, "tyulpan5", 100, Flower.Freshness.GOOD);
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
        l2.add(f3);
        l2.add(w1);
        l2.add(d1);
        l2.add(f4);
        Bouquet b1 = new Bouquet(l1);
        Bouquet b2 = new Bouquet(l2);
        model.addBouquet(b1);
        model.addBouquet(b2);

        controller.process();
    }
}
