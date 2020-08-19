package com.jgoodies.forms.layout;

import com.jgoodies.forms.util.DefaultUnitConverter;
import java.awt.Container;
import java.awt.FontMetrics;
import java.io.Serializable;

// Referenced classes of package com.jgoodies.forms.layout:
//            FormLayout, Size

public final class PrototypeSize
    implements Size, Serializable
{

    private final String prototype;

    public PrototypeSize(String prototype)
    {
        this.prototype = prototype;
    }

    public String getPrototype()
    {
        return prototype;
    }

    public int maximumSize(Container container, java.util.List components, FormLayout.Measure minMeasure, FormLayout.Measure prefMeasure, FormLayout.Measure defaultMeasure)
    {
        java.awt.Font font = DefaultUnitConverter.getInstance().getDefaultDialogFont();
        FontMetrics fm = container.getFontMetrics(font);
        return fm.stringWidth(getPrototype());
    }

    public boolean compressible()
    {
        return false;
    }

    public String encode()
    {
        return "'" + prototype + "'";
    }

    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof PrototypeSize))
        {
            return false;
        } else
        {
            PrototypeSize size = (PrototypeSize)o;
            return prototype.equals(size.prototype);
        }
    }

    public int hashCode()
    {
        return prototype.hashCode();
    }

    public String toString()
    {
        return encode();
    }
}
