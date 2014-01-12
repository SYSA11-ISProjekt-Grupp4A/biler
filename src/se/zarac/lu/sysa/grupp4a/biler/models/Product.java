package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.HashMap;
import java.util.Map;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Product extends Model {
  private static final long serialVersionUID = 332532907994301139L;
  protected String name = "";
  public String getName() {
    return name; }
  public void setName(String name) {
    this.name = name; }
  protected String manufacturer = "";
  public String getManufacturer() {
    return manufacturer; }
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer; }

  public static Map<String, Object> filterSettings;
  static {
    filterSettings = new HashMap<String, Object>();
    filterSettings.put("name", new String());
    filterSettings.put("manufacturer", new String()); }

  public Product(String name) {
    super();
    this.name = name; }

  public String toString() {
    return "{" + getClass().getSimpleName() + ":" + name + ":" + id + "}"; }
  
  @Override
  public boolean filter(Biler biler) {
    System.out.println("Product.filter() " + this + filterSettings + name);

    //if (!super.filter()) return false;
    
    String val = (String)filterSettings.get("name");
    if (val.length() > 0 &&
        (name == null || name.toLowerCase().indexOf(val.toLowerCase()) < 0)) {
      return false; }
    
    // if (!super.filter()) return false;
    System.out.println("Product.filter() passed " + this);
    return true; } }