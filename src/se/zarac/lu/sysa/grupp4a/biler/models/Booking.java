package se.zarac.lu.sysa.grupp4a.biler.models;

import java.util.Date;
import se.zarac.lu.sysa.grupp4a.biler.Model;

public class Booking extends Model {
  private static final long serialVersionUID = -4414963132044701769L;
  protected Person by;
  protected Item item;
  protected Date start;
  protected Date end;

  public Booking (Person by, Item item, Date start, Date end) {
    this.by = by;
    this.item = item;
    this.start = start;
    this.end = end; }

  public String toString() {
    return item + " by " + by + " from " + start + " to " + end; } }