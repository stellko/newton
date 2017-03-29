/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broadcastserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author stella
 */
public class Client2 {
    	public static void main(String[] args){
//		Adress och portnummer behövs alltid för att skapa anslutning/använda sockets.
		String adress = "localhost";
		int portNumber = 3004;
//		
		try {
//			Skapar en anslutning mot en server, denna kan kasta ett par exceptions (vilka alla är eller ligger under IOException)
			Socket socket = new Socket(adress, portNumber);
//			Man måste anropa en metod i en socket för att kunna få informationen över nätet, kastar också exception.
			InputStream stream  = socket.getInputStream();
//			Sedan öppnas en ström för att läsa det man får till datorn. 
			Scanner reader = new Scanner(stream);
//			Så länge som det finns en ny rad att hämta kommer denna skrivas ut
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
