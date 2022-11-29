package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {
    private AbstractWorldMap map;

    @Override
    public void init() throws Exception {

        super.init();
        Parameters parameters = getParameters();
        String[] args = parameters.getRaw().toArray(new String[0]);

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            this.map = new GrassField(10);
//            Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,0) };
//            IEngine engine = new SimulationEngine(directions, this.map, positions);

//            engine.run();
//            System.out.println(map);
        }
        catch(IllegalArgumentException ex){
            System.err.println(ex);
            System.exit(0);
        }
    }

    @Override
    public void start(Stage primaryStage){

        int minX = this.map.getLowerLeftBound().x;
        int minY = this.map.getLowerLeftBound().y;
        int maxX = this.map.getUpperRightBound().x;
        int maxY = this.map.getUpperRightBound().y;

        int width = 40;
        int height = 40;

//        System.out.println("minX: " + minX + " maxX: " + maxX);
//        System.out.println("minY: " + minY + " maxY: " + maxY);

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        Label labelXY = new Label("y/x");

        GridPane.setHalignment(labelXY, HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));
        gridPane.add(labelXY, 0, 0);

        for (int i = 1; minX + i - 1 <= maxX; i++){
            Label label = new Label(String.valueOf(minX + i - 1));

            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            gridPane.add(label, i, 0);
        }

        for (int i = 1; maxY + 1 - i >= minY; i++){
            Label label = new Label(String.valueOf(maxY + 1 - i));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(height));
            gridPane.add(label, 0, i);
        }

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Vector2d position = new Vector2d(x, y);
                if (this.map.isOccupied(position)) {
                    Object worldMapElement = this.map.objectAt(position);
                    Label label = new Label(worldMapElement.toString());
                    gridPane.add(label, position.x - minX + 1, maxY - position.y + 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
