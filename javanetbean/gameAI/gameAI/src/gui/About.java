package gui;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

// Referenced classes of package gui:
//            Frame

public class About extends JPanel
    implements MouseListener
{

    private JLabel background;
    private Frame jf;
    private JButton back;

    public About(Frame jf)
    {
        this.jf = jf;
        setLayout(null);
        background = new JLabel();
        back = new JButton("");
        back.setIcon(new ImageIcon(getClass().getResource("/lib/back.png")));
        add(back);
        background.setIcon(new ImageIcon(getClass().getResource("/lib/bg5.png")));
        add(background);
        back.setBounds(50, 600, 202, 44);
        back.setBorder(null);
        back.setCursor(new Cursor(12));
        background.setBounds(0, -30, 750, 750);
        back.addMouseListener(this);
        setFocusable(true);
    }

    public void mouseClicked(MouseEvent mouseevent)
    {
    }

    public void mouseEntered(MouseEvent mouseevent)
    {
    }

    public void mouseExited(MouseEvent mouseevent)
    {
    }

    public void mousePressed(MouseEvent arg0)
    {
        if(arg0.getSource() == back)
        {
            jf.control();
        }
    }

    public void mouseReleased(MouseEvent mouseevent)
    {
    }
}
