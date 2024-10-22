package model;

import java.util.*;

public class Ecosystem {
    private List<Species> speciesList;

    public Ecosystem(List<Species> speciesList) {
        this.speciesList = speciesList;
    }

    public List<Species> getSpeciesList() {
        return speciesList;
    }

    public void simulateDay() {
        for (Species predator : speciesList) {
            for (Species prey : speciesList) {
                if (predator != prey) {
                    predator.consume(prey);
                }
            }
        }
    }
}
