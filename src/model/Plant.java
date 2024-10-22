package model;

public class Plant extends Species {
    public Plant(int population) {
        super("Plant", population, 0);
    }

    @Override
    public void consume(Species prey) {
        // Растения не потребляют другие виды
    }
}
