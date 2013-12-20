package se.zarac.lu.sysa.grupp4a.biler.models;

public class Address {
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