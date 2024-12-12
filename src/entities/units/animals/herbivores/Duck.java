package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public class Duck extends Herbivore {
    public Duck(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83E\uDD86";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Duck(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
