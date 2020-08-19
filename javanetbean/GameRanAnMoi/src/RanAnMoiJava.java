
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RanAnMoiJava extends JFrame {

    GameScreen game;
    
    public static ArrayList<User> users;
    public RanAnMoiJava() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(820,550);
        users = new ArrayList();
        ReadData();
        game = new GameScreen();
        add(game);
        this.addKeyListener(new handler());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UpdateData(); //To change body of generated methods, choose Tools | Templates.
            }
            
});
        this.setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        RanAnMoiJava f = new RanAnMoiJava();
    }

    private class handler implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                GameScreen.isPlaying = !GameScreen.isPlaying;
                if (GameScreen.isOver) GameScreen.isOver = false;
            }
            if (GameScreen.isPlaying) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    game.ran.setVector(ConRan.GO_UP);
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    game.ran.setVector(ConRan.GO_DOWN);
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    game.ran.setVector(ConRan.GO_LEFT);
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    game.ran.setVector(ConRan.GO_RIGHT);
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }
    public static void UpdateData(){
        try {
            FileWriter fw = new FileWriter("data/data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(User u: users){
                bw.write(u.getName()+" "+u.getPoint());
                bw.newLine();
            }
            
            
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(RanAnMoiJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void ReadData(){
        try {
            FileReader fr = new FileReader("data/data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine())!=null){
                String [] str = line.split(" ");
                users.add(new User(str[0], str[1]));
            }
            
            
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(RanAnMoiJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
