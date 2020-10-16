package agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void testToString() {
    }

    @Test
    void next() {
        //given
        MapDirection mapdirection1 = MapDirection.NORTH;
        MapDirection mapdirection2 = MapDirection.EAST;
        MapDirection mapdirection3 = MapDirection.SOUTH;
        MapDirection mapdirection4 = MapDirection.WEST;

        //when
        MapDirection result1 = mapdirection1.next();
        MapDirection result2 = mapdirection2.next();
        MapDirection result3 = mapdirection3.next();
        MapDirection result4 = mapdirection4.next();

        //then
        assertEquals(MapDirection.EAST, result1);
        assertEquals(MapDirection.SOUTH, result2);
        assertEquals(MapDirection.WEST, result3);
        assertEquals(MapDirection.NORTH, result4);

    }

    @Test
    void toUnitVector() {
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }

    @Test
    void previous() {
        //given
        MapDirection mapdirection1 = MapDirection.NORTH;
        MapDirection mapdirection2 = MapDirection.EAST;
        MapDirection mapdirection3 = MapDirection.SOUTH;
        MapDirection mapdirection4 = MapDirection.WEST;

        //when
        MapDirection result1 = mapdirection1.previous();
        MapDirection result2 = mapdirection2.previous();
        MapDirection result3 = mapdirection3.previous();
        MapDirection result4 = mapdirection4.previous();

        //then
        assertEquals(MapDirection.WEST, result1);
        assertEquals(MapDirection.NORTH, result2);
        assertEquals(MapDirection.EAST, result3);
        assertEquals(MapDirection.SOUTH, result4);

    }
}