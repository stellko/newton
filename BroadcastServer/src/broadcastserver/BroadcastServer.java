package broadcastserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DanielB
 *
 * Denna klass skapar en Server som ständigt ökar ett nummer med så många
 * klienter som kopplat upp sig. Se SimpleServerExample för mer beskrivning av
 * de olika delarna.
 */
public class BroadcastServer {

    public static void main(String[] args) throws IOException {

//	Deklarar objekten här för att slippa göra det varje gång i while-loopen. 
        WritingThread serverThread;
        Thread t1;

//	Öppnar upp en port för servern. 
        ServerSocket server = new ServerSocket(3004);

//	Väntar ständigt på att klienter skall koppla upp sig till servern.
        while (true) {
//          Servern väntar här tills en ny klient kopplar upp sig, sedan går den vidare.
            Socket connection = server.accept();
//          När en ny klient kopplar upp sig mot servern startas en ny tråd, för att kunna hantera flera klienter samtidigt.
            serverThread = new WritingThread(connection);
            t1 = new Thread(serverThread);
            t1.start();
        }
    }
}

/**
 *
 * Klassen som parallellt skriver ut meddelanden till alla klienter kopplade til
 * den. trådningen ligger i en egen klass för att det skall vara möjligt från
 * huvudklassen att skapa flera olika trådar (inte bara av samma klass)
 */
class WritingThread implements Runnable {

//	Klassvariabeln används i run() för att skriva till klient. 
    private PrintStream writeToClient;

//	En räknare som är static så den är delad mellan alla instanser av WritingThread
    static int counter = 0;

//	Konstruktorn tar en connection för att kunna öppna upp en ström till den. 
    public WritingThread(Socket connection) throws IOException {
//	Skapar strömmen som sedan används i run().
        writeToClient = new PrintStream(connection.getOutputStream());
    }

    @Override
    public void run() {
//	Sover 1s sen ökar en räknare med ett och därefter skriver ut det.
        while (true) {
//          try-catch måste användas med Thread.sleep. 
            try {
                Thread.sleep(1000);
                counter++;
//		Skriver till klienten, counter är statisk därav skrivs samma nummer till alla.
                writeToClient.println("Räknare:" + counter);
            } catch (InterruptedException e) {
                System.out.println("Sleep exception: " + e);
            }

        }
    }
}
