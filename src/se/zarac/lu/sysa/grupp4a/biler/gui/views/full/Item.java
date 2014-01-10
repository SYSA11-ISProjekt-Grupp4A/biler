package se.zarac.lu.sysa.grupp4a.biler.gui.views.full;

import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Item extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Item item;
  
  public Item(final se.zarac.lu.sysa.grupp4a.biler.models.Item item, final GUI gui) {
    super(gui);
    this.item = item;
    add(new JLabel("" + item + " is a"));
    if (item.getProduct() != null)
      add(gui.createView(item.getProduct(), GUI.ViewTypes.Short));
    else
      add(new JLabel("Keine produkten!"));
    
    add(new Button("Edit") {
      public void click() {
        gui.view(item, GUI.ViewTypes.Edit); } } ); } }