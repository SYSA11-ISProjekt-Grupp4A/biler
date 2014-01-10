package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Fallback extends View {
  protected Object object;
  
  public Fallback(Object object, GUI gui) {
    super(gui);
    this.object = object;
    if (object == null)
      add(new JLabel("[Fallback View for null!]"));
    else
      add(new JLabel("[Fallback View for '" + object.toString() + "'.]")); } }