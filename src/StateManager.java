import javafx.stage.Stage;

public class StateManager {
    Stage primaryStage;
    State currentState;

    public StateManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
        setState(new MainMenuState(this, primaryStage));
    }

    public State getState() {
        return currentState;
    }

    public void setState(State state) {
        this.currentState = state;
        primaryStage.setScene(state.getScene());
    }
}
