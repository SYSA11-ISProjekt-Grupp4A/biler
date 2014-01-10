package se.zarac.lu.sysa.grupp4a.biler.gui.views.full;

import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;

@SuppressWarnings("serial")
public class Item extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Item item;
  
  public Item(final se.zarac.lu.sysa.grupp4a.biler.models.Item item, final GUI gui) {
    super(gui);
    this.item = item;
    
    /* try {
      @SuppressWarnings("unchecked")
      List<Booking> bookings = (List<Booking>) biler.find(se.zarac.lu.sysa.grupp4a.biler.models.Booking.class.getField("item"), this.item);
      System.out.println(bookings.size()); }
    catch (SecurityException e) {
      e.printStackTrace(); }
    catch (NoSuchFieldException e) {
      e.printStackTrace(); } */
    
    add(new JLabel("" + item + " is a"));
    if (item.getProduct() != null)
      add(gui.createView(item.getProduct(), GUI.ViewTypes.Short));
    else
      add(new JLabel("Keine produkten!"));

    List<Booking> bookings = item.getBookings(biler);
    JPanel row = new JPanel();
    row.add(new JLabel("Bookings :"));
    for (Booking booking : bookings) {
      row.add(gui.createView(booking, GUI.ViewTypes.Short)); }
    add(row);
    
    add(new Button("Edit") {
      public void click() {
        gui.view(item, GUI.ViewTypes.Edit); } } ); } }