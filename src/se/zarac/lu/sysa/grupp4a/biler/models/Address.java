package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Address extends Model {
  private static final long serialVersionUID = 145082793944273633L;
  protected String street;
  protected String number;
  protected String postalCode;
  protected String city;
  protected String country;

  public Address(String street, String number, String postalCode, String city, String country) {
    this.street = street;
    this.number = number;
    this.postalCode = postalCode;
    this.city = city;
    this.country = country; }

  public String toString() {
    return street + " " + number + ", " + city; } }