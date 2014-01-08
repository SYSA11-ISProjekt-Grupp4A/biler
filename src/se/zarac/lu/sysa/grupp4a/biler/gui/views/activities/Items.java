package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.Map.Entry;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Filter;
import se.zarac.lu.sysa.grupp4a.biler.Model;
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
    
    setLayout(new BorderLayout());
    
    filters = new JPanel();
    Iterator<Filter> f = biler.getFilters().iterator();
    while (f.hasNext()) {
      Filter filter = f.next();
      filters.add(gui.createView(filter)); }
    add(filters, BorderLayout.NORTH);
    
    items = new JPanel();
    add(items, BorderLayout.CENTER);

    add(new Menu(), BorderLayout.SOUTH);
    
    draw(); }
  
  protected void draw() {
    items.removeAll();
    Iterator<Entry<String, Model>> i = biler.getIndex("Item").entrySet().iterator();
    while (i.hasNext()) {
      Item item = (Item)i.next().getValue();
      items.add(gui.createView(item)); } }
  
  protected class Menu extends JPanel {
    public Menu() {
      add(new JLabel("ze menyy")); } } }