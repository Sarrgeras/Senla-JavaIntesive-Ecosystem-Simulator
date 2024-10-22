package model;

import java.util.Random;

public class Carnivore extends Species {
    private Random rand = new Random();

    public Carnivore(int population, int energy) {
        super("Carnivore", population, energy);
    }

    @Override
    public void consume(Species prey) {
        if (prey instanceof Herbivore) {
            int maxFoodConsumption = rand.nextInt(2) + 1;
            int foodConsumed = Math.min(prey.getPopulation(), maxFoodConsumption);
            prey.changePopulation(-foodConsumed);
            this.changeEnergy(foodConsumed * 10);
        }
    }
}
