package player;

import java.awt.Image;
import java.io.PrintStream;
import map.Map;

public abstract class Player extends Thread
{

    public static final int DOWN = 0;
    public static final int LEFT = 1;
    public static final int UP = 2;
    public static final int RIGHT = 3;
    Image image;
    protected Image arrImage[];
    private int x;
    private int y;
    public int xp;
    public int yp;
    private int wp;
    private int hp;
    private int direction;
    private int speed;
    private boolean turn;
    private Map map;

    public Player(int x, int y, Map map)
    {
        arrImage = new Image[4];
        turn = false;
        this.x = x;
        this.y = y;
        wp = 60;
        hp = 60;
        xp = x * wp;
        yp = y * wp;
        this.map = map;
    }

    public boolean goable(Map map)
    {
        return map.hasSpaceAround(x, y);
    }

    private boolean stepMove()
    {
        if(xp > x * wp)
        {
            if(xp - x * wp < speed)
            {
                xp = x * wp;
            } else
            {
                xp -= speed;
            }
        } else
        if(xp < x * wp)
        {
            if(x * wp - xp < speed)
            {
                xp = x * wp;
            } else
            {
                xp += speed;
            }
        } else
        if(yp > y * hp)
        {
            if(yp - y * hp < speed)
            {
                yp = y * hp;
            } else
            {
                yp -= speed;
            }
        } else
        if(yp < y * hp)
        {
            if(y * hp - yp < speed)
            {
                yp = y * hp;
            } else
            {
                yp += speed;
            }
        }
        return xp == x * wp && yp == y * hp;
    }

    public void setTurn(boolean b)
    {
        turn = b;
    }

    public boolean getTurn()
    {
        return turn;
    }

    public boolean move(int direction)
    {
        int xt = x;
        int yt = y;
        if(direction == 1)
        {
            xt--;
        } else
        if(direction == 3)
        {
            xt++;
        } else
        if(direction == 2)
        {
            yt--;
        } else
        if(direction == 0)
        {
            yt++;
        }
        if(map.isSpace(xt, yt))
        {
            this.direction = direction;
            x = xt;
            y = yt;
            setXpYp();
            updateImage();
            return true;
        } else
        {
            return false;
        }
    }

    private void updateImage()
    {
        image = arrImage[direction];
    }

    public Image getImage()
    {
        return image;
    }

    public static void printDirection(int d)
    {
        if(d == 2)
        {
            System.out.println("UP");
        } else
        if(d == 0)
        {
            System.out.println("DOWN");
        } else
        if(d == 1)
        {
            System.out.println("LEFT");
        } else
        if(d == 3)
        {
            System.out.println("RIGHT");
        } else
        {
            System.out.println("NO DIR");
        }
    }

    private void setXpYp()
    {
        xp = x * wp;
        yp = y * hp;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void run()
    {
    }
}
