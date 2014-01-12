package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Model;

/**
 * Represents a Person. A customer is merely a Person with relations to Booking(s) and Orders(s).
 * 
 * @author zarac
 */
public class Person extends Model {
  private static final long serialVersionUID = 8990080958752583292L;
  public String name = "Anonymous"; // public to work with biler.find()
  protected String personNumber = "XXXXXXXXXX";
  protected List<Phone> phoneNumbers;
  protected List<Address> addresses;

  public static Map<String, Object> filterSettings;
  static {
    filterSettings = new HashMap<String, Object>();
    filterSettings.put("name", new String()); 
    filterSettings.put("number", new String()); }

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

  public boolean filter(Biler biler) {
    System.out.println("Person() " + this + filterSettings);

    if (!super.filter(biler)) return false;

    String val = (String)filterSettings.get("name");
    if (val.length() > 0
        && Person.this.name.toLowerCase().indexOf(((String)filterSettings.get("name")).toLowerCase()) < 0) {
      return false; }
    
    val = (String)filterSettings.get("number");
    if (val.length() > 0
        && Person.this.personNumber.toLowerCase().indexOf(((String)filterSettings.get("number")).toLowerCase()) < 0) {
      return false; }
    
    System.out.println("Person() passed " + this);
    return true; }

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
      name = "Anonymous"; }

  @SuppressWarnings("unchecked")
  public List<Booking> getBookings(Biler biler) {
    List<Booking> bookings = null;
    try {
      bookings = (List<Booking>) biler.find(Booking.class.getField("by"), this); }
    catch (SecurityException e) {
      e.printStackTrace(); }
    catch (NoSuchFieldException e) {
      e.printStackTrace(); }
    return bookings; } }