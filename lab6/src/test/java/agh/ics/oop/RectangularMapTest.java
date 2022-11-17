package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {
    @Test
    void test(){
        String[] args = {"r","l","f","f","l","r","f","r","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(3,3);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,0) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(0,2)));
        assertTrue(map.isOccupied(new Vector2d(2,0)));

        System.out.println(map);
    }
}