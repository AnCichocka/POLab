package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] moveDirections;
    private final IWorldMap map;
    private final Vector2d[] animalsVectors;
    private final List<Animal> animalsOnMap = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] animalsVectors){
        this.moveDirections = moveDirections;
        this.map = map;
        this.animalsVectors = animalsVectors;
    }
    private int addAndReturnNumberOfAnimals(){

        int numberOfAnimalsOnMap = 0;

        for (Vector2d animalVector : animalsVectors){
            Animal animalToInsert = new Animal(this.map, animalVector);
            if(this.map.place(animalToInsert )){
                this.animalsOnMap.add(animalToInsert);
                numberOfAnimalsOnMap++;
            }
        }
        return numberOfAnimalsOnMap;
    }
    public void run(){

        int numberOfAnimalsOnMap = this.addAndReturnNumberOfAnimals();
        for (int i = 0; i < this.moveDirections.length; i++){
            this.animalsOnMap.get(i%numberOfAnimalsOnMap).move(this.moveDirections[i]);
        }
    }
}
