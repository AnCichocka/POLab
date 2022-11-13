package agh.ics.oop;

import java.util.ArrayList;

public class GrassField extends AbstractWorldMap{

    private final int n;
    private Vector2d lowerLeft;
    private Vector2d upperRight;

    public GrassField(int numberOfFields){
        super();
        this.n = numberOfFields;
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
                IMapElement grassPiece = new Grass(randomPosition);
                mapElements.add(grassPiece);
                counter++;
            }
        }
    }
    private int randomFromRange(double max, double min){
        return (int)((Math.random() * (max - min)) + min);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!this.isOccupied(position) || (this.isOccupied(position) && objectAt(position) instanceof Grass));
    }
    @Override
    public String toString(){
        setLowerLeftAndUpperRight();
        return super.toString(this.lowerLeft, this.upperRight);
    }
    private void setLowerLeftAndUpperRight(){

        for(IMapElement element : this.mapElements){
            this.lowerLeft = element.getPosition().lowerLeft(this.lowerLeft);
            this.upperRight = element.getPosition().upperRight(this.upperRight);
        }
    }
}
