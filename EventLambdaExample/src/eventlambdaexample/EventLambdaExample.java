package eventlambdaexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EventLambdaExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        Button button1 = new Button("Vanlig!");
        Button button2 = new Button("Lambda!");
        
        FlowPane root = new FlowPane();
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("lambdaEvent");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Vanlig Lyssnare på knappen        
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Du tryckte vanlig!");
            }
        });

        // Skrivet med lambda istället (SetonAction vill ha objektet EventHandler<ActionEvent> som bara har en metod (handle).         
        button2.setOnAction(event -> {
            System.out.println("Du tryckte lambda!");
        });

    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
