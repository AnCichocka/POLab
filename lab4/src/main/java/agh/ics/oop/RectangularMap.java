package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RectangularMap implements IWorldMap{

    private final int width;
    private final int height;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final List<Animal> animals;
    private final MapVisualizer visualizer;
    RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width-1, height-1);
        this.animals = new ArrayList<Animal>();
        this.visualizer = new MapVisualizer(this);
    }

    public boolean canMoveTo(Vector2d position){

        return position.follows(lowerLeft) && position.precedes(upperRight) && !this.isOccupied(position);

    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animalInMap : this.animals){
            if (animalInMap.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
    public boolean place(Animal animal){

        if (this.canMoveTo(animal.getPosition()) ) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }
    public Object objectAt(Vector2d position){
        for (Animal animalInMap : this.animals){
            if (animalInMap.getPosition().equals(position)){
                return animalInMap;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.visualizer.draw(this.lowerLeft, this.upperRight);
    }

}
