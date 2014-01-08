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
      biler.add(new Vehicle("Volvo V70", 5));
      biler.add(new Vehicle("SAAB 95", 4));
      biler.add(new Vehicle("enzo", 2)); } }