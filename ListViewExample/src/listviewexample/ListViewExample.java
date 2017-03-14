package listviewexample;

import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListViewExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // I buttonLayout läggs alla knappar, layouten placeras sedan i "layout".
        GridPane buttonLayout = new GridPane();
        
        // I layout placeras buttonLayout till höger och listan till vänster. 	
        BorderPane layout = new BorderPane();

        // Alla komponenter som skall placeras i buttonLayout. 
        Label label = new Label("Knapparna");
        Button changeButton = new Button("Ändra");
        Button removeButton = new Button("Ta bort");
        Button addRowButton = new Button("Lägg till ny rad");
        
        // Placeras i layouten utefter rad-kolumn.		
        buttonLayout.add(label, 0, 0);
        buttonLayout.add(changeButton, 0, 1);
        buttonLayout.add(removeButton, 0, 2);
        buttonLayout.add(addRowButton, 0, 3);

        // Ändrar första, respektive andra kolumnstorleken.
        buttonLayout.getColumnConstraints().add(new ColumnConstraints(100));
        buttonLayout.getColumnConstraints().add(new ColumnConstraints(100));

        // ListView är listkomponenten vilken innehåller en specialanpassad ArrayList.
        ListView<String> theView = new ListView<String>();
        
        // ObservableArrayList uppdaterar automatiskt listkomponenten om den ändras. 
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Ny Kontakt");
        theView.setItems(list);;

        layout.setLeft(theView);
        layout.setRight(buttonLayout);

        Scene scene = new Scene(layout);

        primaryStage.setScene(scene);
        primaryStage.show();

        // Om "ändra"-knappen trycks på kommer en inputruta dyka upp som sedan uppdaterar markerad rad.
        changeButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog("Vad heter kontakten?");
            Optional<String> result = dialog.showAndWait(); //Metoden kallas på för att visa rutan.
            result.ifPresent(text -> list.set(theView.getSelectionModel().getSelectedIndex(), text));
        });
        
        // Tar bort markerat item i listkomponenten
        removeButton.setOnAction(e -> list.remove(theView.getSelectionModel().getSelectedIndex()));
        
        // Lägger till en ny sträng i listan, vilken automatiskt uppdaterar listkomponenten.
        addRowButton.setOnAction(e -> list.add("Ny Kontakt"));
    }

    public static void main(String[] args) {
        Application.launch();
    }

}
