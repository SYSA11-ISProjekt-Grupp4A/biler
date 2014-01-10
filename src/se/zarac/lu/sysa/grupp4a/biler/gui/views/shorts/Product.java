package se.zarac.lu.sysa.grupp4a.biler.gui.views.shorts;

import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;

@SuppressWarnings("serial")
public class Product extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Product product;
  
  public Product(final se.zarac.lu.sysa.grupp4a.biler.models.Product product, final GUI gui) {
    super(gui);
    this.product = product;
    add(new Button(product.toString()) {
      public void click() {
        gui.view(product, GUI.ViewTypes.Full); } } ); } }