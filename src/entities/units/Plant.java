package entities.units;

import entities.map.Cell;
import entities.units.animals.Animal;

public class Plant {
    private double weight =1;
    private static final int MAX_COUNT_ON_CELL = 200;

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\uD83C\uDF3B";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Plant plant = (Plant) obj;
        return getClass().equals(plant.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public static int getMaxCountOnCell() {
        return MAX_COUNT_ON_CELL;
    }
}