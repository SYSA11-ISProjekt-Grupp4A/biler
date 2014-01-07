package se.zarac.lu.sysa.grupp4a.biler.gui;

import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;

/**
 * Something to view our Model(s).
 * 
 * @author zarac
 */
@SuppressWarnings("serial")
public abstract class View extends JPanel {
  protected GUI gui;
  
  public View(GUI gui) {
    this.gui = gui; }
  
  public void onView() {
    System.out.println("[onView() not implemented]"); } }