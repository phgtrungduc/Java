package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import map.Map;

// Referenced classes of package gui:
//            Panel, PN, About, Board

public class Frame extends JFrame
    implements ActionListener
{

    Board board;
    Panel panel;
    PN pn;
    About ab;
    CardLayout card;
    JPanel mainpn;

    public Frame(String s)
    {
        super(s);
        panel = new Panel(this);
        pn = new PN(this);
        ab = new About(this);
        card = new CardLayout();
        mainpn = (JPanel)getContentPane();
        mainpn.setLayout(card);
        mainpn.add("pn", pn);
        mainpn.add("map", panel);
        mainpn.add("about", ab);
    }

    public void control()
    {
        card.show(mainpn, "pn");
    }

    public void map()
    {
        card.show(mainpn, "map");
    }

    public void play()
        throws FileNotFoundException
    {
        board = new Board();
        mainpn.add("play", board);
        addKeyListener(board);
        setFocusable(true);
        card.show(mainpn, "play");
    }

    public void play(Map map)
    {
        board = new Board(map);
        mainpn.add("play1", board);
        addKeyListener(board);
        setFocusable(true);
        card.show(mainpn, "play1");
    }

    public void about()
    {
        card.show(mainpn, "about");
    }

    public void actionPerformed(ActionEvent actionevent)
    {
    }
}
