package player;

import javax.swing.ImageIcon;
import map.Map;

// Referenced classes of package player:
//            Player

public class GreenPlayer extends Player
{

    public GreenPlayer(int x, int y, Map map)
    {
        super(x, y, map);
        arrImage[0] = (new ImageIcon(getClass().getResource("/lib/xex_4.png"))).getImage();
        arrImage[1] = (new ImageIcon(getClass().getResource("/lib/xex_2.png"))).getImage();
        arrImage[2] = (new ImageIcon(getClass().getResource("/lib/xex.png"))).getImage();
        arrImage[3] = (new ImageIcon(getClass().getResource("/lib/xex_3.png"))).getImage();
        image = arrImage[0];
    }
}
