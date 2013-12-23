
package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JComponent;
import se.zarac.lu.sysa.grupp4a.biler.*;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.*;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.Fallback;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.Items;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.Persons;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.Products;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.Splash;

@SuppressWarnings("serial")
public class GUI extends JFrame {
  protected Biler biler;
  protected JPanel container; // for the activities, or something
  protected Menu menu;
  // activities / modes
  protected enum Activity { SPLASH, ABOUT, PRODUCTS, ITEMS, PERSONS, BOOKINGS, EXIT };
  public static Activity DEFAULT_ACTIVITY = Activity.ABOUT;
  protected Splash splash;
  // TODO protected About about;
  protected Products products;
  protected Items items;
  protected Persons persons;
  // TODO protected Bookings bookings;
  
  
  public GUI(Biler biler) {
    this.biler = biler;
    
    // frame
    setTitle(biler.getName());
    setLayout(new BorderLayout());

    // menu
    menu = new Menu(this);
    add(menu, BorderLayout.SOUTH);
    
    // container, for activities
    container = new JPanel();
    container.setLayout(new GridBagLayout());
    add(container, BorderLayout.CENTER);

    // modes / activities / views / whatever you'd like to call them
    splash = new Splash(this, biler.getName());
    // TODO about = new About(this);
    products = new Products(this);
    items = new Items(this);
    persons = new Persons(this);
    // TODO bookings = new Bookings(this);
    
    view(Activity.SPLASH);
    
    // TODO bug-1 : needs to be set here AND after JFrame is instantiated
    setVisible(true); }

  public Biler getBiler() {
    return biler; }

  public void setComponent(JComponent component) {
    container.removeAll();
    container.add(component);
    // be JRE6 compliant, don't use revalidate()
    container.invalidate();
    container.validate();
    container.repaint(); }
  
  public void view(Activity activity) {
    switch(activity) {
      case SPLASH:
        setComponent(splash);
        // TODO bug-timer, cannot be used twice
        splash.timeOut(1);
        break;
      /* TODO case ABOUT:
        setComponent(about);
        break; */
      case PRODUCTS:
        setComponent(products);
        break;
      case ITEMS:
        setComponent(items);
        break;
      case PERSONS:
        setComponent(persons);
        persons.getInput().requestFocus();
        break;
      /* TODO case BOOKINGS:
        setComponent(bookings);
        break; */
      case EXIT:
        System.exit(0);
        break;
      default:
        setComponent(new JLabel("No such activity, '" + activity + "'."));
        break; } }
  
  /**
   * View a Model.
   * 
   * @param model The Model, it must have a matching View. */
  public void view(Model model) {
    setComponent(createView(model.getClass(), model)); }
  
  public void getView(Filter filter) {
    setComponent(createView(filter.getClass(), filter)); }

  /**
   * Create a View for a Model.
   *   find out what type of model it is
   *   create a view for that type
   * 
   * @param model The Model, it must have a matching View. */

  public View createView(Class clas, Object object) {
    View view = null;
    try {
      Constructor<View> constructor = getViewConstructor(clas);
      if (constructor == null) {
        System.out.println("View constructor not found for '" + object + "'.");
        view = new Fallback(object); }
      else {
        view = constructor.newInstance(object); } }
    catch (InstantiationException e) {
      e.printStackTrace(); }
    catch (IllegalAccessException e) {
      e.printStackTrace(); }
    catch (InvocationTargetException e) {
      e.printStackTrace(); }

    return view; }
  
  public View createView(Filter filter) {
    return createView(filter.getClass(), filter); }
  
  public Constructor<View> getViewConstructor(Class c) {
    Constructor<View> constructor = null;
    /* some reflection references (for those interested)
     *   http://docs.oracle.com/javase/7/docs/api/java/lang/reflect/Constructor.html#newInstance(java.lang.Object...)
     *   http://msdn.microsoft.com/en-us/library/aa986011(v=vs.80).aspx
     *   http://www.javapractices.com/topic/TopicAction.do?Id=237
     *   http://www.javapractices.com/topic/TopicAction.do?Id=113 */
    String className = "se.zarac.lu.sysa.grupp4a.biler.gui.views." + c.getSimpleName();
    try {
      Class<? extends Model>[] viewArguments = new Class[] { c };
      Class<View> viewClass = (Class<View>)Class.forName(className);
      return viewClass.getConstructor(viewArguments); }
    catch (SecurityException e) {
      e.printStackTrace(); }
    catch (NoSuchMethodException e) {
      System.out.println("No specific View '" + className + "'."); }
    catch (IllegalArgumentException e) {
      e.printStackTrace(); }
    catch (ClassNotFoundException e) {
      e.printStackTrace(); }
    
    return constructor; } }