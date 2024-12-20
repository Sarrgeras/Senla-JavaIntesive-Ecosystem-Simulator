package view;

import model.Climate;
import model.Ecosystem;
import model.Species;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class MenuView{
    private Scanner scanner = new Scanner(System.in);

    public void showMainMenu(){
        System.out.println("Симулятор экосистемы");
        System.out.println("1. Создать новую экосистему");
        System.out.println("2. Запустить симуляцию экосистемы");
        System.out.println("3. Очистить экосистему");
        System.out.println("4. Очистить лог файл");
        System.out.println("5. Выход");
        System.out.print("Выберите пункт: ");

    }

    public void showCreateEcosystemMenu(){
        System.out.println("1.1. Добавить базовые виды");
        System.out.println("1.2. Добавьте ваши виды растений");
        System.out.println("1.3. Добавьте ваши виды травоядных");
        System.out.println("1.4. Добавьте ваши виды плотоядных");
        System.out.println("1.5. Добавьте ваши виды всеядных");
        System.out.println("1.6. Выйти в главное меню");
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

    public int getEcosystemDays(){
        System.out.println("Введите количествой дней симуляции: ");
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

    public void displayState(int day, List<Species> speciesList) {
        System.out.println("День " + day + ":");
        for (Species species : speciesList) {
            System.out.println(species.getName() + ": " + species.getPopulation() + " особей, энергия: " + species.getEnergy());
        }
        System.out.println("-------------------------");
    }

    public void clearLogFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ecosystem_log.txt"))) {

        } catch (IOException e) {
            System.err.println("Ошибка при очистке лог-файла: " + e.getMessage());
        }
    }

    public void logState(int day, List<Species> speciesList) {
        try (FileWriter writer = new FileWriter("ecosystem_log.txt", true)) {
            writer.write("-------------------------\r\n");
            writer.write("День " + day + ":\r\r\n");
            for (Species species : speciesList) {
                writer.write(species.getName() + ": " + species.getPopulation() + " особей, энергия: " + species.getEnergy() + "\r\n");
            }
            writer.write("-------------------------\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}