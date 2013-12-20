package se.zarac.lu.sysa.grupp4a.biler;

import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Vehicle;

public class SeatsFilter implements Filter {
    protected int seats;

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