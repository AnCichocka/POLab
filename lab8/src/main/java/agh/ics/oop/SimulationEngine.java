package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] moveDirections;
    private final IWorldMap map;
    private final Vector2d[] animalsVectors;
    private final List<Animal> animalsOnMap = new ArrayList<>();
    private App app;
    private int moveDelay;

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] animalsVectors){
        this.moveDirections = moveDirections;
        this.map = map;
        this.animalsVectors = animalsVectors;
    }
    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] animalsVectors, App app, int moveDelay){
        this(moveDirections, map, animalsVectors);
        this.app = app;
        this.moveDelay = moveDelay;
    }
    public SimulationEngine(IWorldMap map, Vector2d[] animalsVectors, App app, int moveDelay){
        this.map = map;
        this.animalsVectors = animalsVectors;
        this.app = app;
        this.moveDelay = moveDelay;
    }

    public void setDirection(MoveDirection[] moveDirection){
        this.moveDirections = moveDirection;
    }
    private int addAndReturnNumberOfAnimals(){

        int numberOfAnimalsOnMap = 0;
        for (Vector2d animalVector : animalsVectors){
            Animal animalToInsert = new Animal(this.map, animalVector);
            if(this.map.place(animalToInsert)){
                this.animalsOnMap.add(animalToInsert);
                numberOfAnimalsOnMap++;
            }
        }
        return numberOfAnimalsOnMap;
    }
    @Override
    public void run(){
        System.out.println("Thread started.");
//        System.out.println(this.map);
        int numberOfAnimalsOnMap = this.addAndReturnNumberOfAnimals();
            //później można wokół całego fora, żeby przerywało cały wątek a nie jeden ruch
            try{
                Thread.sleep(moveDelay);
                for (int i = 0; i < this.moveDirections.length; i++) {
//            System.out.println("MOVE: " + moveDirections[i]);
                    Animal animal = this.animalsOnMap.get(i % numberOfAnimalsOnMap);
                    animal.move(this.moveDirections[i]);
                    System.out.println(this.map);
                    //wydrukuj ponownie mapę
                    this.app.refresh();
                    Thread.sleep(moveDelay);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(this.map);
       }
}
