package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public class Sheep extends Herbivore {
    public Sheep(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC11";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Sheep(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
