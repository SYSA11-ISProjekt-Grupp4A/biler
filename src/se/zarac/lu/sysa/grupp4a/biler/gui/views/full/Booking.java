package se.zarac.lu.sysa.grupp4a.biler.gui.views.full;

import java.util.Calendar;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Booking extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.Model model;
  protected se.zarac.lu.sysa.grupp4a.biler.models.Booking booking;
  
  public Booking(final se.zarac.lu.sysa.grupp4a.biler.models.Booking booking, final GUI gui) {
    super(gui);
    this.model = booking;
    this.booking = booking;
    add(new JLabel(model.getId()));
    add(gui.createView(booking.by, GUI.ViewTypes.Short));
    add(gui.createView(booking.item, GUI.ViewTypes.Short));
    add(new JLabel("Date : "
        + booking.start.get(Calendar.YEAR)
        + "-" + booking.start.get(Calendar.MONTH)
        + "-" + booking.start.get(Calendar.DAY_OF_MONTH)));
    
    add(new Button("Edit") {
      public void click() {
        gui.view(Booking.this.model, GUI.ViewTypes.Edit);
        System.out.println("edit it "); } } ); } }