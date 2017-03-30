package guithreadexample;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GuiThreadExample extends Application {
  private String text = "";
  
  @Override
  public void start(Stage primaryStage) {   
    StackPane pane = new StackPane();
    Label textLabel = new Label("");
    pane.getChildren().add(textLabel);
    
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          while (true) {
            if (textLabel.getText().trim().length() == 0)
              text = "Hej";
            else
              text = "";
  
            Platform.runLater(new Runnable() {
              @Override 
              public void run() {
                textLabel.setText(text);
              }
            });
            
            Thread.sleep(200);
          }
        }
        catch (InterruptedException ex) {
        }
      }
    }).start();
    
    Scene scene = new Scene(pane, 200, 50);
    primaryStage.setTitle("Blinkande text"); 
    primaryStage.setScene(scene); 
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}