package agh.ics.oop;

import java.util.Comparator;

public class xComparator implements Comparator<Vector2d> {

    @Override
    public int compare(Vector2d v1, Vector2d v2) {
        if (v1.x != v2.x){
            return v1.x - v2.x;
        }
        return v1.y - v2.y;
    }
}
