package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal implements IMapElement{

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;
    private final List<IPositionChangeObserver> observers;


    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2));
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
        this.observers = new ArrayList<>();
        //addObserver((IPositionChangeObserver) map);
        //lepiej w place albo IWorldMap extends IPos...
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
            this.positionChanged(this.position, newPosition);
            this.position = newPosition;
        }

    }
    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        //this.observers.forEach(observer -> observer.positionChanged(oldPosition, newPosition));
        for( IPositionChangeObserver observer: this.observers ){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
    @Override
    public String getImageName(){

        String ImageName = switch(this.orientation){
            case NORTH -> "src/main/resources/cat_up.png";
            case WEST -> "src/main/resources/cat_left.png";
            case SOUTH-> "src/main/resources/cat_down.png";
            case EAST -> "src/main/resources/cat_right.png";
        };
        return ImageName;
    }
}


