package com.jgoodies.forms.layout;

import java.awt.Container;
import java.io.Serializable;

// Referenced classes of package com.jgoodies.forms.layout:
//            FormLayout, Size

public final class BoundedSize
    implements Size, Serializable
{

    private final Size basis;
    private final Size lowerBound;
    private final Size upperBound;

    public BoundedSize(Size basis, Size lowerBound, Size upperBound)
    {
        if(basis == null)
        {
            throw new NullPointerException("The basis of a bounded size must not be null.");
        }
        if(lowerBound == null && upperBound == null)
        {
            throw new IllegalArgumentException("A bounded size must have a non-null lower or upper bound.");
        } else
        {
            this.basis = basis;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            return;
        }
    }

    public Size getBasis()
    {
        return basis;
    }

    public Size getLowerBound()
    {
        return lowerBound;
    }

    public Size getUpperBound()
    {
        return upperBound;
    }

    public int maximumSize(Container container, java.util.List components, FormLayout.Measure minMeasure, FormLayout.Measure prefMeasure, FormLayout.Measure defaultMeasure)
    {
        int size = basis.maximumSize(container, components, minMeasure, prefMeasure, defaultMeasure);
        if(lowerBound != null)
        {
            size = Math.max(size, lowerBound.maximumSize(container, components, minMeasure, prefMeasure, defaultMeasure));
        }
        if(upperBound != null)
        {
            size = Math.min(size, upperBound.maximumSize(container, components, minMeasure, prefMeasure, defaultMeasure));
        }
        return size;
    }

    public boolean compressible()
    {
        return getBasis().compressible();
    }

    public boolean equals(Object object)
    {
        if(this == object)
        {
            return true;
        }
        if(!(object instanceof BoundedSize))
        {
            return false;
        } else
        {
            BoundedSize size = (BoundedSize)object;
            return basis.equals(size.basis) && (lowerBound == null && size.lowerBound == null || lowerBound != null && lowerBound.equals(size.lowerBound)) && (upperBound == null && size.upperBound == null || upperBound != null && upperBound.equals(size.upperBound));
        }
    }

    public int hashCode()
    {
        int hashValue = basis.hashCode();
        if(lowerBound != null)
        {
            hashValue = hashValue * 37 + lowerBound.hashCode();
        }
        if(upperBound != null)
        {
            hashValue = hashValue * 37 + upperBound.hashCode();
        }
        return hashValue;
    }

    public String toString()
    {
        return encode();
    }

    public String encode()
    {
        StringBuffer buffer = new StringBuffer("[");
        if(lowerBound != null)
        {
            buffer.append(lowerBound.encode());
            buffer.append(',');
        }
        buffer.append(basis.encode());
        if(upperBound != null)
        {
            buffer.append(',');
            buffer.append(upperBound.encode());
        }
        buffer.append(']');
        return buffer.toString();
    }
}
