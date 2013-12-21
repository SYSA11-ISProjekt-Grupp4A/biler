package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Product extends Model {
    protected String id;
    
    public Product(String id) {
        this.id = id; }
    
    public String toString() {
        return id; }  }