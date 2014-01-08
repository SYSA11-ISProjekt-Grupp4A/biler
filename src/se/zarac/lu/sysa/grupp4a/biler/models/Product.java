package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Product extends Model {
  private static final long serialVersionUID = 332532907994301139L;
  protected String name;

  public Product(String name) {
    super();
    this.name = name; }
  
  @Override
  public boolean filter() {
    System.out.println("Product.filter()" + this);
    
    if (!super.filter())
      return false;
    
    return true; } }