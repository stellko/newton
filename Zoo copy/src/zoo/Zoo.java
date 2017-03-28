package zoo;

import java.util.ArrayList;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Zoo extends Application {
    VBox layout;
    Button buttonDoAge;
    Button buttonDoZoo;
    ArrayList<Animal> animals;
    ArrayList<ZooKeeper> zooKeepers;
    Alert alert;
    FoodPlace foodPlace;
    WaterPlace waterPlace;


    public void getSounds() {        
        String sounds = animals
                .stream()
                .map(Animal::doZoo)
                .collect(Collectors.joining(" "));

        alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(sounds);
        alert.showAndWait();
    }

    public void getAges() {
        int sum = animals
                .stream()
                .map(Animal::getAge)
                .reduce(0, Integer::sum);

        alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(String.valueOf(sum));
        alert.showAndWait();
    }
    
    public void init() {
        layout = new VBox(); 
        buttonDoAge = new Button("Age");
        buttonDoZoo = new Button("Do Zoo");              
        buttonDoZoo.setOnAction(e -> getSounds());
        buttonDoAge.setOnAction(e -> getAges());
        layout.getChildren().addAll(buttonDoAge, buttonDoZoo);
        
        animals = new ArrayList();
        zooKeepers = new ArrayList();
        
        foodPlace = new FoodPlace(0);
        waterPlace = new WaterPlace(0);
        
        zooKeepers.add(new ZooKeeper("ZooKeeper 1", foodPlace, waterPlace));
        zooKeepers.add(new ZooKeeper("ZooKeeper 2", foodPlace, waterPlace));

        animals.add(new Horse(5,"Horse1", "Neeiiigh", foodPlace, waterPlace));
        animals.add(new Horse(10,"Horse2", "Ptrooo", foodPlace, waterPlace));
        animals.add(new Horse(10,"Horse3", "Gnägg", foodPlace, waterPlace));
        animals.add(new Emu(10,"Emu1", "Screeeh", foodPlace, waterPlace));
        animals.add(new Emu(10,"Emu2", "Haahhah", foodPlace, waterPlace));
        
        zooKeepers.forEach(zooKeeper -> zooKeeper.start());
        animals.forEach(animal -> animal.start());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {      
        Scene scene = new Scene(layout, 200, 300);
        primaryStage.setTitle("Zoo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
