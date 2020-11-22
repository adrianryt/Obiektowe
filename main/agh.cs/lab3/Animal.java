package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.LinkedList;
import java.util.List;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new LinkedList<>();

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

    }

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
    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);

    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer: this.observers){
            observer.positionChanged(oldPosition,newPosition);
        }
    }
}

