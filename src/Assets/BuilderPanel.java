package Assets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class BuilderPanel extends VBox {

    Button structure,doorS,windowS,sentTower,tree,target;

    public BuilderPanel() {
        this.createBuilderElements();
        setMinWidth(150);
    }

    public void createBuilderElements() {
        VBox areas = new VBox(2.5);
        structure = new Button("Structure");
        structure.setOnAction(e -> {
            System.out.println("Structure");
        });
        doorS = new Button("Door");
        doorS.setOnAction(e -> {
            System.out.println("Door");
        });
        windowS = new Button("Window");
        windowS.setOnAction(e -> {
            System.out.println("Window");
        });
        sentTower = new Button("Sentry Tower");
        sentTower.setOnAction(e -> {
            System.out.println("Sentry Tower");
        });
        tree = new Button("Shade/trees");
        tree.setOnAction(e -> {
            System.out.println("Shade/trees");
        });
        target = new Button("Target Area");
        target.setOnAction(e -> {
            System.out.println("Target Area");
        });

        this.getChildren().addAll(new Label("Areas"),structure,doorS,windowS,sentTower,tree,target);

    }

}
