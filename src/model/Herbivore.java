package model;

import java.util.Random;

public class Herbivore extends Species {
    private Random rand = new Random();

    public Herbivore(int population, int energy) {
        super("Herbivore", population, energy);
    }

    @Override
    public void consume(Species prey) {
        if (prey instanceof Plant) {
            int maxFoodConsumption = rand.nextInt(5) + 1;
            int foodConsumed = Math.min(prey.getPopulation(), maxFoodConsumption);
            prey.changePopulation(-foodConsumed);
            this.changeEnergy(foodConsumed * 2);
        }
    }
}
