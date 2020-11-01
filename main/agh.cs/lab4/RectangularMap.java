package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab2.MoveDirector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


public class RectangularMap implements IWorldMap {
    private int width;
    private int heigth;
    private List<Animal> animals = new LinkedList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public RectangularMap(int x, int y){
        this.width=x;
        this.heigth=y;
    }

    public void toString(IWorldMap map){
        MapVisualizer visualizer = new MapVisualizer(map);
        System.out.println(visualizer.draw(new Vector2d(0,0),new Vector2d(width,heigth)));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(isOccupied(position)){
            return false;
        }
        if(position.x >= 0 && position.y >= 0 && position.x <= width && position.y <= heigth){
            return true;
        }
        return false;
    }

    public void add(Animal animal){
        if(place(animal)){
            animals.add(animal);
        }
    }

    @Override
    public boolean place(Animal nutka) {
        for(Animal animal: animals){
            if(animal.getPosition().equals(nutka.getPosition())){
                return false;
            }
        }
        return true;
    }

    @Override
    public void run(List<MoveDirector> directions){
        int n= animals.size();
        for(int i= 0; i<directions.size(); i++){
            (animals.get(i%n)).move(directions.get(i));
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal: animals){
            if(animal.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(isOccupied(position)){
            for(Animal animal: animals){
                if(animal.getPosition().equals(position)){
                    return animal.toString();
                }
            }
        }
        return null;
    }
}
