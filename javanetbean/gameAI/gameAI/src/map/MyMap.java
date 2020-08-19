package map;


// Referenced classes of package map:
//            Map

public class MyMap
{

    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int GREEN = 2;
    public static final int RED = 3;
    public static final int TEMP = 4;
    public static final int N = 11;
    public int map[];

    public MyMap(Map mm)
    {
        map = new int[121];
        int m[][] = mm.map;
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                map[i * 11 + j] = m[i][j];
            }

        }

    }

    public MyMap(MyMap mm)
    {
        map = new int[121];
        int m[] = mm.map;
        for(int i = 0; i < 121; i++)
        {
            map[i] = m[i];
        }

    }

    public boolean isSpace(int x, int y)
    {
        if(x >= 11 || y >= 11 || x < 0 || y < 0)
        {
            return false;
        }
        return map[y * 11 + x] == 0 || map[y * 11 + x] == 4;
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

    public boolean isSpaceAndNotTemp(int x, int y)
    {
        if(x >= 11 || y >= 11 || x < 0 || y < 0)
        {
            return false;
        }
        return map[y * 11 + x] == 0;
    }

    public void setTemp(int x, int y)
    {
        map[y * 11 + x] = 4;
    }

    public void setRed(int x, int y)
    {
        map[y * 11 + x] = 3;
    }

    public void setGreen(int x, int y)
    {
        map[y * 11 + x] = 2;
    }

    public void setMap(int x, int y)
    {
        map[y * 11 + x] = 10;
    }

    public boolean isReachable(int x, int y)
    {
        if(x >= 11 || y >= 11 || x < 0 || y < 0)
        {
            return false;
        }
        return map[y * 11 + x] == 10;
    }

    public void setSpace(int x, int y)
    {
        map[y * 11 + x] = 0;
    }
}
