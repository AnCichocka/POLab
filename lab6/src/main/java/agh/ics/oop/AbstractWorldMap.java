package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap {

    protected HashMap<Vector2d, Animal> animals = new HashMap();
    private MapVisualizer visualizer = new MapVisualizer(this);


    @Override
    public Object objectAt(Vector2d position){
        return this.animals.containsKey(position);
    }
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }
    public String toString(){
        return this.visualizer.draw(getLowerLeftBound(), getUpperRightBound());
    }
    protected abstract Vector2d getLowerLeftBound();
    protected abstract Vector2d getUpperRightBound();


    //1 lista -> 1 mapa
    //pozycja w mapie musi się zmieniać w hasp mapie
    //wzorzec projektowy link z opisem, przekazywanie informacji między klasami
}
