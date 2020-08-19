/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class RunnableTest {
    public static void main(String[] args) throws InterruptedException {
 
       System.out.println("Main thread running..");
 
       // Tạo một thread từ Runnable.
       Thread thread = new Thread(new RunnableDemo());
 
       thread.start();
 
       // Ngủ 5 giây.
       Thread.sleep(5000);
       System.out.println("Main thread stopped");
   }
}
