package messageexample;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MessageExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        HBox root = new HBox();
        
        Button simpleMessage = new Button("Enkelt meddelande");
        Button ordinaryMessage = new Button("Vanligt meddelande");
        Button confirmationDialog = new Button("Som en fråga");
        Button inputDialog = new Button("Användaren skall mata in");
        
        root.getChildren().addAll(simpleMessage,ordinaryMessage,confirmationDialog,inputDialog);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Olika slags meddelanden");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
//      Ett av de simplaste sätten att göra ett meddelande på, "Alert message" och "showandWait" måste alltid finnas.  
        simpleMessage.setOnAction(e -> {
        	Alert message = new Alert(AlertType.INFORMATION); //Kan använda olika stilar på meddelandet via AlertType.
        	message.setHeaderText("Simpelt meddelande");
        	message.showAndWait(); //Visar meddelandet. 
        });
        
//		Går att modifiera meddelandet mer. 
        ordinaryMessage.setOnAction(e -> {
        	Alert message = new Alert(AlertType.INFORMATION);
        	message.setTitle("Intressant meddelande");
        	message.setHeaderText("Meddelande till dig");
        	message.setContentText("Detta är ett vanligt meddelande!");
        	message.showAndWait();
        });
        
//      Vill man ha egna knappar blir det mer kod, där ButtonType och Optional<ButtonType> skall användas.
        confirmationDialog.setOnAction(e -> {
        	Alert message = new Alert(AlertType.CONFIRMATION);
        	message.setTitle("Intressant meddelande");
        	message.setHeaderText("Var detta ett intressant meddelande?");
        	
//        	Namnet på knapparna som skall finnas.
        	ButtonType yesAnswer = new ButtonType("Ja");
        	ButtonType noAnswer = new ButtonType("Nah");
        	ButtonType maybeAnswer = new ButtonType("Kanske");
//        	Knapparna måste lägga till i meddelandet.
        	message.getButtonTypes().setAll(yesAnswer,noAnswer,maybeAnswer);

//		Visa meddelandet och vänta på svar (i detta fall genom ButtonTyp)
        	Optional<ButtonType> result = message.showAndWait();
//        	Svaret får man via .get(). går att använda direkt eller spara undan i en variabel (som i detta fall).
        	ButtonType answer = result.get();
        	String textToPrint = "";
        	
//		Kolla vilken av knapparna som trycktes på.         	
        	if(answer == yesAnswer)
        		textToPrint = "Kul att höra!";
        	else if(answer == noAnswer)
        		textToPrint = "Ajdå, synd";
        	else if(answer == maybeAnswer)
        		textToPrint = "Då får du fundera mer på det";
        	else
        		message.close();	//Stänger applikationen. 
        	
//			Skapar ett nytt meddelande (ej nödvändigt).        	
        	Alert message2 = new Alert(AlertType.INFORMATION);
        	message2.setHeaderText(textToPrint);
        	message2.showAndWait();
        	
        });
        
//      Om input skall tas av användaren används TextInputDialog istället, finns ockås CheckBoxDialog.  
        inputDialog.setOnAction(e -> {
        	TextInputDialog dialog = new TextInputDialog("Skriv hur bra du tycker detta programmet är");
        	dialog.setTitle("Inmatning");
        	dialog.setContentText("Hur bra är detta program?");
        	
        	Optional<String> result = dialog.showAndWait(); //Här tas en sträng istället för en ButtonType.
        	
//			Skapar ett nytt meddelande (ej nödvändigt).        	
        	Alert message = new Alert(AlertType.INFORMATION);
        	message.setHeaderText("Du tyckte att: \n"+result.get());
        	message.showAndWait();
        	
        });

        
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}