package simplesocketexample;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
/**
 * 
 * @author DanielB
 *
 *	Denna klass kopplar upp sig till en tidsserver för att hämta den korrekta tiden just nu, vilket
 *	är något som görs i vissa program och applikationer.
 *	
 *	Genom att används sockets där webbadress och port anges, samt skapa en Scanner-ström som läser av denna
 *	är det möjligt att hämta tiden över nätet. Det fungerar utmärkt att använda andra adresser också (så länge de har en server igång). 
 */
public class SimpleSocketExample {
	public static void main(String[] args){
//		Adress och portnummer behövs alltid för att skapa anslutning/använda sockets.
		String adress = "time-c.nist.gov";
		int portNumber = 13;
//		
		try {
//			Skapar en anslutning mot en server, denna kan kasta ett par exceptions (vilka alla är eller ligger under IOException)
			Socket socket = new Socket(adress, portNumber);
//			Man måste anropa en metod i en socket för att kunna få informationen över nätet, kastar också exception.
			InputStream stream  = socket.getInputStream();
//			Sedan öppnas en ström för att läsa det man får till datorn. 
			Scanner reader = new Scanner(stream);
//			Så länge som det finns en ny rad att hämta kommer denna skrivas ut, vilket endast kommer hända en gång i detta exempel.
			while(reader.hasNextLine()) {
//				nextLine kastar exception men borde inte hända då vi kollar om det finns en ny rad varje gång, innan de läses.
				System.out.println(reader.nextLine());
			}
                        socket.close();

		} 
//		Denna catch-sats fångar exception från nästan alla rader i try-satsen, enkelt att göra men kanske inte så bra då det blir så generellt.
		catch (IOException e) { 
			System.out.println("Exception som kastades: "+e);
		}
	}
}
