package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.HashMap;
import java.util.Map;
import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Item extends Model {
  private static final long serialVersionUID = 1388623416825290648L;
  protected Product product;
  
  public static Map<String, Object> filterSettings;
  static {
    filterSettings = new HashMap<String, Object>(); }

  public Item(Product product) {
    super();
    this.product = product; }

  public Product getProduct() {
    return product; } 

  public boolean filter() {
    System.out.println("Item.filter() " + this + filterSettings);
    if (!super.filter() || (product != null && !product.filter())) return false;
    
    System.out.println("Item.filter() passed " + this);
    return true; } }