package player;

import javax.swing.ImageIcon;
import map.Map;

// Referenced classes of package player:
//            Player

public class RedPlayer extends Player
{

    public RedPlayer(int x, int y, Map map)
    {
        super(x, y, map);
        arrImage[0] = (new ImageIcon(getClass().getResource("/lib/xed_4.png"))).getImage();
        arrImage[1] = (new ImageIcon(getClass().getResource("/lib/xed_2.png"))).getImage();
        arrImage[2] = (new ImageIcon(getClass().getResource("/lib/xed.png"))).getImage();
        arrImage[3] = (new ImageIcon(getClass().getResource("/lib/xed_3.png"))).getImage();
        image = arrImage[2];
    }
}
