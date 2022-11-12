package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class GrassField implements IWorldMap{

    private final int n;
    private List<Animal> animals;
    private List<Grass> grassPieces;
    private final MapVisualizer visualizer;
    private Vector2d lowerLeft;
    private Vector2d upperRight;


    public GrassField(int numberOfFields){
        this.n = numberOfFields;
        this.visualizer = new MapVisualizer(this);
        this.animals = new ArrayList<>();
        this.grassPieces = new ArrayList<>();
        this.lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        this.upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        PlaceGrass();
    }

    private void PlaceGrass(){
        double max = Math.sqrt(this.n*10);
        double min = 0;

        int counter = 0;
        while (counter < this.n){
            Vector2d randomPosition = new Vector2d(randomFromRange(min, max), randomFromRange(min,max));
            if (!isOccupied(randomPosition)) {
                Grass grassPiece = new Grass(randomPosition);
                grassPieces.add(grassPiece);
                counter++;
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animalInMap : this.animals){
            if (animalInMap.getPosition().equals(position)){
                return animalInMap;
            }
        }
        for (Grass grassPiece : this.grassPieces){
            if (grassPiece.getPosition().equals(position)){
                return grassPiece;
            }
        }
        return null;
    }
    private int randomFromRange(double max, double min){
        return (int)((Math.random() * (max - min)) + min);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!this.isOccupied(position) || (this.isOccupied(position) && objectAt(position) instanceof Grass));

    }
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        setLowerLeftandUpperRight();
        return this.visualizer.draw(this.lowerLeft, this.upperRight);

    }

    private void setLowerLeftandUpperRight(){

        for(Grass grassPiece : this.grassPieces){
            this.lowerLeft = grassPiece.getPosition().lowerLeft(this.lowerLeft);
            this.upperRight = grassPiece.getPosition().upperRight(this.upperRight);
        }

        for(Animal animal : this.animals){
            this.lowerLeft = animal.getPosition().lowerLeft(this.lowerLeft);
            this.upperRight = animal.getPosition().upperRight(this.upperRight);
        }
    }
}
