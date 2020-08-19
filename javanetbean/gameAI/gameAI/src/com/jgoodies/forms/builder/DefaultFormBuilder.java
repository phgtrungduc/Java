package com.jgoodies.forms.builder;

import com.jgoodies.forms.factories.ComponentFactory;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.*;
import java.awt.Component;
import java.util.ResourceBundle;
import javax.swing.*;

// Referenced classes of package com.jgoodies.forms.builder:
//            I15dPanelBuilder

public final class DefaultFormBuilder extends I15dPanelBuilder
{

    private RowSpec defaultRowSpec;
    private RowSpec lineGapSpec;
    private RowSpec paragraphGapSpec;
    private int leadingColumnOffset;
    private boolean rowGroupingEnabled;

    public DefaultFormBuilder(FormLayout layout)
    {
        this(layout, new JPanel(null));
    }

    public DefaultFormBuilder(FormLayout layout, JPanel panel)
    {
        this(layout, null, panel);
    }

    public DefaultFormBuilder(FormLayout layout, ResourceBundle bundle)
    {
        this(layout, bundle, new JPanel(null));
    }

    public DefaultFormBuilder(FormLayout layout, ResourceBundle bundle, JPanel panel)
    {
        super(layout, bundle, panel);
        defaultRowSpec = FormFactory.PREF_ROWSPEC;
        lineGapSpec = FormFactory.LINE_GAP_ROWSPEC;
        paragraphGapSpec = FormFactory.PARAGRAPH_GAP_ROWSPEC;
        leadingColumnOffset = 0;
        rowGroupingEnabled = false;
    }

    public RowSpec getDefaultRowSpec()
    {
        return defaultRowSpec;
    }

    public void setDefaultRowSpec(RowSpec defaultRowSpec)
    {
        this.defaultRowSpec = defaultRowSpec;
    }

    public RowSpec getLineGapSpec()
    {
        return lineGapSpec;
    }

    public void setLineGapSize(ConstantSize lineGapSize)
    {
        RowSpec rowSpec = RowSpec.createGap(lineGapSize);
        lineGapSpec = rowSpec;
    }

    public void setParagraphGapSize(ConstantSize paragraphGapSize)
    {
        RowSpec rowSpec = RowSpec.createGap(paragraphGapSize);
        paragraphGapSpec = rowSpec;
    }

    public int getLeadingColumnOffset()
    {
        return leadingColumnOffset;
    }

    public void setLeadingColumnOffset(int columnOffset)
    {
        leadingColumnOffset = columnOffset;
    }

    public boolean isRowGroupingEnabled()
    {
        return rowGroupingEnabled;
    }

    public void setRowGroupingEnabled(boolean enabled)
    {
        rowGroupingEnabled = enabled;
    }

    public void append(Component component)
    {
        append(component, 1);
    }

    public void append(Component component, int columnSpan)
    {
        ensureCursorColumnInGrid();
        ensureHasGapRow(lineGapSpec);
        ensureHasComponentLine();
        add(component, createLeftAdjustedConstraints(columnSpan));
        nextColumn(columnSpan + 1);
    }

    public void append(Component c1, Component c2)
    {
        append(c1);
        append(c2);
    }

    public void append(Component c1, Component c2, Component c3)
    {
        append(c1);
        append(c2);
        append(c3);
    }

    public JLabel append(String textWithMnemonic)
    {
        JLabel label = getComponentFactory().createLabel(textWithMnemonic);
        append(((Component) (label)));
        return label;
    }

    public JLabel append(String textWithMnemonic, Component component)
    {
        return append(textWithMnemonic, component, 1);
    }

    public JLabel append(String textWithMnemonic, Component c, boolean nextLine)
    {
        JLabel label = append(textWithMnemonic, c);
        if(nextLine)
        {
            nextLine();
        }
        return label;
    }

    public JLabel append(String textWithMnemonic, Component c, int columnSpan)
    {
        JLabel label = append(textWithMnemonic);
        label.setLabelFor(c);
        append(c, columnSpan);
        return label;
    }

    public JLabel append(String textWithMnemonic, Component c1, Component c2)
    {
        JLabel label = append(textWithMnemonic, c1);
        append(c2);
        return label;
    }

    public JLabel append(String textWithMnemonic, Component c1, Component c2, int colSpan)
    {
        JLabel label = append(textWithMnemonic, c1);
        append(c2, colSpan);
        return label;
    }

    public JLabel append(String textWithMnemonic, Component c1, Component c2, Component c3)
    {
        JLabel label = append(textWithMnemonic, c1, c2);
        append(c3);
        return label;
    }

    public JLabel append(String textWithMnemonic, Component c1, Component c2, Component c3, Component c4)
    {
        JLabel label = append(textWithMnemonic, c1, c2, c3);
        append(c4);
        return label;
    }

    public JLabel appendI15d(String resourceKey)
    {
        return append(getI15dString(resourceKey));
    }

    public JLabel appendI15d(String resourceKey, Component component)
    {
        return append(getI15dString(resourceKey), component, 1);
    }

    public JLabel appendI15d(String resourceKey, Component component, boolean nextLine)
    {
        return append(getI15dString(resourceKey), component, nextLine);
    }

    public JLabel appendI15d(String resourceKey, Component c, int columnSpan)
    {
        return append(getI15dString(resourceKey), c, columnSpan);
    }

    public JLabel appendI15d(String resourceKey, Component c1, Component c2)
    {
        return append(getI15dString(resourceKey), c1, c2);
    }

    public JLabel appendI15d(String resourceKey, Component c1, Component c2, int colSpan)
    {
        return append(getI15dString(resourceKey), c1, c2, colSpan);
    }

    public JLabel appendI15d(String resourceKey, Component c1, Component c2, Component c3)
    {
        return append(getI15dString(resourceKey), c1, c2, c3);
    }

    public JLabel appendI15d(String resourceKey, Component c1, Component c2, Component c3, Component c4)
    {
        return append(getI15dString(resourceKey), c1, c2, c3, c4);
    }

    public JLabel appendTitle(String textWithMnemonic)
    {
        JLabel titleLabel = getComponentFactory().createTitle(textWithMnemonic);
        append(titleLabel);
        return titleLabel;
    }

    public JLabel appendI15dTitle(String resourceKey)
    {
        return appendTitle(getI15dString(resourceKey));
    }

    public JComponent appendSeparator()
    {
        return appendSeparator("");
    }

    public JComponent appendSeparator(String text)
    {
        ensureCursorColumnInGrid();
        ensureHasGapRow(paragraphGapSpec);
        ensureHasComponentLine();
        setColumn(super.getLeadingColumn());
        int columnSpan = getColumnCount();
        setColumnSpan(getColumnCount());
        JComponent titledSeparator = addSeparator(text);
        setColumnSpan(1);
        nextColumn(columnSpan);
        return titledSeparator;
    }

    public JComponent appendI15dSeparator(String resourceKey)
    {
        return appendSeparator(getI15dString(resourceKey));
    }

    protected int getLeadingColumn()
    {
        int column = super.getLeadingColumn();
        return column + getLeadingColumnOffset() * getColumnIncrementSign();
    }

    private void ensureCursorColumnInGrid()
    {
        if(isLeftToRight() && getColumn() > getColumnCount() || !isLeftToRight() && getColumn() < 1)
        {
            nextLine();
        }
    }

    private void ensureHasGapRow(RowSpec gapRowSpec)
    {
        if(getRow() == 1 || getRow() <= getRowCount())
        {
            return;
        }
        if(getRow() <= getRowCount())
        {
            RowSpec rowSpec = getCursorRowSpec();
            if(rowSpec == gapRowSpec)
            {
                return;
            }
        }
        appendRow(gapRowSpec);
        nextLine();
    }

    private void ensureHasComponentLine()
    {
        if(getRow() <= getRowCount())
        {
            return;
        }
        appendRow(getDefaultRowSpec());
        if(isRowGroupingEnabled())
        {
            getLayout().addGroupedRow(getRow());
        }
    }

    private RowSpec getCursorRowSpec()
    {
        return getLayout().getRowSpec(getRow());
    }
}
