import controller.EcosystemController;
import model.*;
import view.EcosystemView;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Species> speciesList = new ArrayList<>();
        speciesList.add(new Plant(100));
        speciesList.add(new Herbivore(20, 20));
        speciesList.add(new Carnivore(5, 30));

        Ecosystem ecosystem = new Ecosystem(speciesList);
        EcosystemView view = new EcosystemView();
        EcosystemController controller = new EcosystemController(ecosystem, view);

        // Запуск симуляции на 10 дней
        controller.simulate(10);
    }
}
