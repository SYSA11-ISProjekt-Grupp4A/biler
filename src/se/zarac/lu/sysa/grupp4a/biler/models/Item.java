package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Item extends Model {
  private static final long serialVersionUID = 1388623416825290648L;
  protected Product product;

  public Item(Product product) {
    super();
    this.product = product; }

  public Product getProduct() {
    return product; } }