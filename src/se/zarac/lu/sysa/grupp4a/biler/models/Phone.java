package se.zarac.lu.sysa.grupp4a.biler.models;

import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Phone extends Model {
    protected String number;
    
    public Phone(String number) {
        this.number = number; }
    
    public String toString() {
        return number; } }