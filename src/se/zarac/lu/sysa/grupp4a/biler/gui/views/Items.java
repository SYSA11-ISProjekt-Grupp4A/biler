package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import java.util.Iterator;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Filter;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;

@SuppressWarnings("serial")
public class Items extends View {
  protected JPanel filters;
  protected JPanel items;
  protected Biler biler;
  
  public Items(GUI gui) {
    super(gui);
    this.gui = gui;
    this.biler = gui.getBiler();
    
    filters = new JPanel();
    Iterator<Filter> f = biler.getFilters().iterator();
    while (f.hasNext()) {
      Filter filter = f.next();
      filters.add(gui.createView(filter)); }
    add(filters);
    
    items = new JPanel();
    add(items);
    
    draw(); }
  
  protected void draw() {
    items.removeAll();
    Iterator<Item> i = biler.getItems().iterator();
    while (i.hasNext()) {
      Item item = i.next();
      items.add(new JLabel(item.toString())); } } }