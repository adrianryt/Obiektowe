package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import agh.cs.lab5.AbstractWorldMap;
import java.util.Optional;



public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int heigth;
    public RectangularMap(int x, int y){
        this.width=x;
        this.heigth=y;
    }

    @Override
    public Vector2d rightUpCorner(){ return new Vector2d(width,heigth);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(isOccupied(position)){
            return false;
        }
        if(position.x >= 0 && position.y >= 0 && position.x <= this.width && position.y <= this.heigth){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal nutka) {
        if(nutka.getPosition().x > this.width || nutka.getPosition().y >this.heigth || nutka.getPosition().x < 0 || nutka.getPosition().y < 0  ){
                throw new IllegalArgumentException(nutka.getPosition().toString() + "this place is out of border");
        }
        if(hashAnimals.containsKey(nutka.getPosition())){
                throw new IllegalArgumentException(nutka.getPosition().toString() + "this place is taken");
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(hashAnimals.containsKey(position)){
            return true;
        }
        return false;
    }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
            if(hashAnimals.containsKey(position)){
                return Optional.of(hashAnimals.get(position));
        }
        return Optional.empty();
    }
}
