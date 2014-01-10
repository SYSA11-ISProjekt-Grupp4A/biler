package se.zarac.lu.sysa.grupp4a.biler.gui.views.shorts;

import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;

@SuppressWarnings("serial")
public class Vehicle extends Product {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Product product;
  
  // TODO load Product automatically if this file doesn't exist.
  public Vehicle(final se.zarac.lu.sysa.grupp4a.biler.models.Product product, final GUI gui) {
    super(product, gui); } }