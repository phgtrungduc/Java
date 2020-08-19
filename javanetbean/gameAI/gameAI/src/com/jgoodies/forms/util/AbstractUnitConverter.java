package com.jgoodies.forms.util;

import java.awt.*;

// Referenced classes of package com.jgoodies.forms.util:
//            UnitConverter

public abstract class AbstractUnitConverter
    implements UnitConverter
{

    private static final int DTP_RESOLUTION = 72;
    private static int defaultScreenResolution = -1;

    public AbstractUnitConverter()
    {
    }

    public int inchAsPixel(double in, Component component)
    {
        return inchAsPixel(in, getScreenResolution(component));
    }

    public int millimeterAsPixel(double mm, Component component)
    {
        return millimeterAsPixel(mm, getScreenResolution(component));
    }

    public int centimeterAsPixel(double cm, Component component)
    {
        return centimeterAsPixel(cm, getScreenResolution(component));
    }

    public int pointAsPixel(int pt, Component component)
    {
        return pointAsPixel(pt, getScreenResolution(component));
    }

    public int dialogUnitXAsPixel(int dluX, Component c)
    {
        return dialogUnitXAsPixel(dluX, getDialogBaseUnitsX(c));
    }

    public int dialogUnitYAsPixel(int dluY, Component c)
    {
        return dialogUnitYAsPixel(dluY, getDialogBaseUnitsY(c));
    }

    protected abstract double getDialogBaseUnitsX(Component component);

    protected abstract double getDialogBaseUnitsY(Component component);

    protected final int inchAsPixel(double in, int dpi)
    {
        return (int)Math.round((double)dpi * in);
    }

    protected final int millimeterAsPixel(double mm, int dpi)
    {
        return (int)Math.round(((double)dpi * mm * 10D) / 254D);
    }

    protected final int centimeterAsPixel(double cm, int dpi)
    {
        return (int)Math.round(((double)dpi * cm * 100D) / 254D);
    }

    protected final int pointAsPixel(int pt, int dpi)
    {
        return Math.round((dpi * pt) / 72);
    }

    protected int dialogUnitXAsPixel(int dluX, double dialogBaseUnitsX)
    {
        return (int)Math.round(((double)dluX * dialogBaseUnitsX) / 4D);
    }

    protected int dialogUnitYAsPixel(int dluY, double dialogBaseUnitsY)
    {
        return (int)Math.round(((double)dluY * dialogBaseUnitsY) / 8D);
    }

    protected double computeAverageCharWidth(FontMetrics metrics, String testString)
    {
        int width = metrics.stringWidth(testString);
        double average = (double)width / (double)testString.length();
        return average;
    }

    protected int getScreenResolution(Component c)
    {
        if(c == null)
        {
            return getDefaultScreenResolution();
        } else
        {
            Toolkit toolkit = c.getToolkit();
            return toolkit == null ? getDefaultScreenResolution() : toolkit.getScreenResolution();
        }
    }

    protected int getDefaultScreenResolution()
    {
        if(defaultScreenResolution == -1)
        {
            defaultScreenResolution = Toolkit.getDefaultToolkit().getScreenResolution();
        }
        return defaultScreenResolution;
    }

}
