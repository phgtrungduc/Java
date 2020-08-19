
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class ConRan {

    int doDai = 3;
    int[] x;
    int[] y;
    public static int GO_UP = 1;
    public static int GO_DOWN = -1;
    public static int GO_LEFT = 2;
    public static int GO_RIGHT = -2;

    public static boolean isUpdate = false;

    int speed = 200;
    int maxLen = 10;

    

    int vector = ConRan.GO_DOWN;
    long t1 = 0, t2 = 0;

    public ConRan() {
        x = new int[100];
        y = new int[100];

        x[0] = 5;
        y[0] = 4;

        x[1] = 5;
        y[1] = 3;

        x[2] = 5;
        y[2] = 2;
    }

    public void setVector(int v) {
        if (vector != -v && isUpdate) {
            this.vector = v;
            isUpdate = false;
        }
    }

    public Point layToaDoMoi() {
        Random rd = new Random();
        int x = rd.nextInt(19);
        int y = rd.nextInt(19);
        return new Point(x, y);
    }

    public boolean toaDoNamTrongThanRan(int x1, int y1) {
        for (int i = 0; i < doDai; i++) {
            if (x[i] == x1 && y[i] == y1) {
                return true;
            }
        }
        return false;
    }

    public boolean isDead() {
        for (int i = 1; i < doDai; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                return true;
            }

        }
        return false;
    }

    public void reset() {
        x = new int[100];
        y = new int[100];
        doDai = 3;

        x[0] = 5;
        y[0] = 4;

        x[1] = 5;
        y[1] = 3;

        x[2] = 5;
        y[2] = 2;

        speed = 200;
        maxLen = 10;
        GameScreen.currentLevel=1;
    }

    public void update() {
        if (isDead()) {
            String name = JOptionPane.showInputDialog("Mời người chơi nhập tên: ");
            RanAnMoiJava.users.add(new User(name.replaceAll("\\s",""),Integer.toString(GameScreen.diem)));
            System.out.println(name.replaceAll("\\s","") + " "+GameScreen.diem);
            GameScreen.isPlaying = false;
            GameScreen.isOver = true;
            reset();
        }
        if (doDai == maxLen) {
            GameScreen.currentLevel++;
            maxLen +=5;
            speed *=0.8;
        }

        if (System.currentTimeMillis() - t2 > 200) {
            isUpdate = true;
            t2 = System.currentTimeMillis();
        }

        if (System.currentTimeMillis() - t1 > speed) {

            if (GameScreen.bg[x[0]][y[0]] == 2) {
                doDai++;
                GameScreen.diem +=10;
                GameScreen.bg[x[0]][y[0]] = 0;
                int nextx = 0;
                int nexty = 0;
                do {
                    nextx = layToaDoMoi().x;
                    nexty = layToaDoMoi().y;
                    
                } while (toaDoNamTrongThanRan(nextx, nexty));
                GameScreen.bg[nextx][nexty] = 2;
            }

            //Cập nhật vị trí thân rắn, cứ vị trí sau sẽ dẫm vào vị trí trước và chỉ có đầu rắn là tăng hoặc giảm giá trị
            for (int i = doDai - 1; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            //Cập nhật vị trí đầu rắn
            if (vector == ConRan.GO_DOWN) {
                y[0]++;
            }
            if (vector == ConRan.GO_UP) {
                y[0]--;
            }
            if (vector == ConRan.GO_LEFT) {
                x[0]--;
            }
            if (vector == ConRan.GO_RIGHT) {
                x[0]++;
            }

            //Cập nhật khi đâm tràn viền bản đồ
            if (x[0] > 19) {
                x[0] = 0;
            }
            if (y[0] > 19) {
                y[0] = 0;
            }
            if (x[0] < 0) {
                x[0] = 19;
            }
            if (y[0] < 0) {
                y[0] = 19;
            }

            t1 = System.currentTimeMillis();
        }

    }

    public void VeRan(Graphics g) {
        g.setColor(Color.red);
        for (int i = 1; i < doDai; i++) {
//            g.fillRect(x[i]*25+1, y[i]*25+1, 23, 23);
            g.drawImage(Data.imageBody, x[i] * 25 - 1 + GameScreen.padding, y[i] * 25 - 1 + GameScreen.padding, null);
        }
        if (vector == 1) {
            g.drawImage(Data.imageHeadUp, x[0] * 25 - 1 + GameScreen.padding, y[0] * 25 - 1 + GameScreen.padding, null);
        }
        if (vector == -1) {
            g.drawImage(Data.imageHeadDown, x[0] * 25 - 1 + GameScreen.padding, y[0] * 25 - 1 + GameScreen.padding, null);
        }
        if (vector == 2) {
            g.drawImage(Data.imageHeadLeft, x[0] * 25 - 1 + GameScreen.padding, y[0] * 25 - 1 + GameScreen.padding, null);
        }
        if (vector == -2) {
            g.drawImage(Data.imageHeadRight, x[0] * 25 - 1 + GameScreen.padding, y[0] * 25 - 1 + GameScreen.padding, null);
        }

    }
}
