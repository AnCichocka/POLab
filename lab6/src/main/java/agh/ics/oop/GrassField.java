package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private final ArrayList<Grass> grassPieces = new ArrayList<>();


    public Object objectAt(Vector2d position) {
        Object animalOnPosition = super.objectAt(position);

        if (animalOnPosition == null) {
            for (Grass grassPiece : this.grassPieces) {
                if (grassPiece.getPosition().equals(position)) {
                    return grassPiece;
                }
            }
        }

        return animalOnPosition;
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
            this.grassPieces.add(grassPiece);
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
        for(Animal animal : this.animals){
            lowerLeft = animal.getPosition().lowerLeft(lowerLeft);
        }
        for(Grass grassPiece : this.grassPieces){
            lowerLeft = grassPiece.getPosition().lowerLeft(lowerLeft);
        }
        return lowerLeft;
    }
    @Override
    protected Vector2d getUpperRightBound(){
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Animal animal : this.animals){
            upperRight = animal.getPosition().upperRight(upperRight);
        }
        for(Grass grassPiece : this.grassPieces){
            upperRight = grassPiece.getPosition().upperRight(upperRight);
        }
        return upperRight;
    }

    // Bounds = new bounds(newVector(0,0)...)
    // bounds.lowerLeft
    //metofa getLower ... ma zwracać rekord Bounds
}