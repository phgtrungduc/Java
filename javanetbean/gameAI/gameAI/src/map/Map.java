package map;

import java.awt.Image;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class Map
{

    public static final int M = 11;
    public static final int N = 11;
    public static final int W = 60;
    public static final int H = 60;
    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int GREEN = 2;
    public static final int RED = 3;
    public static final int TEMP = 4;
    int map[][];
    private int prices[][];
    private Image imagemap;
    private Image image[];
    public static long dem = 0L;

    public Map(String s)
        throws FileNotFoundException
    {
        image = new Image[4];
        map = new int[11][11];
        prices = new int[11][11];
        FileReader fr = new FileReader(getClass().getResource(s).getFile());
        Scanner scan = new Scanner(fr);
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                map[i][j] = scan.nextInt();
            }

        }

        setPrices();
        imagemap = (new ImageIcon(getClass().getResource("/lib/map.png"))).getImage();
        image[1] = (new ImageIcon(getClass().getResource("/lib/3.png"))).getImage();
        image[3] = (new ImageIcon(getClass().getResource("/lib/d.png"))).getImage();
        image[2] = (new ImageIcon(getClass().getResource("/lib/x.png"))).getImage();
    }

    public Map(int m[][])
    {
        image = new Image[4];
        map = m;
        prices = new int[11][11];
        setPrices();
        imagemap = (new ImageIcon(getClass().getResource("/lib/map.png"))).getImage();
        image[1] = (new ImageIcon(getClass().getResource("/lib/3.png"))).getImage();
        image[3] = (new ImageIcon(getClass().getResource("/lib/d.png"))).getImage();
        image[2] = (new ImageIcon(getClass().getResource("/lib/x.png"))).getImage();
    }

    public Map(Map ma)
    {
        image = new Image[4];
        map = new int[11][11];
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                map[i][j] = ma.map[i][j];
            }

        }

        prices = new int[11][11];
        imagemap = ma.imagemap;
        image = ma.image;
    }

    public boolean hasSpaceAround(int x, int y)
    {
        return isSpace(x - 1, y) || isSpace(x + 1, y) || isSpace(x, y - 1) || isSpace(x, y + 1);
    }

    public int amountSpacesAround(int x, int y)
    {
        int count = 0;
        if(isSpace(x - 1, y))
        {
            count++;
        }
        if(isSpace(x + 1, y))
        {
            count++;
        }
        if(isSpace(x, y - 1))
        {
            count++;
        }
        if(isSpace(x, y + 1))
        {
            count++;
        }
        return count;
    }

    public int amountSpacesNotTempAround(int x, int y)
    {
        int count = 0;
        if(isSpaceAndNotTemp(x - 1, y))
        {
            count++;
        }
        if(isSpaceAndNotTemp(x + 1, y))
        {
            count++;
        }
        if(isSpaceAndNotTemp(x, y - 1))
        {
            count++;
        }
        if(isSpaceAndNotTemp(x, y + 1))
        {
            count++;
        }
        return count;
    }

    public int[][] getPrices()
    {
        return prices;
    }

    private void setPrices()
    {
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                prices[i][j] = 1;
            }

        }

    }

    public Image getImageMap()
    {
        return imagemap;
    }

    public Image getImage(int x, int y)
    {
        if(x >= 11 || y >= 11)
        {
            return null;
        }
        int i = map[y][x];
        if(i > 0 && i < 4)
        {
            return image[i];
        } else
        {
            return null;
        }
    }

    public void printMap()
    {
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                System.out.print(map[i][j]);
            }

            System.out.println();
        }

        System.out.println("***********");
    }

    public void printPrices()
    {
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                System.out.print(prices[i][j]);
            }

            System.out.println();
        }

    }

    public boolean isSpace(int x, int y)
    {
        if(x >= 11 || y >= 11 || x < 0 || y < 0)
        {
            return false;
        }
        return map[y][x] == 0 || map[y][x] == 4;
    }

    public boolean isSpaceAndNotTemp(int x, int y)
    {
        if(x >= 11 || y >= 11 || x < 0 || y < 0)
        {
            return false;
        }
        return map[y][x] == 0;
    }

    public void setTemp(int x, int y)
    {
        map[y][x] = 4;
    }

    public int getPrice(int x, int y)
    {
        return prices[y][x];
    }

    public boolean isWall(int x, int y)
    {
        if(x >= 11 || y >= 11 || x < 0 || y < 0)
        {
            return true;
        }
        return map[y][x] == 1;
    }

    public void setRed(int x, int y)
    {
        map[y][x] = 3;
    }

    public void setGreen(int x, int y)
    {
        map[y][x] = 2;
    }

    public void setMap(int x, int y)
    {
        map[y][x] = 10;
    }

    public boolean isReachable(int x, int y)
    {
        if(x >= 11 || y >= 11 || x < 0 || y < 0)
        {
            return false;
        }
        return map[y][x] == 10;
    }

    public void setSpace(int x, int y)
    {
        map[y][x] = 0;
    }

}
