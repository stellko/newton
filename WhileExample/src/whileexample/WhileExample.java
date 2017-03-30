/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whileexample;

/**
 *
 * @author stella
 */
public class WhileExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // A while-loop and a do while loop that does the same thing

        int count = 1;
        while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }
        
        count = 1;
        do {
            System.out.println("Count is: " + count);
            count++;
        } while (count < 11);
    }
}


