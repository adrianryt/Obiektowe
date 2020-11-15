package agh.cs.lab5;

import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {



    @Test
    void canMoveToOccupationTest() {
        //given
        String[] arguments = {"f"};
        List<MoveDirector> directions = new OptionsParser().parser(arguments);
        IWorldMap map = new RectangularMap(5, 5);
        Animal nutka1 = new Animal(map);
        Animal checkOccupation = new Animal(map, new Vector2d(2,3));
        //when
        map.add(nutka1);
        map.add(checkOccupation);
        map.run(directions);
        //then
        assertEquals(new Vector2d(2,2),nutka1.getPosition());
    }
    @Test
    void canMoveToOutOfBorderTest() {
        //given
        String[] arguments = {"f","r","f"};
        List<MoveDirector> directions = new OptionsParser().parser(arguments);
        IWorldMap map = new RectangularMap(5, 5);
        Animal nutka1 = new Animal(map, new Vector2d(5,5));
        //when
        map.add(nutka1);
        map.run(directions);
        //then
        assertEquals(new Vector2d(5,5),nutka1.getPosition());
    }
    @Test
    void canMoveToGoodTest() {
        //given
        String[] arguments = {"f","r","f"};
        List<MoveDirector> directions = new OptionsParser().parser(arguments);
        IWorldMap map = new RectangularMap(5, 5);
        Animal nutka1 = new Animal(map, new Vector2d(4,4));
        //when
        map.add(nutka1);
        map.run(directions);
        //then
        assertEquals(new Vector2d(5,5),nutka1.getPosition());
    }

    @Test //testy dla add oraz place będa robione razem
    void addOutOfBorder() {
        //given
        IWorldMap map = new RectangularMap(5, 5);
        Animal nutka1 = new Animal(map, new Vector2d(6,4));
        Animal nutka2 = new Animal(map, new Vector2d(-2,4));
        //when
        //then
        assertThrows(IllegalArgumentException.class,() ->{ map.add(nutka2); });
    }
    @Test
    void addToOccupatedPosition() {
        //given
        IWorldMap map = new RectangularMap(5, 5);
        Animal nutka1 = new Animal(map, new Vector2d(4,4));
        map.add(nutka1);
        Animal nutka2 = new Animal(map, new Vector2d(4,4));
        //whe
        //then
        assertThrows(IllegalArgumentException.class,() ->{ map.add(nutka2); });
    }
    @Test
    void addGood() {
        //given
        IWorldMap map = new RectangularMap(5, 5);
        Animal nutka1 = new Animal(map, new Vector2d(3,4));

        Animal nutka2 = new Animal(map, new Vector2d(4,4));
        //when
        map.add(nutka1);
        map.add(nutka2);
        //then
        assertEquals(nutka1,((RectangularMap) map).getAnimals().get(0));
        assertEquals(nutka2,((RectangularMap) map).getAnimals().get(1));
    }


    @Test
    void run() {
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

    @Test
    void isOccupied() {
        //given
        IWorldMap map = new RectangularMap(5, 5);
        Animal nutka1 = new Animal(map, new Vector2d(3,4));
        //when
        map.add(nutka1);
        //then
        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(3,5)));

    }

    @Test
    void objectAt() {
        //given
        IWorldMap map = new RectangularMap(5, 5);
        Animal nutka1 = new Animal(map, new Vector2d(3,4));
        //when
        map.add(nutka1);
        //then
        assertEquals(Optional.of(nutka1),map.objectAt(new Vector2d(3,4)));
        assertEquals(Optional.empty(),map.objectAt(new Vector2d(3,5)));
    }
}