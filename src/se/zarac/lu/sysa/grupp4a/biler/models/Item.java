package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Item extends Model {
  private static final long serialVersionUID = 1388623416825290648L;
  protected Product product;
  
  //protected Map<Class<?>, Object> filterables;

  public Item(Product product) {
    super();
    this.product = product;
    //filterables.put(product.getClass(), this.product);
    }

  public Product getProduct() {
    return product; } 

  public boolean filter() {
    System.out.println("Item.filter() " + this);
    //if (!super.filter()) return false;
    if (!super.filter() || (product != null && !product.filter())) return false;
    
    System.out.println("Item.filter() passed " + this);
    return true; } }