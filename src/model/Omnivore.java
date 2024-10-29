package model;

import java.io.*;
import java.util.Random;

public class Omnivore extends Species{
    private Random rand = new Random();

    public Omnivore(String name, int population, int energy) {
        super(name, population, energy);
    }


    @Override
    public void consume(Species prey) {
        int foodConsumed = 0;
        int energyGained = 0;

        if (prey instanceof Plant) {
            int maxFoodConsumption = rand.nextInt(5) + 1;
            foodConsumed = Math.min(prey.getPopulation(), maxFoodConsumption);
            prey.changePopulation(-foodConsumed);
            energyGained = foodConsumed * 5;
            this.changeEnergy(energyGained);
        } else if (prey instanceof Herbivore) {
            int maxFoodConsumption = rand.nextInt(2) + 1;
            foodConsumed = Math.min(prey.getPopulation(), maxFoodConsumption);
            prey.changePopulation(-foodConsumed);
            energyGained = foodConsumed * 10;
            this.changeEnergy(energyGained);
        } else if(prey instanceof Carnivore){
            int maxFoodConsumption = rand.nextInt(2) + 1;
            foodConsumed = Math.min(prey.getPopulation(), maxFoodConsumption);
            prey.changePopulation(-foodConsumed);
            energyGained = foodConsumed;
            this.changeEnergy(energyGained);
        }


        logConsumption(prey, foodConsumed, energyGained);
    }

    private void logConsumption(Species prey, int foodConsumed, int energyGained) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ecosystem_log.txt", true))) {
            writer.write(this.getName() + " съел " + foodConsumed + " особей " + prey.getName() +
                    ", получив " + energyGained + " энергии.\r\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог-файл: " + e.getMessage());
        }
    }
}
