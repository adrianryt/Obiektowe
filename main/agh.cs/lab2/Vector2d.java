package agh.cs.lab2;

import java.util.Objects;

public class Vector2d {
    final int x;
    final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return ("(" + this.x + "," + this.y + ")");
    }

    public boolean precedes(Vector2d other){
        if(this.x <= other.x && this.y <= other.y){
            return true;
        }
        return false;
    }

    public boolean follows(Vector2d other){
        if(this.x >= other.x && this.y >= other.y){
            return true;
        }
        return false;
    }

    public Vector2d upperRight(Vector2d other){
        Vector2d result = new Vector2d(Math.max(this.x,other.x),Math.max(this.y,other.y));
        return result;
    }

    public Vector2d lowerLeft(Vector2d other){
        Vector2d result = new Vector2d(Math.min(this.x,other.x), Math.min(this.y,other.y));
        return result;
    }

    public Vector2d add(Vector2d other){
        Vector2d result = new Vector2d(this.x + other.x , this.y + other.y);
        return result;
    }

    public Vector2d subtract(Vector2d other){
        Vector2d result = new Vector2d(this.x - other.x, this.y - other.y);
        return result;
    }

    public boolean equals(Object other){
        if (this == other) { //sprawdzenie czy porównywane obiekty to dokładnie te same obiekty
            return true;
        }
        if (!(other instanceof Vector2d)) { //sprawdzenie czy other jest obiektem Vector2d
            return false;
        }
        Vector2d that = (Vector2d) other;
        if(this.x == that.x && this.y == that.y) // sprawdzenie czy x,y wektorów są sobie równe
            return true;
        return false;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Vector2d opposite(){
        Vector2d result = new Vector2d((-this.x),(-this.y));
        return result;
    }
}
