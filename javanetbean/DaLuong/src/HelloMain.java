/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class HelloMain {
    public static void main(String[] args) throws InterruptedException {
 
       int idx = 1;
 
       for (int i = 0; i < 2; i++) {
 
           System.out.println("Main thread running " + idx++);
           // Ngủ 2101 milli giây.
           Thread.sleep(2101);
       }
 
       HelloThread helloThread = new HelloThread();
 
       // Chạy thread
       helloThread.start();
 
       for (int i = 0; i < 3; i++) {
           System.out.println("Main thread running " + idx++);
           // Ngủ 2101 milli giây.
           Thread.sleep(2101);
       }
 
       System.out.println("==> Main thread stopped");
   }
}
