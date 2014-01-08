package se.zarac.lu.sysa.grupp4a.biler.models;

public class Vehicle extends Product {
  private static final long serialVersionUID = 8501965668305894009L;
  protected int seats;

  public Vehicle(String id, int seats) {
    super(id);
    this.seats = seats; } 

  public int getSeats() {
    return seats; }
  
  @Override
  public boolean filter() {
    System.out.println("Vehicle.filter()" + this);
    
    if (!super.filter())
      return false;
    
    return true; } }