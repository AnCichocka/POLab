package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    private AbstractWorldMap map;
    private GridPane gridPane;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    static final int CELL_WIDTH = 40;
    static final int CELL_HEIGHT = 40;

    @Override
    public void init() throws Exception {

        super.init();
        String[] args = getParameters().getRaw().toArray(new String[0]);

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            AbstractWorldMap map = new GrassField(8);
            this.map = map;
            Vector2d[] positions = { new Vector2d(3,3), new Vector2d(0,0)};
            SimulationEngine engine = new SimulationEngine(directions, map, positions, this, 0);
            Thread thread = new Thread(engine);
            thread.start();
        }
        catch(IllegalArgumentException ex){
            System.err.println(ex);
            System.exit(1);
        }
    }

    @Override
    public void start(Stage primaryStage){

        Button button = new Button("button");
        TextField text = new TextField();

        HBox buttonContainer = new HBox(text, button);

        this.gridPane = new GridPane();

        this.createScene();

        VBox sceneContainer = new VBox(buttonContainer, this.gridPane);

        Scene scene = new Scene(sceneContainer, CELL_WIDTH*(Math.abs(maxX-minX) + 2), CELL_HEIGHT*(Math.abs(maxY-minY) + 2));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void createScene(){

        this.updateMinAndMax();

        this.addXYLabel();

        this.addColumns();
        this.addRows();
        this.addAnimalsAndGrass();

        gridPane.setGridLinesVisible(true);
    }

    public void updateMinAndMax(){
        minX = this.map.getLowerLeftBound().x;
        minY = this.map.getLowerLeftBound().y;
        maxX = this.map.getUpperRightBound().x;
        maxY = this.map.getUpperRightBound().y;
    }
    public void addXYLabel(){
        Label labelXY = new Label("y/x");
        GridPane.setHalignment(labelXY, HPos.CENTER);

        gridPane.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        gridPane.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        gridPane.add(labelXY, 0, 0);
    }
    public void addColumns(){
        for (int i = 1; minX + i - 1 <= maxX; i++){
            Label label = new Label(String.valueOf(minX + i - 1));

            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
            gridPane.add(label, i, 0);
        }
    }
    public void addRows(){
        for (int i = 1; maxY + 1 - i >= minY; i++){
            Label label = new Label(String.valueOf(maxY + 1 - i));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
            gridPane.add(label, 0, i);
        }
    }
    public void addAnimalsAndGrass(){
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
    }

    public void refresh() {
        Platform.runLater( () -> {
            this.gridPane.getChildren().clear();
            this.gridPane.getColumnConstraints().clear();
            this.gridPane.getRowConstraints().clear();
            gridPane.setGridLinesVisible(false);
            this.createScene();
        });
    }
}
