package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Map.Entry;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Model;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.FilterView;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.ShortView;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;
import se.zarac.lu.sysa.grupp4a.biler.models.Vehicle;

@SuppressWarnings("serial")
public class Items extends View {
  protected JPanel filters;
  protected JPanel items;
  protected Biler biler;
  
  public Items(GUI gui) {
    super(gui);
    this.biler = gui.getBiler();
    
    setLayout(new BorderLayout());
    
    // filters
    filters = new JPanel();
    filters.setLayout(new GridLayout(0, 1));
    filters.add(new FilterView<Model>(gui, Model.class, this));
    filters.add(new FilterView<Product>(gui, Product.class, this));
    filters.add(new FilterView<Vehicle>(gui, Vehicle.class, this));
    filters.add(new FilterView<Item>(gui, Item.class, this));
    add(filters, BorderLayout.NORTH);
    
    // items (matching filters)
    items = new JPanel();
    items.setLayout(new GridLayout(0, 1));
    add(items, BorderLayout.CENTER);
    
    // menu
    add(new Menu(), BorderLayout.SOUTH); }
  
  @Override
  public void preView() {
    draw(); }
  
  public void draw() {
    items.removeAll();
    Iterator<Entry<String, Model>> i = biler.indices.get(Item.class).entrySet().iterator();
    while (i.hasNext()) {
      Item item = (Item)i.next().getValue();
      System.out.println("# Filter it! " + item);
      if (item.filter())
        items.add(new Hit(gui, item)); }
    super.draw(); }

  protected class Hit extends ShortView {
    protected Item item;
        
    /**
     * A short View for Item.
     * 
     * @param item The Item.
     */
    public Hit(final GUI gui, final Item item) {
      super(gui);
      this.item = item;
      
      add(new Button(item.toString()) {
        @Override
        public void click() {
          gui.view(item); } });
      
      final Product product = item.getProduct();
      if (product == null) // shouldn't be
        add(new JLabel("Keine produkten!"));
      else {
        add(new Button(product.toString()) {
          @Override
          public void click() {
            gui.view(product); } }); }

      add(new Button("X") {
        @Override
        public void click() {
          biler.remove(item);
          gui.view(item); } }); } }
  
  protected class Menu extends JPanel {
    public Menu() {
      add(new Button("Add item") {
        public void click() {
          gui.view("Products"); } } ); } } }