package se.zarac.lu.sysa.grupp4a.biler.gui.views.edit;

import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;

@SuppressWarnings("serial")
public class Item extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Item item;
  
  public Item(final se.zarac.lu.sysa.grupp4a.biler.models.Item item, final GUI gui) {
    super(gui);
    this.item = item;
    add(new Button("Save item " + item) {
      public void click() {
        biler.save(item); } } ); } }