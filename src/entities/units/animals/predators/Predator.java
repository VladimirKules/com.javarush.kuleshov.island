package entities.units.animals.predators;

import entities.units.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }

}