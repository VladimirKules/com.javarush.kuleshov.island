package entities.units.animals.predators;

import entities.units.animals.Animal;
import entities.units.animals.herbivores.Bull;

// Дополнительные классы животных
public class Wolf extends Predator {
    public Wolf(double actualSatiety, double weight, int maxPopulation, int maxSpeed, double maxSatiety) {
        super(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }

    @Override
    protected Animal cloneAnimal() {
        return new Wolf(actualSatiety, weight, maxPopulation, maxSpeed, maxSatiety);
    }
}

