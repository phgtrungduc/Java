package gui;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

// Referenced classes of package gui:
//            Frame

public class PN extends JPanel
    implements MouseListener
{

    private JButton play;
    private JButton map;
    private JButton about;
    private JButton exit;
    private JLabel background;
    private Frame jf;

    public PN(Frame jf)
    {
        initComponents();
        this.jf = jf;
        play.addMouseListener(this);
        map.addMouseListener(this);
        about.addMouseListener(this);
        exit.addMouseListener(this);
    }

    private void initComponents()
    {
        play = new JButton();
        map = new JButton();
        about = new JButton();
        exit = new JButton();
        background = new JLabel();
        setLayout(null);
        play.setBorder(null);
        map.setBorder(null);
        about.setBorder(null);
        exit.setBorder(null);
        Cursor cur = new Cursor(12);
        play.setCursor(cur);
        map.setCursor(cur);
        about.setCursor(cur);
        exit.setCursor(cur);
        play.setIcon(new ImageIcon(getClass().getResource("/lib/play.png")));
        map.setIcon(new ImageIcon(getClass().getResource("/lib/createmap.png")));
        about.setIcon(new ImageIcon(getClass().getResource("/lib/about.png")));
        exit.setIcon(new ImageIcon(getClass().getResource("/lib/exit.png")));
        int n = 50;
        play.setBounds(450, 230 + n, 202, 44);
        map.setBounds(450, 300 + n, 202, 44);
        about.setBounds(450, 370 + n, 202, 44);
        exit.setBounds(450, 440 + n, 202, 44);
        add(play);
        add(map);
        add(about);
        add(exit);
        background.setIcon(new ImageIcon(getClass().getResource("/lib/bg4.png")));
        add(background);
        background.setBounds(0, -30, 750, 750);
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

    public void mousePressed(MouseEvent mouseevent)
    {
    }

    public void mouseReleased(MouseEvent arg0)
    {
        if(arg0.getSource() == play)
        {
            jf.map();
        }
        if(arg0.getSource() == map)
        {
            jf.map();
        }
        if(arg0.getSource() == about)
        {
            jf.about();
        }
        if(arg0.getSource() == exit)
        {
            System.exit(0);
        }
    }
}
