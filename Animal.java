package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return ("(" + this.position.x + "," + this.position.y + ")" + "Oriantation:" + this.orientation);
    }

    public void move(MoveDirector director) {
        switch (director) {
            case RIGHT -> this.orientation = orientation.next();
            case LEFT -> this.orientation = orientation.previous();
            case FORWARD -> {
                position = position.add(orientation.toUnitVector());
                if (position.x > 4 || position.y > 4 || position.x < 0 || position.y < 0) {
                    position = position.subtract(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                position = position.subtract(orientation.toUnitVector());
                if (position.x > 4 || position.y > 4 || position.x < 0 || position.y < 0) {
                    position = position.add(orientation.toUnitVector());
                }

            }
        }
    }
}

