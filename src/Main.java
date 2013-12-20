import java.util.Date;
import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;
import se.zarac.lu.sysa.grupp4a.biler.models.Item;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;
import se.zarac.lu.sysa.grupp4a.biler.models.Product;
import se.zarac.lu.sysa.grupp4a.biler.models.Vehicle;

public class Main {
  public static void main(String[] argv) {
    Biler biler = new Biler();
    populate(biler);
    whatsAvailable(biler);
    GUI gui = new GUI(biler);
    // TODO bug-1 : needs to be set here AND inside JFrame constructor (it shouldn't?)
    gui.setVisible(true); }
    
    // some test data
    public static void populate(Biler biler) {
      List<Person> customers = biler.getCustomers();
      List<Product> products = biler.getProducts();
      List<Item> items = biler.getItems();
      List<Booking> bookings = biler.getBookings();
      
      // some customers
      Person kalle = new Person("Kalle", "4803051932");
      Person lisa = new Person("Lisa", "4402025155");

      customers.add(kalle);
      customers.add(lisa);
      
      System.out.println("Customers: " + customers);
      
      // some vehicles (specialized Products)
      Vehicle volvoV70 = new Vehicle("V70", 5);
      Vehicle saab95 = new Vehicle("95", 4);
      Vehicle enzo = new Vehicle("enzo", 2);
      
      products.add(volvoV70);
      products.add(saab95);
      products.add(enzo);

      System.out.println("Products: " + products);
               
      // some items
      Item volvon = new Item(volvoV70, "vulvan");
      Item saaben = new Item(saab95, "saaab");
      Item enzon = new Item(enzo, "enzon");
      
      items.add(volvon);
      items.add(saaben);
      items.add(enzon);
   
      System.out.println("Items: " + items);
      
      // and a booking bookings
      Booking kalleTarVolvon = new Booking(kalle, volvon, new Date(2013, 12, 19), new Date(2013, 12, 19));

      bookings.add(kalleTarVolvon);

      System.out.println("Bookings: " + bookings); }
    
    // test availability
    public static void whatsAvailable(Biler biler) {
      System.out.println("Filtered: " + biler.filter(biler.getFilters(), biler.getItems())); } }