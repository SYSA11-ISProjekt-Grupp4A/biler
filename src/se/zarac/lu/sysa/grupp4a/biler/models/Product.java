package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Product extends Model {
  private static final long serialVersionUID = 332532907994301139L;
  protected String id;

  public Product(String id) {
    this.id = id; }

  public String toString() {
    return id; }  }