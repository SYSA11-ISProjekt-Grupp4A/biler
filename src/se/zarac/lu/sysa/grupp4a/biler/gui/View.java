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
  
  /**
   * A View of something in Biler.
   * 
   * @param gui The GUI we belong to.
   */
  public View(GUI gui) {
    this.gui = gui; }
  
  /**
   * Called by GUI.view(View) post revalidate() and repaint().
   */
  public void onView() { } }