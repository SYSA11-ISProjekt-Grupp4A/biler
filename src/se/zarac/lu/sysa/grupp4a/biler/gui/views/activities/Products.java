package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.util.Iterator;
import se.zarac.lu.sysa.grupp4a.biler.Model;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;

@SuppressWarnings("serial")
public class Products extends View {
  public Products(final GUI gui) {
    super(gui);
    add(new Button("Add Product") {
      public void click() {
        Product product = new Product("Pro yeah");
        biler.add(product);
        gui.view(product); } } );
    
    Iterator<Model> i = biler.getIndex(Product.class).values().iterator();
    while (i.hasNext()) {
      add(gui.createView((Product)i.next(), GUI.ViewTypes.Short)); } } }