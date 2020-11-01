package agh.cs.lab4;

import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void runIntegrationTest() {
        //given
        String[] arguments = {"f","f","l","l","l","b","b","r","r","l","l"};
        List<Animal> results = new LinkedList<>();
        List<Animal> zwierzaki;

        IWorldMap map = new RectangularMap(10, 5);
        List<MoveDirector> directions = new OptionsParser().parser(arguments);
        Animal nutka1 = new Animal(map);
        Animal nutka2 = new Animal(map, new Vector2d(4,5));
        nutka1.move(MoveDirector.FORWARD);
        nutka2.move(MoveDirector.FORWARD);
        nutka1.move(MoveDirector.LEFT);
        nutka2.move(MoveDirector.LEFT);
        nutka1.move(MoveDirector.LEFT);
        nutka2.move(MoveDirector.BACKWARD);
        nutka1.move(MoveDirector.BACKWARD);
        nutka2.move(MoveDirector.RIGHT);
        nutka1.move(MoveDirector.RIGHT);
        nutka2.move(MoveDirector.LEFT);
        nutka1.move(MoveDirector.LEFT);
        results.add(nutka1);
        results.add(nutka2);
        //when
        map.add(new Animal(map));
        map.add(new Animal(map,new Vector2d(4,5)));
        map.run(directions);
        zwierzaki = ((RectangularMap) map).getAnimals();
        //then
        assertEquals(results.get(0).getPosition(),zwierzaki.get(0).getPosition());
        assertEquals(results.get(0).getOrientation(),zwierzaki.get(0).getOrientation());
        assertEquals(results.get(1).getPosition(),zwierzaki.get(1).getPosition());
        assertEquals(results.get(1).getOrientation(),zwierzaki.get(1).getOrientation());



    }
}