package model;

public class Plant extends Species {
    public Plant(String name, int population) {
        super(name, population, 0);
    }

    @Override
    public void consume(Species prey) {
        // Растения не потребляют другие виды
    }
}
