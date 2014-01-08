package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.Model;

/**
 * Represents a Person. A customer is merely a Person with relations to Booking(s) and Orders(s).
 * 
 * @author zarac
 */
public class Person extends Model {
  private static final long serialVersionUID = 8990080958752583292L;
  protected String name = "Anonymous";
  protected String personNumber = "XXXXXXXXXX";
  protected List<Phone> phoneNumbers;
  protected List<Address> addresses;

  /**
   * @param personNumber All persons need a number.
   */
  public Person(String personNumber) {
    super();
    setPersonNumber(personNumber); }

  /**
   * @param name Because it's handy.
   * @param personNumber All persons need a number.
   */
  public Person(String personNumber, String name) {
    this(personNumber);
    setName(name); }

  public String toString() {
    return "{" + name + ":" + id + "}"; } 

  public String getName() {
    return name; }

  public String getPersonNumber() {
    return personNumber; }

  public List<Phone> getPhoneNumbers() {
    return phoneNumbers; }

  public List<Address> getAddresses() {
    return addresses; }

  public void setPersonNumber(String text) {
    if (text.length() > 0)
      personNumber = text;
    else 
      personNumber = "XXXXXXXXXX"; }

  public void setName(String text) {
    if (text.length() > 0)
      name = text;
    else
      name = "Anonymous"; } }