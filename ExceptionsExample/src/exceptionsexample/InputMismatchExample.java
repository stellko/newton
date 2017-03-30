/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionsexample;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author stella
 */
public class InputMismatchExample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean tryAgain = true;

        do {
            try {
                System.out.print("Enter an integer: ");
                int number = in.nextInt();

                System.out.println("The number entered is " + number);

                tryAgain = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                in.nextLine(); 
            }
        } while (tryAgain);
    }

}
