package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import static java.lang.Math.*;

public class GrassField extends AbstractWorldMap {

    private final List<Grass> grass = new LinkedList<>();

    public List<Grass> getGrass() {
        return grass;
    }

    public GrassField(int grassNum){
        placeGrass(grassNum);
    }

    @Override
    public Vector2d rightUpCorner(){
        return getRightUpCorner();
    }


    private void placeGrass(int n){
        Random generator = new Random();
        for(int i = 0; i < n; i++){
            Vector2d next = new Vector2d(generator.nextInt((int) sqrt(n*10) +1 ),generator.nextInt((int) sqrt(n*10) + 1));
            if(checkGrass(next)){
                grass.add(new Grass(next));
            }
            else {
                i--;
            }
        }
    }

    private boolean checkGrass(Vector2d next) {
        for(Grass grass: grass){
            if(next.equals(grass.getPosition())){
                return false;
            }
        }
        return true;
    }

    private Vector2d getRightUpCorner(){
        int maksx = 0;
        int maksy = 0;
        for( Animal animal: this.animals){
            if(animal.getPosition().x >maksx){
                maksx = animal.getPosition().x;
            }
            if(animal.getPosition().y >maksy){
                maksy = animal.getPosition().y;
            }
        }
        for( Grass grass: grass){
            if(grass.getPosition().x >maksx){
                maksx = grass.getPosition().x;
            }
            if(grass.getPosition().y >maksy){
                maksy = grass.getPosition().y;
            }
        }
        return new Vector2d(maksx,maksy);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for(Animal animal: animals){
            if(animal.getPosition().equals(position)){
                return false;
            }
        }

        if(position.x >= 0 && position.y >= 0 && position.x <= Integer.MAX_VALUE  && position.y <= Integer.MAX_VALUE){
            return true;
        }
        return false;
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
    public boolean isOccupied(Vector2d position) {
        for(Animal animal: animals){
            if(animal.getPosition().equals(position)){
                return true;
            }
        }
        for(Grass grass: grass){
            if(grass.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        for(Animal animal: animals) {
            if (animal.getPosition().equals(position)) {
                return Optional.of(animal);
            }
        }
        for(Grass grass: grass){
            if(grass.getPosition().equals(position) ){
                return Optional.of(grass);
            }
        }return Optional.empty();
    }
}
