import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuilderState extends State
{
    Scene scene;

    public BuilderState(StateManager stateManager, Stage primaryStage)
    {
        super(stateManager,primaryStage);
        this.primaryStage.setTitle("Agent Surveillance - World builder");
        this.primaryStage.setResizable(true);

        Button yay = new Button("aya");

        VBox layout = new VBox();

        layout.getChildren().addAll(yay);

        scene = new Scene(layout);
    }

    public Scene getScene() {
        return scene;
    }
}
