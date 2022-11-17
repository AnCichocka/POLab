package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap {

    protected ArrayList<Animal> animals = new ArrayList<>();
    private MapVisualizer visualizer = new MapVisualizer(this);


    @Override
    public Object objectAt(Vector2d position){
        for (Animal animal : this.animals){
            if (animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    public String toString(){
        return this.visualizer.draw(getLowerLeftBound(), getUpperRightBound());
        //return this.visualizer.draw(getLowerLeftBound(), getupperRight());
    }

    protected abstract Vector2d getLowerLeftBound();
    protected abstract Vector2d getUpperRightBound();


    //1 lista -> 1 mapa
    //pozycja w mapie musi się zmieniać w hasp mapie
    //wzorzec projektowy link z opisem, przekazywanie informacji między klasami
}
