/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executorexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author stella
 */
public class ExecutorExample {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(3);

    executor.execute(new PrintChar('a', 100));
    executor.execute(new PrintChar('b', 100));
    executor.execute(new PrintNumber(100));
    executor.shutdown();
  }
    
}

class PrintChar implements Runnable {
  private char charToPrint; 
  private int times;

  public PrintChar(char c, int t) {
    charToPrint = c;
    times = t;
  }

  @Override
  public void run() {
    for (int i = 0; i < times; i++) {
      System.out.print(charToPrint);
    }
  }
}

class PrintNumber implements Runnable {
  private int lastNumToPrint;

  public PrintNumber(int number) {
    lastNumToPrint = number;
  }

  @Override
  public void run() {
    for (int i = 1; i <= lastNumToPrint; i++) {
      System.out.print(" " + i);
      Thread.yield();
    }
  }
}
