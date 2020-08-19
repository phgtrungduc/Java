
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class GameScreen extends JPanel implements Runnable {

    Thread thread;
    ConRan ran;
    static int[][] bg = new int[20][20];

    static boolean isPlaying = false;
    static boolean enableText = false;
    static boolean isOver = false;

    public static int WIDTH = 500;
    public static int HEIGHT = 500;
    public static int padding = 5;

    static int currentLevel = 1;
    static int diem = 0;
    
    public GameScreen() {
        ran = new ConRan();
        Data.loadImage();
        thread = new Thread(this);
        bg[2][2] = 2;
        thread.start();
    }

    public void paintBg(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH + 2 * padding, HEIGHT + 2 * padding);
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH + 2 * padding + 300, HEIGHT + 2 * padding );
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

//                g.fillRect(i * 25 + 1 + padding, j * 25 + 1 + padding, 24, 24);
                if (bg[i][j] == 2) {
                    g.drawImage(Data.imageFood, i * 25 + 1 + padding, j * 25 + padding - 1, null);
                }
            }
        }
    }

    private void veKhung(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(0, 0, WIDTH + 2 * padding, HEIGHT + 2 * padding);
        g.drawRect(1, 1, WIDTH + 2 * padding - 2, HEIGHT + 2 * padding - 2);
        g.drawRect(0, 0, WIDTH + 2 * padding + 300, HEIGHT + 2 * padding);
        g.drawRect(1, 1, WIDTH + 2 * padding - 2 + 300, HEIGHT + 2 * padding - 2);
//        g.drawRect(padding - 1, padding - 1, WIDTH + 1, HEIGHT + 1);
//        g.drawRect(padding - 2, padding - 2, WIDTH + 3, HEIGHT + 3);
    }
    
    public User highScore(){
        int max =-1;
        User usermax = new User();
        for (int i = 0; i < RanAnMoiJava.users.size(); i++) {
            int n = Integer.parseInt(RanAnMoiJava.users.get(i).getPoint());
            if(n>max) {
                max = n;
                usermax = RanAnMoiJava.users.get(i);
            }
        }
        return usermax;
    }
    

    @Override
    public void paint(Graphics g) {
        paintBg(g);
        ran.VeRan(g);
        veKhung(g);
        if (!isPlaying) {
            if (enableText) {
                g.setColor(Color.white);
                g.setFont(g.getFont().deriveFont(25.0f));
                g.drawString("PRESS SPACE TO PLAY GAME", 70, 290);
            }
        }
        if (isOver) {
            g.setColor(Color.white);
            g.setFont(g.getFont().deriveFont(30.0f));
            g.drawString("GAMEOVER", 200, 390);
        }
        g.setColor(Color.white);
        g.setFont(g.getFont().deriveFont(30.0f));
        g.drawString("LEVEL: "+currentLevel, 600, 50);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("DIEM: "+diem, 600, 100);
        
        //in điểm
        g.drawString("HighScore: "+highScore(), 530, 200);
    }

    @Override
    public void run() {
        long t = 0;
        while (true) {
            if (isPlaying) {
                ran.update();
            } else {
                if (System.currentTimeMillis() - t > 800) {
                    enableText = !enableText;
                    t = System.currentTimeMillis();
                }
            }
            repaint();
            
        }
        
    }
}
