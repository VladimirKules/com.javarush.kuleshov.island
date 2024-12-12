package entities.units.animals.predators;

import entities.units.animals.Animal;
import entities.units.animals.herbivores.Bull;

public class Eagle extends Predator {
    public Eagle(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83E\uDD85";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Eagle(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
