
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duc.pt173030
 */
public class NewClass {
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(9);
        a.add(8);
        a.add(10);
        a.add(12);
        
        System.out.println(a);
        a.remove(0);
        System.out.println(a);
        a.remove(0);
        System.out.println(a);
    }
}
