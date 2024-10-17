package view;

import model.Species;

import java.util.List;

public class EcosystemView {
    public void displayEcosystemState(List<Species> speciesList) {
        for (Species s : speciesList) {
            System.out.println(s.getName() + ": " + s.getPopulation() + " особей, энергия: " + s.getEnergy());
        }
        System.out.println("-------------------------");
    }

    public void displayDay(int day) {
        System.out.println("День " + day + ":");
    }
}
