package entities.units.animals.predators;

import entities.units.animals.Animal;
import entities.units.animals.herbivores.Bull;

public class Fox extends Predator {
    public Fox(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Fox(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
