package se.zarac.lu.sysa.grupp4a.biler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;

public class Biler {
  protected List<Person> customers;   
  protected List<Product> products;
  protected List<Filter> filters;
  protected List<Item> items;
  protected List<Booking> bookings;

  public Biler() {
    this.customers = new LinkedList<Person>();
    this.products = new LinkedList<Product>();
    this.filters = new LinkedList<Filter>();
    this.items = new LinkedList<Item>();
    this.bookings = new LinkedList<Booking>();
    
    // THE filters
    SeatsFilter seatsFilter = new SeatsFilter();
    seatsFilter.setSeats(4);
    
    filters.add(seatsFilter);

    System.out.println("Filters: " + filters); }

  // check if item passes all filters
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
    return bookings; } }