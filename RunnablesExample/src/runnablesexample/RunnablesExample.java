/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnablesexample;

/**
 *
 * @author stella
 */
public class RunnablesExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Anonym klass som implementerar Runnable
        Runnable task1 = new Runnable(){
            @Override
            public void run(){
            System.out.println("Task #1 is running");
            }
        };
        Thread thread1 = new Thread(task1);
        thread1.start();
        
        
        // Anonym klass som implementerar Runnable skickas direkt till Thread-konstruktorn
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
            System.out.println("Task #2 is running");
            }
        });
        thread2.start();
        
        
        // Uttryckt med lambda
        Runnable task3 = () -> { System.out.println("Task #3 is running"); };
        new Thread(task3).start();
        
        
        // Uttryckt med lambda utan variabel
        new Thread(() -> System.out.println("Task #4 is running")).start();
    }
    
}
