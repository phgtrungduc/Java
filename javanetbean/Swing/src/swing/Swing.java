/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author duc.pt173030
 */
public class Swing {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame f= new JFrame("Cửa sổ dễ");
        JButton ok = new JButton("Ok");
        JButton calcel = new JButton("Cancel");
        JButton bye = new JButton("Exit");
          f.setLayout(null);  
    f.setVisible(true);
        
    }
    
}
