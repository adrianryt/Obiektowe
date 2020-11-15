package agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        //given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, 3);
        //when
        String result1 = vector1.toString();
        String result2 = vector2.toString();
        //then
        assertEquals("(1,2)", result1);
        assertEquals("(-1,3)", result2);
    }

    @Test
    void precedes() {
        //given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, 3);
        Vector2d vector3 = new Vector2d(0,3);
        //when
        boolean result1 = vector1.precedes(vector3);
        boolean result2 = vector2.precedes(vector3);
        //then
        assertEquals(false, result1);
        assertEquals(true, result2);
    }

    @Test
    void follows() {
        //given
        Vector2d vector1 = new Vector2d(1, 3);
        Vector2d vector2 = new Vector2d(-1, 2);
        Vector2d vector3 = new Vector2d(0,3);
        //when
        boolean result1 = vector1.follows(vector3);
        boolean result2 = vector2.follows(vector3);
        //then
        assertEquals(true, result1);
        assertEquals(false, result2);
    }

    @Test
    void upperRight() {
        //given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, 3);
        Vector2d vector3 = new Vector2d(1,3);
        //when
        Vector2d result1 = vector1.upperRight(vector2);
        Vector2d result2 = vector2.upperRight(vector3);

        //then
        assertEquals(vector3, result1);
        assertEquals(vector3, result2);
    }

    @Test
    void lowerLeft() {
        //given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, 3);
        Vector2d vector3 = new Vector2d(-1,2 );
        //when
        Vector2d result1 = vector1.lowerLeft(vector2);
        Vector2d result2 = vector2.lowerLeft(vector3);

        //then
        assertEquals(vector3, result1);
        assertEquals(vector3, result2);
    }

    @Test
    void add() {
        //given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, 3);
        Vector2d vector3 = new Vector2d(0,5 );
        Vector2d vector4 = new Vector2d(-1,8 );
        //when
        Vector2d result1 = vector1.add(vector2);
        Vector2d result2 = vector2.add(vector3);

        //then
        assertEquals(vector3, result1);
        assertEquals(vector4, result2);
    }

    @Test
    void subtract() {
        //given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, 3);
        Vector2d vector3 = new Vector2d(2,-1 );
        Vector2d vector4 = new Vector2d(-3,4 );
        //when
        Vector2d result1 = vector1.subtract(vector2);
        Vector2d result2 = vector2.subtract(vector3);

        //then
        assertEquals(vector3, result1);
        assertEquals(vector4, result2);

    }

    @Test
    void testEquals() {
        //given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, 3);
        Vector2d vector3 = new Vector2d(2,-1 );
        MapDirection mapdirection = MapDirection.NORTH;
        //when
        boolean result1 = vector1.equals(vector1);
        boolean result2 = vector2.equals(vector3);
        boolean result3 = vector3.equals(mapdirection);

        //then
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    void testHashCode() {
        Vector2d vector2 = new Vector2d(-1, 3);
        Vector2d vector3 = new Vector2d(2,-1 );

        boolean result2 = vector2.equals(vector3);

        assertFalse(result2);
    }

    @Test
    void opposite() {
        //given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, 3);
        Vector2d vector3 = new Vector2d(-1,-2 );
        Vector2d vector4 = new Vector2d(1,-3 );

        //when
        Vector2d result1 = vector1.opposite();
        Vector2d result2 = vector2.opposite();


        //then
        assertEquals(vector3, result1);
        assertEquals(vector4, result2);

    }


}
