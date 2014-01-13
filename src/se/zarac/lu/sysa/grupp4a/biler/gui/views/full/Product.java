package se.zarac.lu.sysa.grupp4a.biler.gui.views.full;

import java.util.Iterator;
import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;

@SuppressWarnings("serial")
public class Product extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Product product;
  
  public Product(final se.zarac.lu.sysa.grupp4a.biler.models.Product product, final GUI gui) {
    super(gui);
    this.product = product;
    add(new JLabel(product.getManufacturer() + " " + product.getName()));
    
    add(new JLabel("Items"));
    @SuppressWarnings("unchecked")
    List<Item> items = (List<Item>) biler.find(Item.class, "product", product);
    System.out.println("Items == " + items.size());
    Iterator<Item> i = items.iterator();
    while (i.hasNext()) {
      Item item = i.next();
      System.out.println("CREATE VIEW FOR ITEM " + item);
      add(gui.createView(item, GUI.ViewTypes.Short)); }
  
    add(new Button("Edit") {
      public void click() {
        gui.view(product, GUI.ViewTypes.Edit); } } ); } }