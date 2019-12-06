package co.winish.controller;

import co.winish.model.Model;
import co.winish.view.View;
import co.winish.entities.Bouquet;
import co.winish.entities.Flower;

import java.util.List;
import java.util.Scanner;

import static co.winish.view.TextConstant.*;

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
        while(true) {
            view.printMessage(View.bundle.getString(INPUT));
            int answer = getIntAnswer(View.bundle.getString(OPTIONS), 1, 4);

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
                default:
                    view.printMessage(View.bundle.getString(BAD_INPUT));
            }
        }
    }


    private void showBouquets() {
        if(!model.isEmpty()) {
            List<Bouquet> bouquets = model.getAvailableBouquets();
            view.printMessage(View.bundle.getString(LIST_AVAILABLE));
            bouquets.stream()
                    .forEach(b -> view.printMessage(bouquets.indexOf(b) + b.toString()));
        } else
            view.printMessage(View.bundle.getString(NO_AVAILABLE));
    }

    private void sortBouquet() {
        if(!model.isEmpty()) {
            int index = getIntAnswer(View.bundle.getString(CHOOSE_SORT), 0, model.getSize());
            model.sortBouque(index);
        } else
            view.printMessage(View.bundle.getString(NO_AVAILABLE));
    }

    private void filterFlowers() {
        if(!model.isEmpty()) {
            int index = getIntAnswer(View.bundle.getString(CHOOSE_FILTER), 0, model.getSize());
            double[] interval = getDoubleInterval(View.bundle.getString(INTERVAL), View.bundle.getString(FIRST), View.bundle.getString(SECOND));

            List<Flower> filteredFlowers = model.filterFlowers(index, interval[0], interval[1]);
            view.printMessage(filteredFlowers.toString());
        } else
            view.printMessage(View.bundle.getString(NO_AVAILABLE));
    }


    private int getIntAnswer(String message, int min, int max) {
        int answer = 0;
        view.printMessage(message);
        while (true) {
            while (!scn.hasNextInt()) {
                view.printMessage(View.bundle.getString(BAD_INPUT));
                view.printMessage(message);
                scn.next();
            }

            if ((answer = scn.nextInt()) < min || answer > max) {
                view.printMessage(View.bundle.getString(BAD_INPUT));
                view.printMessage(message);
                continue;
            }
            break;
        }
        return answer;
    }

    private double[] getDoubleInterval(String message, String first, String second) {
        double[] answer = new double[2];
        view.printMessage(message);
        view.printMessage(first);
        while (true) {
            while (!scn.hasNextDouble()) {
                view.printMessage(View.bundle.getString(BAD_INPUT));
                view.printMessage(first);
                scn.next();
            }
            answer[0] = scn.nextDouble();
            break;
        }

        view.printMessage(second);
        while (true) {
            while (!scn.hasNextDouble()) {
                view.printMessage(View.bundle.getString(BAD_INPUT));
                view.printMessage(second);
                scn.next();
            }
            double input;
            if ((input = scn.nextDouble()) < answer[0]) {
                view.printMessage(View.bundle.getString(BAD_INPUT));
                view.printMessage(second);
            }
            answer[1] = input;
            break;
        }
        return answer;
    }
}
