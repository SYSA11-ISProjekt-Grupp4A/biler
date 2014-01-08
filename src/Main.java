import java.util.Date;
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

    System.out.println((Person)biler.getIndex("Person").get("6667dce7-932d-4937-8e09-dc6b5cfc5635"));
    System.out.println((Item)biler.getIndex("Item").get("NDU673"));
    
    biler.add(new Item((Product)biler.getIndex("Product").get("Volvo V70")));
    /* Test data
    biler.add(
        new Booking(
            (Person)biler.getIndex("Person").get("6667dce7-932d-4937-8e09-dc6b5cfc5635"),
            (Item)biler.getIndex("Item").get("NDU673"),
            new Date(2013, 12, 22),
            new Date(2013, 12, 27)));
    */
        
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
      biler.add(new Item((Product)biler.getIndex("Product").get("V70")));
      biler.add(new Item((Product)biler.getIndex("Product").get("saab95")));
      biler.add(new Item((Product)biler.getIndex("Product").get("enzo")));
      
      // and a booking
      biler.add(new Booking(
          (Person)biler.getIndex("Person").get("4803051932"),
          (Item)biler.getIndex("Item").get("vulvan"),
          new Date(2013, 12, 19), new Date(2013, 12, 19))); } }