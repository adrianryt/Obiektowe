package agh.cs.lab5;

import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChangeObserver;
import agh.cs.lab7.MapBoundary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected List<Animal> animals = new LinkedList<>();
    protected Map<Vector2d,Animal> hashAnimals= new HashMap<>();
    protected MapBoundary mapBoundary;

    public List<Animal> getAnimals() {
        return animals;
    }


    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(mapBoundary.getLower(),mapBoundary.getUpper());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal nutka= hashAnimals.get(oldPosition);
        hashAnimals.remove(oldPosition);
        hashAnimals.put(newPosition,nutka);
    }

    @Override
    public void add(Animal animal) {
        if(place(animal)){
            animals.add(animal);
            hashAnimals.put(animal.getPosition(),animal);
            animal.addObserver(this.mapBoundary);
            MapBoundary.positionAdd(animal.getPosition());
        }

    }

    @Override
    public void run(List<MoveDirector> directions) {
        int n = this.animals.size();
        for(int i = 0; i < directions.size(); i++){
            hashAnimals.remove(animals.get(i%n).getPosition());
            Vector2d oldPos = this.animals.get(i%n).getPosition();
            (this.animals.get(i%n)).move(directions.get(i));
            hashAnimals.put(animals.get(i%n).getPosition(),animals.get(i%n));
            (this.animals.get(i%n)).positionChanged(oldPos,animals.get(i%n).getPosition());
        }
    }
}
