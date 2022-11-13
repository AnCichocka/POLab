package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

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

        int bound = (int)Math.floor(Math.sqrt(this.n*10));
        ArrayList<Vector2d> allPositions = new ArrayList<>();

        for (int i = 0; i <= bound; i++){
            for (int j = 0; j <= bound; j++){
                allPositions.add(new Vector2d(i,j));
            }
        }

        Random random = new Random();

        for (int i = 0; i < this.n; i++){
            int randomIndex =  random.nextInt(allPositions.size() - 0) + 0;
            Vector2d grassPosition = allPositions.get(randomIndex);
            IMapElement grassPiece = new Grass(grassPosition);
            mapElements.add(grassPiece);
            allPositions.remove(grassPosition);
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
