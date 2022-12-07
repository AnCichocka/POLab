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
            this.mapBoundary.add(grassPosition);
            allPositions.remove(grassPosition);
        }
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!this.isOccupied(position) || (this.isOccupied(position) && objectAt(position) instanceof Grass));
    }

    @Override
    public Vector2d getLowerLeftBound() {
        return this.mapBoundary.getLowerLeft();
    }

    @Override
    public Vector2d getUpperRightBound() {
        return this.mapBoundary.getUpperRight();
    }
}