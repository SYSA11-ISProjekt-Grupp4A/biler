import java.util.Date;
import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Model;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;
import se.zarac.lu.sysa.grupp4a.biler.models.Vehicle;

/**
 * (Example) execution of Biler.
 * 
 * @author zarac
 */
public class Main {
  /**
   * Creates an instance of Biler, attaches a GUI to it, and populate()s it with some stuff.
   * @param argv
   */
  public static void main(String[] argv) {
    Biler biler = new Biler();
    //populate(biler);
    Model.load(biler);
    
    System.out.println("Person index: " + biler.getIndex("Person"));
    System.out.println("Product index: " + biler.getIndex("Product"));
    System.out.println("Vehicle index: " + biler.getIndex("Vehicle"));
    System.out.println("Item index: " + biler.getIndex("Item"));
    System.out.println("Booking index: " + biler.getIndex("Booking"));
    
    GUI gui = new GUI(biler);
    // TODO bug-gui-visible : needs to be set here AND inside JFrame constructor (it shouldn't?)
    gui.setVisible(true); }
    
    /**
     * Populate Biler with some data.
     * 
     * @param biler The instance of Biler, duh!
     */
    public static void populate(Biler biler) {      
      // some persons (can become customers and/or users)
      biler.add(new Person("4803051932", "Kalle"));
      biler.add(new Person("8581484013", "Lisa"));
      biler.add(new Person("4884120443", "Arne"));
      biler.add(new Person("5802837592", "Hugo"));
      
      // some vehicles (specialized Products)
      biler.add(new Vehicle("V70", 5));
      biler.add(new Vehicle("95", 4));
      biler.add(new Vehicle("enzo", 2));
      
      // some items
      biler.add(new Item((Product)biler.getIndex("Product").get("V70"), "vulvan"));
      biler.add(new Item((Product)biler.getIndex("Product").get("saab95"), "saaab"));
      biler.add(new Item((Product)biler.getIndex("Product").get("enzo"), "enzon"));
      
      // and a booking
      biler.add(new Booking(
          (Person)biler.getIndex("Person").get("4803051932"),
          (Item)biler.getIndex("Item").get("vulvan"),
          new Date(2013, 12, 19), new Date(2013, 12, 19))); } }