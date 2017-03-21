package changecolorwithrunnableexample;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 * 
 * Detta exempel ändrar färg på en rektangel genom att använda trådar. 
 * 
 */
public class ChangeColorWithRunnableExample extends Application {
	
	private Rectangle rectangle;
	
	@Override
	public void start(Stage primaryStage) {

		Group root = new Group();
		
		rectangle = new Rectangle(100,100);
		root.getChildren().add(rectangle);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		evokeThreads();
	}
	
	public void changeColor(Color color) {
		rectangle.setFill(color);
	}
	
//	Metoden som skapar alla trådar och kör igång dem.
	public void evokeThreads() {
		
//		Göra objekt av klassen och skicka med en pekare till GUI:klassen i konstruktorn.  		
		ThreadsInGui thread1 = new ThreadsInGui(this);
		ThreadsInGui thread2 = new ThreadsInGui(this);
		ThreadsInGui thread3 = new ThreadsInGui(this);
		
//		Ge de tre trådarna olika färger. 
		thread1.setColor(Color.RED);
		thread2.setColor(Color.BLUE);
		thread3.setColor(Color.GREEN);	

//		När gränssnittet används måste först det trådade objekt läggas i en Thread, innan den kan starta.		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);
		
//		Starta alla trådar. 	
		t1.start();
		t2.start();
		t3.start();	
	}

	
//	main-metoden. 
	public static void main(String[] args){
		Application.launch();
	}

} 
/**
 * 
 * Klassen som skall köras trådat, använder Runnable gränssnittet men hade likväl kunnat ärva Thread.
 * 
 */
class ThreadsInGui implements Runnable {
	
//	Klassen måste spara Color och GUI-klassen som instansvariabler för att kunna ändra på dem. 
	private Color color;
	private ChangeColorWithRunnableExample gui;
	
//	Hur många gånger som for-loopen skall printa ut, samt med hur kort intervall (millisekunder). 	
	private static int nmbrOfRuns = 10000;
	private static int sleepTime = 1000;
	
//	När objekt skapas av denna klass måste den ha en pekare till GUI:et, för att senare ha möjlighet att ändra det.
	ThreadsInGui(ChangeColorWithRunnableExample gui) {
		this.gui = gui;
	}
	
	@Override
//	Metoden som körs vid trådning, skillnaden här (jämfört med Thread) är att "Thread.", används istället för "this.".
	public void run() {
		
		for (int i = 0; i < nmbrOfRuns; i++) {
// 			När sleep används måste try-catch också implementeras.
			try {
				Thread.sleep(sleepTime); //Millisekunder som den skall vänta. 
				gui.changeColor(color);
			} 
			catch (InterruptedException e) {
				System.out.println("Något gick fel");
			}
		}
		
	}
//	Metod för att kunna sätta vilken färg som denna tråd skall byta rektangeln till.
	public void setColor(Color color) {
		this.color = color;
	}
}