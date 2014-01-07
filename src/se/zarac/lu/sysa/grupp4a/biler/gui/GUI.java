package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JComponent;
import se.zarac.lu.sysa.grupp4a.biler.*;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Splash;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Items;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Persons;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Products;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.About;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.*;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.Fallback;

/**
 * A Graphical User Interface (GUI) for Biler.
 * 
 * @author zarac
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {
  protected Biler biler;
  protected JPanel container; // for the activities, or something
  protected Menu menu;
  // activities / modes
  public static enum Activity { SPLASH, ABOUT, PRODUCTS, ITEMS, PERSONS, 
    PERSON_ADD, BOOKINGS, EXIT };
  public static Activity DEFAULT_ACTIVITY = Activity.ABOUT;
  protected Splash splash;
  protected About about;
  protected Products products;
  protected Items items;
  protected Persons persons;
  // TODO protected Bookings bookings;
  
  /**
   * Construct it jao.
   * 
   * @param biler The Biler instance to control.
   */
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
    about = new About(this);
    products = new Products(this);
    items = new Items(this);
    persons = new Persons(this);
    // TODO bookings = new Bookings(this);
    
    view(Activity.SPLASH);
    
    // TODO bug-gui-visible : needs to be set here AND after JFrame is instantiated
    setVisible(true); }

  /**
   * Get the Biler instance the GUI is attached to.
   * 
   * @return The Biler instance.
   */
  public Biler getBiler() {
    return biler; }

  /**
   * Direct access to set a JComponent in the main container.
   * 
   * @param component The JComponent.
   */
  public void setComponent(JComponent component) {
    container.removeAll();
    container.add(component);
    // be JRE6 compliant, don't use revalidate()
    container.invalidate();
    container.validate();
    container.repaint(); }
  
  /**
   * View an Activity.
   * @param activity The Activity.
   */
  public void view(Activity activity) {
    switch(activity) {
      case SPLASH:
        setComponent(splash);
        // TODO bug-timer, cannot be used twice
        splash.timeOut(1);
        break;
      case ABOUT:
        setComponent(about);
        break;
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
   * Shortcut for setComponent().
   * 
   * @param component The JComponent. */
  public void view(JComponent component) {
    setComponent(component); }
  
  /**
   * View a Model.
   * 
   * @param model The Model, it must have a matching View. */
  public void view(Model model) {
    setComponent(createView(model.getClass(), model)); }
  
  /**
   * Create a View for an Object.
   * 
   * @param obj The Object to create a View for.
   * @return The View.
   */
  public View createView(Object obj) {
    return createView(obj.getClass(), obj); }
  
  /**
   * Create a View for a Model.
   *   find out what type of model it is
   *   create a view for that type
   * 
   * @param model The Model, it must have a matching View. */
  protected View createView(Class<?> clas, Object object) {
    View view = null;
    try {
      Constructor<View> constructor = getViewConstructor(clas);
      if (constructor == null) {
        System.out.println("View constructor not found for '" + object + "'.");
        view = new Fallback(object, this); }
      else {
        view = constructor.newInstance(object, this); } }
    catch (InstantiationException e) {
      e.printStackTrace(); }
    catch (IllegalAccessException e) {
      e.printStackTrace(); }
    catch (InvocationTargetException e) {
      e.printStackTrace(); }

    return view; }
  
  protected Constructor<View> getViewConstructor(Class<?> c) {
    // TODO Clean.
    Constructor<View> constructor = null;
    /* some reflection references (for those interested)
     *   http://docs.oracle.com/javase/7/docs/api/java/lang/reflect/Constructor.html#newInstance(java.lang.Object...)
     *   http://msdn.microsoft.com/en-us/library/aa986011(v=vs.80).aspx
     *   http://www.javapractices.com/topic/TopicAction.do?Id=237
     *   http://www.javapractices.com/topic/TopicAction.do?Id=113 */
    String className = "se.zarac.lu.sysa.grupp4a.biler.gui.views." + c.getSimpleName();
    //System.out.println("simple name " + c.getSimpleName());
    /* Class<?>[] viewArguments = new Class<?>[] { (new Object()).getClass(), getClass() };
    System.out.println("arguments " + viewArguments[0] + viewArguments[1]); */
    try {
      @SuppressWarnings("unchecked")
      Class<View> viewClass = (Class<View>)Class.forName(className);
      @SuppressWarnings("unchecked")
      Constructor<View>[] cons = (Constructor<View>[])viewClass.getConstructors();
      //System.out.println("returning constructor : " + cons[0]);
      constructor = cons[0];
      /* System.out.println("constructors " + cons.length + cons[0]);
      return viewClass.getConstructor(viewArguments); */ }
    catch (SecurityException e) {
      e.printStackTrace(); }
    /* catch (NoSuchMethodException e) {
      System.out.println("No specific View '" + className + "' with arguments '" + viewArguments + "'."); } */
    catch (IllegalArgumentException e) {
      e.printStackTrace(); }
    catch (ClassNotFoundException e) {
      e.printStackTrace(); }
    
    return constructor; }

  protected class Menu extends JPanel {
    protected GUI gui;

    public Menu(GUI gui) {
      this.gui = gui;

      add(new Button("About") {
        public void click() { Menu.this.gui.view(GUI.Activity.ABOUT); } } );
      add(new Button("Products") {
        public void click() { Menu.this.gui.view(GUI.Activity.PRODUCTS); } } );
      add(new Button("Items") {
        public void click() { Menu.this.gui.view(GUI.Activity.ITEMS); } } ); 
      add(new Button("Customers") {
        public void click() { Menu.this.gui.view(GUI.Activity.PERSONS); } } ); 
      add(new Button("Bookings") {
        public void click() { Menu.this.gui.view(GUI.Activity.BOOKINGS); } } ); 
      add(new Button("Exit") {
        public void click() { Menu.this.gui.view(GUI.Activity.EXIT); } } ); } } }