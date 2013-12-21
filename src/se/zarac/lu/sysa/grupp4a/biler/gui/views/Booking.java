package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Booking extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Booking booking;
  
  public Booking(se.zarac.lu.sysa.grupp4a.biler.models.Booking booking) {
    this.booking = booking;
    add(new JLabel(booking.toString())); } }