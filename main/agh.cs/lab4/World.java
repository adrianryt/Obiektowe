package agh.cs.lab4;

import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import java.util.List;

public class World {
    public static void main(String[] args) {
        String[] arguments = {"f","f","l","l","l","b","b","r","r","l","l"};
        List<MoveDirector> directions = new OptionsParser().parser(arguments);
        IWorldMap map = new RectangularMap(10, 5);
        map.add(new Animal(map));
        map.add(new Animal(map,new Vector2d(4,5)));
        map.run(directions);
        System.out.println();
        ((RectangularMap) map).toString(map);

    }
}
