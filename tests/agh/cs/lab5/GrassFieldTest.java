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

class GrassFieldTest {



    @Test
    void canMoveToOccupationTest() {
        //given
        String[] arguments = {"f"};
        List<MoveDirector> directions = new OptionsParser().parser(arguments);
        IWorldMap map = new GrassField(5);
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
        String[] arguments = {"b"};
        List<MoveDirector> directions = new OptionsParser().parser(arguments);
        IWorldMap map = new GrassField(5);
        Animal nutka1 = new Animal(map, new Vector2d(0,0));
        //when
        map.add(nutka1);
        map.run(directions);
        //then
        assertEquals(new Vector2d(0,0),nutka1.getPosition());
    }

    @Test
    void canMoveToGoodTest() {
        //given
        String[] arguments = {"f","r","f"};
        List<MoveDirector> directions = new OptionsParser().parser(arguments);
        IWorldMap map = new GrassField(5);
        Animal nutka1 = new Animal(map, new Vector2d(4,4));
        //when
        map.add(nutka1);
        map.run(directions);
        //then
        assertEquals(new Vector2d(5,5),nutka1.getPosition());
    }

    @Test
    void addToOccupatedPosition() {
        //given
        IWorldMap map = new GrassField(5);
        Animal nutka1 = new Animal(map, new Vector2d(4,4));
        map.add(nutka1);
        Animal nutka2 = new Animal(map, new Vector2d(4,4));
        //when
        map.add(nutka2);
        //then
        assertEquals(1,((GrassField) map).getAnimals().size());
    }
    @Test
    void addGood() {
        //given
        IWorldMap map = new GrassField(5);
        Animal nutka1 = new Animal(map, new Vector2d(3,4));

        Animal nutka2 = new Animal(map, new Vector2d(4,4));
        //when
        map.add(nutka1);
        map.add(nutka2);
        //then
        assertEquals(nutka1,((GrassField) map).getAnimals().get(0));
        assertEquals(nutka2,((GrassField) map).getAnimals().get(1));
    }


    @Test
    void run() {
        //given
        String[] arguments = {"f","f","l","l","l","b","b","r","r","l","l"};
        List<Animal> results = new LinkedList<>();
        List<Animal> zwierzaki;

        IWorldMap map = new GrassField(10);
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
        zwierzaki = ((GrassField) map).getAnimals();
        //then
        assertEquals(results.get(0).getPosition(),zwierzaki.get(0).getPosition());
        assertEquals(results.get(0).getOrientation(),zwierzaki.get(0).getOrientation());
        assertEquals(results.get(1).getPosition(),zwierzaki.get(1).getPosition());
        assertEquals(results.get(1).getOrientation(),zwierzaki.get(1).getOrientation());

    }


    @Test
    void isOccupiedByAnimal() {
        //given
        IWorldMap map = new GrassField(0);
        Animal nutka1 = new Animal(map, new Vector2d(3,4));
        //when
        map.add(nutka1);
        //then
        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(3,5)));
    }
    @Test
    void isOccupiedByGrass() {
        //given
        IWorldMap map = new GrassField(2);
        //when
        int licznik = 0;
        for(int i=0; i <=5; i++){
            for(int j=0; j <= 5; j++){
                if(map.isOccupied(new Vector2d(i,j))){
                    licznik++;
                }
            }
        }
        //then
        assertEquals(2,licznik);
    }


    @Test
    void objectAt() {
        //given
        IWorldMap map = new GrassField(5);
        Animal nutka1 = new Animal(map, new Vector2d(3,4));
        Grass result = ((GrassField) map).getGrass().get(0);
        //when
        map.add(nutka1);
        //then
        assertEquals(Optional.of(nutka1),map.objectAt(new Vector2d(3,4)));
        assertEquals(Optional.of(result),map.objectAt(result.getPosition()));
    }
}