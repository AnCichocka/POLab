package agh.ics.oop;

import java.util.Objects;

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

        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (newPosition.precedes(new Vector2d(4,4)) && newPosition.follows(new Vector2d(0,0))){
                    this.position = newPosition;
                }
                break;
            case BACKWARD:
                newPosition = this.position.subtract(this.orientation.toUnitVector());
                if (newPosition.precedes(new Vector2d(4,4)) && newPosition.follows(new Vector2d(0,0))){
                    this.position = newPosition;
                }
                break;
        }
    }

}


