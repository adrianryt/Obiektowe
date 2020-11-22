package agh.cs.lab5;

import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;

import java.util.List;

public class World {
    public static void main(String[] args) {
        try {
            String[] arguments = {"f", "f", "l", "l", "l", "b", "b", "r", "r", "l", "l", "f", "f", "f", "l", "f", "f", "f"};
            List<MoveDirector> directions = new OptionsParser().parser(arguments);
            IWorldMap map = new GrassField(10);
            map.add(new Animal(map));
            map.add(new Animal(map, new Vector2d(4, 5)));
            map.add(new Animal(map, new Vector2d(6, 7)));
            map.add(new Animal(map, new Vector2d(2, 6)));
            map.add(new Animal(map, new Vector2d(11, 5)));
            map.run(directions);
            System.out.println(map.toString());
        }
        catch(IllegalArgumentException ex){
            System.out.println("Zakończono proces z powodu:" + ex);
        }
    }
}
