package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import se.zarac.lu.sysa.grupp4a.biler.*;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.AddPerson;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Exit;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Splash;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Items;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Persons;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Products;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.About;
import se.zarac.lu.sysa.grupp4a.biler.gui.views.activities.Testicle;
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
  // package paths to types of Views
  public static enum ViewTypes {
    View("se.zarac.lu.sysa.grupp4a.biler.gui.views."),
    Full("se.zarac.lu.sysa.grupp4a.biler.gui.views.full."),
    Short("se.zarac.lu.sysa.grupp4a.biler.gui.views.shorts."), // package cannot be named .short
    Edit("se.zarac.lu.sysa.grupp4a.biler.gui.views.edit.");
    
    protected final String path;
    
    private ViewTypes(final String path) {
      this.path = path; }
    
    public String toString() {
      return path; } };
  
  protected JScrollPane pane;
      
  /**
   * Construct it jao.
   * 
   * @param biler The Biler instance to control.
   */
  public GUI(Biler biler) {
    this.biler = biler;

    // frame (window)
    setTitle(biler.getName());
    setLayout(new BorderLayout());

    // menu
    menu = new Menu(this);
    add(menu, BorderLayout.SOUTH);


    // container, for activities
    container = new JPanel();
    container.setLayout(new GridBagLayout());
    pane = new JScrollPane(container,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    pane.setBorder(View.EmptyBorder);
    pane.setViewportView(container);
    add(pane, BorderLayout.CENTER);

    // initialize singleton Activities (Just some indexed Views)
    activities.put("Splash", new Splash(GUI.this));
    activities.put("About", new About(GUI.this));
    activities.put("Products", new Products(GUI.this));
    activities.put("Items", new Items(GUI.this));
    activities.put("Persons", new Persons(GUI.this));
    activities.put("AddPerson", new AddPerson(GUI.this));
    // TODO activities.put("bookings", new Bookings(GUI.this));
    activities.put("Testicle", new Testicle(GUI.this));
    activities.put("Exit", new Exit(GUI.this));

    setVisible(true);
    
    view("Splash"); }

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
    System.out.println("setComponent(" + component + ")");
    if (!(container.getComponentCount() > 0 && component == container.getComponent(0))) {
      container.removeAll();
      container.add(component); }
    pane.getViewport().revalidate();
    pane.setPreferredSize(new Dimension(container.getPreferredSize().width, component.getPreferredSize().height));
    redraw(); }
  
  /**
   * Force redraw of container.
   * TODO remove? (shouldn't be needed)
   */
  public void redraw() {
    // be JRE6 compliant, don't use revalidate()
    container.invalidate();
    container.validate();
    container.repaint(); }
  
  /**
   * View an Activity from the activities index (singletons).
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
   * @param model The Model, it must have a matching View.
   */
  public void view(Model model) {
    view(model, ViewTypes.Full); }
  
  /**
   * View a Model with a specified view type.
   * 
   * @param model The Model, it must have a matching View of the specified type.
   * @param type The type.
   */
  public void view(Model model, ViewTypes type) {
    view(createView(model, type)); }

  /**
   * View a View then execute its onView().
   * 
   * @param view The View.
   */
  public void view(View view) {
    view.preView();
    setComponent(view);
    view.postView(); }
  
  /**
   * Create a View for an Object.
   * 
   * @param obj The Object to create a View for.
   * @return The View.
   */
  public View createView(Model obj) {
    return createView(obj, ViewTypes.View); }

  /**
   * Create a View for an Object.
   * 
   * @param object The Object (e.g. Model, Filter), it must have a matching View.
   * @param clas The View Type.
   * @return the View
   */
  public View createView(Object object, ViewTypes type) {
    if (object == null) // Cannot view nothing!
      return new Fallback(null, this);
    
    View view = null;
    Constructor<View> constructor = null;
    String className = null;
    try {
      Class<?> clas = object.getClass();
      while (clas != null) {
        className = type.toString() + clas.getSimpleName();
        constructor = getViewConstructor(className);
        // done?
        if (constructor != null) {
          view = constructor.newInstance(object, this);
          break; }
        else
          clas = clas.getSuperclass(); } }
    catch (InstantiationException e) {
      e.printStackTrace(); }
    catch (IllegalAccessException e) {
      e.printStackTrace(); }
    catch (InvocationTargetException e) {
      System.out.println("!");
      System.out.println(object);
      System.out.println(className);
      e.printStackTrace(); }
    
    if (view == null) {
      view = new Fallback(object, this); }
    
    return view; }
  
  protected Constructor<View> getViewConstructor(String className) {
    // TODO Clean.
    Constructor<View> constructor = null;
    /* some reflection references (for those interested)
     *   http://docs.oracle.com/javase/7/docs/api/java/lang/reflect/Constructor.html#newInstance(java.lang.Object...)
     *   http://msdn.microsoft.com/en-us/library/aa986011(v=vs.80).aspx
     *   http://www.javapractices.com/topic/TopicAction.do?Id=237
     *   http://www.javapractices.com/topic/TopicAction.do?Id=113 */
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
    catch (ClassNotFoundException e) { } // It's OK.
      // e.printStackTrace(); }
    
    return constructor; }

  protected class Menu extends JPanel {
    protected GUI gui;

    public Menu(final GUI gui) {
      this.gui = gui;
      
      add(new Button("About") {
        public void click() { Menu.this.gui.view("About"); } } );
      add(new Button("Products") {
        public void click() { Menu.this.gui.view("Products"); } } );
      add(new Button("Items") {
        public void click() { Menu.this.gui.view("Items"); } } );
      add(new Button("Customers") {
        public void click() { Menu.this.gui.view("Persons"); } } );
      add(new Button("Bookings") {
        public void click() { Menu.this.gui.view("Bookings"); } } );
      add(new Button("Testicle") {
        public void click() { Menu.this.gui.view("Testicle"); } } );
      add(new Button("maxa") {
        public void click() {
          if (gui.getExtendedState() != JFrame.MAXIMIZED_BOTH)
            gui.setExtendedState(gui.getExtendedState()|JFrame.MAXIMIZED_BOTH);
          else
            gui.setExtendedState(JFrame.NORMAL); } } );
      add(new Button("Exit") {
        public void click() { Menu.this.gui.view("Exit"); } } ); } } }