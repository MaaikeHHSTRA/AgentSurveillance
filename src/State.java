import javafx.scene.Scene;
import javafx.stage.Stage;


public abstract class State {
    protected StateManager stateManager;
    protected Stage primaryStage;

    public State(StateManager stateManager, Stage primaryStage) {
        this.stateManager = stateManager;
        this.primaryStage = primaryStage;
    }

    public abstract Scene getScene();
}

