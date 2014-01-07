package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.Model;

/**
 * Represents a Person. A customer is merely a Person with relations to Booking(s) and Orders(s).
 * 
 * @author zarac
 */
public class Person extends Model {
    protected String name = "anonymous";
    protected String personNumber = "XXXXXXXXXX"; // ID
    protected List<Phone> phoneNumbers;
    protected List<Address> addresses;

    /**
     * @param personNumber All persons need a number.
     */
    public Person(String personNumber) {
        this.personNumber = personNumber; }
    
    /**
     * @param name Because it's handy.
     * @param personNumber All persons need a number.
     */
    public Person(String personNumber, String name) {
      if (personNumber.length() > 0)
        this.personNumber = personNumber;
      if (name.length() > 0)
        this.name = name; }
    
    public String toString() {
        return personNumber + "-" + name; } 
    
    public String getName() {
        return name; }

    public String getPersonNumber() {
        return personNumber; }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers; }

    public List<Address> getAddresses() {
        return addresses; } }