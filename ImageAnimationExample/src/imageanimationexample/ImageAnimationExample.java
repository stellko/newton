package imageanimationexample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ImageAnimationExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group layout = new Group();
		
//		För att visa en bild i programmet så används image för att skapa ett bildobjekt och ImageView för att göra det till en komponent.
//		Image-klassen kan ta dem vanligaste filformaten och källa från filsystemet eller en webbadress. 
		Image image = new Image("https://static-secure.guim.co.uk/sys-images/Media/Pix/pictures/2013/1/14/1358150745448/Java-logo-008.jpg");
		ImageView imageNode = new ImageView(image);
		
//		Metoder för att modifiera bilden. 
//		imageNode.setFitHeight(50);
//		imageNode.setFitWidth(100);	
//		imageNode.setRotate(180);
		
//		Vad och hur det skall animeras, där ImageNode är vilken egenskap (Många liknande metoder som alla Komponenter har) och hur den skall förändras.
		KeyValue xValue = new KeyValue(imageNode.xProperty(), 100); //ImageNode är vilken egenskap som skall tillämpas och var den skall gå
		KeyValue yValue = new KeyValue(imageNode.yProperty(), 100); // I detta fall flytt i x och y-led.  
		KeyValue oValue = new KeyValue(imageNode.opacityProperty(), 0); //Samt ändra opacity från 1 till 0.  		
		KeyFrame keyFrame = new KeyFrame(Duration.millis(10000), xValue,yValue,oValue); //Hur lång tid det skall ta och slutföra KeyValues. 

//		För att animera en KeyFrame så måste Timeline användas, där man bestämmer hur själva animeringen skall gå till.
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE); //Anropa denna metod om den skall loopa.
		timeline.setAutoReverse(false); //Börja om från början eller gå samma väg tillbaka. 
		timeline.getKeyFrames().add(keyFrame); //Går att lägga till flera animationer.
		timeline.play();
		
		layout.getChildren().add(imageNode);
		
		Scene scene = new Scene(layout,700,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args){
		Application.launch();
	}

}
