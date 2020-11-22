package agh.cs.lab7;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.Grass;


import java.util.*;

public class MapBoundary implements IPositionChangeObserver {
    static Comparator xComparator = new XComparator();
    private static SortedSet<Vector2d> xSorted = new TreeSet<>(xComparator);
    static Comparator yComparator = new YComparator();
    private static SortedSet<Vector2d> ySorted = new TreeSet<>(yComparator);


    public MapBoundary(HashMap<Vector2d, Grass> hashGrass) {
        for(Vector2d grass : hashGrass.keySet() ){
            xSorted.add(grass);
            ySorted.add(grass);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xSorted.remove(oldPosition);
        ySorted.remove(oldPosition);
        xSorted.add(newPosition);
        ySorted.add(newPosition);
    }

    public static void positionAdd(Vector2d position) {
        xSorted.add(position);
        ySorted.add(position);
    }

    public Vector2d getUpper() {
        return new Vector2d(xSorted.last().x, ySorted.last().y);
    }


    public Vector2d getLower() {
        return new Vector2d(xSorted.first().x, ySorted.first().y);
    }
}

