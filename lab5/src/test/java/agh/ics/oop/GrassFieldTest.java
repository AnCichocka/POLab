package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    void test(){
        String[] args = {"r","l","f","f","l","l","l","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,0) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(-1,0)));
        assertTrue(map.isOccupied(new Vector2d(1,-1)));

        System.out.println(map);
    }
}