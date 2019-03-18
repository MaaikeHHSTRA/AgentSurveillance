import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Map extends Pane {

    Group mapProperties;
    double startX, startY;

    public Map() {
        mapProperties = new Group();
        Image BGImage = new Image("file:src/Assets/grassBG.png");
        ImageView background = new ImageView();
        background.setImage(BGImage);
        mapProperties.getChildren().add(background);

        background.setOnMousePressed((MouseEvent event) -> {
            startX = event.getSceneX();
            startY = event.getSceneY();

            System.out.println("Start X: " + startX);
            System.out.println("Start Y: " + startY);
        });


        background.setOnMouseReleased((MouseEvent event) -> {
            double endX = event.getSceneX();
            double endY = event.getSceneY();

            System.out.println("End X: " + endX);
            System.out.println("End Y: " + endY);

            Rectangle rect = new Rectangle(startX, startY, endX - startX, endY - endY);
            rect.setFill(Color.BLACK);
            rect.setVisible(true);
            mapProperties.getChildren().add(rect);
            BuilderState.setLayout();
            printMap();
        });
    }

    public void printMap() {
        System.out.println(mapProperties.getChildren());
    }


//    public void event(String area){
//        scene.setOnMousePressed((MouseEvent event) -> {
//            if ( drawNewRect == false ) {
//
//                startX = event.getSceneX() ;
//                startY = event.getSceneY() ;
////                rect = new Rectangle() ;
//                System.out.println("Start X: " + startX);
//                System.out.println("Start Y: " + startY);
////                rect.setFill(Color.SNOW);
////                rect.setStroke(Color.BLACK);
////                groupOfRects.getChildren().add(rect) ;
//                drawNewRect = true ;
//            }
//        });
//
//        scene.setOnMouseReleased((MouseEvent event) -> {
//            double endX = event.getSceneX();
//            double endY = event.getSceneY();
//
//            System.out.println("End X: " + endX);
//            System.out.println("End Y: " + endY);
//
//
//            rect = new Rectangle(startX, startY, endX - startX, endY - startY);
//
//            if (drawNewRect == true){
//                if(area == "Structure")
//                    colorArea = 0;
//                if(area == "Sentry Tower")
//                    colorArea = 1;
//                if(area == "Shade/trees")
//                    colorArea = 2;
//                if(area == "Target Area")
//                    colorArea = 3;
//
//                rect.setFill(rectangleColors[colorArea]);
//
//                groupOfRects.getChildren().add(rect);
//                Scene scene = new Scene(groupOfRects);
//                primaryStage.setScene(scene);
//                primaryStage.show();
////                scene.
////                rect = null ;
//                drawNewRect = false ;
//            }
//        });
//    }


    public Group getMap() {
        return mapProperties;
    }


}
