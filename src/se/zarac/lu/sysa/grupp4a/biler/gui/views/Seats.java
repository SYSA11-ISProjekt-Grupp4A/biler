package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import se.zarac.lu.sysa.grupp4a.biler.Filter;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;

@SuppressWarnings("serial")
public class Seats extends View {
  protected Filter filter;
  
  public Seats(Filter filter, GUI gui) {
    super(gui);
    this.filter = filter; } }
