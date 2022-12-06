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

    static final int CELL_WIDTH = 60;
    static final int CELL_HEIGHT = 60;
    static final int BUTTON_HEIGHT = 25;
    private SimulationEngine engine;

    @Override
    public void init() throws Exception {

        super.init();

        try{
            AbstractWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(3, 3)};
            this.map = map;
            AppVisualizer appVisualizer = new AppVisualizer(this);
            this.engine = new SimulationEngine(this.map, positions, appVisualizer, 1000);
        }
        catch(IllegalArgumentException ex){
            System.err.println(ex);
            System.exit(1);
        }
    }
    @Override
    public void start(Stage primaryStage){

        this.gridPane = new GridPane();
        this.createScene();

        VBox sceneContainer = new VBox(getButtonContainer(), this.gridPane);

        Scene scene = new Scene(sceneContainer, CELL_WIDTH*(Math.abs(maxX-minX) + 2), CELL_HEIGHT*(Math.abs(maxY-minY) + 2) + BUTTON_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public HBox getButtonContainer(){
        Button buttonStart = new Button("start");
        TextField text = new TextField();

        HBox buttonContainer = new HBox(text, buttonStart);

        buttonStart.setOnAction(event -> {
            String[] args = text.getCharacters().toString().split(" ");
            MoveDirection[] moveDirections = new OptionsParser().parse(args);
            this.engine.setDirection(moveDirections);
            Thread thread = new Thread(this.engine);
            thread.start();
        });
        return buttonContainer;
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
                    GuiElementBox guiElementBox = new GuiElementBox((IMapElement) worldMapElement);
                    VBox elementContainer = guiElementBox.getElementContainer();
                    gridPane.add(elementContainer, position.x - minX + 1, maxY - position.y + 1);
                    GridPane.setHalignment(elementContainer, HPos.CENTER);
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
