package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JTextField;

@SuppressWarnings("serial")
public abstract class Editable extends JTextField implements KeyListener {
  protected String saved;
  
  @Override
  public void keyPressed(KeyEvent e) { 
    if (e.getKeyCode() != 10) // <ENTER>
      editing(); }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == 10) // <ENTER>
      edited(); }
  
  @Override
  public void keyTyped(KeyEvent e) { }

  public Editable(String string) {
    super();
    this.saved = string;
    setText(string);
    addKeyListener(this); }

  public abstract void edited(); 

  public void editing() { } }