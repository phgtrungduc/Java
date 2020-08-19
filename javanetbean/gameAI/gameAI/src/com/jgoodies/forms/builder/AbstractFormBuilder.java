package com.jgoodies.forms.builder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.*;
import java.awt.*;

public abstract class AbstractFormBuilder
{

    private final Container container;
    private final FormLayout layout;
    private final CellConstraints currentCellConstraints;
    private boolean leftToRight;

    public AbstractFormBuilder(FormLayout layout, Container container)
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
            currentCellConstraints = new CellConstraints();
            ComponentOrientation orientation = container.getComponentOrientation();
            leftToRight = orientation.isLeftToRight() || !orientation.isHorizontal();
            return;
        }
    }

    public final Container getContainer()
    {
        return container;
    }

    public final FormLayout getLayout()
    {
        return layout;
    }

    public final int getColumnCount()
    {
        return getLayout().getColumnCount();
    }

    public final int getRowCount()
    {
        return getLayout().getRowCount();
    }

    public final boolean isLeftToRight()
    {
        return leftToRight;
    }

    public final void setLeftToRight(boolean b)
    {
        leftToRight = b;
    }

    public final int getColumn()
    {
        return currentCellConstraints.gridX;
    }

    public final void setColumn(int column)
    {
        currentCellConstraints.gridX = column;
    }

    public final int getRow()
    {
        return currentCellConstraints.gridY;
    }

    public final void setRow(int row)
    {
        currentCellConstraints.gridY = row;
    }

    public final void setColumnSpan(int columnSpan)
    {
        currentCellConstraints.gridWidth = columnSpan;
    }

    public final void setRowSpan(int rowSpan)
    {
        currentCellConstraints.gridHeight = rowSpan;
    }

    public final void setOrigin(int column, int row)
    {
        setColumn(column);
        setRow(row);
    }

    public final void setExtent(int columnSpan, int rowSpan)
    {
        setColumnSpan(columnSpan);
        setRowSpan(rowSpan);
    }

    public final void setBounds(int column, int row, int columnSpan, int rowSpan)
    {
        setColumn(column);
        setRow(row);
        setColumnSpan(columnSpan);
        setRowSpan(rowSpan);
    }

    public final void nextColumn()
    {
        nextColumn(1);
    }

    public final void nextColumn(int columns)
    {
        currentCellConstraints.gridX += columns * getColumnIncrementSign();
    }

    public final void nextRow()
    {
        nextRow(1);
    }

    public final void nextRow(int rows)
    {
        currentCellConstraints.gridY += rows;
    }

    public final void nextLine()
    {
        nextLine(1);
    }

    public final void nextLine(int lines)
    {
        nextRow(lines);
        setColumn(getLeadingColumn());
    }

    public final void setHAlignment(com.jgoodies.forms.layout.CellConstraints.Alignment alignment)
    {
        currentCellConstraints.hAlign = alignment;
    }

    public final void setVAlignment(com.jgoodies.forms.layout.CellConstraints.Alignment alignment)
    {
        currentCellConstraints.vAlign = alignment;
    }

    public final void setAlignment(com.jgoodies.forms.layout.CellConstraints.Alignment hAlign, com.jgoodies.forms.layout.CellConstraints.Alignment vAlign)
    {
        setHAlignment(hAlign);
        setVAlignment(vAlign);
    }

    public final void appendColumn(ColumnSpec columnSpec)
    {
        getLayout().appendColumn(columnSpec);
    }

    public final void appendColumn(String encodedColumnSpec)
    {
        appendColumn(ColumnSpec.decode(encodedColumnSpec));
    }

    public final void appendGlueColumn()
    {
        appendColumn(FormFactory.GLUE_COLSPEC);
    }

    public final void appendLabelComponentsGapColumn()
    {
        appendColumn(FormFactory.LABEL_COMPONENT_GAP_COLSPEC);
    }

    public final void appendRelatedComponentsGapColumn()
    {
        appendColumn(FormFactory.RELATED_GAP_COLSPEC);
    }

    public final void appendUnrelatedComponentsGapColumn()
    {
        appendColumn(FormFactory.UNRELATED_GAP_COLSPEC);
    }

    public final void appendRow(RowSpec rowSpec)
    {
        getLayout().appendRow(rowSpec);
    }

    public final void appendRow(String encodedRowSpec)
    {
        appendRow(RowSpec.decode(encodedRowSpec));
    }

    public final void appendGlueRow()
    {
        appendRow(FormFactory.GLUE_ROWSPEC);
    }

    public final void appendRelatedComponentsGapRow()
    {
        appendRow(FormFactory.RELATED_GAP_ROWSPEC);
    }

    public final void appendUnrelatedComponentsGapRow()
    {
        appendRow(FormFactory.UNRELATED_GAP_ROWSPEC);
    }

    public final void appendParagraphGapRow()
    {
        appendRow(FormFactory.PARAGRAPH_GAP_ROWSPEC);
    }

    public Component add(Component component, CellConstraints cellConstraints)
    {
        container.add(component, cellConstraints);
        return component;
    }

    public final Component add(Component component, String encodedCellConstraints)
    {
        container.add(component, new CellConstraints(encodedCellConstraints));
        return component;
    }

    public final Component add(Component component)
    {
        add(component, currentCellConstraints);
        return component;
    }

    protected final CellConstraints cellConstraints()
    {
        return currentCellConstraints;
    }

    protected int getLeadingColumn()
    {
        return isLeftToRight() ? 1 : getColumnCount();
    }

    protected final int getColumnIncrementSign()
    {
        return isLeftToRight() ? 1 : -1;
    }

    protected final CellConstraints createLeftAdjustedConstraints(int columnSpan)
    {
        int firstColumn = isLeftToRight() ? getColumn() : (getColumn() + 1) - columnSpan;
        return new CellConstraints(firstColumn, getRow(), columnSpan, cellConstraints().gridHeight);
    }
}
