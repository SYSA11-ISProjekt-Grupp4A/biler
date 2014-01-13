package se.zarac.lu.sysa.grupp4a.biler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

/**
 * The main program, Biler.
 * 
 * @author zarac
 */
public class Biler {
  public transient static final String VERSION = "0.0.1";
  public transient static final String AUTHORS = "Alexander, Hannes, Mikkel";
  public transient static final String DATA_PATH = "data/";
  
  protected String name = "Biler vr00m!";

  // model indices
  public transient Map<Class<? extends Model>, Map<String, Model>> indices = new HashMap<Class<? extends Model>, Map<String, Model>>();

  public List<? extends Model> find(Class<? extends Model> clas, String fieldName, Object key) {
    try {
      Field field = clas.getField(fieldName);
      return find(field, key); }
    catch (SecurityException e) {
      e.printStackTrace(); }
    catch (NoSuchFieldException e) {
      e.printStackTrace(); }
    
    return null; }
  
  public List<? extends Model> find(Field field, Object key) {
    //System.out.println("biler.find(field, key)");
    //System.out.println(" field = " + field);
    //System.out.println(" key = " + key);
    List<Model> hits = new LinkedList<Model>();
    @SuppressWarnings("unchecked")
    Class<Model> clas = (Class<Model>) field.getDeclaringClass();
    //System.out.println(" class = " + clas);
    Map<String, Model> index = getIndex(clas);
    //System.out.println(" index = " + index);
    for (Model model : index.values()) {
      //System.out.println(" .model " + model);
      try {
        Object value = field.get(model);
        //System.out.println("  value = " + value);
        //System.out.println("   class = " + value.getClass());
        //System.out.println("  ? compare hashCode()s = " + key.hashCode() + " .. " + value.hashCode());
        //if (value.toString().equals(key.toString())) { // TODO compare directly (without toString()).
        if (value.equals(key)) {
          //System.out.println("   YAY!");
          hits.add(model); }
        //else 
          //System.out.println("   NO");
        }
      catch (IllegalArgumentException e) {
        e.printStackTrace(); }
      catch (IllegalAccessException e) {
        e.printStackTrace(); } }
    
    return hits; }

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
  public Map<String, Model> getIndex(Class<? extends Model> clas) {
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
    if (model == null) {
      System.out.println("! cannot add(null)");
      return; }
    // TODO throws StreamCorruptedException on strange file.
    getIndex((Class<Model>)model.getClass()).put(model.getId(), model); }
  
  /**
   * Remove a Model.
   * 
   * @param model The Model.
   */
  @SuppressWarnings("unchecked")
  public boolean remove(Model model) {
    String tail = DATA_PATH + model.getClass().getSimpleName();
    // make sure target for data save exists
    new File(tail).mkdirs();
    String path = tail + "/" + model.getId();

    new File(path).delete();
    
    return (getIndex((Class<Model>)model.getClass()).remove(model.getId()) != null ? true : false); } 
  
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
   * Get a random Model from random Index.
   * 
   * @return A Model.
   */
  public Model random() {
    Collection<Class<? extends Model>> keys = indices.keySet();
    int i = (int) Math.floor(Math.random() * keys.size());
    Class<? extends Model> index = null;
    for (Class<? extends Model> key : keys) {
      if (i-- == 0) index = key; }
    
    return random(index); }
  
  /**
   * Get a random Model from an Index.
   * 
   * @param index The index.
   * @return A Model.
   */
  public Model random(Class<? extends Model> index) {
    Collection<Model> values = getIndex(index).values();
    
    int i = (int) Math.floor(Math.random() * values.size());
    for (Model val : values) {
      if (i-- == 0) return val; }
    
    return null; }

  /**
   * Populate biler with whatever is in Biler.DATA_PATH.
   * 
   * @param biler The instance of Biler.
   */
  public void load() {
    System.out.println("# Load everything!");
    new File(Biler.DATA_PATH).mkdirs();
    Collection<File> files = FileUtils.listFiles(
        new File(Biler.DATA_PATH),
        new RegexFileFilter("^(.*?)"),
        DirectoryFileFilter.DIRECTORY);
    
    for (File file: files) {
      add(load(file.getPath())); } }
  
  /**
   * Load up a serialized model.
   * 
   * @param path Path to file.
   * @return The deserialized Model.
   */
  public Model load(String path) {
    Model model = null;
    FileInputStream file;
    ObjectInputStream object;
    try {
      file = new FileInputStream(path);
      object = new ObjectInputStream(file);
      model = (Model)object.readObject();
      object.close();
      file.close(); }
    catch (FileNotFoundException e) {
      e.printStackTrace(); }
    catch (NotSerializableException e) {
      System.out.println("! could not serialize " + path);
      e.printStackTrace(); }
    catch (IOException e) {
      System.out.println("! io error " + path); }
    catch (ClassNotFoundException e) {
      e.printStackTrace(); }
    
    return model; }
  
  protected void serialize(Model model) {
    FileOutputStream file = null;
    ObjectOutputStream object = null;
    try {
      String tail = DATA_PATH + model.getClass().getSimpleName();
      // make sure target for data save exists
      new File(tail).mkdirs();
      String path = tail + "/" + model.getId();
      file = new FileOutputStream(path);
      object = new ObjectOutputStream(file);
      object.writeObject(model);
      object.close();
      file.close(); }
    catch (FileNotFoundException e) {
      e.printStackTrace(); }
    catch (NotSerializableException e) {
      System.out.println("! could not serialize " + model + " to " + object);
      e.printStackTrace(); }
    catch (IOException e) {
      System.out.println("! io error in serialize(" + model + ")"); } }
  
  /**
   * Save a Model (to persistent storage).
   * 
   * @param model The Model.
   */
  public void save(Model model) {
    //System.out.println("Model.save(" + model + ")" );
    serialize(model); }

  /**
   * Save Everything (all Models in all indices). 
   */
  public void saveEverything() {
    System.out.println("# Save everything!");
    for (Map.Entry<Class<? extends Model>, Map<String, Model>> index : indices.entrySet()) {
      for (Map.Entry<String, Model> model : index.getValue().entrySet()) {
        save(model.getValue()); } } } }