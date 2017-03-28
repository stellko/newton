package streamsexample;

import java.net.*;
import java.util.Scanner;
import java.io.*;
/**
 * 
 * @author DanielB
 * 
 *	Kolla SimpleSocketExample för simplare exempel med mer kommentarer!
 *
 *	Detta exempel visar på tre olika sätt för att läsa av en ström, samma uppkoppling som användes i SimpleSocketExample.
 *	Alla tre exempel gör på lite olika sätt, där ofta Scanner är att föredra men de andra har också sina fördelar.
 */
public class StreamsExample {
	public static void main(String[] args) {
	
//		De tre olika exemplen skall alla skriva ut samma sak, UTC-tiden. 
		minimalScannerReader("time-c.nist.gov", 13);
		inputStreamReader("time-c.nist.gov", 13);		
		bufferedReader("time-c.nist.gov", 13);		
		
	}
        
        
	public static void minimalScannerReader(String adress,int portNumber){
//		Använder Scanner i try-with-resources där en instans av sockets skapas och öppnas för läsning. 
		try (Scanner reader = new Scanner((new Socket(adress, portNumber)).getInputStream())){
//			Läser och printar ut varje rad. 
			while(reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}

		} catch (IOException e) { e.printStackTrace(); }
	}
	
	
//	Exemplet är främst taget från boken (s.242). 
	public static void inputStreamReader(String adress,int portNumber){
		Socket socket = null;
		try {
			socket = new Socket(adress, portNumber);
			socket.setSoTimeout(15000);
//			
			InputStream in = socket.getInputStream();
		
			StringBuilder time = new StringBuilder();
			
			InputStreamReader reader = new InputStreamReader(in); 
			
			for (int c = reader.read(); c != -1; c = reader.read()) {
				time.append((char) c);
			}
			System.out.println(time);
			
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException ex) {
					// ignore
				}
			}
		}
	}
	
//	BufferedReader är rätt lik InputStreamReader, dock används en while-loop istället för for-sats.
	public static void bufferedReader(String adress,int portNumber){
		
		try {
			Socket socket = new Socket(adress,portNumber);
//			BufferedReader måste wrappa en ström, i detta fall inputStreamReader, som tar in en socket ström. 
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
//			Måste skapa en variabel då det inte går att se hasNextLine.
			String s = in.readLine();
//			loopa så länge det går att läsa något från servern, det vill säga att den ej stängt anslutningen.
			while(s != null){
				System.out.println(s);
//				Läser nästa rad, om raden inte finns tilldelas s null. 
				s = in.readLine();	
			}
			
		} catch (IOException e) {e.printStackTrace();}
	}
}



