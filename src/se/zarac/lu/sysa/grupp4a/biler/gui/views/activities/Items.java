package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Map.Entry;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Filter;
import se.zarac.lu.sysa.grupp4a.biler.Model;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;

@SuppressWarnings("serial")
public class Items extends View {
  protected JPanel filters;
  protected JPanel items;
  protected Biler biler;
  
  public Items(GUI gui) {
    super(gui);
    this.gui = gui;
    this.biler = gui.getBiler();
    
    setLayout(new BorderLayout());
    
    // filters
    filters = new JPanel();
    Iterator<Filter> f = biler.getFilters().iterator();
    while (f.hasNext()) {
      Filter filter = f.next();
      filters.add(gui.createView(filter)); }
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
  
  protected void draw() {
    items.removeAll();
    Iterator<Entry<String, Model>> i = biler.getIndex("Item").entrySet().iterator();
    while (i.hasNext()) {
      Item item = (Item)i.next().getValue();
      items.add(new ShortView(item)); } }

  protected class ShortView extends JPanel {
    protected Item item;
    
    protected Button itemButton = new Button("") {
      public void click() { } };
    
    public ShortView(final Item item) {
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
            gui.view(product); } }); } } }
  
  protected class Menu extends JPanel {
    public Menu() {
      add(new JLabel("ze menyy..")); } } }