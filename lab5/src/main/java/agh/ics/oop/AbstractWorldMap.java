package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        IMapElement grassPiece = null;
        for (IMapElement element : this.mapElements){
            if (element.getPosition().equals(position)){
                if (element instanceof Animal){
                    return element;
                }
                else{
                    grassPiece = element;
                }
            }
        }
        return grassPiece;
    }
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            this.mapElements.add(animal);
            return true;
        }
        return false;
    }

    public String toString(Vector2d lowerLeft, Vector2d upperRight){
        return this.visualizer.draw(lowerLeft, upperRight);
    }
}
