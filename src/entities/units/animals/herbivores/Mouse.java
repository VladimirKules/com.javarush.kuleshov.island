package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public class Mouse extends Herbivore {
    public Mouse(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC01";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Mouse(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
