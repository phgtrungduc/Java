package gui;

import ai.Aiv12;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import javax.swing.*;
import map.Map;
import map.MapS;
import player.*;

public class Board extends JPanel
    implements KeyListener, ActionListener
{

    public static final int HEIGHT = 720;
    public static final int WIDTH = 700;
    private final int offsetx = 20;
    private final int offsety = 20;
    Map map;
    RedPlayer red;
    GreenPlayer green;
    Timer timer;
    int x;
    int y;
    Aiv12 aiv12;
    boolean finished;

    public Board()
        throws FileNotFoundException
    {
        x = 0;
        y = 0;
        aiv12 = new Aiv12();
        finished = false;
        setFocusable(true);
        addKeyListener(this);
        map = new Map("/lib/map.txt");
        red = new RedPlayer(10, 10, map);
        green = new GreenPlayer(0, 0, map);
        map.setGreen(0, 0);
        map.setRed(10, 10);
        timer = new Timer(27, this);
        timer.start();
        if((new Random()).nextInt(2) == 1)
        {
            setFirstTurn(red);
        } else
        {
            setFirstTurn(green);
        }
    }

    public Board(Map m)
    {
        x = 0;
        y = 0;
        aiv12 = new Aiv12();
        finished = false;
        setFocusable(true);
        addKeyListener(this);
        map = m;
        red = new RedPlayer(10, 10, map);
        green = new GreenPlayer(0, 0, map);
        map.setGreen(0, 0);
        map.setRed(10, 10);
        timer = new Timer(27, this);
        timer.start();
        if((new Random()).nextInt(2) == 1)
        {
            setFirstTurn(green);
        } else
        {
            setFirstTurn(red);
        }
    }

    private void setFirstTurn(Player p)
    {
        p.setTurn(true);
    }

    private void changeTurn()
    {
        if(green.getTurn())
        {
            green.setTurn(false);
            red.setTurn(true);
        } else
        {
            green.setTurn(true);
            red.setTurn(false);
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(map.getImageMap(), 0, 0, this);
        for(int x = 0; x < 11; x++)
        {
            for(int y = 0; y < 11; y++)
            {
                if(!map.isSpace(x, y))
                {
                    g.drawImage(map.getImage(x, y), x * 60 + 20, y * 60 + 20, this);
                }
            }

        }

        g.drawImage(red.getImage(), red.xp + 20, red.yp + 20, this);
        g.drawImage(green.getImage(), green.xp + 20, green.yp + 20, this);
        if(finished)
        {
            if(red.goable(map))
            {
                g.drawImage((new ImageIcon(getClass().getResource("/lib/rw.png"))).getImage(), 0, 0, this);
            } else
            {
                g.drawImage((new ImageIcon(getClass().getResource("/lib/gw.png"))).getImage(), 0, 0, this);
            }
        }
        repaint();
    }

    public void keyTyped(KeyEvent keyevent)
    {
    }

    public void keyPressed(KeyEvent keyevent)
    {
    }

    public void keyReleased(KeyEvent ke)
    {
        if(green.getTurn() && !finished)
        {
            int k = ke.getKeyCode();
            int dir = -1;
            if(k == 38)
            {
                dir = 2;
            } else
            if(k == 40)
            {
                dir = 0;
            } else
            if(k == 37)
            {
                dir = 1;
            } else
            if(k == 39)
            {
                dir = 3;
            }
            if(green.move(dir))
            {
                map.setGreen(green.getX(), green.getY());
                changeTurn();
            }
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(!finished)
        {
            if(!green.goable(map))
            {
                System.out.println("Do Thang");
                finished = true;
            } else
            if(red.getTurn())
            {
                Long T = Long.valueOf(System.nanoTime());
                red.move(aiv12.findDirection(new MapS(map), red.getX(), red.getY(), green.getX(), green.getY()));
                map.setRed(red.getX(), red.getY());
                if(!red.goable(map))
                {
                    System.out.println("Xanh Thang");
                    finished = true;
                } else
                {
                    changeTurn();
                }
            }
        }
    }
}
