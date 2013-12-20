package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.List;

public class Person {
    protected String name;
    protected String personNumber;
    protected List<Phone> phoneNumbers;
    protected List<Address> addresses;
    
    public Person(String name, String personNumber) {
        this.name = name;
        this.personNumber = personNumber; }
    
    public String toString() {
        return name; } 
    
    public String getName() {
        return name; }

    public String getPersonNumber() {
        return personNumber; }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers; }

    public List<Address> getAddresses() {
        return addresses; } }