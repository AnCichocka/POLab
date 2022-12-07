package agh.ics.oop;

import agh.ics.oop.gui.AppVisualizer;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] moveDirections;
    private final IWorldMap map;
    private final Vector2d[] animalsVectors;
    private final List<Animal> animalsOnMap = new ArrayList<>();
    protected AppVisualizer appVisualizer;
    private int moveDelay;

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] animalsVectors){
        this.moveDirections = moveDirections;
        this.map = map;
        this.animalsVectors = animalsVectors;

        this.addAnimals();
    }
    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] animalsVectors, AppVisualizer appVisualizer, int moveDelay){
        this(moveDirections, map, animalsVectors);
        this.appVisualizer = appVisualizer;
        this.moveDelay = moveDelay;
    }
    public SimulationEngine(IWorldMap map, Vector2d[] animalsVectors, AppVisualizer appVisualizer, int moveDelay){
        this.map = map;
        this.animalsVectors = animalsVectors;
        this.appVisualizer = appVisualizer;
        this.moveDelay = moveDelay;

        this.addAnimals();
    }

    public void setDirection(MoveDirection[] moveDirection){
        this.moveDirections = moveDirection;
    }
    private void addAnimals(){

        for (Vector2d animalVector : animalsVectors){
            Animal animalToInsert = new Animal(this.map, animalVector);
            if(this.map.place(animalToInsert)){
                this.animalsOnMap.add(animalToInsert);
                animalToInsert.addObserver(this.appVisualizer);
            }
        }
    }
    @Override
    public void run(){
//        System.out.println(this.map);
        int numberOfAnimalsOnMap = this.animalsOnMap.size();
            try{
                Thread.sleep(moveDelay);
                for (int i = 0; i < this.moveDirections.length; i++) {
                    Animal animal = this.animalsOnMap.get(i % numberOfAnimalsOnMap);
                    animal.move(this.moveDirections[i]);
                    //System.out.println(this.map);
                    Thread.sleep(moveDelay);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
       }
}
