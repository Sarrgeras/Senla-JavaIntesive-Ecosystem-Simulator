package controller;

import model.Ecosystem;
import view.EcosystemView;

public class EcosystemController {
    private Ecosystem ecosystem;
    private EcosystemView view;

    public EcosystemController(Ecosystem ecosystem, EcosystemView view) {
        this.ecosystem = ecosystem;
        this.view = view;
    }

    public void simulateDay(int day) {
        view.displayDay(day);
        ecosystem.simulateInteractions();
        view.displayEcosystemState(ecosystem.getSpeciesList());
    }

    public void runSimulation(int days) {
        for (int day = 1; day <= days; day++) {
            simulateDay(day);
        }
    }
}
