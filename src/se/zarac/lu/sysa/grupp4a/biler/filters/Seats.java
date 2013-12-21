package se.zarac.lu.sysa.grupp4a.biler.filters;

import se.zarac.lu.sysa.grupp4a.biler.Filter;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Vehicle;

public class Seats implements Filter {
  protected int seats;
  
  public Seats(int seats) {
    this.seats = seats; }

  public int getSeats() {
    return seats; }

  public void setSeats(int seats) {
    this.seats = seats; }

  @Override
  public boolean filter(Item item) {
    if (item.getProduct() instanceof Vehicle
        && ((Vehicle)item.getProduct()).getSeats() >= seats) {
      return true; }

    return false; } }