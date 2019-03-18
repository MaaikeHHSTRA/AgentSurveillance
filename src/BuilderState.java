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
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.*;

public class BuilderState extends State {
    Scene scene;
    BorderPane layout;
    private int windowSize = 700;
    Button structure, doorS, windowS, sentTower, tree, target;
    Color[] rectangleColors = {Color.YELLOWGREEN, Color.TURQUOISE, Color.VIOLET, Color.TOMATO};
    double startX, startY;
    boolean drawNewRect = false;
    Rectangle rect = null;
    Group groupOfRects = new Group();
    int colorArea;

    public BuilderState(StateManager stateManager, Stage window) {
        super(stateManager, window);
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
        structure = new Button("BuildingStructure");
        structure.setOnAction(e -> {
            event("BuildingStructure");
        });
        doorS = new Button("Door");
        doorS.setOnAction(e -> {

        });
        windowS = new Button("Window");
        windowS.setOnAction(e -> {

        });
        sentTower = new Button("SentryTower");
        sentTower.setOnAction(e -> {
            event("SentryTower");
        });
        tree = new Button("Vegetation");
        tree.setOnAction(e -> {
            event("Vegetation");
        });
        target = new Button("TargetArea");
        target.setOnAction(e -> {
            event("TargetArea");
        });
        areas.getChildren().addAll(new Label("Areas"), structure, doorS, windowS, sentTower, tree, target);

        //Map clarifications/adjustments

        //Map
        //Image BGImage = new Image("http://icon-park.com/imagefiles/noize_background_lightgreen.png");
        Image BGImage = new Image("file:src/files/grassBG.png");
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

    private void drawRect(int x, int y) {
        Rectangle rect = new Rectangle(x, y);
    }

    /*public void mousePressed(MouseEvent evt) {
            int x = evt.getX();
            int y = evt.getY();
            drawRect(x,y);
    }*/

    public void event(String area) {
        scene.setOnMousePressed((MouseEvent event) -> {
            if (drawNewRect == false) {
                startX = event.getSceneX();
                startY = event.getSceneY();
                rect = new Rectangle();
                rect.setFill(Color.SNOW);
                rect.setStroke(Color.BLACK);
                groupOfRects.getChildren().add(rect);
                drawNewRect = true;
            }
        });

        scene.setOnMouseDragged((MouseEvent event) -> {
            if (drawNewRect == true) {
                double endX = event.getSceneX();
                double endY = event.getSceneY();
                adjustRect(startX, startY, endX, endY, rect);
            }

        });

        scene.setOnMouseReleased((MouseEvent event) -> {
            if (drawNewRect == true) {
                if (area == "BuildingStructure")
                    colorArea = 0;
                if (area == "Sentry Tower")
                    colorArea = 1;
                if (area == "Shade/trees")
                    colorArea = 2;
                if (area == "Target Area")
                    colorArea = 3;

                rect.setFill(rectangleColors[colorArea]);

                rect = null;
                drawNewRect = false;
            }
        });
    }

    void adjustRect(double startX, double startY, double endX, double endY, Rectangle rect) {
        rect.setX(startX);
        rect.setY(startY);
        rect.setWidth(endX - startX);
        rect.setHeight(endY - startY);

        if (rect.getWidth() < 0) {
            rect.setWidth(-rect.getWidth());
            rect.setX(rect.getX() - rect.getWidth());
        }
        if (rect.getHeight() < 0) {
            rect.setHeight(-rect.getHeight());
            rect.setY(rect.getY() - rect.getHeight());
        }
    }
}
