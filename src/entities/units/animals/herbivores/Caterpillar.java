package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public class Caterpillar extends Herbivore {
    public Caterpillar(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC1B";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Caterpillar(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
