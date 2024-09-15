package model.comparators;

import model.Plantacion;

import java.util.Comparator;

public class PlantacionIdComparator implements Comparator<Plantacion> {
    @Override
    public int compare(Plantacion o1, Plantacion o2) {
        return o1.getPlantacionId().compareTo(o2.getPlantacionId());
    }
}


