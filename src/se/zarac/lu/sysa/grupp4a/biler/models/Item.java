package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Item extends Model {
  private static final long serialVersionUID = 1388623416825290648L;
  protected Product product;
  protected String id;

  public Item(Product product, String id) {
    this.product = product;
    this.id = id; }

  public Product getProduct() {
    return product; }

  public String toString() {
    return id; } }