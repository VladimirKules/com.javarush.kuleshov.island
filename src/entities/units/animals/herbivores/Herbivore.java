package entities.units.animals.herbivores;

import entities.units.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }

}