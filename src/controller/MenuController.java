package controller;

import model.*;
import view.MenuView;

import java.util.*;

public class MenuController {
    private Ecosystem ecosystem;
    private MenuView menuView;
    private int day;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;
        this.ecosystem = new Ecosystem(new ArrayList<>());
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
                    addPlant(speciesList);
                    break;
                case 2:
                    addHerbivore(speciesList);
                    break;
                case 3:
                    addCarnivore(speciesList);
                    break;
                case 4:
                    addOmnivore(speciesList);
                    break;
                case 5:
                    running = false;
                    this.ecosystem = new Ecosystem(speciesList);
                    break;
                default:
                    menuView.showInvalidOptionMessage();
            }
        }
    }

    public void addPlant(List<Species> speciesList){
        String name = menuView.getSpeciesName();
        int population = menuView.getSpeciesPopulation();
        speciesList.add(new Plant(population));
        System.out.println("Добавлен вид растения: " + name + ", популяция: " + population);
    }

    public void addHerbivore(List<Species> speciesList){
        String name = menuView.getSpeciesName();
        int population = menuView.getSpeciesPopulation();
        int energy = menuView.getSpeciesEnergy();
        speciesList.add(new Herbivore(population, energy));
        System.out.println("Добавлен травоядный вид: " + name + ", популяция: " + population + ", энергия: " + energy);
    }

    public void addCarnivore(List<Species> speciesList){
        String name = menuView.getSpeciesName();
        int population = menuView.getSpeciesPopulation();
        int energy = menuView.getSpeciesEnergy();
        speciesList.add(new Carnivore(population, energy));
        System.out.println("Добавлен плотоядный вид: " + name + ", популяция: " + population + ", энергия: " + energy);
    }

    public void addOmnivore(List<Species> speciesList){
        String name = menuView.getSpeciesName();
        int population = menuView.getSpeciesPopulation();
        int energy = menuView.getSpeciesEnergy();
        speciesList.add(new Omnivore(population, energy));
        System.out.println("Добавлен всеядный вид: " + name + ", популяция: " + population + ", энергия: " + energy);
    }

    private void runSimulation() {
        if (ecosystem.getSpeciesList().isEmpty()) {
            System.out.println("Экосистема пуста. Сначала создайте новую экосистему.");
        } else {
            int days = menuView.getEcosystemDays();
            for (int i = 0; i < days; i++, day++) {
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