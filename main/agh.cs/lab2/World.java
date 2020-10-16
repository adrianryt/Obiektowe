package agh.cs.lab2;

public class World {
    public static void main(String[] args){
        Vector2d vector1 = new Vector2d(2, 2);
        Vector2d vector2 = new Vector2d(1, 3);
        System.out.println(vector1.toString());
        System.out.println(vector2.precedes(vector1));
        System.out.println(vector2.follows(vector1));
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(vector1.upperRight(vector2));
        MapDirection mapdirection = MapDirection.NORTH;
        MapDirection result = mapdirection.next();
        System.out.println(result);
        MapDirection testunit = MapDirection.NORTH;
        System.out.println(testunit.toUnitVector());
    }
}

