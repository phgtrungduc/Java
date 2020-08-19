
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    int a = 0;
    Thread thread;

    public GameScreen() {
        thread = new Thread(this);  //tham số truyền vào khi khởi tạo một thread là đối tượng chạy trong thread đó, trong th này đối tượng là chính lớp này
        thread.start();   //khi gọi start của lớp kế thừa runnable thì nó tự động gọi phương thức run
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.BLUE);
        g.fillRect(a, a, 20, 20);
    }

    @Override
    public void run() {
        while (true) {
            a++;
            repaint();   //Thực hiện lại hàm paint
            try {
                thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
