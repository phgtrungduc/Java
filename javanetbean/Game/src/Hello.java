
import java.awt.Graphics;
import javax.swing.JFrame;

public class Hello extends JFrame {

    public Hello() {
//        JFrame j = new JFrame();
        setTitle("Hello"); // Tiêu đề form sẽ là Hello
        setVisible(true); // Cho nhìn thấy form, nếu truyền false sẽ ko thấy form
        setSize(400, 400); // đặt kích thước form là 400x400 px.
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Hello world", 100, 100); // Vẽ xâu "Hello world" tại vị trí (100, 100)
    }

    public static void main(String[] args) {
        Hello a = new Hello(); // tạo mới một form
        JFrame j = new JFrame();
        j.setSize(500,500);
        j.add(a);
        j.setDefaultCloseOperation(EXIT_ON_CLOSE);
        j.setVisible(true);
        
    }
}
