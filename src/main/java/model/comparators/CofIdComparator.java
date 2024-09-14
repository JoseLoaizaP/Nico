package model.comparators;

import model.Cofre;

import java.util.Comparator;


public class CofIdComparator implements Comparator<Cofre> {
    @Override
    public int compare(Cofre o1, Cofre o2) {
        return o1.getCofreId().compareTo(o2.getCofreId());
    }
}