package com.jgoodies.forms.layout;

import java.awt.Container;

// Referenced classes of package com.jgoodies.forms.layout:
//            FormLayout

public interface Size
{

    public abstract int maximumSize(Container container, java.util.List list, FormLayout.Measure measure, FormLayout.Measure measure1, FormLayout.Measure measure2);

    public abstract boolean compressible();

    public abstract String encode();
}
