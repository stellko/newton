/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridpane;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author stella
 */
public class GridPaneEx extends Application {
    
@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GridPane Example");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 380, 150, Color.WHITE);
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);       
        
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
        column2.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(column1, column2);
        
        Label fNameLabel = new Label("First Name");
        TextField fNameTextField = new TextField();
        Label lNameLabel = new Label("Last Name");
        TextField lNameTextField = new TextField();
        Button saveButton = new Button("Save");
        
        GridPane.setHalignment(fNameLabel, HPos.RIGHT);
        GridPane.setHalignment(lNameLabel, HPos.RIGHT);
        GridPane.setHalignment(fNameTextField, HPos.LEFT);
        GridPane.setHalignment(lNameTextField, HPos.LEFT);
        GridPane.setHalignment(saveButton, HPos.RIGHT);
        
        
        gridPane.add(fNameLabel, 0, 0);
        gridPane.add(fNameTextField, 1, 0);
        gridPane.add(lNameLabel, 0, 1);
        gridPane.add(lNameTextField, 1, 1);
        gridPane.add(saveButton, 1, 2);
        
        
        // TOP BANNER
        FlowPane topBanner = new FlowPane();
        topBanner.setPadding(new Insets(5));
        topBanner.setPrefHeight(40);
        String backgroundStyle = 
                  "-fx-background-color: lightBlue;"
                + "-fx-background-radius: 30%"
                + "-fx-background-inset: 5px;";
        topBanner.setStyle(backgroundStyle);
        
        Text text = new Text("Contact");
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Verdana", 30));
        
        
        topBanner.getChildren().addAll(text);
        
        root.setTop(topBanner);
        root.setCenter(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
