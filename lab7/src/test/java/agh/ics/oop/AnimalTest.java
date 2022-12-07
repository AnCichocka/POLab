package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    public void placeAnimalWithNoExceptions(){
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(map, new Vector2d(0, 0));

        map.place(animal);
        assertEquals(map.objectAt(new Vector2d(0, 0)), animal);
    }
    @Test
    public void placeAnimalOutsideMap(){
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(map, new Vector2d(10, 10));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { map.place(animal); });

        assertEquals(new Vector2d(10, 10) + " is invalid position", exception.getMessage());
    }
    @Test
    public void placeAnimalsAtTheSameSpot(){
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal1 = new Animal(map, new Vector2d(0, 0));
        Animal animal2 = new Animal(map, new Vector2d(0, 0));

        map.place(animal1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { map.place(animal2); });

        assertEquals(new Vector2d(0, 0) + " is invalid position", exception.getMessage());
    }
}