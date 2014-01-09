package se.zarac.lu.sysa.grupp4a.biler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

  // model indices
  public Map<Class<Model>, Map<String, Model>> indices = new HashMap<Class<Model>, Map<String, Model>>();
    
  public List<Person> findPerson(String key) {
    List<Person> matches = new LinkedList<Person>();

    Iterator<Entry<String, Model>> p = indices.get(Person.class).entrySet().iterator();
    while (p.hasNext()) {
      Entry<String, Model> entry = p.next();
      Person person = (Person)entry.getValue();
      if (person.getName().toLowerCase().indexOf(key.toLowerCase()) > -1) {
        matches.add(person); } }

    return matches; }

  public void setName(String name) {
    this.name = name; }

  public String getName() {
    return name; }
  
  /**
   * Index singletons. Used for our models.
   *  
   * @param clas The name of the index.
   * @return The index.
   */
  public Map<String, Model> getIndex(Class<Model> clas) {
    Map<String, Model> index = indices.get(clas);
    if (index == null) {
      index = new HashMap<String, Model>();
      indices.put(clas, index); }
    return index; }
  
  /**
   * Add a Model.
   * 
   * @param model The Model.
   */
  @SuppressWarnings("unchecked")
  public void add(Model model) {
    String name = model.getClass().getSimpleName();
    System.out.println("Biler.add(" + name + " " + model + ")");
    // TODO throws StreamCorruptedException on strange file.
    getIndex((Class<Model>)model.getClass()).put(model.getId(), model); }

  /**
   * Find Model.
   * 
   * @param index What index?
   * @param id What id?
   * @return The Model, hopefully.
   */
  public Model find(Class<Model> index, String id) {
    return getIndex(index).get(id); }
  
  /**
   * Save all Models in all indices. 
   */
  public void saveEverything() {
    System.out.println("# Save everything!");
    for (Map.Entry<Class<Model>, Map<String, Model>> index : indices.entrySet()) {
      for (Map.Entry<String, Model> model : index.getValue().entrySet()) {
        model.getValue().save(); } } } }