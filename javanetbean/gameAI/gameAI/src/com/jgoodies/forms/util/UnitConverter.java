package com.jgoodies.forms.util;

import java.awt.Component;

public interface UnitConverter
{

    public abstract int inchAsPixel(double d, Component component);

    public abstract int millimeterAsPixel(double d, Component component);

    public abstract int centimeterAsPixel(double d, Component component);

    public abstract int pointAsPixel(int i, Component component);

    public abstract int dialogUnitXAsPixel(int i, Component component);

    public abstract int dialogUnitYAsPixel(int i, Component component);
}
