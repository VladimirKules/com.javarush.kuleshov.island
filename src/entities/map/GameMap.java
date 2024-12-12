package entities.map;

import entities.units.Plant;
import entities.units.animals.Animal;
import enumeration.AnimalType;
import fabric.AnimalFactory;
import util.YamlConfigReader;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class GameMap extends Thread{
    private final Cell[][] matrix;
    private final int length;
    private final int width;
    private static final String CONFIG_FILE_PATH = "C:\\JavaRushProject\\com.javarush.kuleshov.island\\resources\\settings.yaml";
    private static int day = 0;
    Map<String, Object> config = YamlConfigReader.readConfig(CONFIG_FILE_PATH);

    public GameMap() throws Exception {
        length = (int) config.get("mapLength");
        width = (int) config.get("mapWidth");
        matrix = new Cell[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= length || y < 0 || y >= width) return null;
        return matrix[x][y];
    }

    public void populateIsland() {
        System.out.println("Сотворение острова! И появились на острове следующие животные:");
        Random random = new Random();
        AnimalFactory animalFactory = new AnimalFactory();
        for (AnimalType animalType : AnimalType.values()) {
            for (int i = 0; i < (int) config.get("maxCountAnimal"); i++) {
                int x = random.nextInt(length);
                int y = random.nextInt(width);
                Animal newAnimal = animalFactory.createAnimal(String.valueOf(animalType));
                matrix[x][y].addAnimal(newAnimal);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int numPlants = new Random().nextInt((int) config.get("maxCountPlant") + 1);
                for (int k = 0; k < numPlants; k++) {
                    matrix[i][j].addPlant();
                }
            }
        }
    }

    public void run(){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        scheduler.scheduleAtFixedRate(this::simulationStep, 0, 1, TimeUnit.SECONDS);
    }

    private void simulationStep() {
        System.out.println("День "+ ++day);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = matrix[i][j];
                List<Animal> animalsToRemove = new ArrayList<>();
                synchronized (cell) {
                    for (Animal animal : new ArrayList<>(cell.animals.keySet())) {
                        animal.eat(this,cell);
                        animal.move(this);
                        animal.reproduce(this,cell);
                        animal.actualSatiety -= 30;
                        if (animal.actualSatiety <= 0) {
                            animalsToRemove.add(animal);
                        }
                    }
                    animalsToRemove.forEach(cell::removeAnimal);
                }
                int numNewPlants = new Random().nextInt(10);
                for (int k = 0; k < numNewPlants; k++) {
                    cell.addPlant();
                }
            }
        }
        printMap();
    }

    public void printMap() {
        Map<Animal, Integer> totalAnimals = new HashMap<>();
        int totalPlants = 0;
        for (Cell[] row : matrix) {
            for (Cell cell : row) {
                try {
                    for (Map.Entry<Animal, Integer> entry : cell.animals.entrySet()) {
                        totalAnimals.put(entry.getKey(), totalAnimals.getOrDefault(entry.getKey(), 0) + entry.getValue());
                    }
                    for (Plant plant : cell.plants) {
                        totalPlants++;
                    }
                } catch (ConcurrentModificationException e) {
                    System.err.println("Ошибка многопоточности");
                }
            }
        }
        totalAnimals.forEach((animal, count) -> System.out.print(animal + " = " + count + " "));
        System.out.println( "\uD83C\uDF3B "+ totalPlants);
    }
}
