import Assets.BuilderPanel;
import javafx.geometry.Insets;
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

public class BuilderState extends State
{
    Scene scene;
    static BorderPane layout;
    private int windowSize = 700;

    Color[] rectangleColors = {Color.YELLOWGREEN,Color.TURQUOISE,Color.VIOLET,Color.TOMATO} ;
    double startX,startY;
    boolean drawNewRect = false;
    Rectangle rect = null;
    Group groupOfRects = new Group();
    int colorArea;
    static Map map = new Map();


    public BuilderState(StateManager stateManager, Stage window){
        super(stateManager,window);
        window.setTitle("Agent Surveillance - World builder");

        //Menu: file
//        Menu file = new Menu("File");
//        file.getItems().add(new MenuItem("New..."));
//        file.getItems().add(new MenuItem("Open..."));
//        file.getItems().add(new MenuItem("Save"));
//        file.getItems().add(new MenuItem("Save as..."));
//        file.getItems().add(new MenuItem("Run"));
//
//        //Menu: settings
//        Menu settings = new Menu("Settings");
//        settings.getItems().add(new MenuItem("Resize"));
//        settings.getItems().add(new MenuItem("Toggle grid"));
//
//        MenuBar menubar = new MenuBar();
//        menubar.getMenus().addAll(file, settings);
        MenuBar menubar = createMenuBar();

        //Area buttons
//        VBox areas = new VBox();
//        structure = new Button("Structure");
//        structure.setOnAction(e -> {
//            event("Structure");
//        });
//        doorS = new Button("Door");
//        doorS.setOnAction(e -> {
//
//        });
//        windowS = new Button("Window");
//        windowS.setOnAction(e -> {
//
//        });
//        sentTower = new Button("Sentry Tower");
//        sentTower.setOnAction(e -> {
//            event("Sentry Tower");
//        });
//        tree = new Button("Shade/trees");
//        tree.setOnAction(e -> {
//            event("Shade/trees");
//        });
//        target = new Button("Target Area");
//        target.setOnAction(e -> {
//            event("Target Area");
//        });
//        areas.getChildren().addAll(new Label("Areas"),structure,doorS,windowS,sentTower,tree,target);

        //Map clarifications/adjustments

        //Map
        //Image BGImage = new Image("http://icon-park.com/imagefiles/noize_background_lightgreen.png");
//        Image BGImage = new Image("file:src/Assets/grassBG.png");
//        ImageView background = new ImageView();
//        background.setImage(BGImage);
//        groupOfRects.getChildren().add(background);


//        builderPanel.setWidth(1000);
//        System.out.println(builderPanel.getWidth());

        BuilderPanel builderPanel = new BuilderPanel();


        layout = new BorderPane();
        layout.setTop(menubar);
        layout.setLeft(builderPanel);
//        layout.setCenter(map.getMap());
        setLayout();


        window.setResizable(true);
        scene = new Scene(layout, windowSize, windowSize);
        window.setScene(scene);
        window.show();
        //VBox layout = new VBox();
        //layout.getChildren().addAll(yay);
    }

    static void setLayout() {
        layout.setCenter(map.getMap());
        System.out.println(map.getMap());
    }



    public Scene getScene() {
        return scene;
    }

    private void drawRect(int x, int y){
        Rectangle rect = new Rectangle(x,y);
    }

    void adjustRect( double startX, double startY, double endX, double endY, Rectangle rect) {
        rect.setX(startX) ;
        rect.setY(startY) ;
        rect.setWidth(endX - startX) ;
        rect.setHeight(endY - startY) ;

        if (rect.getWidth() < 0){
            rect.setWidth( - rect.getWidth());
            rect.setX( rect.getX() - rect.getWidth());
        }
        if (rect.getHeight() < 0){
            rect.setHeight( - rect.getHeight());
            rect.setY( rect.getY() - rect.getHeight());
        }
    }

    public MenuBar createMenuBar() {
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
        return menubar;
    }
}
