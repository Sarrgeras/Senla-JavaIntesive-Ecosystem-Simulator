package model;

public abstract class Species {
    protected String name;
    protected int population;
    protected int energy;
    protected boolean canFindFood;

    public boolean isCanFindFood() {
        return canFindFood;
    }

    public void setCanFindFood(boolean canFindFood) {
        this.canFindFood = canFindFood;
    }

    public Species(String name, int population, int energy) {
        this.name = name;
        this.population = population;
        this.energy = energy;
        this.canFindFood = true;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public void changePopulation(int amount) {
        this.population = Math.max(0, this.population + amount);
    }

    public int getEnergy() {
        return energy;
    }

    public void changeEnergy(int amount) {
        this.energy += amount;
    }

    public abstract void consume(Species prey);
}