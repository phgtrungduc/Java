package com.jgoodies.forms.builder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.border.Border;

public abstract class AbstractButtonPanelBuilder
{

    protected static final String NARROW_KEY = "jgoodies.isNarrow";
    private final JPanel container;
    private final FormLayout layout;
    private final CellConstraints currentCellConstraints;
    private boolean leftToRight;

    protected AbstractButtonPanelBuilder(FormLayout layout, JPanel container)
    {
        if(layout == null)
        {
            throw new NullPointerException("The layout must not be null.");
        }
        if(container == null)
        {
            throw new NullPointerException("The layout container must not be null.");
        } else
        {
            this.container = container;
            this.layout = layout;
            container.setLayout(layout);
            setOpaque(false);
            currentCellConstraints = new CellConstraints();
            ComponentOrientation orientation = container.getComponentOrientation();
            leftToRight = orientation.isLeftToRight() || !orientation.isHorizontal();
            return;
        }
    }

    public final JPanel getContainer()
    {
        return container;
    }

    public final JPanel getPanel()
    {
        return getContainer();
    }

    public final FormLayout getLayout()
    {
        return layout;
    }

    public final void setBackground(Color background)
    {
        getPanel().setBackground(background);
    }

    public final void setBorder(Border border)
    {
        getPanel().setBorder(border);
    }

    public final void setOpaque(boolean b)
    {
        getPanel().setOpaque(b);
    }

    public final boolean isLeftToRight()
    {
        return leftToRight;
    }

    public final void setLeftToRight(boolean b)
    {
        leftToRight = b;
    }

    protected final void nextColumn()
    {
        nextColumn(1);
    }

    private void nextColumn(int columns)
    {
        currentCellConstraints.gridX += columns * getColumnIncrementSign();
    }

    protected int getColumn()
    {
        return currentCellConstraints.gridX;
    }

    protected final void nextRow()
    {
        nextRow(1);
    }

    private void nextRow(int rows)
    {
        currentCellConstraints.gridY += rows;
    }

    protected final void appendColumn(ColumnSpec columnSpec)
    {
        getLayout().appendColumn(columnSpec);
    }

    protected final void appendGlueColumn()
    {
        appendColumn(FormFactory.GLUE_COLSPEC);
    }

    protected final void appendRelatedComponentsGapColumn()
    {
        appendColumn(FormFactory.RELATED_GAP_COLSPEC);
    }

    protected final void appendUnrelatedComponentsGapColumn()
    {
        appendColumn(FormFactory.UNRELATED_GAP_COLSPEC);
    }

    protected final void appendRow(RowSpec rowSpec)
    {
        getLayout().appendRow(rowSpec);
    }

    protected final void appendGlueRow()
    {
        appendRow(FormFactory.GLUE_ROWSPEC);
    }

    protected final void appendRelatedComponentsGapRow()
    {
        appendRow(FormFactory.RELATED_GAP_ROWSPEC);
    }

    protected final void appendUnrelatedComponentsGapRow()
    {
        appendRow(FormFactory.UNRELATED_GAP_ROWSPEC);
    }

    protected final Component add(Component component)
    {
        container.add(component, currentCellConstraints);
        return component;
    }

    private int getColumnIncrementSign()
    {
        return isLeftToRight() ? 1 : -1;
    }
}
