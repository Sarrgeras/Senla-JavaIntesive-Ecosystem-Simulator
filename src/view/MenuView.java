package view;

import model.Ecosystem;
import model.Species;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuView{
    private Scanner scanner = new Scanner(System.in);

    public void showMainMenu(){
        System.out.println("Welcome to the Menu View");
        System.out.println("Please select an option:");
        System.out.println("1. Создать новую экосистему");
        System.out.println("2. Запустить симуляцию экосистемы");
        System.out.println("3. Очистить экосистему");
        System.out.println("4. Выход");
        System.out.print("Выберите пункт: ");

    }

    public void showCreateEcosystemMenu(){
        System.out.println("1.1. Добавьте ваши виды растений");
        System.out.println("1.2. Добавьте ваши виды травоядных");
        System.out.println("1.3. Добавьте ваши виды плотоядных");
        System.out.println("1.4. Добавьте ваши виды всеядных");
        System.out.println("1.5. Выйти в главное меню");
        System.out.print("Выберите пункт: ");

    }

    public int getUserInput(){
        return scanner.nextInt();
    }

    public String getSpeciesName() {
        System.out.print("Введите название вида: ");
        return scanner.next();
    }

    public int getSpeciesPopulation() {
        System.out.print("Введите начальную популяцию: ");
        return scanner.nextInt();
    }

    public int getSpeciesEnergy() {
        System.out.print("Введите начальную энергию: ");
        return scanner.nextInt();
    }

    public void showEcosystemClearedMessage() {
        System.out.println("Текущая симуляция очищена.");
    }

    public void showExitMessage() {
        System.out.println("Выход из программы. До свидания!");
    }

    public void showInvalidOptionMessage() {
        System.out.println("Неверный выбор. Пожалуйста, выберите правильный пункт меню.");
    }

    public void showEcosystemState(Ecosystem ecosystem) {
        System.out.println("Статистика экосистемы");
        List<Species> speciesList = ecosystem.getSpeciesList();

        if(speciesList.isEmpty()){
            System.out.println("Экосистема пустая");
        }
        else{
            for(Species species : speciesList){
                System.out.println("Вид: " + species.getName() +
                        ", Популяция: " + species.getPopulation() +
                        ", Энергия: " + species.getEnergy());
            }
        }
        System.out.println("-------------------------");
    }
}