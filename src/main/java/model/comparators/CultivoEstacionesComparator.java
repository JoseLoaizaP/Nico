package model.comparators;


import model.Cultivo;

import java.util.Comparator;

public class CultivoEstacionesComparator implements Comparator<Cultivo> {
    @Override
    public int compare(Cultivo o1, Cultivo o2) {
        return o1.getEstacion().compareTo(o2.getEstacion());
    }
}
