package com.jgoodies.forms.builder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.*;
import javax.swing.*;

// Referenced classes of package com.jgoodies.forms.builder:
//            PanelBuilder

public final class ButtonStackBuilder extends PanelBuilder
{

    private static final ColumnSpec COL_SPECS[];
    private static final RowSpec ROW_SPECS[] = new RowSpec[0];
    private static final String NARROW_KEY = "jgoodies.isNarrow";

    public ButtonStackBuilder()
    {
        this(new JPanel(null));
    }

    public ButtonStackBuilder(JPanel panel)
    {
        this(new FormLayout(COL_SPECS, ROW_SPECS), panel);
    }

    public ButtonStackBuilder(FormLayout layout, JPanel panel)
    {
        super(layout, panel);
        setOpaque(false);
    }

    public void addButtons(JButton buttons[])
    {
        for(int i = 0; i < buttons.length; i++)
        {
            addGridded(buttons[i]);
            if(i < buttons.length - 1)
            {
                addRelatedGap();
            }
        }

    }

    public void addFixed(JComponent component)
    {
        getLayout().appendRow(FormFactory.PREF_ROWSPEC);
        add(component);
        nextRow();
    }

    public void addGridded(JComponent component)
    {
        getLayout().appendRow(FormFactory.PREF_ROWSPEC);
        getLayout().addGroupedRow(getRow());
        component.putClientProperty("jgoodies.isNarrow", Boolean.TRUE);
        add(component);
        nextRow();
    }

    public void addGlue()
    {
        appendGlueRow();
        nextRow();
    }

    public void addRelatedGap()
    {
        appendRelatedComponentsGapRow();
        nextRow();
    }

    public void addUnrelatedGap()
    {
        appendUnrelatedComponentsGapRow();
        nextRow();
    }

    public void addStrut(ConstantSize size)
    {
        getLayout().appendRow(new RowSpec(RowSpec.TOP, size, 0.0D));
        nextRow();
    }

    public void addButton(JButton button)
    {
        addButton(new JButton[] {
            button
        });
    }

    public void addButton(JButton button1, JButton button2)
    {
        addButton(new JButton[] {
            button1, button2
        });
    }

    public void addButton(JButton button1, JButton button2, JButton button3)
    {
        addButton(new JButton[] {
            button1, button2, button3
        });
    }

    public void addButton(JButton button1, JButton button2, JButton button3, JButton button4)
    {
        addButton(new JButton[] {
            button1, button2, button3, button4
        });
    }

    public void addButton(JButton buttons[])
    {
        addButtons(buttons);
    }

    public void addButton(Action action)
    {
        addButton(new Action[] {
            action
        });
    }

    public void addButton(Action action1, Action action2)
    {
        addButton(new Action[] {
            action1, action2
        });
    }

    public void addButton(Action action1, Action action2, Action action3)
    {
        addButton(new Action[] {
            action1, action2, action3
        });
    }

    public void addButton(Action action1, Action action2, Action action3, Action action4)
    {
        addButton(new Action[] {
            action1, action2, action3, action4
        });
    }

    public void addButton(Action actions[])
    {
        JButton buttons[] = new JButton[actions.length];
        for(int i = 0; i < actions.length; i++)
        {
            buttons[i] = new JButton(actions[i]);
        }

        addButtons(buttons);
    }

    static 
    {
        COL_SPECS = (new ColumnSpec[] {
            FormFactory.BUTTON_COLSPEC
        });
    }
}
