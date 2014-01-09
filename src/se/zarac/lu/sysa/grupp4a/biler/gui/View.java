package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;

/**
 * Something to view our Model(s).
 * 
 * @author zarac
 */
@SuppressWarnings("serial")
public abstract class View extends JPanel {
  protected GUI gui;
  public final static Border EmptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
  public final static Border border = BorderFactory.createCompoundBorder(
      BorderFactory.createEmptyBorder(5, 5, 5, 5),
      BorderFactory.createEmptyBorder(0, 0, 0, 0));
  
  
  /**
   * A View of something in Biler.
   * 
   * @param gui The GUI we belong to.
   */
  public View(GUI gui) {
    this.gui = gui;
    setLayout(new GridLayout(0, 1));
    setBorder(border); }
  
  /**
   * Called by GUI.view(View) pre revalidate() and repaint().
   */
  public void preView() { }
  
  /**
   * Called by GUI.view(View) post revalidate() and repaint().
   */
  public void postView() { }
  
  public void draw() {
    invalidate();
    validate();
    repaint(); } }