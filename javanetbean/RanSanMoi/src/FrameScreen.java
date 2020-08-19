
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class FrameScreen extends JFrame {
    GameScreen gamescreen;
    public FrameScreen(){
        gamescreen = new GameScreen();
        add(gamescreen);
    }

    public static void main(String[] args) {
        FrameScreen f = new FrameScreen();
        f.setVisible(true);
        f.setSize(800,800);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
