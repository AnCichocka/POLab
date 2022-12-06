package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    final static int IMAGE_SIZE = 42;
    private ImageView image;
    private VBox elementContainer;

    public GuiElementBox(IMapElement element){
        try{
            Image image = new Image(new FileInputStream(element.getImageName()));
            this.image = new ImageView(image);
            this.image.setFitWidth(IMAGE_SIZE);
            this.image.setFitHeight(IMAGE_SIZE);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }

        Label elementPosition = new Label(element.getPosition().toString());
        this.elementContainer = new VBox(this.image, elementPosition);
        this.elementContainer.setAlignment(Pos.CENTER);
    }

    public VBox getElementContainer(){
        return this.elementContainer;
    }


}
