package entities.units.animals;
import entities.map.Cell;
import entities.map.GameMap;
import entities.units.Plant;
import entities.units.animals.herbivores.Bull;
import entities.units.animals.herbivores.Caterpillar;
import entities.units.animals.herbivores.Deer;
import entities.units.animals.herbivores.Duck;
import entities.units.animals.herbivores.Goat;
import entities.units.animals.herbivores.Herbivore;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Animal {
    protected double weight;
    protected int maxSpeed;
    public double actualSatiety;
    protected double maxSatiety;
    protected int maxPopulation;
    protected int x;
    protected int y;
    protected static final Map<Class<? extends Animal>, Map<Class<?>, Integer>> eatProbabilities = new HashMap<>();

    static {
        Map<Class<?>, Integer> wolfEat = new HashMap<>();
        wolfEat.put(Horse.class, 10);
        wolfEat.put(Deer.class, 15);
        wolfEat.put(Rabbit.class, 60);
        wolfEat.put(Mouse.class, 80);
        wolfEat.put(Goat.class, 60);
        wolfEat.put(Sheep.class, 70);
        wolfEat.put(WildBoar.class, 15);
        wolfEat.put(Bull.class, 10);
        wolfEat.put(Duck.class, 40);
        eatProbabilities.put(Wolf.class, wolfEat);

        Map<Class<?>, Integer> snakeEat = new HashMap<>();
        snakeEat.put(Fox.class, 15);
        snakeEat.put(Rabbit.class, 20);
        snakeEat.put(Mouse.class, 40);
        snakeEat.put(Duck.class, 10);
        eatProbabilities.put(Snake.class, snakeEat);

        Map<Class<?>, Integer> foxEat = new HashMap<>();
        foxEat.put(Rabbit.class, 70);
        foxEat.put(Mouse.class, 90);
        foxEat.put(Duck.class, 60);
        foxEat.put(Caterpillar.class, 40);
        eatProbabilities.put(Fox.class, foxEat);

        Map<Class<?>, Integer> bearEat = new HashMap<>();
        bearEat.put(Snake.class, 80);
        bearEat.put(Horse.class, 40);
        bearEat.put(Deer.class, 80);
        bearEat.put(Rabbit.class, 80);
        bearEat.put(Mouse.class, 90);
        bearEat.put(Goat.class, 70);
        bearEat.put(Sheep.class, 70);
        bearEat.put(WildBoar.class, 50);
        bearEat.put(Bull.class, 20);
        bearEat.put(Duck.class, 10);
        eatProbabilities.put(Bear.class, bearEat);

        Map<Class<?>, Integer> eagleEat = new HashMap<>();
        eagleEat.put(Fox.class, 10);
        eagleEat.put(Rabbit.class, 90);
        eagleEat.put(Mouse.class, 90);
        eagleEat.put(Duck.class, 80);
        eatProbabilities.put(Eagle.class, eagleEat);

        Map<Class<?>, Integer> horseEat = new HashMap<>();
        horseEat.put(Plant.class, 100);
        eatProbabilities.put(Horse.class, horseEat);

        Map<Class<?>, Integer> deerEat = new HashMap<>();
        deerEat.put(Plant.class, 100);
        eatProbabilities.put(Deer.class, deerEat);

        Map<Class<?>, Integer> rabbitEat = new HashMap<>();
        rabbitEat.put(Plant.class, 100);
        eatProbabilities.put(Rabbit.class, rabbitEat);

        Map<Class<?>, Integer> mouseEat = new HashMap<>();
        mouseEat.put(Caterpillar.class, 90);
        mouseEat.put(Plant.class, 100);
        eatProbabilities.put(Mouse.class, mouseEat);

        Map<Class<?>, Integer> goatEat = new HashMap<>();
        goatEat.put(Plant.class, 100);
        eatProbabilities.put(Goat.class, goatEat);

        Map<Class<?>, Integer> sheepEat = new HashMap<>();
        sheepEat.put(Plant.class, 100);
        eatProbabilities.put(Sheep.class, sheepEat);

        Map<Class<?>, Integer> wildboarEat = new HashMap<>();
        wildboarEat.put(Caterpillar.class, 90);
        wildboarEat.put(Plant.class, 100);
        eatProbabilities.put(WildBoar.class, wildboarEat);

        Map<Class<?>, Integer> bullEat = new HashMap<>();
        bullEat.put(Plant.class, 100);
        eatProbabilities.put(Bull.class, bullEat);

        Map<Class<?>, Integer> duckEat = new HashMap<>();
        duckEat.put(Caterpillar.class, 90);
        duckEat.put(Plant.class, 100);
        eatProbabilities.put(Duck.class, duckEat);

        Map<Class<?>, Integer> caterpillarEat = new HashMap<>();
        caterpillarEat.put(Plant.class, 100);
        eatProbabilities.put(Caterpillar.class, caterpillarEat);

        Map<Class<?>, Integer> herbivoreEat = new HashMap<>();
        herbivoreEat.put(Plant.class, 100); //Пример для травоядных
        eatProbabilities.put(Horse.class, herbivoreEat);
        eatProbabilities.put(Deer.class, herbivoreEat);
        eatProbabilities.put(Rabbit.class, herbivoreEat);
        eatProbabilities.put(Mouse.class, herbivoreEat);
        eatProbabilities.put(Goat.class, herbivoreEat);
        eatProbabilities.put(Sheep.class, herbivoreEat);
        eatProbabilities.put(WildBoar.class, herbivoreEat);
        eatProbabilities.put(Bull.class, herbivoreEat);
        eatProbabilities.put(Duck.class, herbivoreEat);
        eatProbabilities.put(Caterpillar.class, herbivoreEat);
    }

    public Animal(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        this.actualSatiety = actualSatiety;
        this.weight = weight;
        this.maxPopulation = maxPopulation;
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void eat(GameMap gameMap, Cell cell) {
        Random random = new Random();
        if (cell == null) return;

        // Попытка съесть другое животное
        for (Map.Entry<Animal, Integer> entry : cell.animals.entrySet()) {
            Animal prey = entry.getKey();
            if (prey != this && eatProbabilities.getOrDefault(this.getClass(), new HashMap<>()).containsKey(prey.getClass())) {
                int probability = eatProbabilities.get(this.getClass()).get(prey.getClass());
                if (random.nextInt(100) < probability) {
                    this.actualSatiety += prey.weight;
                    cell.removeAnimal(prey); // Удаление добычи
                    break; // Съели только одного
                }
            }
        }
        if (this.actualSatiety < maxSatiety && cell.plants.size() > 0 && this instanceof Herbivore) {
            this.actualSatiety += cell.plants.get(0).getWeight(); // Поедание растений
            cell.plants.remove(0); // Съедается только одно растение
        }
    }

    public void move(GameMap gameMap) {

        Random random = new Random();
        int dx = random.nextInt(2 * maxSpeed + 1) - maxSpeed; // Случайное смещение от -maxSpeed до maxSpeed
        int dy = random.nextInt(2 * maxSpeed + 1) - maxSpeed;
        int newX = x + dx;
        int newY = y + dy;

        newX = Math.max(0, Math.min(newX, gameMap.getLength()));
        newY = Math.max(0, Math.min(newY, gameMap.getWidth()));

        x = newX;
        y = newY;
    }
    public void reproduce(GameMap gameMap, Cell cell) {
        int count = cell.animals.getOrDefault(this, 0);
        if (count >= 2) {
            int toReproduce = count / 2;
            for (int i = 0; i < toReproduce; i++) {
                Animal newAnimal = this.cloneAnimal();
                newAnimal.setPosition(x, y);
                cell.addAnimal(newAnimal);
            }
        }
    }

    protected abstract Animal cloneAnimal();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return getClass().equals(animal.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
