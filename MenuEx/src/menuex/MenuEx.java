
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MenuEx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane layout = new BorderPane();

        // Först måste ne menybar skapas, för att sedan kunna lägga in olika menyer.				
        MenuBar menuBar = new MenuBar();

        // Första meny-avdelningen som innehåller tre items. 		
        Menu fileMenu = new Menu("Arkiv");
        MenuItem saveItem = new MenuItem("Spara");
        MenuItem loadItem = new MenuItem("Öppna");
        MenuItem exitItem = new MenuItem("Stäng program");

        // Måste läggas till i fileMenu fliken.		
        fileMenu.getItems().addAll(saveItem, loadItem, exitItem);

        // Andra meny-avdelningen.		
        Menu fileHelp = new Menu("Hjälp");
        MenuItem aboutItem = new MenuItem("Om");

        //Som också läggs till.		
        fileHelp.getItems().addAll(aboutItem);

        // De både avdelningarna läggs till i menybaren, samt positionen sätts. 		
        menuBar.getMenus().addAll(fileMenu, fileHelp);
        layout.setTop(menuBar);

        // Skapar rektangel för att fylla ut i mitten.		
        layout.setCenter(new Rectangle(100, 100, Color.GRAY));

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Platform.exit() kallas för att stänga programmet. 
        exitItem.setOnAction(e -> Platform.exit());

        // Alert är meddelande klassen i JavaFX, går också att fånga svaret. 
        aboutItem.setOnAction(e -> {

            Alert aboutMessage = new Alert(AlertType.INFORMATION, "Ett fint program med en meny och rektangel!");
            aboutMessage.showAndWait();

        });

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
