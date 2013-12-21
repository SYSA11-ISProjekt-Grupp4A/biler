package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Item extends Model {
    protected Product product;
    protected String id;
    
    public Item(Product product, String id) {
        this.product = product;
        this.id = id; }
    
    public Product getProduct() {
        return product; }
    
    public String toString() {
        return id; } }