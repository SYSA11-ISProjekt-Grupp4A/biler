
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
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
    biler.load();
    GUI gui = new GUI(biler);
    // TODO bug-gui-visible : needs to be set here AND inside JFrame constructor (it shouldn't?)
    gui.setVisible(true); } }