import controller.MenuController;
import view.MenuView;

public class Main {
    /*public static void main(String[] args) {
        List<Species> speciesList = new ArrayList<>();
        speciesList.add(new Plant(100));
        speciesList.add(new Herbivore(20, 20));
        speciesList.add(new Carnivore(5, 30));
        speciesList.add(new Omnivore(5, 30));

        Ecosystem ecosystem = new Ecosystem(speciesList);
        EcosystemView view = new EcosystemView();
        EcosystemController controller = new EcosystemController(ecosystem, view);

        // Запуск симуляции на 10 дней
        controller.simulate(10);
    }*/

    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);

        menuController.start();
    }
}

/*import controller.MenuController;
import view.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);

        menuController.start();
    }
}*/
