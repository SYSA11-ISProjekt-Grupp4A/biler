package se.zarac.lu.sysa.grupp4a.biler.gui.views.edit;

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

    add(new JLabel(item.toString()));
    
    add(new Button("Save. Although, not really, 'cause there's nothing to save") {
      public void click() {
        biler.save(item); } } ); 
    
    add(new Button("Remove") {
      public void click() {
        biler.remove(item);
        gui.view("Items"); } } ); } }