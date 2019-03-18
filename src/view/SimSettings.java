package view;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

public class SimSettings {
    BorderPane layout;
    VBox settings,agent,time,weights,endButtons;
    Label title,guard,intruder,guardNumb,intrNumb,maxTime,explore,explTime,wTime,wMove,wComD,wComID;
    Button OKButton,cancelButton;
    ComboBox guardCB,intruderCB;
    //TextInputDialog intrNumbT;
    TextField guardNumbT,intrNumbT,maxTimeT,explTimeT,wTimeT,wMoveT,wComDT,wComIDT;
    ToggleButton exploreB;

    public void SimSettings(){
        title = new Label("Simulation Settings");

        //Agent
        guard = new Label("Guard AI");
        guardCB = new ComboBox();
        guardNumb = new Label("Number of guards");
        guardNumbT = new TextField();
        intruder = new Label("Intruder AI");
        intruderCB = new ComboBox();
        intrNumb = new Label("Number of intruders");
        //intrNumbT = new TextInputDialog("Tran");
        //intrNumbT.setTitle("o7planning");
        //intrNumbT.setHeaderText("Enter your name:");
        //intrNumbT.setContentText("Number of intruders:");
        intrNumbT = new TextField();
        agent.getChildren().addAll(new Label("Agents"),guard,guardNumb,guardNumbT,intruder,intrNumb,intrNumbT);

        //Time
        maxTime = new Label("Maximum time (s)");
        maxTimeT = new TextField();
        explore = new Label("Exploration phase");
        exploreB = new ToggleButton();
        explTime = new Label("Exploration time (s)");
        explTimeT = new TextField();
        time.getChildren().addAll(new Label("Time"),maxTime,maxTimeT,explore,exploreB,explTime,explTimeT);


        //Weights
        wTime = new Label("Time");
        wTimeT = new TextField();
        wMove = new Label("Movement");
        wMoveT = new TextField();
        wComD = new Label("Direct communication");
        wComDT = new TextField();
        wComID = new Label("Indirect communicaton");
        wComIDT = new TextField();
        weights.getChildren().addAll(new Label("Weights"),wTime,wTimeT,wMove,wMoveT,wComD,wComDT,wComID,wComIDT);

        //Closing buttons
        OKButton = new Button("OK");
        OKButton.setPrefWidth(50);
        OKButton.setOnAction(e -> {

        });

        cancelButton = new Button("Cancel");
        cancelButton.setPrefWidth(50);
        cancelButton.setOnAction(e -> {

        });
        endButtons.getChildren().addAll(OKButton,cancelButton);

        settings.getChildren().addAll(agent,time,weights);
        layout = new BorderPane();
        layout.setTop(title);
        layout.setCenter(settings);
        layout.setBottom(endButtons);
    }
}
