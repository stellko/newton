package filereaderexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderExample {

public static void main(String[] args) {

	int sum=0;
	int rows=0;
	
    //En fil med värden som öppnas i en try-with-resources-sats. 
    try (Scanner sc = new Scanner(new File("data.txt"))) { 
    	
//	Löp igenom så länge det finns fler rader.
        while (sc.hasNextLine()) {
//        Summera om det är integer
            sum += sc.nextInt();
            rows++;
        }
//        sc.close(); Behövs ej, då den sker automatiskt i try-with-resources.
    } 
    catch (FileNotFoundException e) {
        System.out.println("Filen hittades inte!");
    }

    System.out.println("Summa:"+sum+"\nMedelvärde: "+(double)sum/(rows)); //För att få decimaler måste resultatet vara en double.
 }
}
