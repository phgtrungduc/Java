package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

class Button extends JToggleButton
{

    String label;
    public static final String SELECTED = "WALL";
    public static final String UNSELECT = "";
    public final ImageIcon WALLIMAGE = new ImageIcon(getClass().getResource("/lib/3.png"));

    public Button()
    {
        setMaximumSize(new Dimension(60, 60));
        setMinimumSize(new Dimension(60, 60));
        setBackground(Color.decode("#1695a3"));
        setBorder(new LineBorder(Color.white));
    }

    public void click()
    {
        if(isSelected())
        {
            setIcon(WALLIMAGE);
        } else
        {
            setIcon(null);
        }
    }

    public void reset()
    {
        setSelected(false);
        setIcon(null);
    }

    public void setClick()
    {
        if(isSelected())
        {
            setSelected(false);
            setIcon(null);
        } else
        {
            setSelected(true);
            setIcon(WALLIMAGE);
        }
    }
}
