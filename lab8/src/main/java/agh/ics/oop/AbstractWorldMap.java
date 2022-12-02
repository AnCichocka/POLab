package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    private MapVisualizer visualizer = new MapVisualizer(this);
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapBoundary mapBoundary = new MapBoundary();


    @Override
    public Object objectAt(Vector2d position){
        return this.animals.get(position);
    }
    //wyrzuc boolean bo zawsze zwroci true
    @Override
    public boolean place(Animal animal){
        if (this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            this.mapBoundary.add(animal.getPosition());
            animal.addObserver(this);
            animal.addObserver(this.mapBoundary);
            return true;
        }
        else{
            throw new IllegalArgumentException(animal.getPosition() + " is invalid position");
        }
    }
    @Override
    public String toString(){return this.visualizer.draw(getLowerLeftBound(), getUpperRightBound());}
    public abstract Vector2d getLowerLeftBound();
    public abstract Vector2d getUpperRightBound();
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
        this.mapBoundary.positionChanged(oldPosition, newPosition);
    }


    //1 lista -> 1 mapa
    //pozycja w mapie musi się zmieniać w hasp mapie
    //wzorzec projektowy link z opisem, przekazywanie informacji między klasami
}
