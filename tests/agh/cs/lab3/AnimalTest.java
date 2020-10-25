package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirector;
import agh.cs.lab2.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void moveRighLeft() {
        //given
        Animal nutka1 = new Animal();
        Animal nutka2 = new Animal();
        //when
        nutka1.move(MoveDirector.RIGHT);
        nutka2.move(MoveDirector.LEFT);
        //then
        assertEquals(MapDirection.EAST,nutka1.getOrientation());
        assertEquals(MapDirection.WEST,nutka2.getOrientation());
    }

    @Test
    void moveFORWARDBACKWARDOY() {
        //given
        Animal nutka1 = new Animal();
        Animal nutka2 = new Animal();
        //when
        nutka1.move(MoveDirector.FORWARD);
        nutka2.move(MoveDirector.BACKWARD);
        //then
        assertEquals("(2,3)",nutka1.getPosition().toString());
        assertEquals("(2,1)",nutka2.getPosition().toString());
    }

    @Test
    void moveFORWARDBACKWARDOX() {
        //given
        Animal nutka1 = new Animal();
        Animal nutka2 = new Animal();
        //when
        nutka1.move(MoveDirector.RIGHT);
        nutka2.move(MoveDirector.RIGHT);
        nutka1.move(MoveDirector.FORWARD);
        nutka2.move(MoveDirector.BACKWARD);
        //then
        assertEquals("(3,2)",nutka1.getPosition().toString());
        assertEquals("(1,2)",nutka2.getPosition().toString());
    }

    @Test
    void moveBesideTheField() {
        //given
        Animal nutka1 = new Animal(); //górna krawędz
        Animal nutka2 = new Animal(); //prawa krawędz
        Animal nutka3 = new Animal(); //dolna krawędz
        Animal nutka4 = new Animal(); //lewa krawędz

        //when
        nutka1.move(MoveDirector.FORWARD);
        nutka1.move(MoveDirector.FORWARD);
        nutka1.move(MoveDirector.FORWARD);

        nutka2.move(MoveDirector.LEFT);
        nutka2.move(MoveDirector.BACKWARD);
        nutka2.move(MoveDirector.BACKWARD);
        nutka2.move(MoveDirector.BACKWARD);

        nutka3.move(MoveDirector.RIGHT);
        nutka3.move(MoveDirector.RIGHT);
        nutka3.move(MoveDirector.FORWARD);
        nutka3.move(MoveDirector.FORWARD);
        nutka3.move(MoveDirector.FORWARD);

        nutka4.move(MoveDirector.LEFT);
        nutka4.move(MoveDirector.FORWARD);
        nutka4.move(MoveDirector.FORWARD);
        nutka4.move(MoveDirector.FORWARD);

        //then
        assertEquals("(2,4)",nutka1.getPosition().toString());
        assertEquals("(4,2)",nutka2.getPosition().toString());
        assertEquals("(2,0)",nutka3.getPosition().toString());
        assertEquals("(0,2)",nutka4.getPosition().toString());

    }
}