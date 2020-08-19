package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import map.Map;

// Referenced classes of package gui:
//            Button, Frame

public class Panel extends JPanel
    implements MouseListener
{

    Button buttons[][];
    JButton butok;
    Frame jf;
    Font font;

    public Panel(Frame jf)
    {
        buttons = new Button[11][11];
        butok = new JButton("OK");
        font = new Font("MV Boli", 1, 18);
        this.jf = jf;
        butok.setBackground(Color.decode("#f1f1f1"));
        butok.setFont(font);
        butok.setIcon(new ImageIcon(getClass().getResource("/lib/ok.png")));
        butok.setText(null);
        butok.setCursor(new Cursor(12));
        butok.setBorder(null);
        addMouseListener(this);
        setFocusable(true);
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                buttons[i][j] = new Button();
            }

        }

        setLayout(new GridLayout(11, 11));
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                if(i == 5 && j == 5)
                {
                    add(butok);
                    butok.addMouseListener(this);
                } else
                {
                    add(buttons[i][j]);
                    buttons[i][j].addMouseListener(this);
                }
            }

        }

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
        if(arg0.getSource() == butok)
        {
            Map map = new Map(getMap());
            jf.play(map);
        }
    }

    public void mouseReleased(MouseEvent arg0)
    {
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                if(arg0.getSource() == buttons[i][j])
                {
                    buttons[i][j].click();
                    buttons[10 - i][10 - j].setClick();
                }
            }

        }

    }

    public Map getMap()
    {
        int map[][] = new int[11][11];
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                if(buttons[i][j].isSelected())
                {
                    map[i][j] = 1;
                } else
                {
                    map[i][j] = 0;
                }
            }

        }

        return new Map(map);
    }

    public void check()
    {
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                if(buttons[i][j].isSelected() && !buttons[10 - i][10 - j].isSelected())
                {
                    buttons[i][j].reset();
                    buttons[10 - i][10 - j].reset();
                }
            }

        }

    }
}
