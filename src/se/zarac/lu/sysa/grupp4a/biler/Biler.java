package se.zarac.lu.sysa.grupp4a.biler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import se.zarac.lu.sysa.grupp4a.biler.filters.Seats;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;

/**
 * The main program, Biler.
 * 
 * @author zarac
 */
public class Biler {
  public static final String VERSION = "0.0.1";
  public static final String AUTHORS = "Alexander, Hannes, Mikkel";
  public static final String DATA_PATH = "data/";
  protected String name = "Biler vr00m!";
  protected List<Filter> filters = new LinkedList<Filter>();
  protected Seats seatsFilter;
  protected Map<String, Map<String, Model>> indices = new HashMap<String, Map<String, Model>>();

  /**
   * Ze konstrukt0r.
   */
  public Biler() {    
    // THE filters
    // seatsFilter = new Seats(4);
    // seatsFilter.setSeats(4);
    // filters.add(seatsFilter);
    filters.add(new Seats(4));
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

    Iterator<Entry<String, Model>> p = indices.get("Person").entrySet().iterator();
    //Iterator<Person> p = customers.iterator();
    while (p.hasNext()) {
      Entry<String, Model> entry = p.next();
      Person person = (Person)entry.getValue();
      //Person person = p.next();
      if (person.getName().toLowerCase().indexOf(key.toLowerCase()) > -1) {
        matches.add(person); } }

    return matches; }

  public List<Filter> getFilters() {
    return filters; }

  public void setName(String name) {
    this.name = name; }

  public String getName() {
    return name; }

  /**
   * Index singletons. Used for our models.
   * 
   * @param name The name of the index.
   * @return The index.
   */
  public Map<String, Model> getIndex(String name) {
    Map<String, Model> index = indices.get(name);
    if (index == null) {
      index = new HashMap<String, Model>();
      indices.put(name, index); }
    return index; }
  
  /**
   * Add a Model.
   * 
   * @param model The Model.
   */
  public void add(Model model) {
    String name = model.getClass().getSimpleName();
    System.out.println("Biler.add(" + name + " " + model + ")");
    // TODO throws StreamCorruptedException on strange file.
    getIndex(name).put(model.getId(), model); }
  
  /**
   * Add a Filter.
   * 
   * @param filter The Filter.
   */
  public void add(Filter filter) {
    filters.add(filter); }

  /**
   * Find Model.
   * 
   * @param index What index?
   * @param id What id?
   * @return The Model, hopefully.
   */
  public Model find(String index, String id) {
    return getIndex(index).get(id); }
  
  /**
   * Save all Models in all indices. 
   */
  public void saveEverything() {
    System.out.println("Save Everything! : )");
    for (Map.Entry<String, Map<String, Model>> index : indices.entrySet()) {
      for (Map.Entry<String, Model> model : index.getValue().entrySet()) {
        model.getValue().save(); } } } }