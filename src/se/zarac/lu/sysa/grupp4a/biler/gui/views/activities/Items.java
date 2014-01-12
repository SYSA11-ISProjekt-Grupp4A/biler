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
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;
import se.zarac.lu.sysa.grupp4a.biler.models.Vehicle;

@SuppressWarnings("serial")
public class Items extends View {
  protected JPanel filters;
  protected JPanel items;
  protected Biler biler;
  
  /* public class Filters extends View {
    protected View view;
    public Filters(GUI gui, View view) {
      super(gui);
      this.view = view; }
    public void add(Class<? extends Model> c) {
      add(new FilterView(gui, c, this));
    } } */
  
  public Items(GUI gui) {
    super(gui);
    this.biler = gui.getBiler();
    
    setLayout(new BorderLayout());
    
    /* Filters f = new Filters(gui, this);
    f.add(Model.class);
    f.add(Product.class);
    add(f, BorderLayout.NORTH); */
    
    // filters
    filters = new JPanel();
    filters.setLayout(new GridLayout(0, 1));
    filters.add(new FilterView<Model>(gui, Model.class, this));
    filters.add(new FilterView<Product>(gui, Product.class, this));
    filters.add(new FilterView<Vehicle>(gui, Vehicle.class, this));
    //filters.add(new FilterView<Item>(gui, Item.class, this));
    filters.add(new FilterView<Booking>(gui, Booking.class, this));
    add(filters, BorderLayout.NORTH);
    
    // items (matching filters)
    items = new JPanel();
    items.setLayout(new GridLayout(0, 1));
    add(items, BorderLayout.CENTER);
    
    // menu
    add(new Menu(), BorderLayout.SOUTH); }
  
  @Override
  public void preView() {
    update(); }
  
  public void update() {
    items.removeAll();
    Iterator<Entry<String, Model>> i = biler.indices.get(Item.class).entrySet().iterator();
    while (i.hasNext()) {
      Item item = (Item)i.next().getValue();
      System.out.println("## Filter Item " + item);
      if (item.filter(biler))
        items.add(gui.createView(item, GUI.ViewTypes.Short)); } }
  
  public void draw() {
    super.draw(); }
  
  protected class Menu extends JPanel {
    public Menu() {
      add(new Button("Add item") {
        public void click() {
          gui.view("Products"); } } ); } } }