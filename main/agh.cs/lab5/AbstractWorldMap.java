package agh.cs.lab5;

import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new LinkedList<>();
    protected Map<Vector2d,Animal> hashAnimals= new HashMap<>();

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
            hashAnimals.put(animal.getPosition(),animal);
        }

    }

    @Override
    public void run(List<MoveDirector> directions) {
        int n = this.animals.size();
        for(int i = 0; i < directions.size(); i++){
            hashAnimals.remove(animals.get(i%n).getPosition());
            (this.animals.get(i%n)).move(directions.get(i));
            hashAnimals.put(animals.get(i%n).getPosition(),animals.get(i%n));
        }
    }
}
