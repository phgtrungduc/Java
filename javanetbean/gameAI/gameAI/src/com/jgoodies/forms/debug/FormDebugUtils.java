package com.jgoodies.forms.debug;

import com.jgoodies.forms.layout.*;
import java.awt.Component;
import java.awt.Container;
import java.io.PrintStream;
import javax.swing.JLabel;

public final class FormDebugUtils
{

    private FormDebugUtils()
    {
    }

    public static void dumpAll(Container container)
    {
        if(!(container.getLayout() instanceof FormLayout))
        {
            System.out.println("The container's layout is not a FormLayout.");
            return;
        } else
        {
            FormLayout layout = (FormLayout)container.getLayout();
            dumpColumnSpecs(layout);
            dumpRowSpecs(layout);
            System.out.println();
            dumpColumnGroups(layout);
            dumpRowGroups(layout);
            System.out.println();
            dumpConstraints(container);
            dumpGridBounds(container);
            return;
        }
    }

    public static void dumpColumnSpecs(FormLayout layout)
    {
        System.out.print("COLUMN SPECS:");
        for(int col = 1; col <= layout.getColumnCount(); col++)
        {
            ColumnSpec colSpec = layout.getColumnSpec(col);
            System.out.print(colSpec.toShortString());
            if(col < layout.getColumnCount())
            {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    public static void dumpRowSpecs(FormLayout layout)
    {
        System.out.print("ROW SPECS:   ");
        for(int row = 1; row <= layout.getRowCount(); row++)
        {
            RowSpec rowSpec = layout.getRowSpec(row);
            System.out.print(rowSpec.toShortString());
            if(row < layout.getRowCount())
            {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    public static void dumpColumnGroups(FormLayout layout)
    {
        dumpGroups("COLUMN GROUPS: ", layout.getColumnGroups());
    }

    public static void dumpRowGroups(FormLayout layout)
    {
        dumpGroups("ROW GROUPS:    ", layout.getRowGroups());
    }

    public static void dumpGridBounds(Container container)
    {
        System.out.println("GRID BOUNDS");
        dumpGridBounds(getLayoutInfo(container));
    }

    public static void dumpGridBounds(com.jgoodies.forms.layout.FormLayout.LayoutInfo layoutInfo)
    {
        System.out.print("COLUMN ORIGINS: ");
        for(int col = 0; col < layoutInfo.columnOrigins.length; col++)
        {
            System.out.print(layoutInfo.columnOrigins[col] + " ");
        }

        System.out.println();
        System.out.print("ROW ORIGINS:    ");
        for(int row = 0; row < layoutInfo.rowOrigins.length; row++)
        {
            System.out.print(layoutInfo.rowOrigins[row] + " ");
        }

        System.out.println();
    }

    public static void dumpConstraints(Container container)
    {
        System.out.println("COMPONENT CONSTRAINTS");
        if(!(container.getLayout() instanceof FormLayout))
        {
            System.out.println("The container's layout is not a FormLayout.");
            return;
        }
        FormLayout layout = (FormLayout)container.getLayout();
        int childCount = container.getComponentCount();
        for(int i = 0; i < childCount; i++)
        {
            Component child = container.getComponent(i);
            CellConstraints cc = layout.getConstraints(child);
            String ccString = cc != null ? cc.toShortString(layout) : "no constraints";
            System.out.print(ccString);
            System.out.print("; ");
            String childType = child.getClass().getName();
            System.out.print(childType);
            if(child instanceof JLabel)
            {
                JLabel label = (JLabel)child;
                System.out.print("      \"" + label.getText() + "\"");
            }
            if(child.getName() != null)
            {
                System.out.print("; name=");
                System.out.print(child.getName());
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void dumpGroups(String title, int allGroups[][])
    {
        System.out.print(title + " {");
        for(int group = 0; group < allGroups.length; group++)
        {
            int groupIndices[] = allGroups[group];
            System.out.print(" {");
            for(int i = 0; i < groupIndices.length; i++)
            {
                System.out.print(groupIndices[i]);
                if(i < groupIndices.length - 1)
                {
                    System.out.print(", ");
                }
            }

            System.out.print("} ");
            if(group < allGroups.length - 1)
            {
                System.out.print(", ");
            }
        }

        System.out.println("}");
    }

    public static com.jgoodies.forms.layout.FormLayout.LayoutInfo getLayoutInfo(Container container)
    {
        if(!(container.getLayout() instanceof FormLayout))
        {
            throw new IllegalArgumentException("The container must use an instance of FormLayout.");
        } else
        {
            FormLayout layout = (FormLayout)container.getLayout();
            return layout.getLayoutInfo(container);
        }
    }
}
