package model;

import java.io.*;
import java.util.*;

public class Climate {
    private String currentCondition;
    private static final String[] CONDITIONS = {"Благоприятный климат",
            "Засушливый климат", "Климат высокой влажности"};
    private Random random = new Random();

    public Climate() {
        this.currentCondition = "Благоприятный климат";
    }

    public void updateClimate(List<Species> speciesList) {
        int conditionIndex = random.nextInt(CONDITIONS.length);
        currentCondition = CONDITIONS[conditionIndex];
        System.out.println("Климатические условия изменились на: " + currentCondition);

        switch (currentCondition) {
            case "Засушливый климат":
                for (Species species : speciesList) {
                    if (species instanceof Plant) {
                        int decrease = Math.min(species.getPopulation(), 20);
                        species.changePopulation(-decrease);
                        logEffect("Засуха привела к гибели растений. "
                                + species.getName() + " популяция уменьшена.");
                    }
                }
                break;
            case "Климат высокой влажности":
                for (Species species : speciesList) {
                    if (species instanceof Carnivore || species instanceof Omnivore) {
                        species.setCanFindFood(false);
                        logEffect("Высокая влажность: " + species.getName()
                                + " теряет энергию и меньше находит пищи.\n");
                    }
                    if (species instanceof Plant) {
                        int increase = Math.min(species.getPopulation(), 10);
                        species.changePopulation(increase);
                        logEffect("Высокая влажность: " + species.getName()
                                + " получает прирост к популяции на " + increase + ".\n");
                    }
                }
                break;
            default:
                for (Species species : speciesList) {
                    species.setCanFindFood(true);
                }
                break;
        }
        logClimateChange();
    }

    private void logClimateChange() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ecosystem_log.txt", true))) {
            writer.write("Изменение климата: текущее состояние - " + currentCondition + "\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог-файл: " + e.getMessage());
        }
    }

    private void logEffect(String effectMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ecosystem_log.txt", true))) {
            writer.write(effectMessage + "\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог-файл: " + e.getMessage());
        }
    }
    public String getCurrentCondition() {
        return currentCondition;
    }
}