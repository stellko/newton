/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnableinterfaceexample;

/**
 *
 * @author stella
 */
public class RunnableInterfaceExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
    
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("My runnable is running");
    }
    
}

