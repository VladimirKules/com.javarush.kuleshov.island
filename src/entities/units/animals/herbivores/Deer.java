package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public class Deer extends Herbivore {
    public Deer(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83E\uDD8C";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Deer(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
