package co.winish.controller;

import co.winish.model.Model;
import co.winish.view.View;
import co.winish.entities.Bouquet;
import co.winish.entities.Decoration;
import co.winish.entities.Flower;
import co.winish.entities.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements Controlable {
    private Model model;
    private View view;
    private Scanner scn = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    @Override
    public void process() {
        view.printMessage("!!!");
        int answer = getIntAnswer("Input:  1 to see available bouquets 2 to sort particular bouquet  3 to filter flowers in a bouquet 4 to create new bouquet",
                1, 4);

        switch (answer) {
            case 1:
                showBouquets();
                break;
            case 2:
                sortBouquet();
                break;
            case 3:
                filterFlowers();
                break;
            case 4:
                createBouquet();
                break;
        }

        answer = getIntAnswer("Wanna start again?\nInput 1", 1,1);
        if(answer == 1)
            process();
    }


    private void showBouquets() {
        List<Bouquet> bouquets = model.getAvailableBouquets();
        if (!bouquets.isEmpty()) {
            view.printMessage("The list of available bouquets:\n");
            bouquets.stream()
                    .forEach(b -> view.printMessage(bouquets.indexOf(b) + b.toString()));
        } else {
            view.printMessage("There's no available bouquets");
        }
    }

    private void sortBouquet() {
        List<Bouquet> bouquets = model.getAvailableBouquets();
        if (!bouquets.isEmpty()) {
            int index = getIntAnswer("Which one do you want to sort?", 0, bouquets.size());
            bouquets.get(index).sort();
        } else {
            view.printMessage("There's no available bouquets");
        }
    }

    private void filterFlowers() {
        List<Bouquet> bouquets = model.getAvailableBouquets();
        if (!bouquets.isEmpty()) {
            int index = getIntAnswer("Which one do you want to filter?", 0, bouquets.size());
            double[] interval = getDoubleInterval("Input interval", "Input first", "Input second");
            //bouquets.get(index).filterFlowersByLength(interval[0], interval[1]);
            List<Flower> filteredFlowers = bouquets.get(index).filterFlowersByLength(interval[0], interval[1]);
            view.printMessage(filteredFlowers.toString());
        }
    }

    private void createBouquet() {
        view.printMessage("Creating new bouque");
        List<Item> items = new ArrayList<>();
        items.add(createItem());

        int answer = getIntAnswer("Do you want to add another Item to bouque?\nInput 1", 1, 1);
        if (answer == 1)
            items.add(createItem());

        view.printMessage("Bouque has been created");
        model.getAvailableBouquets().add(new Bouquet(items));
    }


    private Item createItem() {
        int answer = getIntAnswer("Input:\n1 to create new Flower \n2 to create new Decoration", 1, 2);
        Item item;
        if (answer == 1) {
            view.printMessage("Creating new Flower");
            double price = getDoubleAnswer("Input price", 0.0, Double.POSITIVE_INFINITY);
            String name = getStringAnswer("Input name");
            double length = getDoubleAnswer("Input length", 0.0, Double.POSITIVE_INFINITY);
            int daysOld = getIntAnswer("Input daysOld (1, 4)", 1, 4);

            item = new Flower(price, name, length, Flower.Freshness.values()[daysOld]);
        } else {
            view.printMessage("Creating new Decoration");
            double price = getDoubleAnswer("Input price" , 0.0, Double.POSITIVE_INFINITY);
            String name = getStringAnswer("Input name");

            item = new Decoration(price, name);
        }
        return item;
    }


    private int getIntAnswer(String message, int min, int max) {
        int answer = 0;
        view.printMessage(message);
        while (true) {
            while (!scn.hasNextInt()) {
                view.printMessage("Input was not recognised");
                view.printMessage(message);
                scn.next();
            }

            if ((answer = scn.nextInt()) < min || answer > max) {
                view.printMessage("Input was not recognised");
                view.printMessage(message);
                continue;
            }
            break;
        }
        return answer;
    }


    private double getDoubleAnswer(String message, double min, double max) {
        double answer = 0;
        view.printMessage(message);
        while (true) {
            while (!scn.hasNextDouble()) {
                view.printMessage("Input was not recognised");
                view.printMessage(message);
                scn.next();
            }

            if ((answer = scn.nextDouble()) < min || answer > max) {
                view.printMessage("Input was not recognised");
                view.printMessage(message);
                continue;
            }
            break;
        }
        return answer;
    }


    private String getStringAnswer(String message) {
        view.printMessage(message);
        return scn.next();
    }


    private double[] getDoubleInterval(String message, String first, String second) {
        double[] answer = new double[2];
        view.printMessage(message);
        view.printMessage(first);
        while (true) {
            while (!scn.hasNextDouble()) {
                view.printMessage("Input was not recognised");
                view.printMessage(first);
                scn.next();
            }
            answer[0] = scn.nextDouble();
            break;
        }

        view.printMessage(second);
        while (true) {
            while (!scn.hasNextDouble()) {
                view.printMessage("Input was not recognised");
                view.printMessage(second);
                scn.next();
            }
            double input;
            if ((input = scn.nextDouble()) < answer[0]) {
                view.printMessage("Input was not recognised");
                view.printMessage(second);
            }
            answer[1] = scn.nextDouble();
            break;
        }
        return answer;
    }


}
