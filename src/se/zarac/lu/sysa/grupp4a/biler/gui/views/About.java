package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class About extends View {
  
  public About(GUI gui) {
    super(gui);
    add(new JLabel("Version: "+ gui.getBiler().getName())); } }