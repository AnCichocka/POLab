package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    //dodajemy vectory zwierzątek i trawy, trawy i zwierzęta o tym samym wektorze MUSZĄ mieć rózne pozycje - gdy zwierzątko się cofnie,
    //a była pod nim trawa to trawa nie zostanie inaczej uwzględniona

    SortedSet<Vector2d> elementsX = new TreeSet<>(new xComparator());
    SortedSet<Vector2d> elementsY = new TreeSet<>(new yComparator());

//    SortedSet<Vector2d> animalsX = new TreeSet<>(new XComparator());
//    SortedSet<Vector2d> animalsY = new TreeSet<>(new YComparator());

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
