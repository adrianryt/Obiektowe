package agh.cs.lab5;

import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new LinkedList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    protected abstract Vector2d rightUpCorner();

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0,0),rightUpCorner());
    }

    @Override
    public void add(Animal animal) {
        if(place(animal)){
            animals.add(animal);
        }
    }

    @Override
    public void run(List<MoveDirector> directions) {
        int n = this.animals.size();
        for(int i = 0; i < directions.size(); i++){
            (this.animals.get(i%n)).move(directions.get(i));
        }
    }
}
