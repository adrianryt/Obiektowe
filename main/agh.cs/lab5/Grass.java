package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

public class Grass {
    private Vector2d position;

    public Grass(Vector2d initialPosition){

        this.position = initialPosition;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString(){
        return "*" ;
    }

}
