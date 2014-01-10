package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.BorderLayout;
import java.util.Date;
import java.util.GregorianCalendar;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;
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
    add(new Menu(), BorderLayout.CENTER); }
  
  @Override
  public void preView() {
    draw(); }
  
  protected class Menu extends View {
    public Menu() {
      super(Testicle.this.gui);
      
      add(new Button("view random Model") {
        public void click() {
          gui.view(biler.random()); } } );
      
      add(new Button("view random Product") {
        public void click() {
          gui.view(biler.random(Product.class)); } } );
      
      add(new Button("view random Vehicle") {
        public void click() {
          gui.view(biler.random(Vehicle.class)); } } );
      
      add(new Button("view random Item") {
        public void click() {
          gui.view(biler.random(Item.class)); } } );
      
      add(new Button("view random Person") {
        public void click() {
          gui.view(biler.random(Person.class)); } } );
      
      add(new Button("view random Booking") {
        public void click() {
          gui.view(biler.random(Booking.class)); } } );
      
      add(new Button("new Product") {
        public void click() {
          Product product = new Product("new Product");
          biler.add(product);
          gui.view(product, GUI.ViewTypes.Edit); } } );
      
      add(new Button("new 3 seat Vehicle") {
        public void click() {
          Vehicle vehicle = new Vehicle("new Vehicle", 3);
          biler.add(vehicle);
          gui.view(vehicle, GUI.ViewTypes.Edit);  } } );

      add(new Button("new (random) Product Item") {
        public void click() {
          Item item = new Item((Product)biler.random(Product.class));
          biler.add(item);
          gui.view(item); } } );
      
      add(new Button("new (random) Vehicle Item") {
        public void click() {
          Item item = new Item((Vehicle)biler.random(Vehicle.class));
          biler.add(item);
          gui.view(item); } } );

      add(new Button("new (random) Booking") {
        public void click() {
          Person by = (Person)biler.random(Person.class);
          Item item = (Item)biler.random(Item.class);
          Date from = new GregorianCalendar(1970, 01, 01).getTime();
          Date to = new GregorianCalendar(1970, 01, 03).getTime();
          Booking booking = new Booking(by, item, from, to);
          biler.add(booking);
          gui.view(booking); } } ); } } }