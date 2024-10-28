import controller.MenuController;
import view.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);

        menuController.start();
    }
}