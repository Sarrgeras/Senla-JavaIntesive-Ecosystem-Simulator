package model;

import java.util.Random;

public class Omnivore extends Species{
    private Random rand = new Random();

    public Omnivore(int population, int energy) {
        super("Omnivore", population, energy);
    }


    @Override
    public void consume(Species prey) {
        if (prey instanceof Plant) {
            int maxFoodConsumption = rand.nextInt(5) + 1;
            int foodConsumed = Math.min(prey.getPopulation(), maxFoodConsumption);
            prey.changePopulation(-foodConsumed);
            this.changeEnergy(foodConsumed * 2);
        } else if (prey instanceof Herbivore) {
            int maxFoodConsumption = rand.nextInt(2) + 1;
            int foodConsumed = Math.min(prey.getPopulation(), maxFoodConsumption);
            prey.changePopulation(-foodConsumed);
            this.changeEnergy(foodConsumed * 5);
        }
    }
}
