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
    GridLayout gl = new GridLayout(1, 0);
    gl.setVgap(5);
    gl.setHgap(5);
    setLayout(gl);
    setBorder(border); } }