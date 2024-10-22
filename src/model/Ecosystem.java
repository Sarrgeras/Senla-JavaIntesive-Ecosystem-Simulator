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
        convertEnergyToPopulation();
    }

    private void convertEnergyToPopulation() {
        for (Species species : speciesList) {
            if (species.energy > 50) {
                species.changePopulation(1);
                species.changeEnergy(-30);
            }
        }
    }
}
