package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import se.zarac.lu.sysa.grupp4a.biler.*;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Exit;
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
  public Map<String, View> activities = new HashMap<String, View>();
  
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

    // init. activities
    activities.put("Splash", new Splash(GUI.this, "Herrow! o/", 1500));
    activities.put("About", new About(GUI.this));
    activities.put("Products", new Products(GUI.this));
    activities.put("Items", new Items(GUI.this));
    activities.put("Persons", new Persons(GUI.this));
    // TODO activities.put("bookings", new Bookings(GUI.this));
    activities.put("Exit", new Exit(GUI.this));

    view("Splash");
    
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
    if (component == null)
      container.add(new JLabel("Cannot setComponent(null)"));
    else
      container.add(component);
    // be JRE6 compliant, don't use revalidate()
    container.invalidate();
    container.validate();
    container.repaint(); }
  
  /**
   * View an Activity from the activities index.
   * 
   * @param activity The Activity.
   */
  public void view(String activity) {
    View view = activities.get(activity);
    if (view == null)
      setComponent(new JLabel("[The activity '" + activity + "' was not found.]"));
    else
      view(view); }
  
  /**
   * View a Model.
   * 
   * @param model The Model, it must have a matching View. */
  public void view(Model model) {
    setComponent(createView(model.getClass(), model)); }

  /**
   * View a View then execute its onView().
   * 
   * @param view The View. */
  public void view(View view) {
    setComponent(view);
    view.onView(); }
  
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
        public void click() { Menu.this.gui.view("Splash"); } } );
      add(new Button("Products") {
        public void click() { Menu.this.gui.view("Products"); } } );
      add(new Button("Items") {
        public void click() { Menu.this.gui.view("Items"); } } ); 
      add(new Button("Customers") {
        public void click() { Menu.this.gui.view("Persons"); } } ); 
      add(new Button("Bookings") {
        public void click() { Menu.this.gui.view("Bookings"); } } ); 
      add(new Button("Exit") {
        public void click() { Menu.this.gui.view("Exit"); } } ); } } }