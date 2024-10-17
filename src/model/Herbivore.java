package model;

public class Herbivore extends Species {
    public Herbivore(String name, int population, int energy) {
        super(name, population, energy);
    }

    @Override
    public void consume(Species food) {

    }
}
