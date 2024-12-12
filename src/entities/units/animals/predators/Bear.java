package entities.units.animals.predators;

import entities.units.animals.Animal;
import entities.units.animals.herbivores.Bull;

public class Bear extends Predator {
    public Bear(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Bear(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
