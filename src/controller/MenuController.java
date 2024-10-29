package controller;

import model.*;
import view.MenuView;

import java.util.*;

public class MenuController {
    private Ecosystem ecosystem;
    private MenuView menuView;
    private Climate climate;
    private int day;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;
        this.ecosystem = new Ecosystem(new ArrayList<>());
        this.climate = new Climate();
        this.day = 1;
    }

    public void start(){
        boolean running = true;

        while (running) {
            menuView.showMainMenu();
            int choice = menuView.getUserInput();

            switch (choice) {
                case 1:
                    startCreateEcosystem();
                    break;
                case 2:
                    runSimulation();
                    break;
                case 3:
                    clearSimulation();
                    break;
                case 4:
                    menuView.clearLogFile();
                    break;
                case 5:
                    running = false;
                    menuView.showExitMessage();
                    break;
                default:
                    menuView.showInvalidOptionMessage();
            }
        }
    }

    public void startCreateEcosystem(){
        boolean running = true;
        List<Species> speciesList = new ArrayList<>();

        while (running) {
            menuView.showCreateEcosystemMenu();
            int choice = menuView.getUserInput();

            switch (choice) {
                case 1:
                    addBasicEcosystem(speciesList);
                    break;
                case 2:
                    addPlant(speciesList);
                    break;
                case 3:
                    addHerbivore(speciesList);
                    break;
                case 4:
                    addCarnivore(speciesList);
                    break;
                case 5:
                    addOmnivore(speciesList);
                    break;
                case 6:
                    running = false;
                    this.ecosystem = new Ecosystem(speciesList);
                    break;
                default:
                    menuView.showInvalidOptionMessage();
            }
        }
    }

    public void addBasicEcosystem(List<Species> speciesList){
        speciesList.add(new Plant("Пшеница", 150));
        speciesList.add(new Herbivore("Овца", 75, 20));
        speciesList.add(new Carnivore("Волк", 10, 30));
        speciesList.add(new Omnivore("Медведь", 6, 40));
    }

    public void addPlant(List<Species> speciesList){
        String name = menuView.getSpeciesName();
        int population = menuView.getSpeciesPopulation();
        speciesList.add(new Plant(name, population));
        System.out.println("Добавлен вид растения: " + name + ", популяция: " + population);
    }

    public void addHerbivore(List<Species> speciesList){
        String name = menuView.getSpeciesName();
        int population = menuView.getSpeciesPopulation();
        int energy = menuView.getSpeciesEnergy();
        speciesList.add(new Herbivore(name, population, energy));
        System.out.println("Добавлен травоядный вид: " + name + ", популяция: " + population + ", энергия: " + energy);
    }

    public void addCarnivore(List<Species> speciesList){
        String name = menuView.getSpeciesName();
        int population = menuView.getSpeciesPopulation();
        int energy = menuView.getSpeciesEnergy();
        speciesList.add(new Carnivore(name, population, energy));
        System.out.println("Добавлен плотоядный вид: " + name + ", популяция: " + population + ", энергия: " + energy);
    }

    public void addOmnivore(List<Species> speciesList){
        String name = menuView.getSpeciesName();
        int population = menuView.getSpeciesPopulation();
        int energy = menuView.getSpeciesEnergy();
        speciesList.add(new Omnivore(name, population, energy));
        System.out.println("Добавлен всеядный вид: " + name + ", популяция: " + population + ", энергия: " + energy);
    }

    private void runSimulation() {
        if (ecosystem.getSpeciesList().isEmpty()) {
            System.out.println("Экосистема пуста. Сначала создайте новую экосистему.");
        } else {
            int days = menuView.getEcosystemDays();
            day = 1;
            for ( int i = 0; i < days; i++, day++) {
                ecosystem.simulateDay();
                menuView.displayState(day, ecosystem.getSpeciesList());
                menuView.logState(day, ecosystem.getSpeciesList());
            }
        }
    }

    private void clearSimulation() {
        this.ecosystem = new Ecosystem(new ArrayList<>());
        menuView.showEcosystemClearedMessage();
    }
}