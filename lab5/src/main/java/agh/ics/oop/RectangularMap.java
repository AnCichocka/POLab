package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap{

    private final int width;
    private final int height;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    RectangularMap(int width, int height){
        super();
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width-1, height-1);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(this.lowerLeft) && position.precedes(this.upperRight) && !this.isOccupied(position);
    }
    @Override
    public String toString(){
        return super.toString(this.lowerLeft, this.upperRight);
    }

}
