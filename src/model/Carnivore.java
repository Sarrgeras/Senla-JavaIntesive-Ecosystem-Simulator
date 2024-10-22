package model;

public class Carnivore extends Species {
    public Carnivore(int population, int energy) {
        super("Carnivore", population, energy);
    }

    @Override
    public void consume(Species prey) {
        if (prey instanceof Herbivore) {
            int foodConsumed = Math.min(prey.getPopulation(), 2);
            prey.changePopulation(-foodConsumed);
            this.changeEnergy(foodConsumed * 10);
        }
    }
}
