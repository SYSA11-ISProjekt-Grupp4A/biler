package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Booking extends Model {
  private static final long serialVersionUID = -4414963132044701769L;
  public Person by; // usable by biler.find(..)
  public Item item; // usable by biler.find(..)
  public Date start;
  public Date end;

  public static Map<String, Object> filterSettings;
  static {
    filterSettings = new HashMap<String, Object>();
    filterSettings.put("year", new String());
    filterSettings.put("month", new String());
    filterSettings.put("day", new String()); }

  public Booking(Person by, Item item, Date start, Date end) {
    super();
    this.by = by;
    this.item = item;
    this.start = start;
    this.end = end; }
  
  @Override
  public boolean filter(Biler biler) {
    System.out.println("Booking.filter() " + this + filterSettings + start + end);

    //if (!super.filter()) return false;

    String year = (String)filterSettings.get("year");
    String month = (String)filterSettings.get("month");
    String day = (String)filterSettings.get("day");
    if (year.length() > 0 || month.length() > 0 || day.length() > 0) {
      if (start == null) return false; // all bookings should have a start date
      try {
        Integer valInt = Integer.parseInt(year);
        if (start.getYear() != valInt) {
          return false; } }
      catch (NumberFormatException e) { } }
    
    // if (!super.filter()) return false;
    System.out.println("Booking.filter() passed " + this);
    return true; }  }