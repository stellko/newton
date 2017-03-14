/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathicecreamexample;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;

/**
 *
 * @author stella
 */
public class PathIceCreamExample extends Application {
    
@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Chapter 2 Drawing Shapes");
    Group root = new Group();
    Scene scene = new Scene(root, 306, 550, Color.WHITE);

//  Ice cream cone
    Path path = new Path();
    path.setStrokeWidth(3);
//  create top part beginning on the left
    MoveTo moveTo = new MoveTo();
    moveTo.setX(50);
    moveTo.setY(150);
//  curve ice cream (dome)
    QuadCurveTo quadCurveTo = new QuadCurveTo();
    quadCurveTo.setX(150);
    quadCurveTo.setY(150);
    quadCurveTo.setControlX(100);
    quadCurveTo.setControlY(50);
//    
//  cone rim
    LineTo lineTo1 = new LineTo();
    lineTo1.setX(50);
    lineTo1.setY(150);
//  left side of cone
    LineTo lineTo2 = new LineTo();
    lineTo2.setX(100);
    lineTo2.setY(275);
//  right side of cone
    LineTo lineTo3 = new LineTo();
    lineTo3.setX(150);
    lineTo3.setY(150);
    path.getElements().addAll(moveTo, quadCurveTo, lineTo1, lineTo2, lineTo3);
    path.setTranslateY(30);

    // move slightly down
    path.setTranslateY(path.getBoundsInParent().getMinY() + 10);
    root.getChildren().add(path);
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
