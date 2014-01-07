package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.GridLayout;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class About extends View {
  protected Biler biler;
  
  public About(GUI gui) {
    super(gui);
    biler = gui.getBiler();
    setLayout(new GridLayout(0,1)); }

  @Override
  public void preView() {
    super.preView();
    setInformation(); }
  
  protected void setInformation() {
    removeAll();
    add(new JLabel("Name : "+ biler.getName()));
    add(new JLabel("Authors : "+ Biler.AUTHORS));
    add(new JLabel("Version : "+ Biler.VERSION));
    add(new JLabel("Filters : "+ biler.getFilters()));
    add(new JLabel("Customers : "+ biler.getCustomers()));
    add(new JLabel("Products : "+ biler.getProducts()));
    add(new JLabel("Items : "+ biler.getItems()));
    add(new JLabel("Bookings : "+ biler.getBookings())); } }