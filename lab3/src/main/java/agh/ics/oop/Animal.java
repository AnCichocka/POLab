package agh.ics.oop;

import java.util.Objects;
import java.util.Vector;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString(){ return "%s %s".formatted(this.position, this.orientation); }

    public boolean isAt(Vector2d position){

        return Objects.equals(this.position, position);

    }

    public void move(MoveDirection direction){
        Vector2d newPosition = position;
        switch (direction) {
            case RIGHT -> {this.orientation = this.orientation.next();}
            case LEFT -> {this.orientation = this.orientation.previous();}
            case FORWARD -> {newPosition = this.position.add(this.orientation.toUnitVector());}
            case BACKWARD -> {newPosition = this.position.subtract(this.orientation.toUnitVector());}
        }
        if (newPosition.precedes(World.UPPER_BOUND) && newPosition.follows(World.LOWER_BOUND)){
            this.position = newPosition;
        }
        //or upper and lower, public static World
        //position = position.lowerLeft(World.LOWER_BOUND).upperRight(World.UPPER_BOUND)
    }

}


