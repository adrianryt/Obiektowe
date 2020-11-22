package agh.cs.lab7;

import agh.cs.lab2.Vector2d;

import java.util.Comparator;

public class XComparator implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d o1, Vector2d o2) {
        return o1.x - o2.x;
    }
}
