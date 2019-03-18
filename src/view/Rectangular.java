package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rectangular {

    Scene scene;
    Color[] rectangleColors = {Color.YELLOWGREEN,Color.TURQUOISE,Color.VIOLET,Color.TOMATO} ;
    double startX,startY;
    boolean drawNewRect = false;
    Rectangle rect = null;
    Group groupOfRects = new Group();
    int colorArea;

    public void event(String area){
        scene.setOnMousePressed((MouseEvent event) -> {
            if ( drawNewRect == false ) {
                startX = event.getSceneX() ;
                startY = event.getSceneY() ;
                rect = new Rectangle();
                rect.setFill(Color.SNOW);
                rect.setStroke(Color.BLACK);
                groupOfRects.getChildren().add(rect) ;
                drawNewRect = true ;

            }
        });

        scene.setOnMouseDragged((MouseEvent event) -> {
            if (drawNewRect == true){
                double endX = event.getSceneX();
                double endY = event.getSceneY();
                adjustRect(startX, startY,endX,endY,rect);
            }

        });

        scene.setOnMouseReleased((MouseEvent event) -> {
            if (drawNewRect == true){
                if(area == "Structure")
                    colorArea = 0;
                if(area == "Sentry Tower")
                    colorArea = 1;
                if(area == "Shade/trees")
                    colorArea = 2;
                if(area == "Target Area")
                    colorArea = 3;

                rect.setFill(rectangleColors[colorArea]);

                rect = null ;
                drawNewRect = false ;
            }
        });
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
}


