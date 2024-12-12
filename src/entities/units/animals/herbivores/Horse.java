package entities.units.animals.herbivores;

import entities.units.animals.Animal;

// Травоядные животные
public class Horse extends Herbivore {
    public Horse(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC0E";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Horse(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
