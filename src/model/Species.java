package model;

public abstract class Species {
    private String name;
    private int population;
    private int energy;

    public Species(String name, int population, int energy) {
        this.name = name;
        this.population = population;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getEnergy() {
        return energy;
    }

    public void changePopulation(int delta) {
        this.population += delta;
    }

    public abstract void consume(Species food);
}
