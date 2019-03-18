package view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuState extends State
{
    double stageWidth, stageHeight, buttonWidth;

    VBox vbox;
    Label titleL;
    Button newWorldB,openWorldB, exitB;

    Scene scene;

    public MainMenuState(StateManager stateManager, Stage primaryStage)
    {
        super(stateManager,primaryStage);
        this.primaryStage.setTitle("Agent Surveillance - Main menu");
        this.primaryStage.setResizable(false);

        buttonWidth = 100;

        //Main menu layout
        vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        //Title label
        titleL = new Label("Agent Surveillance");
        titleL.setAlignment(Pos.CENTER);
        titleL.setScaleX(1.5);
        titleL.setScaleY(1.5);
        titleL.setPrefSize(240,80);

        //World buttons
        newWorldB = new Button("New world");
        newWorldB.setPrefWidth(buttonWidth);
        newWorldB.setOnAction(e ->
        {
            stateManager.setState(new BuilderState(stateManager,primaryStage));
        });

        openWorldB = new Button("Open world");
        openWorldB.setPrefWidth(buttonWidth);
        openWorldB.setOnAction(e ->
        {

        });

        exitB = new Button("Exit");
        exitB.setPrefWidth(buttonWidth);
        exitB.setOnAction(e ->
        {
            Platform.exit();
        });

        vbox.getChildren().addAll(titleL,newWorldB,openWorldB,exitB);

        scene = new Scene(vbox);
    }

    public Scene getScene()
    {
        return scene;
    }
}
