package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.Color;

/**
 * Something to view our Model(s).
 * 
 * @author zarac
 */
@SuppressWarnings("serial")
public abstract class ShortView extends View {  
  /**
   * A Short View (less detailed) of something in Biler.
   * 
   * @param gui The GUI we belong to.
   */
  public ShortView(GUI gui) {
    super(gui);
    setLayout(new GridLayout(1, 0));
    setBorder(BorderFactory.createLineBorder(Color.DARK_DAYS)); } }