package agh.ics.oop;

import java.util.Objects;
import java.util.Vector;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

//    public Animal(){
//        this(null);
//    }
    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2));
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public Vector2d getPosition() {
        return new Vector2d(this.position.x, this.position.y);
    }

    @Override
    public String toString(){
        String stringMapDirection = switch(this.orientation){
            case NORTH -> "N";
            case WEST -> "W";
            case SOUTH-> "S";
            case EAST -> "E";
        };
        return stringMapDirection;
    }

    public boolean isAt(Vector2d position){

        return Objects.equals(this.position, position);

    }

    public void move(MoveDirection direction){

        Vector2d newPosition = position;

        switch (direction) {
            case RIGHT -> { this.orientation = this.orientation.next(); }
            case LEFT -> { this.orientation = this.orientation.previous(); }
            case FORWARD -> { newPosition = this.position.add(this.orientation.toUnitVector()); }
            case BACKWARD -> { newPosition = this.position.subtract(this.orientation.toUnitVector()); }
        }
        if (map.canMoveTo(newPosition)){
            this.position = newPosition;
        }

    }
}


