package model;

import java.io.*;
import java.util.*;

public class Ecosystem {
    private List<Species> speciesList;
    private Climate climate;
    private Random random = new Random();

    private String[] plantNames = {"Овес", "Черника", "Клубника", "Клюква"};
    private String[] herbivoreNames = {"Олень", "Антилопа", "Газель", "Лань"};
    private String[] carnivoreNames = {"Лев", "Тигр", "Волк", "Ягуар"};
    private String[] omnivoreNames = {"Медведь", "Енот", "Кабан", "Шимпанзе"};

    public Ecosystem(List<Species> speciesList) {
        this.speciesList = speciesList;
        this.climate = new Climate();
    }

    public List<Species> getSpeciesList() {
        return speciesList;
    }

    public void simulateDay() {
        climate.updateClimate(speciesList);

        checkForExtinctionAndMigrate();

        for (Species predator : speciesList) {
            for (Species prey : speciesList) {
                if (predator != prey) {
                    if (predator.isCanFindFood()) {
                        predator.consume(prey);
                    }
                    else {
                        predator.changeEnergy(-10);
                    }
                }
            }
        }
        convertEnergyToPopulation();
    }

    private void checkForExtinctionAndMigrate() {
        List<Species> newMigrations = new ArrayList<>();

        speciesList.removeIf(species -> {
            if (species.getPopulation() <= 0) {
                Species migratingSpecies = createMigratingSpecies(species);
                if (migratingSpecies != null) {
                    newMigrations.add(migratingSpecies);
                    logToFile("Вид " + species.getName() + " вымер. Миграция нового вида: " + migratingSpecies.getName());
                }
                return true;
            }
            return false;
        });
        speciesList.addAll(newMigrations);
    }

    private Species createMigratingSpecies(Species extinctSpecies) {
        String name;
        int initialPopulation;
        int initialEnergy;

        if (extinctSpecies instanceof Plant) {
            initialPopulation = 120 + random.nextInt(61);
            name = plantNames[random.nextInt(plantNames.length)];
            return new Plant(name, initialPopulation);
        } else if (extinctSpecies instanceof Herbivore) {
            initialEnergy = 20 + random.nextInt(21);
            initialPopulation = 30 + random.nextInt(41);
            name = herbivoreNames[random.nextInt(herbivoreNames.length)];
            return new Herbivore(name, initialPopulation, initialEnergy);
        } else if (extinctSpecies instanceof Carnivore) {
            initialEnergy = 20 + random.nextInt(21);
            initialPopulation = 5 + random.nextInt(6);
            name = carnivoreNames[random.nextInt(carnivoreNames.length)];
            return new Carnivore(name, initialPopulation, initialEnergy);
        } else if (extinctSpecies instanceof Omnivore) {
            initialEnergy = 20 + random.nextInt(21);
            initialPopulation = 5 + random.nextInt(6);
            name = omnivoreNames[random.nextInt(omnivoreNames.length)];
            return new Omnivore(name, initialPopulation, initialEnergy);
        }
        return null;
    }

    private void convertEnergyToPopulation() {
        for (Species species : speciesList) {
            if (species.energy > 50) {
                species.changePopulation(1);
                species.changeEnergy(-30);
                logToFile(species.getName() + " из-за переполнения энергии рождается новая особь.\n");
            } else if (species.energy < 0) {
                species.changePopulation(-1);
                species.changeEnergy(50);
                logToFile(species.getName() + " из-за нехватки энергии особь умирает.\n");
            }
        }
    }

    private void logToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ecosystem_log.txt", true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог-файл: " + e.getMessage());
        }
    }

}
