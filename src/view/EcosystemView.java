package view;

import model.Species;

import java.io.*;
import java.util.List;

public class EcosystemView {
    public void displayState(int day, List<Species> speciesList) {
        System.out.println("День " + day + ":");
        for (Species species : speciesList) {
            System.out.println(species.getName() + ": " + species.getPopulation() + " особей, энергия: " + species.getEnergy());
        }
        System.out.println("-------------------------");
    }

    public void logState(int day, List<Species> speciesList) {
        try (FileWriter writer = new FileWriter("ecosystem_log.txt", true)) {
            writer.write("День " + day + ":\n");
            for (Species species : speciesList) {
                writer.write(species.getName() + ": " + species.getPopulation() + " особей, энергия: " + species.getEnergy() + "\n");
            }
            writer.write("-------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
