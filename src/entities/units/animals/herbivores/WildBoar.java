package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public class WildBoar extends Herbivore {
    public WildBoar(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC17";
    }

    @Override
    protected Animal cloneAnimal() {
        return new WildBoar(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
