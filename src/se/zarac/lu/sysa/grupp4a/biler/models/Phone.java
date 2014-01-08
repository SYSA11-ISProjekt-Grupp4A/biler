package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Phone extends Model {
  private static final long serialVersionUID = 2837140987188026665L;
  protected String number;

  public Phone(String number) {
    super();
    this.number = number; }

  public String toString() {
    return number; } }