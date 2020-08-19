package gui;

import java.io.FileNotFoundException;

// Referenced classes of package gui:
//            Frame, PN

public class Main
{

    public Main()
    {
    }

    public static void main(String args[])
        throws FileNotFoundException
    {
        Frame jf = new Frame("AI");
        jf.add(new PN(jf));
        jf.setVisible(true);
        jf.setSize(700, 720);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setAlwaysOnTop(false);
        jf.setDefaultCloseOperation(3);
    }
}
