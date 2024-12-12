package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public class Goat extends Herbivore {
    public Goat(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC10";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Goat(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
