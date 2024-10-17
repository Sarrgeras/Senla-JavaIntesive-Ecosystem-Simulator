package model;

public class Carnivore extends Species{
    public Carnivore(String name, int population, int energy){
        super(name, population, energy);
    }

    @Override
    public void consume(Species food) {

    }
}
