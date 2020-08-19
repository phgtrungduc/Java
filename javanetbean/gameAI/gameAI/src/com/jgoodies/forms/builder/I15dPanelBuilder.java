package com.jgoodies.forms.builder;

import com.jgoodies.forms.layout.FormLayout;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.JPanel;

// Referenced classes of package com.jgoodies.forms.builder:
//            AbstractI15dPanelBuilder

public class I15dPanelBuilder extends AbstractI15dPanelBuilder
{

    private final ResourceBundle bundle;

    public I15dPanelBuilder(FormLayout layout, ResourceBundle bundle)
    {
        this(layout, bundle, new JPanel(null));
    }

    public I15dPanelBuilder(FormLayout layout, ResourceBundle bundle, JPanel panel)
    {
        super(layout, panel);
        this.bundle = bundle;
    }

    protected String getI15dString(String resourceKey)
    {
        if(bundle == null)
        {
            throw new IllegalStateException("You must specify a ResourceBundle before using the internationalization support.");
        }
        return bundle.getString(resourceKey);
        
    }
}
