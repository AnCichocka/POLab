package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    ///////////////////////////////////////////////////ORIENTATION
    @Test
    void IsOrientationInMoveRightCorrect(){

        Animal a = new Animal();

        a.move(MoveDirection.RIGHT);
        MapDirection expectedOrientation = MapDirection.EAST;
        assertEquals(a.getOrientation(),expectedOrientation);

        a.setOrientation(MapDirection.EAST);
        a.move(MoveDirection.RIGHT);
        expectedOrientation = MapDirection.SOUTH;
        assertEquals(a.getOrientation(),expectedOrientation);

        a.setOrientation(MapDirection.SOUTH);
        a.move(MoveDirection.RIGHT);
        expectedOrientation = MapDirection.WEST;
        assertEquals(a.getOrientation(),expectedOrientation);

        a.setOrientation(MapDirection.WEST);
        a.move(MoveDirection.RIGHT);
        expectedOrientation = MapDirection.NORTH;
        assertEquals(a.getOrientation(),expectedOrientation);
    }

    @Test
    void IsOrientationInMoveLeftCorrect(){

        Animal a = new Animal();

        a.move(MoveDirection.LEFT);
        MapDirection expectedOrientation = MapDirection.WEST;
        assertEquals(a.getOrientation(),expectedOrientation);

        a.setOrientation(MapDirection.WEST);
        a.move(MoveDirection.LEFT);
        expectedOrientation = MapDirection.SOUTH;
        assertEquals(a.getOrientation(),expectedOrientation);

        a.setOrientation(MapDirection.SOUTH);
        a.move(MoveDirection.LEFT);
        expectedOrientation = MapDirection.EAST;
        assertEquals(a.getOrientation(),expectedOrientation);

        a.setOrientation(MapDirection.EAST);
        a.move(MoveDirection.LEFT);
        expectedOrientation = MapDirection.NORTH;
        assertEquals(a.getOrientation(),expectedOrientation);

    }


    ///////////////////////////////////////////////////POSITION
    @Test
    void IsPositionInMoveForwardCorrectInAllowedBox(){

        Animal a = new Animal();

        a.move(MoveDirection.FORWARD);
        Vector2d expectedPosition = new Vector2d(2,3);
        assertEquals(a.getPosition(), expectedPosition);

        a = new Animal();
        a.setOrientation(MapDirection.EAST);
        a.move(MoveDirection.FORWARD);
        expectedPosition = new Vector2d(3,2);
        assertEquals(a.getPosition(), expectedPosition);

        a = new Animal();
        a.setOrientation(MapDirection.SOUTH);
        a.move(MoveDirection.FORWARD);
        expectedPosition = new Vector2d(2,1);
        assertEquals(a.getPosition(), expectedPosition);

        a = new Animal();
        a.setOrientation(MapDirection.WEST);
        a.move(MoveDirection.FORWARD);
        expectedPosition = new Vector2d(1,2);
        assertEquals(a.getPosition(), expectedPosition);

    }

    @Test
    void CanIGoOutOfTheAllowedBox(){

        Animal a = new Animal();

        a.setPosition(new Vector2d(0,0));
        a.move(MoveDirection.BACKWARD);
        Vector2d expectedPosition = new Vector2d(0,0);
        assertEquals(a.getPosition(), expectedPosition);

        a.setPosition(new Vector2d(0,4));
        a.move(MoveDirection.FORWARD);
        expectedPosition = new Vector2d(0,4);
        assertEquals(a.getPosition(), expectedPosition);

        a.setPosition(new Vector2d(4,4));
        a.move(MoveDirection.FORWARD);
        expectedPosition = new Vector2d(4,4);
        assertEquals(a.getPosition(), expectedPosition);

        a.setPosition(new Vector2d(4,0));
        a.move(MoveDirection.BACKWARD);
        expectedPosition = new Vector2d(4,0);
        assertEquals(a.getPosition(), expectedPosition);

    }

}