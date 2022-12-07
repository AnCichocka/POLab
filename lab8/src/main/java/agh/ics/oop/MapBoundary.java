package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    //TreeSet<IMapElemeny>((e1,e2)->{
    // if e1 < e2:
    // return e1.getPosition()})

    private SortedSet<Vector2d> elementsX = new TreeSet<>(new xComparator());

    //private SortedSet<IMapElement> elementsX = new TreeSet<>Comparator.comparingInt(element -> element.getPosition().x).thenComparing(element -> element.getPosition().y)
    private SortedSet<Vector2d> elementsY = new TreeSet<>(new yComparator());

    public void add(Vector2d position){
        elementsY.add(position);
        elementsX.add(position);
    }

    public void remove(Vector2d position){
        elementsY.remove(position);
        elementsX.remove(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
       elementsX.remove(oldPosition);
       elementsX.add(newPosition);
       elementsY.remove(oldPosition);
       elementsY.add(newPosition);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(this.elementsX.first().x, this.elementsY.first().y);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(this.elementsX.last().x, this.elementsY.last().y);
    }
}
