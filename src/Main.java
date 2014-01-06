import java.util.Date;
import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;
import se.zarac.lu.sysa.grupp4a.biler.models.Vehicle;

/**
 * Entry point to running Biler.
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
    populate(biler);
    GUI gui = new GUI(biler);
    // TODO bug-gui-visible : needs to be set here AND inside JFrame constructor (it shouldn't?)
    gui.setVisible(true); }
    
    /**
     * Populate Biler with some data.
     * 
     * @param biler The instance of Biler, duh!
     */
    public static void populate(Biler biler) {
      List<Person> customers = biler.getCustomers();
      List<Product> products = biler.getProducts();
      List<Item> items = biler.getItems();
      List<Booking> bookings = biler.getBookings();
      
      // some persons (can become customers and/or users)
      Person kalle = new Person("Kalle", "4803051932");
      Person lisa = new Person("Lisa", "8581484013");
      Person arne = new Person("Arne", "4884120443");
      Person hugo = new Person("Hugo", "5802837592");

      biler.add(kalle);
      biler.add(lisa);
      biler.add(arne);
      biler.add(hugo);
      
      System.out.println("Customers: " + customers);
      
      // some vehicles (specialized Products)
      Vehicle volvoV70 = new Vehicle("V70", 5);
      Vehicle saab95 = new Vehicle("95", 4);
      Vehicle enzo = new Vehicle("enzo", 2);
      
      biler.add(volvoV70);
      biler.add(saab95);
      biler.add(enzo);

      System.out.println("Products: " + products);
               
      // some items
      Item volvon = new Item(volvoV70, "vulvan");
      Item saaben = new Item(saab95, "saaab");
      Item enzon = new Item(enzo, "enzon");
      
      biler.add(volvon);
      biler.add(saaben);
      biler.add(enzon);
   
      System.out.println("Items: " + items);
      
      // and a booking bookings
      // TODO : don't use deprecated stuff
      @SuppressWarnings("deprecation")
      Booking kalleTarVolvon = new Booking(kalle, volvon, new Date(2013, 12, 19), new Date(2013, 12, 19));

      biler.add(kalleTarVolvon);

      System.out.println("Bookings: " + bookings); } }