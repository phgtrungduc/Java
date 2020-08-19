package map;

import java.io.PrintStream;

// Referenced classes of package map:
//            Map

public class Mapn
{

    public static final int M = 11;
    public static final int N = 11;
    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int GREEN = 2;
    public static final int RED = 3;
    public static final int TEMP = 4;
    private int map[][];
    public static long dem = 0L;

    public Mapn(Map ma)
    {
        map = new int[11][11];
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                map[i][j] = ma.map[i][j];
            }

        }

        dem++;
    }

    public Mapn(Mapn ma)
    {
        map = new int[11][11];
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                map[i][j] = ma.map[i][j];
            }

        }

        dem++;
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
