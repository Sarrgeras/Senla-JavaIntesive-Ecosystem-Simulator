package model;

import java.util.ArrayList;
import java.util.List;

public class Ecosystem {
    private List<Species> speciesList;

    public Ecosystem() {
        speciesList = new ArrayList<>();
        initializeSpecies();
    }

    private void initializeSpecies() {
        speciesList.add(new Plant("Трава", 100));
        speciesList.add(new Herbivore("Кролик", 20, 10));
        speciesList.add(new Carnivore("Волк", 5, 20));
    }

    public List<Species> getSpeciesList() {
        return speciesList;
    }

    public void simulateInteractions() {
        for (Species predator : speciesList) {
            for (Species prey : speciesList) {
                if (predator != prey) {
                    predator.consume(prey);
                }
            }
        }
        speciesList.removeIf(s -> s.getPopulation() <= 0);
    }
}
