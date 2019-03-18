package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    private Stage primaryStage;
    private StateManager stateManager;

    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.stateManager = new StateManager(primaryStage);
        primaryStage.show();
    }
}