package model;

public class Omnivore extends Species{
    public Omnivore(String name, int population) {
        super(name, population, 0);
    }


    @Override
    public void consume(Species food) {

    }
}
