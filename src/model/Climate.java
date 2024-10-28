package model;

import java.util.Random;

public class Climate {
    private String currentCondition;
    private static final String[] CONDITIONS = {"Благоприятный климат",
            "Засушливый климат", "Климат высокой влажности"};
    private Random random = new Random();

    public Climate() {
        this.currentCondition = "Благоприятный климат";
    }

    public void updateClimate() {
        int conditionIndex = random.nextInt(CONDITIONS.length);
        currentCondition = CONDITIONS[conditionIndex];
        System.out.println("Климатические условия изменились на: " + currentCondition);
    }

    public void affectEcosystem(Ecosystem ecosystem) {
        switch (currentCondition) {
            case "Засушливый климат":
                for (Species species : ecosystem.getSpeciesList()) {
                    if (species instanceof Plant) {
                        int decrease = Math.min(species.getPopulation(), 20);
                        species.changePopulation(-decrease);
                    }
                }
                break;
            case "Климат высокой влажности":
                for (Species species : ecosystem.getSpeciesList()) {
                    if (species instanceof Carnivore || species instanceof Omnivore) {
                        species.setCanFindFood(false);
                        System.out.println(species.getName() + " не может найти еду из-за высокой влажности.");
                    }
                    if (species instanceof Plant) {
                        int increase = Math.min(species.getPopulation(), 10);
                        species.changePopulation(increase);
                    }
                }
                break;
            default:
                for (Species species : ecosystem.getSpeciesList()) {
                    species.setCanFindFood(true);
                }
                break;
        }
    }

    public String getCurrentCondition() {
        return currentCondition;
    }
}