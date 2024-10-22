package controller;

import model.Ecosystem;
import view.EcosystemView;

public class EcosystemController {
    private Ecosystem ecosystem;
    private EcosystemView view;
    private int day;

    public EcosystemController(Ecosystem ecosystem, EcosystemView view) {
        this.ecosystem = ecosystem;
        this.view = view;
        this.day = 1;
    }

    public void simulate(int days) {
        for (int i = 0; i < days; i++) {
            ecosystem.simulateDay();
            view.displayState(day, ecosystem.getSpeciesList());
            view.logState(day, ecosystem.getSpeciesList());
            day++;
        }
    }
}
