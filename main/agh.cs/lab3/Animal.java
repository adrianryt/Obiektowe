package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(){
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        this.position = initialPosition;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return switch(this.orientation){
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
      
    public void move(MoveDirector director) {
        switch (director) {
            case RIGHT -> this.orientation = orientation.next();
            case LEFT -> this.orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newposition = this.position.add(this.orientation.toUnitVector());
                if(this.map.canMoveTo(newposition)){
                    this.position = newposition;
                }
            }
            case BACKWARD -> {
                Vector2d newposition = this.position.subtract(this.orientation.toUnitVector());
                if(this.map.canMoveTo(newposition)){
                    this.position = newposition;
                }
            }
        }
    }
}