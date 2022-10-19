package agh.ics.oop;

import java.util.Objects;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    @Override
    public String toString(){ return "%s %s".formatted(this.position, this.orientation); }

    public boolean isAt(Vector2d position){

        if (Objects.equals(this.position, position)){
            return true;
        }
        return false;
    }
}

