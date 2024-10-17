import controller.EcosystemController;
import model.Ecosystem;
import view.EcosystemView;

public class Main {
    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem();
        EcosystemView view = new EcosystemView();
        EcosystemController controller = new EcosystemController(ecosystem, view);

        controller.runSimulation(10);
    }
}
