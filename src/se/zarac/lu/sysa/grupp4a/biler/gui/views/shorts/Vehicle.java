package se.zarac.lu.sysa.grupp4a.biler.gui.views.shorts;

import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Vehicle extends Product {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Vehicle vehicle;
  
  public Vehicle(final se.zarac.lu.sysa.grupp4a.biler.models.Vehicle vehicle, final GUI gui) {
    super(vehicle, gui);
    this.vehicle = vehicle;
    add(new JLabel(vehicle.getSeats() + " seats")); } }