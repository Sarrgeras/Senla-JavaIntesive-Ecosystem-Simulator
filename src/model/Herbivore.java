package model;

public class Herbivore extends Species {
    public Herbivore(int population, int energy) {
        super("Herbivore", population, energy);
    }

    @Override
    public void consume(Species prey) {
        if (prey instanceof Plant) {
            int foodConsumed = Math.min(prey.getPopulation(), 5);
            prey.changePopulation(-foodConsumed);
            this.changeEnergy(foodConsumed * 2);
        }
    }
}
