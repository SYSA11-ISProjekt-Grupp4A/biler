package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import java.util.Iterator;
import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;

@SuppressWarnings("serial")
public class Items extends View {
  protected GUI gui;
  protected Biler biler;
  protected JPanel items;
  
  public Items(GUI gui) {
    this.gui = gui; 
    biler = gui.getBiler();
    items = new JPanel();
    view(biler.getItems()); }
  
  protected void view(List<Item> items) {
    this.items.removeAll();
    Iterator<Item> i = items.iterator();
    while (i.hasNext()) {
      Item item = i.next();
      add(new JLabel(item.toString())); } } }