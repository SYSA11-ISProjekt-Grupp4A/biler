package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.HashMap;
import java.util.Map;
import se.zarac.lu.sysa.grupp4a.biler.Biler;

public class Vehicle extends Product {
  private static final long serialVersionUID = 8501965668305894009L;
  protected int seats;
  
  public static Map<String, Object> filterSettings;
  static {
    filterSettings = new HashMap<String, Object>();
    filterSettings.put("min-seats", new String("")); 
    filterSettings.put("max-seats", new String("")); }

  public Vehicle(String name, int seats) {
    super(name);
    this.seats = seats; } 

  public int getSeats() {
    return seats; }
  
  @Override
  public boolean filter(Biler biler) {
    System.out.println("Vehicle.filter() " + this + filterSettings + seats);
    
    if (!super.filter(biler)) return false;
    
    Integer val = null;
    try {
      val = Integer.parseInt((String)filterSettings.get("min-seats"));}
    catch (NumberFormatException e) { }
    if (val != null && seats < val) return false;
    
    val = null;
    try {
      val = Integer.parseInt((String)filterSettings.get("max-seats"));}
    catch (NumberFormatException e) { }
    if (val != null && seats >= val) return false; 
    
    System.out.println("Vehicle.filter() passed " + this);
    
    return true; } }