package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Model;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.FilterView;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;
import se.zarac.lu.sysa.grupp4a.biler.models.Vehicle;

@SuppressWarnings("serial")
public class Items extends View {
  protected JPanel filters;
  protected JPanel result;
  protected JLabel meta;
  protected JPanel items;
  protected Menu menu;
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
    
    // menu
    menu = new Menu();
    add(menu, BorderLayout.SOUTH);
    
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
    result = new JPanel();
    result.setLayout(new BorderLayout());
    meta = new JLabel("nothing yet..");
    result.add(meta, BorderLayout.NORTH);
    items = new JPanel();
    items.setLayout(new GridLayout(0, 1));
    result.add(items, BorderLayout.CENTER);
    add(result, BorderLayout.CENTER); }
  
  @Override
  public void preView() {
    update(); }
  
  public void update() {
    items.removeAll();
    Map<String, Model> index = biler.indices.get(Item.class);
    Iterator<Entry<String, Model>> i = index.entrySet().iterator();

    String year = (String)Booking.filterSettings.get("year");
    String month = (String)Booking.filterSettings.get("month");
    String day = (String)Booking.filterSettings.get("day");
    GregorianCalendar cal = null;
    if (year != null && year.length() > 0
        && month != null && month.length() > 0
        && day != null && day.length() > 0) {
      Integer yearInt = Integer.parseInt(year);
      Integer monthInt = Integer.parseInt(month);
      Integer dayInt = Integer.parseInt(day);
      
      cal = new GregorianCalendar(yearInt, monthInt, dayInt); }
    
    System.out.println(" cal = " + cal);
    
    int count = 0;
    while (i.hasNext()) {
      final Item item = (Item)i.next().getValue();
      System.out.println("## Filter Item " + item);
      if (item.filter(biler)) {
        count++;
        View view = gui.createView(item, GUI.ViewTypes.Short);
        if (cal != null) {
          final GregorianCalendar cal2 = cal;
          view.add(new Button("Book") {
            public void click() {
              Booking booking = new Booking((Person)biler.random(Person.class), item, cal2, cal2);
              biler.add(booking);
              gui.view(booking); } } ); }
        
        items.add(view); } }
    meta.setText("Displaying " + count + " / " + index.size() + " items."); }
  
  public void draw() {
    super.draw(); }
  
  protected class Menu extends JPanel {
    public Menu() {
      add(new Button("Add item") {
        public void click() {
          gui.view("Products"); } } ); } } }