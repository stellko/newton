/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionsexample;

import java.util.Scanner;

/**
 *
 * @author stella
 */
public class ExceptionsExample {

    public static void divideNumbers(int number1, int number2) {
        if(number2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        } else {
            System.out.println(number1 + " / " + number2 + " is "
                + (number1 / number2));
        }
        
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter two integers: ");
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        
        try {
            divideNumbers(number1, number2);
        } catch (ArithmeticException ex) {
            System.out.println("Expected an integer: Cannot divide by zero");
        }

    }

}
