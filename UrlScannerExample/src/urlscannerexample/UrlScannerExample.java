package urlscannerexample;


import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * 
 * Använder URL och Scanner för att hämta källkoden och annan information på en hemsida. 
 * Finns ett annat exempel i boken på s.129. 
 */
public class UrlScannerExample{
//	Tar en adressen till en hemsida i konstruktorn
	public static void printURLCode(String address){
		
//		Använder en try-with-resource block, där Scanner stängs automatiskt. 
//		Skapar också ett URL objekt direkt i Scannern för att slippa att skapa ett try-catch block till. 
		try(Scanner sc = new Scanner((new URL(address)).openStream())){
			
//			Kolla så en ny rad finns och skriver ut denna i konsolen. 
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
//		Om det något blir galet skall inget göras.
		} catch(IOException e){}
	}
	
	
/**
 * URL-objektet kan också ge annan information om en webbsida.
 */
	public static void getInformationAboutURL(String address) {
		try {
			
			URL url = new URL(address);
			System.out.println("Protokoll: "+url.getProtocol());
			System.out.println("Port: "+url.getDefaultPort());
			System.out.println("Domän: "+url.getHost());
//			För att få IP:n måste InetAddress anropas med URL-domänen.			
			System.out.println("IP: "+InetAddress.getByName(url.getHost()).getHostAddress());
			
			
		} catch (MalformedURLException|UnknownHostException e){}
	}
	/**
	 * main-metoden
	 * 
	 */
	public static void main(String[] args) {

		printURLCode("http://www.idg.se");
		getInformationAboutURL("http://www.idg.se");

	}

}
