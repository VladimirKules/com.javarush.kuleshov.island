package entities.units.animals.predators;

import entities.units.animals.Animal;
import entities.units.animals.herbivores.Bull;

public class Snake extends Predator {
    public Snake(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC0D";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Snake(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
