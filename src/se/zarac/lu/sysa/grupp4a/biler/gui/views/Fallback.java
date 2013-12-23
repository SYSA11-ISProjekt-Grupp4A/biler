package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Fallback extends View {
  protected Object object;
  
  public Fallback(Object object) {
    this.object = object;
    add(new JLabel("[No view for '" + object.toString() + "'.]")); } }