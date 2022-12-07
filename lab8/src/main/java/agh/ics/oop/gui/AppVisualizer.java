package agh.ics.oop.gui;

import agh.ics.oop.IPositionChangeObserver;
import agh.ics.oop.Vector2d;

public class AppVisualizer implements IPositionChangeObserver {
    private final App app;
    public AppVisualizer(App app){
        this.app = app;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.app.refresh();
    }
}
