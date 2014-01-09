package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Something to view our Model(s).
 * 
 * @author zarac
 */
@SuppressWarnings("serial")
public abstract class ShortView extends View {
  public final static Border border = BorderFactory.createCompoundBorder(
      BorderFactory.createEmptyBorder(2, 2, 2, 2),
      BorderFactory.createEmptyBorder(2, 2, 2, 2));
  
  /**
   * A Short View (less detailed) of something in Biler.
   * 
   * @param gui The GUI we belong to.
   */
  public ShortView(GUI gui) {
    super(gui);
    GridLayout layout = new GridLayout(1, 0);
    layout.setVgap(5);
    layout.setHgap(5);
    setLayout(layout);
    setBorder(border); } }