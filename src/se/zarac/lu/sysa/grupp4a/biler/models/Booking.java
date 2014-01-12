package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Booking extends Model {
  private static final long serialVersionUID = -4414963132044701769L;
  public Person by; // usable by biler.find(..)
  public Item item; // usable by biler.find(..)
  protected Date start;
  protected Date end;

  public static Map<String, Object> filterSettings;
  static {
    filterSettings = new HashMap<String, Object>();
    filterSettings.put("start", new String()); 
    filterSettings.put("end", new String()); }

  public Booking(Person by, Item item, Date start, Date end) {
    super();
    this.by = by;
    this.item = item;
    this.start = start;
    this.end = end; }
  
  @Override
  public boolean filter() {
    System.out.println("Booking.filter() " + this + filterSettings + start + end);

    //if (!super.filter()) return false;
    
    String val = (String)filterSettings.get("start");
    if (val.length() > 0 &&
        (start == null || true)) {
      return false; }
    
    // if (!super.filter()) return false;
    System.out.println("Booking.filter() passed " + this);
    return true; }  }