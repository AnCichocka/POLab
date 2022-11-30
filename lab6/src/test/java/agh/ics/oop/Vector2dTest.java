package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    //////////////////////////////////////////////////////EQUALS
    @Test
    void equals1(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v1, v2);
    }

    @Test
    void equals2(){
        Vector2d v1 = new Vector2d(1,2);
        assertTrue(v1.equals(v1));
    }

    @Test
    void equals3(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(6,2);
        assertFalse(v1.equals(v2));
    }

    @Test
    void equals4(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,4);
        assertFalse(v1.equals(v2));
    }

    @Test
    void equals5(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(6,4);
        assertFalse(v1.equals(v2));
    }

    //////////////////////////////////////////////////////TO STRING
    @Test
    void stringNORTH(){
        MapDirection direction = MapDirection.NORTH;
        assertEquals(direction.toString(), "północ");
    }
    @Test
    void stringEAST(){
        MapDirection direction = MapDirection.EAST;
        assertEquals(direction.toString(), "wschód");
    }
    @Test
    void stringSOUTH(){
        MapDirection direction = MapDirection.SOUTH;
        assertEquals(direction.toString(), "południe");
    }
    @Test
    void stringWEST(){
        MapDirection direction = MapDirection.WEST;
        assertEquals(direction.toString(), "zachód");
    }

    //////////////////////////////////////////////////////PRECEDES
    @Test
    void precedes1(){
        Vector2d v1 = new Vector2d(1,2);
        assertTrue(v1.precedes(v1));
    }

    @Test
    void precedes2(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        assertTrue(v1.precedes(v2));
    }

    @Test
    void precedes3(){
        Vector2d v1 = new Vector2d(4,2);
        Vector2d v2 = new Vector2d(2,2);
        assertFalse(v1.precedes(v2));
    }

    @Test
    void precedes4(){
        Vector2d v1 = new Vector2d(2,7);
        Vector2d v2 = new Vector2d(2,2);
        assertFalse(v1.precedes(v2));
    }

    @Test
    void precedes5(){
        Vector2d v1 = new Vector2d(9,7);
        Vector2d v2 = new Vector2d(2,2);
        assertFalse(v1.precedes(v2));
    }

    //////////////////////////////////////////////////////FOLLOWS
    @Test
    void follows1(){
        Vector2d v1 = new Vector2d(1,2);
        assertTrue(v1.follows(v1));
    }

    @Test
    void follows2(){
        Vector2d v1 = new Vector2d(3,2);
        Vector2d v2 = new Vector2d(1,2);
        assertTrue(v1.follows(v2));
    }

    @Test
    void follows3(){
        Vector2d v1 = new Vector2d(0,2);
        Vector2d v2 = new Vector2d(1,2);
        assertFalse(v1.follows(v2));
    }

    @Test
    void follows4(){
        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d(1,2);
        assertFalse(v1.follows(v2));
    }

    @Test
    void follows5(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(1,2);
        assertFalse(v1.follows(v2));
    }

    //////////////////////////////////////////////////////UPPER RIGHT
    @Test
    void upperRight1(){
        Vector2d v1 = new Vector2d(1,2);
        assertEquals(v1.upperRight(v1), new Vector2d(1,2));
    }

    @Test
    void upperRight2(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        assertEquals(v1.upperRight(v2), new Vector2d(2,2));
    }

    @Test
    void upperRight3(){
        Vector2d v1 = new Vector2d(1,7);
        Vector2d v2 = new Vector2d(2,2);
        assertEquals(v1.upperRight(v2), new Vector2d(2,7));
    }

    //////////////////////////////////////////////////////LOWER LEFT
    @Test
    void lowerLeft1(){
        Vector2d v1 = new Vector2d(1,1);
        assertEquals(v1.lowerLeft(v1), new Vector2d(1,1));
    }

    @Test
    void lowerLeft2(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        assertEquals(v1.lowerLeft(v2), new Vector2d(1,1));
    }

    @Test
    void lowerLeft3(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(0,7);
        assertEquals(v1.lowerLeft(v2), new Vector2d(0,1));
    }

    //////////////////////////////////////////////////////ADD
    @Test
    void add1(){
        Vector2d v1 = new Vector2d(1,1);
        assertEquals(v1.add(v1), new Vector2d(2,2));
    }

    @Test
    void add2(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(-1,-1);
        assertEquals(v1.add(v2), new Vector2d(0,0));
    }

    @Test
    void add3(){
        Vector2d v1 = new Vector2d(2,1);
        Vector2d v2 = new Vector2d(3,7);
        assertEquals(v1.add(v2), new Vector2d(5,8));
    }

    //////////////////////////////////////////////////////SUBTRACT
    @Test
    void subtract1(){
        Vector2d v1 = new Vector2d(1,1);
        assertEquals(v1.subtract(v1), new Vector2d(0,0));
    }

    @Test
    void subtract2(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        assertEquals(v1.subtract(v2), new Vector2d(-1,-1));
    }

    @Test
    void subtract3(){
        Vector2d v1 = new Vector2d(2,1);
        Vector2d v2 = new Vector2d(3,7);
        assertEquals(v1.subtract(v2), new Vector2d(-1,-6));
    }

    @Test
    void subtract4(){
        Vector2d v1 = new Vector2d(5,5);
        Vector2d v2 = new Vector2d(3,7);
        assertEquals(v1.subtract(v2), new Vector2d(2,-2));
    }

    //////////////////////////////////////////////////////OPPOSITE
    @Test
    void opposite1(){
        Vector2d v1 = new Vector2d(1,1);
        assertEquals(v1.opposite(), new Vector2d(-1,-1));
    }

    @Test
    void opposite2(){
        Vector2d v1 = new Vector2d(-1,-1);
        assertEquals(v1.opposite(), new Vector2d(1,1));
    }

    @Test
    void opposite3(){
        Vector2d v1 = new Vector2d(-1,1);
        assertEquals(v1.opposite(), new Vector2d(1,-1));
    }

    @Test
    void opposite4(){
        Vector2d v1 = new Vector2d(1,-1);
        assertEquals(v1.opposite(), new Vector2d(-1,1));
    }

}