package ai;

import java.io.PrintStream;
import java.util.*;
import map.MapS;

// Referenced classes of package ai:
//            Point

public class Aiv12
{

    private static final int DEPTH = 7;
    private static final int DEPTH_PATH = 12;
    private static final int MAXIMUM = 0x13880;
    private static final int MINIMUM = 0xfffec780;
    int priceofspace[];
    int amountnode;
    boolean crack;
    private boolean alphabeta;
    private static final int VAT = 5;
    private static final int VS = 1;
    private static final int KN = 31;
    private static final int KE = 11;

    public Aiv12()
    {
        priceofspace = new int[5];
        crack = false;
        alphabeta = true;
    }

    public int findDirection(MapS map, int x, int y, int xe, int ye)
    {
        if(!map.isSpace(x - 1, y) && !map.isSpace(x + 1, y) && !map.isSpace(x, y + 1) && !map.isSpace(x, y - 1))
        {
            return -1;
        }
        if(crack)
        {
            return findPathV1(map, x, y);
        }
        if(!enemyInside(new MapS(map), xe, ye, x, y))
        {
            crack = true;
            return findPathV1(map, x, y);
        }
        int t = minimax(map, x, y, xe, ye);
        if(t < 0)
        {
            if(map.isSpace(x - 1, y))
            {
                return 1;
            }
            if(map.isSpace(x + 1, y))
            {
                return 3;
            }
            if(map.isSpace(x, y - 1))
            {
                return 2;
            }
            if(map.isSpace(x, y + 1))
            {
                return 0;
            }
        }
        return t;
    }

    private int findPathV1(MapS map, int x, int y)
    {
        int max = -1000;
        int dir = -1;
        if(map.isSpace(x - 1, y))
        {
            MapS m = new MapS(map);
            m.setRed(x - 1, y);
            int temp = searchPath(m, x - 1, y, 12);
            if(temp > max)
            {
                max = temp;
                dir = 1;
            }
        }
        if(map.isSpace(x + 1, y))
        {
            MapS m = new MapS(map);
            m.setRed(x + 1, y);
            int temp = searchPath(m, x + 1, y, 12);
            if(temp > max)
            {
                max = temp;
                dir = 3;
            }
        }
        if(map.isSpace(x, y - 1))
        {
            MapS m = new MapS(map);
            m.setRed(x, y - 1);
            int temp = searchPath(m, x, y - 1, 12);
            if(temp > max)
            {
                max = temp;
                dir = 2;
            }
        }
        if(map.isSpace(x, y + 1))
        {
            MapS m = new MapS(map);
            m.setRed(x, y + 1);
            int temp = searchPath(m, x, y + 1, 12);
            if(temp > max)
            {
                max = temp;
                dir = 0;
            }
        }
        return dir;
    }

    private int searchPath(MapS map, int x, int y, int depth)
    {
        int t = -999;
        if(depth <= 0)
        {
            return numberofegdes(map, x, y);
        }
        if(map.isSpace(x - 1, y))
        {
            MapS m = new MapS(map);
            m.setRed(x - 1, y);
            int temp = searchPath(m, x - 1, y, depth - 1);
            t = t <= temp ? temp : t;
        }
        if(map.isSpace(x + 1, y))
        {
            MapS m = new MapS(map);
            m.setRed(x + 1, y);
            int temp = searchPath(m, x + 1, y, depth - 1);
            t = t <= temp ? temp : t;
        }
        if(map.isSpace(x, y - 1))
        {
            MapS m = new MapS(map);
            m.setRed(x, y - 1);
            int temp = searchPath(m, x, y - 1, depth - 1);
            t = t <= temp ? temp : t;
        }
        if(map.isSpace(x, y + 1))
        {
            MapS m = new MapS(map);
            m.setRed(x, y + 1);
            int temp = searchPath(m, x, y + 1, depth - 1);
            t = t <= temp ? temp : t;
        }
        if(t < -990)
        {
            return -depth;
        } else
        {
            return t;
        }
    }

    private int countEdgesAStep(MapS map, ArrayList arp)
    {
        int count = 0;
        ArrayList temp = new ArrayList();
        while(!arp.isEmpty()) 
        {
            Point p = (Point)arp.remove(0);
            int x = p.x;
            int y = p.y;
            if(map.isSpaceAndNotTemp(x + 1, y))
            {
                count += map.amountSpacesAround(x + 1, y);
                temp.add(new Point(x + 1, y));
                map.setTemp(x + 1, y);
            }
            if(map.isSpaceAndNotTemp(x - 1, y))
            {
                count += map.amountSpacesAround(x - 1, y);
                temp.add(new Point(x - 1, y));
                map.setTemp(x - 1, y);
            }
            if(map.isSpaceAndNotTemp(x, y + 1))
            {
                count += map.amountSpacesAround(x, y + 1);
                temp.add(new Point(x, y + 1));
                map.setTemp(x, y + 1);
            }
            if(map.isSpaceAndNotTemp(x, y - 1))
            {
                count += map.amountSpacesAround(x, y - 1);
                temp.add(new Point(x, y - 1));
                map.setTemp(x, y - 1);
            }
        }
        arp.addAll(temp);
        return count;
    }

    private int luonggiacanh(MapS map, int x, int y, int xe, int ye, boolean myturn)
    {
        int mysum = 0;
        int hissum = 0;
        ArrayList me = new ArrayList();
        ArrayList him = new ArrayList();
        me.add(new Point(x, y));
        him.add(new Point(xe, ye));
        if(myturn)
        {
            mysum += countEdgesAStep(map, me);
        }
        while(!me.isEmpty() || !him.isEmpty()) 
        {
            hissum += countEdgesAStep(map, him);
            mysum += countEdgesAStep(map, me);
        }
        return mysum - hissum;
    }

    private int numberofegdes(MapS map, int x, int y)
    {
        int max = 0;
        ArrayList arp = new ArrayList();
        arp.add(new Point(x, y));
        int xs = x;
        int ys = y;
        if(map.isSpaceAndNotTemp(xs + 1, ys))
        {
            int t = 0;
            t += map.amountSpacesAround(xs + 1, ys);
            map.setTemp(xs + 1, ys);
            arp.add(new Point(xs + 1, ys));
            while(!arp.isEmpty()) 
            {
                Point p = (Point)arp.remove(0);
                xs = p.x;
                ys = p.y;
                if(map.isSpaceAndNotTemp(xs + 1, ys))
                {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }
                if(map.isSpaceAndNotTemp(xs - 1, ys))
                {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }
                if(map.isSpaceAndNotTemp(xs, ys + 1))
                {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }
                if(map.isSpaceAndNotTemp(xs, ys - 1))
                {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }
            if(t > max)
            {
                max = t;
            }
        }
        if(map.isSpaceAndNotTemp(xs - 1, ys))
        {
            int t = 0;
            t += map.amountSpacesAround(xs - 1, ys);
            map.setTemp(xs - 1, ys);
            arp.add(new Point(xs - 1, ys));
            while(!arp.isEmpty()) 
            {
                Point p = (Point)arp.remove(0);
                xs = p.x;
                ys = p.y;
                if(map.isSpaceAndNotTemp(xs + 1, ys))
                {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }
                if(map.isSpaceAndNotTemp(xs - 1, ys))
                {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }
                if(map.isSpaceAndNotTemp(xs, ys + 1))
                {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }
                if(map.isSpaceAndNotTemp(xs, ys - 1))
                {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }
            if(t > max)
            {
                max = t;
            }
        }
        if(map.isSpaceAndNotTemp(xs, ys + 1))
        {
            int t = 0;
            t += map.amountSpacesAround(xs, ys + 1);
            map.setTemp(xs, ys + 1);
            arp.add(new Point(xs, ys + 1));
            while(!arp.isEmpty()) 
            {
                Point p = (Point)arp.remove(0);
                xs = p.x;
                ys = p.y;
                if(map.isSpaceAndNotTemp(xs + 1, ys))
                {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }
                if(map.isSpaceAndNotTemp(xs - 1, ys))
                {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }
                if(map.isSpaceAndNotTemp(xs, ys + 1))
                {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }
                if(map.isSpaceAndNotTemp(xs, ys - 1))
                {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }
            if(t > max)
            {
                max = t;
            }
        }
        if(map.isSpaceAndNotTemp(xs, ys - 1))
        {
            int t = 0;
            t += map.amountSpacesAround(xs, ys - 1);
            map.setTemp(xs, ys - 1);
            arp.add(new Point(xs, ys - 1));
            while(!arp.isEmpty()) 
            {
                Point p = (Point)arp.remove(0);
                xs = p.x;
                ys = p.y;
                if(map.isSpaceAndNotTemp(xs + 1, ys))
                {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }
                if(map.isSpaceAndNotTemp(xs - 1, ys))
                {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }
                if(map.isSpaceAndNotTemp(xs, ys + 1))
                {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }
                if(map.isSpaceAndNotTemp(xs, ys - 1))
                {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }
            if(t > max)
            {
                max = t;
            }
        }
        return max;
    }

    public int minimax(MapS map, int x, int y, int xe, int ye)
    {
        int depth = 14;
        int direction = -1;
        int value = 0xfffec780;
        int alpha = 0xfffec780;
        int beta = 0x13880;
        amountnode = 0;
        if(map.isSpace(x, y + 1))
        {
            MapS maptemp = new MapS(map);
            maptemp.setRed(x, y + 1);
            int temp = minValue(maptemp, x, y + 1, xe, ye, depth - 1, alpha, beta);
            if(temp > value)
            {
                value = temp;
                direction = 0;
            }
        }
        if(map.isSpace(x, y - 1))
        {
            MapS maptemp = new MapS(map);
            maptemp.setRed(x, y - 1);
            int temp = minValue(maptemp, x, y - 1, xe, ye, depth - 1, alpha, beta);
            if(temp > value)
            {
                value = temp;
                direction = 2;
            }
        }
        if(map.isSpace(x + 1, y))
        {
            MapS maptemp = new MapS(map);
            maptemp.setRed(x + 1, y);
            int temp = minValue(maptemp, x + 1, y, xe, ye, depth - 1, alpha, beta);
            if(temp > value)
            {
                value = temp;
                direction = 3;
            }
        }
        if(map.isSpace(x - 1, y))
        {
            MapS maptemp = new MapS(map);
            maptemp.setRed(x - 1, y);
            int temp = minValue(maptemp, x - 1, y, xe, ye, depth - 1, alpha, beta);
            if(temp > value)
            {
                value = temp;
                direction = 1;
            }
        }
        System.out.println((new StringBuilder("V12: ")).append(value).toString());
        return direction;
    }

    private int maxValue(MapS map, int x, int y, int xe, int ye, int depth, int alpha, 
            int beta)
    {
        amountnode++;
        int max = 0xfffec780;
        if(!crack && !enemyInside(map, xe, ye, x, y))
        {
            int t = 31 * luonggiaOutside(new MapS(map), x, y, xe, ye) + 11 * luonggiacanh(new MapS(map), x, y, xe, ye, true);
            if(t > 1 || t < -1)
            {
                return t * 5;
            } else
            {
                return t;
            }
        }
        if(depth > 0)
        {
            if(map.isSpace(x + 1, y))
            {
                MapS maptemp = new MapS(map);
                maptemp.setRed(x + 1, y);
                int temp = minValue(maptemp, x + 1, y, xe, ye, depth - 1, alpha, beta);
                if(temp > max)
                {
                    max = temp;
                }
                if(alphabeta)
                {
                    if(max >= beta)
                    {
                        return max;
                    }
                    if(alpha < max)
                    {
                        alpha = max;
                    }
                }
            }
            if(map.isSpace(x - 1, y))
            {
                MapS maptemp = new MapS(map);
                maptemp.setRed(x - 1, y);
                int temp = minValue(maptemp, x - 1, y, xe, ye, depth - 1, alpha, beta);
                if(temp > max)
                {
                    max = temp;
                }
                if(alphabeta)
                {
                    if(max >= beta)
                    {
                        return max;
                    }
                    if(alpha < max)
                    {
                        alpha = max;
                    }
                }
            }
            if(map.isSpace(x, y + 1))
            {
                MapS maptemp = new MapS(map);
                maptemp.setRed(x, y + 1);
                int temp = minValue(maptemp, x, y + 1, xe, ye, depth - 1, alpha, beta);
                if(temp > max)
                {
                    max = temp;
                }
                if(alphabeta)
                {
                    if(max >= beta)
                    {
                        return max;
                    }
                    if(alpha < max)
                    {
                        alpha = max;
                    }
                }
            }
            if(map.isSpace(x, y - 1))
            {
                MapS maptemp = new MapS(map);
                maptemp.setRed(x, y - 1);
                int temp = minValue(maptemp, x, y - 1, xe, ye, depth - 1, alpha, beta);
                if(temp > max)
                {
                    max = temp;
                }
                if(alphabeta)
                {
                    if(max >= beta)
                    {
                        return max;
                    }
                    if(alpha < max)
                    {
                        alpha = max;
                    }
                }
            }
        } else
        {
            max = 31 * luonggia(new MapS(map), x, y, xe, ye, true) + 11 * luonggiacanh(new MapS(map), x, y, xe, ye, true);
        }
        if(max == 0xfffec780)
        {
            max = -40000 - depth;
        }
        return max;
    }

    private int minValue(MapS map, int x, int y, int xe, int ye, int depth, int alpha, 
            int beta)
    {
        amountnode++;
        int min = 0x13880;
        if(!crack && !enemyInside(map, xe, ye, x, y))
        {
            int t = 31 * luonggiaOutside(new MapS(map), x, y, xe, ye) + 11 * luonggiacanh(new MapS(map), x, y, xe, ye, false);
            if(t > 1 || t < -1)
            {
                return t * 5;
            } else
            {
                return t;
            }
        }
        if(map.isSpace(xe + 1, ye))
        {
            MapS maptemp = new MapS(map);
            maptemp.setGreen(xe + 1, ye);
            int temp = maxValue(maptemp, x, y, xe + 1, ye, depth - 1, alpha, beta);
            if(temp < min)
            {
                min = temp;
            }
            if(alphabeta)
            {
                if(min <= alpha)
                {
                    return min;
                }
                beta = beta >= min ? min : beta;
            }
        }
        if(map.isSpace(xe - 1, ye))
        {
            MapS maptemp = new MapS(map);
            maptemp.setGreen(xe - 1, ye);
            int temp = maxValue(maptemp, x, y, xe - 1, ye, depth - 1, alpha, beta);
            if(temp < min)
            {
                min = temp;
            }
            if(alphabeta)
            {
                if(min <= alpha)
                {
                    return min;
                }
                beta = beta >= min ? min : beta;
            }
        }
        if(map.isSpace(xe, ye + 1))
        {
            MapS maptemp = new MapS(map);
            maptemp.setGreen(xe, ye + 1);
            int temp = maxValue(maptemp, x, y, xe, ye + 1, depth - 1, alpha, beta);
            if(temp < min)
            {
                min = temp;
            }
            if(alphabeta)
            {
                if(min <= alpha)
                {
                    return min;
                }
                beta = beta >= min ? min : beta;
            }
        }
        if(map.isSpace(xe, ye - 1))
        {
            MapS maptemp = new MapS(map);
            maptemp.setGreen(xe, ye - 1);
            int temp = maxValue(maptemp, x, y, xe, ye - 1, depth - 1, alpha, beta);
            if(temp < min)
            {
                min = temp;
            }
            if(alphabeta)
            {
                if(min <= alpha)
                {
                    return min;
                }
                beta = beta >= min ? min : beta;
            }
        }
        if(min == 0x13880)
        {
            min = 40000 + depth;
        }
        return min;
    }

    private int luonggiaOutside(MapS m, int x, int y, int xe, int ye)
    {
        int mysum = 0;
        int hissum = 0;
        int black = 0;
        int white = 0;
        ArrayList arp = new ArrayList();
        arp.add(new Point(x, y));
        boolean blackturn = true;
        while(!arp.isEmpty()) 
        {
            if(blackturn)
            {
                black += redGo(arp, m);
                blackturn = false;
            } else
            {
                white += redGo(arp, m);
                blackturn = true;
            }
        }
        mysum = white + black;
        if(white > black)
        {
            mysum -= white - black;
        } else
        if(white < black - 1)
        {
            mysum -= black - 1 - white;
        }
        black = white = 0;
        arp.add(new Point(xe, ye));
        blackturn = true;
        while(!arp.isEmpty()) 
        {
            if(blackturn)
            {
                black += redGo(arp, m);
                blackturn = false;
            } else
            {
                white += redGo(arp, m);
                blackturn = true;
            }
        }
        hissum = white + black;
        if(hissum <= 0)
        {
            if(white > black)
            {
                hissum -= white - black;
            } else
            if(white < black - 1)
            {
                hissum -= black - 1 - white;
            }
        }
        return mysum - hissum;
    }

    public int luonggia(MapS map, int x, int y, int xe, int ye, boolean ismyturn)
    {
        ArrayList red = new ArrayList();
        ArrayList green = new ArrayList();
        red.add(new Point(x, y));
        green.add(new Point(xe, ye));
        int sumred = 0;
        int sumgreen = 0;
        if(!crack)
        {
            if(ismyturn)
            {
                while(!red.isEmpty() || !green.isEmpty()) 
                {
                    sumred += redGo(red, map);
                    sumgreen += greenGo(green, map);
                }
            } else
            {
                while(!red.isEmpty() || !green.isEmpty()) 
                {
                    sumgreen += greenGo(green, map);
                    sumred += redGo(red, map);
                }
            }
        } else
        {
            while(!red.isEmpty()) 
            {
                sumred += redGo(red, map);
            }
        }
        return sumred - sumgreen;
    }

    private int redGo(ArrayList red, MapS map)
    {
        ArrayList redtemp = new ArrayList();
        int sumred = 0;
        for(; !red.isEmpty(); red.remove(0))
        {
            Point point = (Point)red.get(0);
            int x = point.x;
            int y = point.y;
            if(map.isSpace(x + 1, y))
            {
                sumred++;
                map.setRed(x + 1, y);
                redtemp.add(new Point(x + 1, y));
            }
            if(map.isSpace(x - 1, y))
            {
                sumred++;
                map.setRed(x - 1, y);
                redtemp.add(new Point(x - 1, y));
            }
            if(map.isSpace(x, y + 1))
            {
                sumred++;
                map.setRed(x, y + 1);
                redtemp.add(new Point(x, y + 1));
            }
            if(map.isSpace(x, y - 1))
            {
                sumred++;
                map.setRed(x, y - 1);
                redtemp.add(new Point(x, y - 1));
            }
        }

        for(int i = 0; i < redtemp.size(); i++)
        {
            red.add((Point)redtemp.get(i));
        }

        return sumred;
    }

    private int greenGo(ArrayList green, MapS map)
    {
        ArrayList greentemp = new ArrayList();
        int sumgreen = 0;
        for(; !green.isEmpty(); green.remove(0))
        {
            Point point = (Point)green.get(0);
            int x = point.x;
            int y = point.y;
            if(map.isSpace(x + 1, y))
            {
                sumgreen++;
                map.setGreen(x + 1, y);
                greentemp.add(new Point(x + 1, y));
            }
            if(map.isSpace(x - 1, y))
            {
                sumgreen++;
                map.setGreen(x - 1, y);
                greentemp.add(new Point(x - 1, y));
            }
            if(map.isSpace(x, y + 1))
            {
                sumgreen++;
                map.setGreen(x, y + 1);
                greentemp.add(new Point(x, y + 1));
            }
            if(map.isSpace(x, y - 1))
            {
                sumgreen++;
                map.setGreen(x, y - 1);
                greentemp.add(new Point(x, y - 1));
            }
        }

        for(int i = 0; i < greentemp.size(); i++)
        {
            green.add((Point)greentemp.get(i));
        }

        return sumgreen;
    }

    private boolean enemyInside(MapS m, int xg, int yg, int xr, int yr)
    {
        MapS map = new MapS(m);
        Queue queue = new LinkedList();
        queue.add(new Point(xr, yr));
        while(!queue.isEmpty()) 
        {
            Point element = (Point)queue.remove();
            int x = element.x;
            int y = element.y;
            if(map.isSpace(x + 1, y))
            {
                map.setMap(x + 1, y);
                queue.add(new Point(x + 1, y));
            }
            if(map.isSpace(x - 1, y))
            {
                map.setMap(x - 1, y);
                queue.add(new Point(x - 1, y));
            }
            if(map.isSpace(x, y - 1))
            {
                map.setMap(x, y - 1);
                queue.add(new Point(x, y - 1));
            }
            if(map.isSpace(x, y + 1))
            {
                map.setMap(x, y + 1);
                queue.add(new Point(x, y + 1));
            }
        }
        return map.isReachable(xg + 1, yg) || map.isReachable(xg - 1, yg) || map.isReachable(xg, yg + 1) || map.isReachable(xg, yg - 1);
    }
}
