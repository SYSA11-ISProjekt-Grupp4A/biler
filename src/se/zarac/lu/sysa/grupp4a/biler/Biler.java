package se.zarac.lu.sysa.grupp4a.biler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;

/**
 * The main program, Biler.
 * 
 * @author zarac
 */
public class Biler {
  protected String name = "Biler 0.0.1";
  protected List<Person> customers;   
  protected List<Product> products;
  protected List<Filter> filters;
  protected SeatsFilter seatsFilter;
  protected List<Item> items;
  protected List<Booking> bookings;

  /**
   * Ze k0nstrukt0r.
   */
  public Biler() {
    this.customers = new LinkedList<Person>();
    this.products = new LinkedList<Product>();
    this.filters = new LinkedList<Filter>();
    this.items = new LinkedList<Item>();
    this.bookings = new LinkedList<Booking>();
    
    // THE filters
    seatsFilter = new SeatsFilter();
    seatsFilter.setSeats(4);
    
    filters.add(seatsFilter);

    System.out.println("Filters: " + filters); }

  /**
   * Check if item passes all given filters.
   * 
   * @param filters
   * @param item
   * @return Well, did it?
   */
  public boolean filter(List<Filter> filters, Item item) {
    Iterator<Filter> f = filters.iterator();
    while (f.hasNext()) {
      Filter filter = f.next();
      if (!filter.filter(item)) {
        return false; } }

    return true; }

  // check every item against all filters. Return goodies.
  public List<Item> filter(List<Filter> filters, List<Item> items) {
    Iterator<Item> i = items.iterator();

    List<Item> goodies = new LinkedList<Item>();

    while (i.hasNext()) {
      Item item = i.next();

      if (filter(filters, item)) {
        goodies.add(item); } }

    return goodies; }

  public List<Person> findPerson(String key) {
    List<Person> matches = new LinkedList<Person>();

    Iterator<Person> p = customers.iterator();
    while (p.hasNext()) {
      Person person = p.next();
      if (person.getName().toLowerCase().indexOf(key.toLowerCase()) > -1) {
        matches.add(person); } }

    return matches; }

  public List<Person> getCustomers() {
    return customers; }

  public List<Product> getProducts() {
    return products; }

  public List<Filter> getFilters() {
    return filters; }

  public List<Item> getItems() {
    return items; }

  public List<Booking> getBookings() {
    return bookings; }

  public void setName(String name) {
    // TODO trigger event so GUI can act?
    this.name = name; }
  
  public String getName() {
    return name; }

  public void add(Person kalle) {
    customers.add(kalle); } 

  public void add(Product product) {
    products.add(product); } 

  public void add(Item item) {
    items.add(item); } 

  public void add(Booking booking) {
    bookings.add(booking); } 

  public void add(Filter filter) {
    filters.add(filter); } }