package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public class Rabbit extends Herbivore {
    public Rabbit(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Rabbit(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
