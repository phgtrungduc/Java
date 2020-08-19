package com.jgoodies.forms.layout;

import java.awt.Component;
import java.awt.Container;
import java.io.Serializable;

// Referenced classes of package com.jgoodies.forms.layout:
//            FormLayout, Size, Sizes

public final class ConstantSize
    implements Size, Serializable
{
    public static final class Unit
        implements Serializable
    {

        private final transient String name;
        private final transient String abbreviation;
        private final transient String parseAbbreviation;
        final transient boolean requiresIntegers;
        private static int nextOrdinal = 0;
        private final int ordinal;

        static Unit valueOf(String name, boolean horizontal)
        {
            if(name.length() == 0)
            {
                Unit defaultUnit = Sizes.getDefaultUnit();
                if(defaultUnit != null)
                {
                    return defaultUnit;
                } else
                {
                    return horizontal ? ConstantSize.DIALOG_UNITS_X : ConstantSize.DIALOG_UNITS_Y;
                }
            }
            if(name.equals("px"))
            {
                return ConstantSize.PIXEL;
            }
            if(name.equals("dlu"))
            {
                return horizontal ? ConstantSize.DIALOG_UNITS_X : ConstantSize.DIALOG_UNITS_Y;
            }
            if(name.equals("pt"))
            {
                return ConstantSize.POINT;
            }
            if(name.equals("in"))
            {
                return ConstantSize.INCH;
            }
            if(name.equals("mm"))
            {
                return ConstantSize.MILLIMETER;
            }
            if(name.equals("cm"))
            {
                return ConstantSize.CENTIMETER;
            } else
            {
                throw new IllegalArgumentException("Invalid unit name '" + name + "'. Must be one of: " + "px, dlu, pt, mm, cm, in");
            }
        }

        public String toString()
        {
            return name;
        }

        public String encode()
        {
            return parseAbbreviation == null ? abbreviation : parseAbbreviation;
        }

        public String abbreviation()
        {
            return abbreviation;
        }

        private Object readResolve()
        {
            return ConstantSize.VALUES[ordinal];
        }


        private Unit(String name, String abbreviation, String parseAbbreviation, boolean requiresIntegers)
        {
            ordinal = nextOrdinal++;
            this.name = name;
            this.abbreviation = abbreviation;
            this.parseAbbreviation = parseAbbreviation;
            this.requiresIntegers = requiresIntegers;
        }

    }


    public static final Unit PIXEL;
    public static final Unit POINT;
    public static final Unit DIALOG_UNITS_X;
    public static final Unit DIALOG_UNITS_Y;
    public static final Unit MILLIMETER;
    public static final Unit CENTIMETER;
    public static final Unit INCH;
    public static final Unit PX;
    public static final Unit PT;
    public static final Unit DLUX;
    public static final Unit DLUY;
    public static final Unit MM;
    public static final Unit CM;
    public static final Unit IN;
    private static final Unit VALUES[];
    private final double value;
    private final Unit unit;

    public ConstantSize(int value, Unit unit)
    {
        this.value = value;
        this.unit = unit;
    }

    public ConstantSize(double value, Unit unit)
    {
        this.value = value;
        this.unit = unit;
    }

    static ConstantSize valueOf(String encodedValueAndUnit, boolean horizontal)
    {
        String split[] = splitValueAndUnit(encodedValueAndUnit);
        String encodedValue = split[0];
        String encodedUnit = split[1];
        Unit unit = Unit.valueOf(encodedUnit, horizontal);
        double value = Double.parseDouble(encodedValue);
        if(unit.requiresIntegers && value != (double)(int)value)
        {
            throw new IllegalArgumentException(unit.toString() + " value " + encodedValue + " must be an integer.");
        } else
        {
            return new ConstantSize(value, unit);
        }
    }

    static ConstantSize dluX(int value)
    {
        return new ConstantSize(value, DLUX);
    }

    static ConstantSize dluY(int value)
    {
        return new ConstantSize(value, DLUY);
    }

    public double getValue()
    {
        return value;
    }

    public Unit getUnit()
    {
        return unit;
    }

    public int getPixelSize(Component component)
    {
        if(unit == PIXEL)
        {
            return intValue();
        }
        if(unit == POINT)
        {
            return Sizes.pointAsPixel(intValue(), component);
        }
        if(unit == INCH)
        {
            return Sizes.inchAsPixel(value, component);
        }
        if(unit == MILLIMETER)
        {
            return Sizes.millimeterAsPixel(value, component);
        }
        if(unit == CENTIMETER)
        {
            return Sizes.centimeterAsPixel(value, component);
        }
        if(unit == DIALOG_UNITS_X)
        {
            return Sizes.dialogUnitXAsPixel(intValue(), component);
        }
        if(unit == DIALOG_UNITS_Y)
        {
            return Sizes.dialogUnitYAsPixel(intValue(), component);
        } else
        {
            throw new IllegalStateException("Invalid unit " + unit);
        }
    }

    public int maximumSize(Container container, java.util.List components, FormLayout.Measure minMeasure, FormLayout.Measure prefMeasure, FormLayout.Measure defaultMeasure)
    {
        return getPixelSize(container);
    }

    public boolean compressible()
    {
        return false;
    }

    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof ConstantSize))
        {
            return false;
        } else
        {
            ConstantSize size = (ConstantSize)o;
            return value == size.value && unit == size.unit;
        }
    }

    public int hashCode()
    {
        return (new Double(value)).hashCode() + 37 * unit.hashCode();
    }

    public String toString()
    {
        return value != (double)intValue() ? Double.toString(value) + unit.abbreviation() : Integer.toString(intValue()) + unit.abbreviation();
    }

    public String encode()
    {
        return value != (double)intValue() ? Double.toString(value) + unit.encode() : Integer.toString(intValue()) + unit.encode();
    }

    private int intValue()
    {
        return (int)Math.round(value);
    }

    private static String[] splitValueAndUnit(String encodedValueAndUnit)
    {
        String result[] = new String[2];
        int len = encodedValueAndUnit.length();
        int firstLetterIndex;
        for(firstLetterIndex = len; firstLetterIndex > 0 && Character.isLetter(encodedValueAndUnit.charAt(firstLetterIndex - 1)); firstLetterIndex--) { }
        result[0] = encodedValueAndUnit.substring(0, firstLetterIndex);
        result[1] = encodedValueAndUnit.substring(firstLetterIndex);
        return result;
    }

    static 
    {
        PIXEL = new Unit("Pixel", "px", null, true);
        POINT = new Unit("Point", "pt", null, true);
        DIALOG_UNITS_X = new Unit("Dialog units X", "dluX", "dlu", true);
        DIALOG_UNITS_Y = new Unit("Dialog units Y", "dluY", "dlu", true);
        MILLIMETER = new Unit("Millimeter", "mm", null, false);
        CENTIMETER = new Unit("Centimeter", "cm", null, false);
        INCH = new Unit("Inch", "in", null, false);
        PX = PIXEL;
        PT = POINT;
        DLUX = DIALOG_UNITS_X;
        DLUY = DIALOG_UNITS_Y;
        MM = MILLIMETER;
        CM = CENTIMETER;
        IN = INCH;
        VALUES = (new Unit[] {
            PIXEL, POINT, DIALOG_UNITS_X, DIALOG_UNITS_Y, MILLIMETER, CENTIMETER, INCH
        });
    }

}
