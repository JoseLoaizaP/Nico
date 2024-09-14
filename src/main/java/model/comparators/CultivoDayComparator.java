package model.comparators;

import model.Cultivo;

import java.util.Comparator;

public class CultivoDayComparator implements Comparator<Cultivo> {
    @Override
    public int compare(Cultivo o1, Cultivo o2) {
        return Integer.compare(o1.getDiasCrecimiento(), o2.getDiasCrecimiento());
    }
}
