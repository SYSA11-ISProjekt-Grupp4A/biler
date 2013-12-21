package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JButton;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;

public class Menu extends JPanel {
  protected GUI gui;

  public Menu(GUI gui) {
    this.gui = gui;
    add(new Button("About", GUI.Activity.ABOUT));
    add(new Button("Products", GUI.Activity.PRODUCTS));
    add(new Button("Items", GUI.Activity.ITEMS)); 
    add(new Button("Customers", GUI.Activity.PERSONS));
    add(new Button("Bookings", GUI.Activity.BOOKINGS)); 
    add(new Button("Exit", GUI.Activity.EXIT)); }

  public class Button extends JButton implements ActionListener {
    protected GUI.Activity activity;
    
    public Button(String text, GUI.Activity activity) {
      super(text);
      this.activity = activity; 
      addActionListener(this); }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      gui.view(activity); } } }