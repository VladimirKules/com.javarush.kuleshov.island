package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public class Bull extends Herbivore{
    public Bull(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC03";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Bull(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}
