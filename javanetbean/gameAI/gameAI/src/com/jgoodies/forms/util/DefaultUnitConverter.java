package com.jgoodies.forms.util;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

// Referenced classes of package com.jgoodies.forms.util:
//            AbstractUnitConverter, FormUtils

public final class DefaultUnitConverter extends AbstractUnitConverter
{
    private static final class DialogBaseUnits
    {

        final double x;
        final double y;

        public String toString()
        {
            return "DBU(x=" + x + "; y=" + y + ")";
        }

        DialogBaseUnits(double dialogBaseUnitsX, double dialogBaseUnitsY)
        {
            x = dialogBaseUnitsX;
            y = dialogBaseUnitsY;
        }
    }


    public static final String PROPERTY_AVERAGE_CHARACTER_WIDTH_TEST_STRING = "averageCharacterWidthTestString";
    public static final String PROPERTY_DEFAULT_DIALOG_FONT = "defaultDialogFont";
    private static final Logger LOGGER;
    private static DefaultUnitConverter instance;
    private String averageCharWidthTestString;
    private Font defaultDialogFont;
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private DialogBaseUnits cachedGlobalDialogBaseUnits;
    private DialogBaseUnits cachedDialogBaseUnits;
    private FontMetrics cachedFontMetrics;
    private Font cachedDefaultDialogFont;

    private DefaultUnitConverter()
    {
        averageCharWidthTestString = "X";
        cachedGlobalDialogBaseUnits = null;
        cachedDialogBaseUnits = null;
        cachedFontMetrics = null;
        cachedDefaultDialogFont = null;
    }

    public static DefaultUnitConverter getInstance()
    {
        if(instance == null)
        {
            instance = new DefaultUnitConverter();
        }
        return instance;
    }

    public String getAverageCharacterWidthTestString()
    {
        return averageCharWidthTestString;
    }

    public void setAverageCharacterWidthTestString(String newTestString)
    {
        if(newTestString == null)
        {
            throw new NullPointerException("The test string must not be null.");
        }
        if(newTestString.length() == 0)
        {
            throw new IllegalArgumentException("The test string must not be empty.");
        } else
        {
            String oldTestString = averageCharWidthTestString;
            averageCharWidthTestString = newTestString;
            changeSupport.firePropertyChange("averageCharacterWidthTestString", oldTestString, newTestString);
            return;
        }
    }

    public Font getDefaultDialogFont()
    {
        return defaultDialogFont == null ? getCachedDefaultDialogFont() : defaultDialogFont;
    }

    public void setDefaultDialogFont(Font newFont)
    {
        Font oldFont = defaultDialogFont;
        defaultDialogFont = newFont;
        clearCache();
        changeSupport.firePropertyChange("defaultDialogFont", oldFont, newFont);
    }

    protected double getDialogBaseUnitsX(Component component)
    {
        return getDialogBaseUnits(component).x;
    }

    protected double getDialogBaseUnitsY(Component component)
    {
        return getDialogBaseUnits(component).y;
    }

    private DialogBaseUnits getGlobalDialogBaseUnits()
    {
        if(cachedGlobalDialogBaseUnits == null)
        {
            cachedGlobalDialogBaseUnits = computeGlobalDialogBaseUnits();
        }
        return cachedGlobalDialogBaseUnits;
    }

    private DialogBaseUnits getDialogBaseUnits(Component c)
    {
        FormUtils.ensureValidCache();
        if(c == null)
        {
            return getGlobalDialogBaseUnits();
        }
        FontMetrics fm = c.getFontMetrics(getDefaultDialogFont());
        if(fm.equals(cachedFontMetrics))
        {
            return cachedDialogBaseUnits;
        } else
        {
            DialogBaseUnits dialogBaseUnits = computeDialogBaseUnits(fm);
            cachedFontMetrics = fm;
            cachedDialogBaseUnits = dialogBaseUnits;
            return dialogBaseUnits;
        }
    }

    private DialogBaseUnits computeDialogBaseUnits(FontMetrics metrics)
    {
        double averageCharWidth = computeAverageCharWidth(metrics, averageCharWidthTestString);
        int ascent = metrics.getAscent();
        double height = ascent <= 14 ? ascent + (15 - ascent) / 3 : ascent;
        DialogBaseUnits dialogBaseUnits = new DialogBaseUnits(averageCharWidth, height);
        if(LOGGER.isLoggable(Level.CONFIG))
        {
            LOGGER.config("Computed dialog base units " + dialogBaseUnits + " for: " + metrics.getFont());
        }
        return dialogBaseUnits;
    }

    private DialogBaseUnits computeGlobalDialogBaseUnits()
    {
        LOGGER.config("Computing global dialog base units...");
        Font dialogFont = getDefaultDialogFont();
        FontMetrics metrics = createDefaultGlobalComponent().getFontMetrics(dialogFont);
        DialogBaseUnits globalDialogBaseUnits = computeDialogBaseUnits(metrics);
        return globalDialogBaseUnits;
    }

    private Font getCachedDefaultDialogFont()
    {
        FormUtils.ensureValidCache();
        if(cachedDefaultDialogFont == null)
        {
            cachedDefaultDialogFont = lookupDefaultDialogFont();
        }
        return cachedDefaultDialogFont;
    }

    private Font lookupDefaultDialogFont()
    {
        Font buttonFont = UIManager.getFont("Button.font");
        return buttonFont == null ? (new JButton()).getFont() : buttonFont;
    }

    private Component createDefaultGlobalComponent()
    {
        return new JPanel(null);
    }

    void clearCache()
    {
        cachedGlobalDialogBaseUnits = null;
        cachedFontMetrics = null;
        cachedDefaultDialogFont = null;
    }

    public synchronized void addPropertyChangeListener(PropertyChangeListener listener)
    {
        changeSupport.addPropertyChangeListener(listener);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener listener)
    {
        changeSupport.removePropertyChangeListener(listener);
    }

    public synchronized void addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        changeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public synchronized void removePropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        changeSupport.removePropertyChangeListener(propertyName, listener);
    }

    static Class _mthclass$(String x0) throws ClassNotFoundException
    {
        return Class.forName(x0);
       
    }

    static 
    {
        LOGGER = Logger.getLogger((com.jgoodies.forms.util.DefaultUnitConverter.class).getName());
    }
}
