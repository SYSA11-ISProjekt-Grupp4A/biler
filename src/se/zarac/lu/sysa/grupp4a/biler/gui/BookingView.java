package se.zarac.lu.sysa.grupp4a.biler.gui;

import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;

public class BookingView extends JPanel {
  protected Booking booking;
  
  public BookingView(Booking booking) {
    this.booking = booking;
    add(new JLabel(booking.toString())); } }