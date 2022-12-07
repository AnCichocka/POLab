package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    //NEXT
    @Test
    void nextNORTH(){
        MapDirection direction = MapDirection.NORTH;
        assertEquals(direction.next(), MapDirection.EAST);
    }

    @Test
    void nextEAST(){
        MapDirection direction = MapDirection.EAST;
        assertEquals(direction.next(), MapDirection.SOUTH);
    }

    @Test
    void nextSOUTH(){
        MapDirection direction = MapDirection.SOUTH;
        assertEquals(direction.next(), MapDirection.WEST);
    }

    @Test
    void nextWEST(){
        MapDirection direction = MapDirection.WEST;
        assertEquals(direction.next(), MapDirection.NORTH);
    }

    //PREVIOUS
    @Test
    void previousNORTH(){
        MapDirection direction = MapDirection.NORTH;
        assertEquals(direction.previous(), MapDirection.WEST);
    }

    @Test
    void previousEAST(){
        MapDirection direction = MapDirection.EAST;
        assertEquals(direction.previous(), MapDirection.NORTH);
    }

    @Test
    void previousSOUTH(){
        MapDirection direction = MapDirection.SOUTH;
        assertEquals(direction.previous(), MapDirection.EAST);
    }

    @Test
    void previousWEST(){
        MapDirection direction = MapDirection.WEST;
        assertEquals(direction.previous(), MapDirection.SOUTH);
    }
}