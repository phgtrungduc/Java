package com.jgoodies.forms.factories;

import javax.swing.JComponent;
import javax.swing.JLabel;

public interface ComponentFactory
{

    public abstract JLabel createLabel(String s);

    public abstract JLabel createTitle(String s);

    public abstract JComponent createSeparator(String s, int i);
}
