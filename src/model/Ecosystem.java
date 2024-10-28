package model;

import java.io.*;
import java.util.*;

public class Ecosystem {
    private List<Species> speciesList;
    private Climate climate;

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
                    if (predator.isCanFindFood()) {
                        predator.consume(prey);
                    }
                    else {
                        predator.changeEnergy(-10);
                    }
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
                logToFile(species.getName() + " из-за переполнения энергии рождается новая особь.\n");
            } else if (species.energy < 0) {
                species.changePopulation(-1);
                species.changeEnergy(50);
                logToFile(species.getName() + " из-за нехватки энергии особь умирает.\n");
            }
        }
    }

    private void logToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ecosystem_log.txt", true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог-файл: " + e.getMessage());
        }
    }

}
