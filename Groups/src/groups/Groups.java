/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groups;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author stella
 */
public class Groups extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Rectangle rectangle = new Rectangle(10, 10, 50, 50);
        Circle circle = new Circle(100, 35, 25);
        Line line = new Line(150, 10, 200, 50);
          
        Group root = new Group();
        root.getChildren().add(rectangle);
        root.getChildren().add(circle);
        root.getChildren().add(line);
        
        Scene scene = new Scene(root, 500, 150);
        
        primaryStage.setTitle("Groups");
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
