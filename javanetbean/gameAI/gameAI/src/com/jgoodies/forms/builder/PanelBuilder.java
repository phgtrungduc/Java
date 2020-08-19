package com.jgoodies.forms.builder;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.Color;
import java.awt.Component;
import java.lang.ref.WeakReference;
import javax.swing.*;
import javax.swing.border.Border;

// Referenced classes of package com.jgoodies.forms.builder:
//            AbstractFormBuilder

public class PanelBuilder extends AbstractFormBuilder
{

    private static final String LABELED_BY_PROPERTY = "labeledBy";
    private static boolean labelForFeatureEnabledDefault = false;
    private ComponentFactory componentFactory;
    private boolean labelForFeatureEnabled;
    private WeakReference mostRecentlyAddedLabelReference;

    public PanelBuilder(FormLayout layout)
    {
        this(layout, new JPanel(null));
    }

    public PanelBuilder(FormLayout layout, JPanel panel)
    {
        super(layout, panel);
        mostRecentlyAddedLabelReference = null;
        labelForFeatureEnabled = labelForFeatureEnabledDefault;
    }

    public static boolean getLabelForFeatureEnabledDefault()
    {
        return labelForFeatureEnabledDefault;
    }

    public static void setLabelForFeatureEnabledDefault(boolean b)
    {
        labelForFeatureEnabledDefault = b;
    }

    public boolean isLabelForFeatureEnabled()
    {
        return labelForFeatureEnabled;
    }

    public void setLabelForFeatureEnabled(boolean b)
    {
        labelForFeatureEnabled = b;
    }

    public final JPanel getPanel()
    {
        return (JPanel)getContainer();
    }

    public final void setBackground(Color background)
    {
        getPanel().setBackground(background);
    }

    public final void setBorder(Border border)
    {
        getPanel().setBorder(border);
    }

    public final void setDefaultDialogBorder()
    {
        setBorder(Borders.DIALOG_BORDER);
    }

    public final void setOpaque(boolean b)
    {
        getPanel().setOpaque(b);
    }

    public final JLabel addLabel(String textWithMnemonic)
    {
        return addLabel(textWithMnemonic, cellConstraints());
    }

    public final JLabel addLabel(String textWithMnemonic, CellConstraints constraints)
    {
        JLabel label = getComponentFactory().createLabel(textWithMnemonic);
        add(label, constraints);
        return label;
    }

    public final JLabel addLabel(String textWithMnemonic, String encodedConstraints)
    {
        return addLabel(textWithMnemonic, new CellConstraints(encodedConstraints));
    }

    public final JLabel addLabel(String textWithMnemonic, CellConstraints labelConstraints, Component component, CellConstraints componentConstraints)
    {
        if(labelConstraints == componentConstraints)
        {
            throw new IllegalArgumentException("You must provide two CellConstraints instances, one for the label and one for th" +
"e component.\nConsider using #clone(). See the JavaDocs for details."
);
        } else
        {
            JLabel label = addLabel(textWithMnemonic, labelConstraints);
            add(component, componentConstraints);
            label.setLabelFor(component);
            return label;
        }
    }

    public final JLabel addROLabel(String textWithMnemonic)
    {
        return addROLabel(textWithMnemonic, cellConstraints());
    }

    public final JLabel addROLabel(String textWithMnemonic, CellConstraints constraints)
    {
        ComponentFactory factory = getComponentFactory();
        ComponentFactory2 factory2;
        if(factory instanceof ComponentFactory2)
        {
            factory2 = (ComponentFactory2)factory;
        } else
        {
            factory2 = DefaultComponentFactory.getInstance();
        }
        JLabel label = factory2.createReadOnlyLabel(textWithMnemonic);
        add(label, constraints);
        return label;
    }

    public final JLabel addROLabel(String textWithMnemonic, String encodedConstraints)
    {
        return addROLabel(textWithMnemonic, new CellConstraints(encodedConstraints));
    }

    public final JLabel addROLabel(String textWithMnemonic, CellConstraints labelConstraints, Component component, CellConstraints componentConstraints)
    {
        if(labelConstraints == componentConstraints)
        {
            throw new IllegalArgumentException("You must provide two CellConstraints instances, one for the label and one for th" +
"e component.\nConsider using #clone(). See the JavaDocs for details."
);
        } else
        {
            JLabel label = addROLabel(textWithMnemonic, labelConstraints);
            add(component, componentConstraints);
            label.setLabelFor(component);
            return label;
        }
    }

    public final JLabel addTitle(String textWithMnemonic)
    {
        return addTitle(textWithMnemonic, cellConstraints());
    }

    public final JLabel addTitle(String textWithMnemonic, CellConstraints constraints)
    {
        JLabel titleLabel = getComponentFactory().createTitle(textWithMnemonic);
        add(titleLabel, constraints);
        return titleLabel;
    }

    public final JLabel addTitle(String textWithMnemonic, String encodedConstraints)
    {
        return addTitle(textWithMnemonic, new CellConstraints(encodedConstraints));
    }

    public final JComponent addSeparator(String textWithMnemonic)
    {
        return addSeparator(textWithMnemonic, getLayout().getColumnCount());
    }

    public final JComponent addSeparator(String textWithMnemonic, CellConstraints constraints)
    {
        int titleAlignment = isLeftToRight() ? 2 : 4;
        JComponent titledSeparator = getComponentFactory().createSeparator(textWithMnemonic, titleAlignment);
        add(titledSeparator, constraints);
        return titledSeparator;
    }

    public final JComponent addSeparator(String textWithMnemonic, String encodedConstraints)
    {
        return addSeparator(textWithMnemonic, new CellConstraints(encodedConstraints));
    }

    public final JComponent addSeparator(String textWithMnemonic, int columnSpan)
    {
        return addSeparator(textWithMnemonic, createLeftAdjustedConstraints(columnSpan));
    }

    public final JLabel add(JLabel label, CellConstraints labelConstraints, Component component, CellConstraints componentConstraints)
    {
        if(labelConstraints == componentConstraints)
        {
            throw new IllegalArgumentException("You must provide two CellConstraints instances, one for the label and one for th" +
"e component.\nConsider using #clone(). See the JavaDocs for details."
);
        } else
        {
            add(((Component) (label)), labelConstraints);
            add(component, componentConstraints);
            label.setLabelFor(component);
            return label;
        }
    }

    public final ComponentFactory getComponentFactory()
    {
        if(componentFactory == null)
        {
            componentFactory = DefaultComponentFactory.getInstance();
        }
        return componentFactory;
    }

    public final void setComponentFactory(ComponentFactory newFactory)
    {
        componentFactory = newFactory;
    }

    public Component add(Component component, CellConstraints cellConstraints)
    {
        Component result = super.add(component, cellConstraints);
        if(!isLabelForFeatureEnabled())
        {
            return result;
        }
        JLabel mostRecentlyAddedLabel = getMostRecentlyAddedLabel();
        if(mostRecentlyAddedLabel != null && isLabelForApplicable(mostRecentlyAddedLabel, component))
        {
            setLabelFor(mostRecentlyAddedLabel, component);
            clearMostRecentlyAddedLabel();
        }
        if(component instanceof JLabel)
        {
            setMostRecentlyAddedLabel((JLabel)component);
        }
        return result;
    }

    protected boolean isLabelForApplicable(JLabel label, Component component)
    {
        if(label.getLabelFor() != null)
        {
            return false;
        }
        if(!component.isFocusable())
        {
            return false;
        }
        if(!(component instanceof JComponent))
        {
            return true;
        } else
        {
            JComponent c = (JComponent)component;
            return c.getClientProperty("labeledBy") == null;
        }
    }

    protected void setLabelFor(JLabel label, Component component)
    {
        Component labeledComponent;
        if(component instanceof JScrollPane)
        {
            JScrollPane scrollPane = (JScrollPane)component;
            labeledComponent = scrollPane.getViewport().getView();
        } else
        {
            labeledComponent = component;
        }
        label.setLabelFor(labeledComponent);
    }

    private JLabel getMostRecentlyAddedLabel()
    {
        if(mostRecentlyAddedLabelReference == null)
        {
            return null;
        }
        JLabel label = (JLabel)mostRecentlyAddedLabelReference.get();
        if(label == null)
        {
            return null;
        } else
        {
            return label;
        }
    }

    private void setMostRecentlyAddedLabel(JLabel label)
    {
        mostRecentlyAddedLabelReference = new WeakReference(label);
    }

    private void clearMostRecentlyAddedLabel()
    {
        mostRecentlyAddedLabelReference = null;
    }

}
