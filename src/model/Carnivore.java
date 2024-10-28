package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Carnivore extends Species {
    private Random rand = new Random();

    public Carnivore(String name, int population, int energy) {
        super(name, population, energy);
    }

    @Override
    public void consume(Species prey) {
        int foodConsumed = 0;
        int energyGained = 0;

        if (prey instanceof Herbivore) {
            int maxFoodConsumption = rand.nextInt(2) + 1;
            foodConsumed = Math.min(prey.getPopulation(), maxFoodConsumption);
            prey.changePopulation(-foodConsumed);
            energyGained += foodConsumed * 10;
            this.changeEnergy(energyGained);
        }

        logConsumption(prey, foodConsumed, energyGained);
    }

    private void logConsumption(Species prey, int foodConsumed, int energyGained) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ecosystem_log.txt", true))) {
            writer.write(this.getName() + " съел " + foodConsumed + " особей " + prey.getName() +
                    ", получив " + energyGained + " энергии.\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог-файл: " + e.getMessage());
        }
    }
}
