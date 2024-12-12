package entities.map;
import entities.units.Plant;
import entities.units.animals.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class Cell{
    public ConcurrentHashMap<Animal,Integer> animals = new ConcurrentHashMap<>();
    public List<Plant> plants = new ArrayList<>();


    public synchronized void addAnimal(Animal animal){
        int currentCount = animals.getOrDefault(animal,0);
        if (currentCount < animal.getMaxPopulation()){
            animals.put(animal,currentCount+1);
        }
    }

    public synchronized void removeAnimal(Animal animal) {
        int currentCount = animals.getOrDefault(animal, 0);
        if (currentCount > 0) {
            animals.put(animal, currentCount - 1);
            if (currentCount == 1) animals.remove(animal);
        }
    }


    public synchronized void addPlant() { // Добавить растение
        plants.add(new Plant());
    }
}
