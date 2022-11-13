package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected  List<IMapElement> mapElements;
    protected MapVisualizer visualizer;

    public AbstractWorldMap(){
        this.mapElements = new ArrayList<>();
        this.visualizer = new MapVisualizer(this);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }
    @Override
    public Object objectAt(Vector2d position){
        for (IMapElement element : this.mapElements){
            if (element.getPosition().equals(position)){
                return element;
            }
        }
        return null;

        //return this.animals.stream().filter(animal -> animal.getPosition().equals(position)).findFirst().orElse(null);
    }
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            Object element = objectAt(animal.getPosition());
            if (element instanceof Grass){
                this.mapElements.remove(element);
            }
            this.mapElements.add(animal);
            return true;
        }
        return false;
    }
    public String toString(Vector2d lowerLeft, Vector2d upperRight){
        return this.visualizer.draw(lowerLeft, upperRight);
    }
}
