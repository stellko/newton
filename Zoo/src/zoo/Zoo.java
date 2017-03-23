package zoo;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Zoo extends Application {
    Button buttonDoAge;
    Button buttonDoZoo;
    ArrayList<Animal> animals;
    ArrayList<ZooKeeper> zooKeepers;
    Alert alert;
    FoodPlace foodPlace;
    WaterPlace waterPlace;


    public void getSounds() {
        // TODO: Make a string of all the sounds the animals make and display them in an Alert
        // TODO: If you're up for it, try using java.util.stream https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
    }

    public void getAges() {
        // TODO: Sum up the ages of all the animals and display the result in an Alert
        // TODO: If you're up for it, try using java.util.stream https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
    }
    
    public void init() {
        // TODO: Create your buttons and put them in a cool layout
        
        // TODO: If buttonDoAge is clicked, call the getAges method
        // TODO: If buttonDoZoo is clicked, call the getSounds method

        // TODO: Create a foodPlace and a waterPlace
        
        // TODO: Add some zooKeepers to the zooKeepers list
        // TODO: Add some animals to the animals list
        
        // TODO: The ZooKeeper class extends Thread, for each zooKeeper in the zooKeepers list, start the thread
        // TODO: The Animal extends Thread, for each animal in the animals list, start the thread
    }

    @Override
    public void start(Stage primaryStage) throws Exception {      
//        Scene scene = new Scene(layout, 200, 300);
//        primaryStage.setTitle("Zoo");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
