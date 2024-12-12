package fabric;

import entities.units.animals.Animal;
import entities.units.animals.herbivores.Bull;
import entities.units.animals.herbivores.Caterpillar;
import entities.units.animals.herbivores.Deer;
import entities.units.animals.herbivores.Duck;
import entities.units.animals.herbivores.Goat;
import entities.units.animals.herbivores.Horse;
import entities.units.animals.herbivores.Mouse;
import entities.units.animals.herbivores.Rabbit;
import entities.units.animals.herbivores.Sheep;
import entities.units.animals.herbivores.WildBoar;
import entities.units.animals.predators.Bear;
import entities.units.animals.predators.Eagle;
import entities.units.animals.predators.Fox;
import entities.units.animals.predators.Snake;
import entities.units.animals.predators.Wolf;
import util.YamlConfigReader;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalFactory {
    private static final String SPEC_FILE_PATH = "C:\\JavaRushProject\\com.javarush.kuleshov.island\\resources\\specifications.yaml";
    Map<String, Map<String, Object>> specAnimal;

    {
        try {
            specAnimal = YamlConfigReader.readSpecAnimal(SPEC_FILE_PATH);
        } catch (Exception e) {
            System.out.println("Не найден файл со спецификацией животных");
            ;
        }
    }

    public Animal createAnimal(String animalType) {
        Map<String,Object> value = specAnimal.get(animalType.toLowerCase());

        double weight = convertToDouble(value.get("weight"));
        int maxPopulation =convertToInteger(value.get("maxPopulation"));
        int maxSpeed =  convertToInteger(value.get("maxSpeed"));
        double maxSatiety = convertToDouble(value.get("maxSatiety"));

        switch (animalType.toLowerCase()) {
            case "bull":
                return new Bull(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "caterpillar":
                return new Caterpillar(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "deer":
                return new Deer(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "duck":
                return new Duck(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "goat":
                return new Goat(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "horse":
                return new Horse(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "mouse":
                return new Mouse(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "rabbit":
                return new Rabbit(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "sheep":
                return new Sheep(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "wildboar":
                return new WildBoar(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "bear":
                return new Bear(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "eagle":
                return new Eagle(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "fox":
                return new Fox(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "snake":
                return new Snake(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            case "wolf":
                return new Wolf(maxSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
            default:
                throw new IllegalArgumentException("Unknown animal type: " + animalType);
        }
    }
    private static double convertToDouble(Object value) {
        if (value instanceof Integer) {
            return ((Integer) value).doubleValue();
        } else if (value instanceof Double) {
            return (Double) value;
        } else if (value instanceof Long) {
            return ((Long) value).doubleValue();
        } else {
            return 0.0;
        }
    }
    private static int convertToInteger(Object value) {
        if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof Double) {
            return ((Double) value).intValue();
        } else if (value instanceof Long) {
            return ((Long) value).intValue();
        } else {
            return 0;
        }
    }
}
