package se.zarac.lu.sysa.grupp4a.biler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

public abstract class Model implements Serializable {
  private static final long serialVersionUID = 5678656957190670757L;
  protected static String dataPath = "data/";
  protected String id;
  
  public Model() { 
    id = UUID.randomUUID().toString(); }

  /**
   * Pass through everything by default.
   * 
   * @return true
   */
  public boolean filter() {
    System.out.println("Model.filter()" + this);
    return true; }
  
  public void save() {
    serialize();
    System.out.println("Model.save(" + this + ")" ); }

  /**
   * Populate biler with whatever is in Biler.DATA_PATH.
   * 
   * @param biler The instance of Biler.
   */
  public static void load(Biler biler) {
    new File(Biler.DATA_PATH).mkdirs();
    Collection<File> files = FileUtils.listFiles(
        new File(Biler.DATA_PATH),
        new RegexFileFilter("^(.*?)"),
        DirectoryFileFilter.DIRECTORY);
    
    for (File file: files) {
      biler.add(load(file.getPath())); } }
  
  /**
   * Load up a serialized model.
   * 
   * @param path Path to file.
   * @return The deserialized Model.
   */
  public static Model load(String path) {
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
    catch (IOException e) {
      e.printStackTrace(); }
    catch (ClassNotFoundException e) {
      e.printStackTrace(); }
    
    return model; }

  public String getId() {
    return id; }

  public String toString() {
    return getClass().getSimpleName() + ":" + id; }
  
  protected void serialize() {
    FileOutputStream file;
    ObjectOutputStream object;
    try {
      String tail = Biler.DATA_PATH + getClass().getSimpleName();
      // make sure target for data save exists
      new File(tail).mkdirs();
      String path = tail + "/" + id;
      file = new FileOutputStream(path);
      object = new ObjectOutputStream(file);
      object.writeObject(this);
      object.close();
      file.close(); }
    catch (FileNotFoundException e) {
      e.printStackTrace(); }
    catch (IOException e) {
      e.printStackTrace(); } } }