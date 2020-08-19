package com.jgoodies.forms.layout;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.util.LayoutStyle;
import java.util.*;

// Referenced classes of package com.jgoodies.forms.layout:
//            ColumnSpec, FormSpecParser, RowSpec, Size

public final class LayoutMap
{

    private static final char VARIABLE_PREFIX_CHAR = 36;
    private static final Map COLUMN_ALIASES = new HashMap();
    private static final Map ROW_ALIASES = new HashMap();
    private static LayoutMap root = null;
    private final LayoutMap parent;
    private final Map columnMap;
    private final Map columnMapCache;
    private final Map rowMap;
    private final Map rowMapCache;

    public LayoutMap()
    {
        this(getRoot());
    }

    public LayoutMap(LayoutMap parent)
    {
        this.parent = parent;
        columnMap = new HashMap();
        rowMap = new HashMap();
        columnMapCache = new HashMap();
        rowMapCache = new HashMap();
    }

    public static LayoutMap getRoot()
    {
        if(root == null)
        {
            root = createRoot();
        }
        return root;
    }

    public boolean columnContainsKey(String key)
    {
        String resolvedKey = resolveColumnKey(key);
        return columnMap.containsKey(resolvedKey) || parent != null && parent.columnContainsKey(resolvedKey);
    }

    public String columnGet(String key)
    {
        String resolvedKey = resolveColumnKey(key);
        String cachedValue = (String)columnMapCache.get(resolvedKey);
        if(cachedValue != null)
        {
            return cachedValue;
        }
        String value = (String)columnMap.get(resolvedKey);
        if(value == null && parent != null)
        {
            value = parent.columnGet(resolvedKey);
        }
        if(value == null)
        {
            return null;
        } else
        {
            String expandedString = expand(value, true);
            columnMapCache.put(resolvedKey, expandedString);
            return expandedString;
        }
    }

    public String columnPut(String key, String value)
    {
        String resolvedKey = resolveColumnKey(key);
        if(value == null)
        {
            throw new NullPointerException("The column expression value must not be null.");
        } else
        {
            columnMapCache.clear();
            return (String)columnMap.put(resolvedKey, value.toLowerCase(Locale.ENGLISH));
        }
    }

    public String columnPut(String key, ColumnSpec value)
    {
        return columnPut(key, value.encode());
    }

    public String columnPut(String key, Size value)
    {
        return columnPut(key, value.encode());
    }

    public String columnRemove(String key)
    {
        String resolvedKey = resolveColumnKey(key);
        columnMapCache.clear();
        return (String)columnMap.remove(resolvedKey);
    }

    public boolean rowContainsKey(String key)
    {
        String resolvedKey = resolveRowKey(key);
        return rowMap.containsKey(resolvedKey) || parent != null && parent.rowContainsKey(resolvedKey);
    }

    public String rowGet(String key)
    {
        String resolvedKey = resolveRowKey(key);
        String cachedValue = (String)rowMapCache.get(resolvedKey);
        if(cachedValue != null)
        {
            return cachedValue;
        }
        String value = (String)rowMap.get(resolvedKey);
        if(value == null && parent != null)
        {
            value = parent.rowGet(resolvedKey);
        }
        if(value == null)
        {
            return null;
        } else
        {
            String expandedString = expand(value, false);
            rowMapCache.put(resolvedKey, expandedString);
            return expandedString;
        }
    }

    public String rowPut(String key, String value)
    {
        String resolvedKey = resolveRowKey(key);
        if(value == null)
        {
            throw new NullPointerException("The row expression value must not be null.");
        } else
        {
            rowMapCache.clear();
            return (String)rowMap.put(resolvedKey, value.toLowerCase(Locale.ENGLISH));
        }
    }

    public String rowPut(String key, RowSpec value)
    {
        return rowPut(key, value.encode());
    }

    public String rowPut(String key, Size value)
    {
        return rowPut(key, value.encode());
    }

    public String rowRemove(String key)
    {
        String resolvedKey = resolveRowKey(key);
        rowMapCache.clear();
        return (String)rowMap.remove(resolvedKey);
    }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer(super.toString());
        buffer.append("\n  Column associations:");
        java.util.Map.Entry name;
        for(Iterator iterator = columnMap.entrySet().iterator(); iterator.hasNext(); buffer.append(name.getValue()))
        {
            name = (java.util.Map.Entry)iterator.next();
            buffer.append("\n    ");
            buffer.append(name.getKey());
            buffer.append("->");
        }

        buffer.append("\n  Row associations:");
        for(Iterator iterator = rowMap.entrySet().iterator(); iterator.hasNext(); buffer.append(name.getValue()))
        {
            name = (java.util.Map.Entry)iterator.next();
            buffer.append("\n    ");
            buffer.append(name.getKey());
            buffer.append("->");
        }

        return buffer.toString();
    }

    String expand(String expression, boolean horizontal)
    {
        int cursor = 0;
        int start = expression.indexOf('$', cursor);
        if(start == -1)
        {
            return expression;
        }
        StringBuffer buffer = new StringBuffer();
        do
        {
            buffer.append(expression.substring(cursor, start));
            String variableName = nextVariableName(expression, start);
            buffer.append(expansion(variableName, horizontal));
            cursor = start + variableName.length() + 1;
            start = expression.indexOf('$', cursor);
        } while(start != -1);
        buffer.append(expression.substring(cursor));
        return buffer.toString();
    }

    private String nextVariableName(String expression, int start)
    {
        int length = expression.length();
        if(length <= start)
        {
            FormSpecParser.fail(expression, start, "Missing variable name after variable char '$'.");
        }
        int end;
        if(expression.charAt(start + 1) == '{')
        {
            end = expression.indexOf('}', start + 1);
            if(end == -1)
            {
                FormSpecParser.fail(expression, start, "Missing closing brace '}' for variable.");
            }
            return expression.substring(start + 1, end + 1);
        }
        for(end = start + 1; end < length && Character.isUnicodeIdentifierPart(expression.charAt(end)); end++) { }
        return expression.substring(start + 1, end);
    }

    private String expansion(String variableName, boolean horizontal)
    {
        String key = stripBraces(variableName);
        String expansion = horizontal ? columnGet(key) : rowGet(key);
        if(expansion == null)
        {
            String orientation = horizontal ? "column" : "row";
            throw new IllegalArgumentException("Unknown " + orientation + " layout variable \"" + key + "\"");
        } else
        {
            return expansion;
        }
    }

    private static String stripBraces(String variableName)
    {
        return variableName.charAt(0) != '{' ? variableName : variableName.substring(1, variableName.length() - 1);
    }

    private String resolveColumnKey(String key)
    {
        if(key == null)
        {
            throw new NullPointerException("The key must not be null.");
        } else
        {
            String lowercaseKey = key.toLowerCase(Locale.ENGLISH);
            String defaultKey = (String)COLUMN_ALIASES.get(lowercaseKey);
            return defaultKey != null ? defaultKey : lowercaseKey;
        }
    }

    private String resolveRowKey(String key)
    {
        if(key == null)
        {
            throw new NullPointerException("The key must not be null.");
        } else
        {
            String lowercaseKey = key.toLowerCase(Locale.ENGLISH);
            String defaultKey = (String)ROW_ALIASES.get(lowercaseKey);
            return defaultKey != null ? defaultKey : lowercaseKey;
        }
    }

    private static LayoutMap createRoot()
    {
        LayoutMap map = new LayoutMap(null);
        map.columnPut("label-component-gap", new String[] {
            "lcg", "lcgap"
        }, FormFactory.LABEL_COMPONENT_GAP_COLSPEC);
        map.columnPut("related-gap", new String[] {
            "rg", "rgap"
        }, FormFactory.RELATED_GAP_COLSPEC);
        map.columnPut("unrelated-gap", new String[] {
            "ug", "ugap"
        }, FormFactory.UNRELATED_GAP_COLSPEC);
        map.columnPut("button", new String[] {
            "b"
        }, FormFactory.BUTTON_COLSPEC);
        map.columnPut("growing-button", new String[] {
            "gb"
        }, FormFactory.GROWING_BUTTON_COLSPEC);
        map.columnPut("dialog-margin", new String[] {
            "dm", "dmargin"
        }, ColumnSpec.createGap(LayoutStyle.getCurrent().getDialogMarginX()));
        map.columnPut("tabbed-dialog-margin", new String[] {
            "tdm", "tdmargin"
        }, ColumnSpec.createGap(LayoutStyle.getCurrent().getTabbedDialogMarginX()));
        map.columnPut("glue", FormFactory.GLUE_COLSPEC.toShortString());
        map.rowPut("related-gap", new String[] {
            "rg", "rgap"
        }, FormFactory.RELATED_GAP_ROWSPEC);
        map.rowPut("unrelated-gap", new String[] {
            "ug", "ugap"
        }, FormFactory.UNRELATED_GAP_ROWSPEC);
        map.rowPut("narrow-line-gap", new String[] {
            "nlg", "nlgap"
        }, FormFactory.NARROW_LINE_GAP_ROWSPEC);
        map.rowPut("line-gap", new String[] {
            "lg", "lgap"
        }, FormFactory.LINE_GAP_ROWSPEC);
        map.rowPut("paragraph-gap", new String[] {
            "pg", "pgap"
        }, FormFactory.PARAGRAPH_GAP_ROWSPEC);
        map.rowPut("dialog-margin", new String[] {
            "dm", "dmargin"
        }, RowSpec.createGap(LayoutStyle.getCurrent().getDialogMarginY()));
        map.rowPut("tabbed-dialog-margin", new String[] {
            "tdm", "tdmargin"
        }, RowSpec.createGap(LayoutStyle.getCurrent().getTabbedDialogMarginY()));
        map.rowPut("button", new String[] {
            "b"
        }, FormFactory.BUTTON_ROWSPEC);
        map.rowPut("glue", FormFactory.GLUE_ROWSPEC);
        return map;
    }

    private void columnPut(String key, String aliases[], ColumnSpec value)
    {
        ensureLowerCase(key);
        columnPut(key, value);
        for(int i = 0; i < aliases.length; i++)
        {
            ensureLowerCase(aliases[i]);
            COLUMN_ALIASES.put(aliases[i], key);
        }

    }

    private void rowPut(String key, String aliases[], RowSpec value)
    {
        ensureLowerCase(key);
        rowPut(key, value);
        for(int i = 0; i < aliases.length; i++)
        {
            ensureLowerCase(aliases[i]);
            ROW_ALIASES.put(aliases[i], key);
        }

    }

    private void ensureLowerCase(String str)
    {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if(!lowerCase.equals(str))
        {
            throw new IllegalArgumentException("The string \"" + str + "\" should be lower case.");
        } else
        {
            return;
        }
    }

}
