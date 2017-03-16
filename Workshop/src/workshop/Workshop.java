/*
 * TODO: Utöka programmet så att du kan välja ytterligare en Shape
 * TODO: Utöka programmet så att du kan välja ytterligare en färg
 * TODO: Utöka programmet så att du kan sätta x och y-koordinater där din Shape ritas ut
 * TODO: Utöka programmet så att du kan din Shape ritas ut på en random position
 * TODO: Snygga till kodstrukturen, bryt ut till metoder osv.
 */
package workshop;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author stella
 */
public class Workshop extends Application {
    int windowHeight = 500;
    int windowWidth = 1000;
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, windowWidth, windowHeight);
    FlowPane flowPane = new FlowPane();
    HBox circleBox = new HBox();
    HBox rectangleBox = new HBox();
    Pane centerPane = new Pane();
    
    @Override
    public void start(Stage primaryStage) {

        ComboBox colorPicker = new ComboBox();
        colorPicker.getItems().addAll(
                "red",
                "green",
                "blue"); 
        colorPicker.setValue("red");
        
        
        // Circle
        Button circleBtn = new Button();
        Label radiusLabel = new Label("Radius:");
        TextField radiusField = new TextField();
        radiusField.setMaxWidth(40);     
        circleBtn.setText("Draw circle");
        circleBtn.setOnAction( e -> { 
            try {
                double radius = Double.parseDouble(radiusField.getText());
                Circle circle = new Circle(radius);
                setFill(circle, colorPicker);
                centerPane.getChildren().clear();
                centerPane.getChildren().add(circle);
                
              } catch (Exception ex) {
                  System.out.println(e);
              }
                  
        });   
        
        
        // Rectangle
        Button squareBtn = new Button();
        Label heightLabel = new Label("Height:");
        Label widthLabel = new Label("Width:");
        TextField heightField = new TextField();
        TextField widthField = new TextField();
        heightField.setMaxWidth(40); 
        widthField.setMaxWidth(40); 
        squareBtn.setText("Draw rectangle");
        squareBtn.setOnAction( e -> {
            try {
              double width = Double.parseDouble(widthField.getText());
              double height = Double.parseDouble(heightField.getText());
              
              Rectangle rectangle = new Rectangle(width, height);
              setFill(rectangle, colorPicker);
              
              centerPane.getChildren().clear();
              centerPane.getChildren().add(rectangle);
              
              } catch (Exception ex) {
                  System.out.println(ex.getMessage());
              }
        });
        
        circleBox.setSpacing(5);
        rectangleBox.setSpacing(5);
        circleBox.getChildren().addAll(radiusLabel, radiusField, circleBtn);
        rectangleBox.getChildren().addAll(widthLabel, widthField, heightLabel, heightField, squareBtn);
        
        flowPane.setHgap(30);
        flowPane.setMaxHeight(40);
        flowPane.setPadding(new Insets(11, 12, 13, 14));
        flowPane.getChildren().addAll(circleBox, rectangleBox, colorPicker);
        
        root.setTop(flowPane);
        root.setCenter(centerPane);
        
        primaryStage.setTitle("Uppgift 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void setFill(Shape shape, ComboBox colorPicker) {
        String color = colorPicker.getValue().toString();
        switch (color) {
            case "red":
                shape.setFill(Color.RED);
                break;
            case "blue":
                shape.setFill(Color.BLUE);
                break;
            case "green":
                shape.setFill(Color.GREEN);
                break;
            default:
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
