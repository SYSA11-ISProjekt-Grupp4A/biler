package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.HashMap;
import java.util.Map;
import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Product extends Model {
  private static final long serialVersionUID = 332532907994301139L;
  protected String name = "";
  protected String manufacturer = "";
  
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
  public boolean filter() {
    System.out.println("Product.filter() " + this + filterSettings + name);

    String val = (String)filterSettings.get("name");
    if (val.length() > 0 &&
        (name == null || name.indexOf(val) < 0)) {
      return false; }
    
    // if (!super.filter()) return false;
    System.out.println("Product.filter() passed " + this);
    return true; } }