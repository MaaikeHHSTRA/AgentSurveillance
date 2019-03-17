import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class BuilderState extends State
{
    Scene scene;
    BorderPane layout;
    private int windowSize = 700;
    Button structure,doorS,windowS,sentTower,tree,target;

    public BuilderState(StateManager stateManager, Stage window)
    {
        super(stateManager,window);
        window.setTitle("Agent Surveillance - World builder");

        //Menu: file
        Menu file = new Menu("File");
        file.getItems().add(new MenuItem("New..."));
        file.getItems().add(new MenuItem("Open..."));
        file.getItems().add(new MenuItem("Save"));
        file.getItems().add(new MenuItem("Save as..."));
        file.getItems().add(new MenuItem("Run"));

        //Menu: settings
        Menu settings = new Menu("Settings");
        settings.getItems().add(new MenuItem("Resize"));
        settings.getItems().add(new MenuItem("Toggle grid"));

        MenuBar menubar = new MenuBar();
        menubar.getMenus().addAll(file, settings);

        //Area buttons
        VBox areas = new VBox();
        structure = new Button("Structure");
        doorS = new Button("Door");
        windowS = new Button("Window");
        sentTower = new Button("Sentry Tower");
        tree = new Button("Shade/trees");
        target = new Button("Target Area");
        areas.getChildren().addAll(new Label("Areas"),structure,doorS,windowS,sentTower,tree,target);

        //Map clearifications/adjustments

        //Map
        //Image BGImage = new Image("http://icon-park.com/imagefiles/noize_background_lightgreen.png");
        Image BGImage = new Image("file:src/Assets/grassBG.png");
        ImageView background = new ImageView();
        background.setImage(BGImage);

        layout = new BorderPane();
        layout.setTop(menubar);
        layout.setLeft(areas);
        layout.setCenter(background);

        window.setResizable(true);
        scene = new Scene(layout, windowSize, windowSize);
        window.setScene(scene);
        window.show();
        //VBox layout = new VBox();
        //layout.getChildren().addAll(yay);
    }

    public Scene getScene() {
        return scene;
    }
}
