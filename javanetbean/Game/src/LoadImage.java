/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duc.pt173030
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class LoadImage extends JPanel {

    private Image image;

    public LoadImage() {
        ImageIcon imageIcon = new ImageIcon("image/a.jpg");
        image = imageIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(image, 100, 100, this); // Vẽ hình tại tọa độ (x, y) = (100, 100)
    }
    @Override
    public void paintComponents(Graphics g) {
        //Không dùng với jpanel
    }

    public static void main(String[] args) {
        JFrame j = new JFrame();
        j.setSize(500, 500);
        j.setResizable(false);
        j.add(new LoadImage());
        j.setVisible(true);
        j.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
