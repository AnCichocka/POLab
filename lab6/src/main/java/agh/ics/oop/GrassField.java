package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private final Map<Vector2d, Grass> grassPieces = new HashMap<>();


    public Object objectAt(Vector2d position) {
        Object animalOnPosition = super.objectAt(position);
        if (animalOnPosition != null) {
            return animalOnPosition;
        }
        return grassPieces.get(position);
    }
    public GrassField(int n){

        int bound = (int)Math.floor(Math.sqrt(n*10));
        ArrayList<Vector2d> allPositions = new ArrayList<>();

        for (int i = 0; i <= bound; i++){
            for (int j = 0; j <= bound; j++){
                allPositions.add(new Vector2d(i,j));
            }
        }

        Random random = new Random();

        for (int i = 0; i < n; i++){
            int randomIndex =  random.nextInt(allPositions.size());
            Vector2d grassPosition = allPositions.get(randomIndex);
            Grass grassPiece = new Grass(grassPosition);
            this.grassPieces.put(grassPosition, grassPiece);
            allPositions.remove(grassPosition);
        }
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!this.isOccupied(position) || (this.isOccupied(position) && objectAt(position) instanceof Grass));
    }
    @Override
    protected Vector2d getLowerLeftBound(){
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(Vector2d position : this.animals.keySet()){
            lowerLeft = position.lowerLeft(lowerLeft);
        }
        for(Vector2d position : this.grassPieces.keySet()){
            lowerLeft = position.lowerLeft(lowerLeft);
        }
        return lowerLeft;
    }
    @Override
    protected Vector2d getUpperRightBound(){
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Vector2d position : this.animals.keySet()){
            upperRight = position.upperRight(upperRight);
        }
        for(Vector2d position : this.grassPieces.keySet()){
            upperRight = position.upperRight(upperRight);
        }
        return upperRight;
    }

    // Bounds = new bounds(newVector(0,0)...)
    // bounds.lowerLeft
    //metofa getLower ... ma zwracać rekord Bounds
}