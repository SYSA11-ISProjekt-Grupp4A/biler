package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.BorderLayout;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;
import se.zarac.lu.sysa.grupp4a.biler.models.Vehicle;

@SuppressWarnings("serial")
public class Testicle extends View {
  protected JPanel filters;
  protected JPanel items;
  
  public Testicle(GUI gui) {
    super(gui);
    
    setLayout(new BorderLayout());

    // menu
    add(new Menu(), BorderLayout.SOUTH); }
  
  @Override
  public void preView() {
    draw(); }
  
  protected class Menu extends JPanel {
    public Menu() {
      add(new Button("view random Model") {
        public void click() {
          gui.view(biler.random()); } } );
      
      add(new Button("new Product") {
        public void click() {
          biler.add(new Product("new Product")); } } );
      
      add(new Button("new Vehicle") {
        public void click() {
          biler.add(new Vehicle("new Vehicle", 3)); } } );
      
      add(new Button("new Item") {
        public void click() {
          Item item = new Item((Product)biler.random(Product.class));
          biler.add(item);
          gui.view(item); } } ); } } }