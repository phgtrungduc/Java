package com.jgoodies.forms.util;

import com.jgoodies.forms.layout.ConstantSize;
import com.jgoodies.forms.layout.Size;
import java.util.logging.Logger;

// Referenced classes of package com.jgoodies.forms.util:
//            MacLayoutStyle, WindowsLayoutStyle

public abstract class LayoutStyle
{

    private static LayoutStyle current = initialLayoutStyle();

    public LayoutStyle()
    {
    }

    private static LayoutStyle initialLayoutStyle()
    {
        if(isOSMac())
        {
            return MacLayoutStyle.INSTANCE;
        } else
        {
            return WindowsLayoutStyle.INSTANCE;
        }
    }

    private static boolean isOSMac()
    {
        return getSystemProperty("os.name").startsWith("Mac");
    }

    private static String getSystemProperty(String key) throws SecurityException
    {
        return System.getProperty(key);
        
    }

    public static LayoutStyle getCurrent()
    {
        return current;
    }

    public static void setCurrent(LayoutStyle newLayoutStyle)
    {
        current = newLayoutStyle;
    }

    public abstract Size getDefaultButtonWidth();

    public abstract Size getDefaultButtonHeight();

    public abstract ConstantSize getDialogMarginX();

    public abstract ConstantSize getDialogMarginY();

    public abstract ConstantSize getTabbedDialogMarginX();

    public abstract ConstantSize getTabbedDialogMarginY();

    public abstract ConstantSize getLabelComponentPadX();

    public abstract ConstantSize getRelatedComponentsPadX();

    public abstract ConstantSize getRelatedComponentsPadY();

    public abstract ConstantSize getUnrelatedComponentsPadX();

    public abstract ConstantSize getUnrelatedComponentsPadY();

    public abstract ConstantSize getNarrowLinePad();

    public abstract ConstantSize getLinePad();

    public abstract ConstantSize getParagraphPad();

    public abstract ConstantSize getButtonBarPad();

    public abstract boolean isLeftToRightButtonOrder();

}
