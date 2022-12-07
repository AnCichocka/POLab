package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;


    RectangularMap(int width, int height){
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width-1, height-1);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(this.lowerLeft) && position.precedes(this.upperRight) && !this.isOccupied(position);
    }

    public Vector2d getLowerLeftBound(){
        return this.lowerLeft;
    }
    public Vector2d getUpperRightBound(){
        return this.upperRight;
    }

}
