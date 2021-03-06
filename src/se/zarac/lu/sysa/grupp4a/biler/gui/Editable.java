package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JTextField;

@SuppressWarnings("serial")
public class Editable extends JTextField implements KeyListener {
  public final static Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
  
  protected String saved;
  
  @Override
  public void keyPressed(KeyEvent e) { 
    /* if (e.getKeyCode() != 10) // <ENTER>
      editing(); */ }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == 10) // <ENTER>
      edited();
    else
      editing(); }
  
  @Override
  public void keyTyped(KeyEvent e) { }

  public Editable() {
    this(""); }
  
  public Editable(String string) {
    this(string, border); }
  
  public Editable(String string, String title) {
    this(string, BorderFactory.createTitledBorder(border, title)); }
  
  public Editable(String string, Border border) {
    super();
    this.saved = string;
    setBorder(border);
    setSize(new Dimension(100, getSize().height)); 
    setText(string);
    addKeyListener(this); }

  public void edited() { } 

  public void editing() { } }