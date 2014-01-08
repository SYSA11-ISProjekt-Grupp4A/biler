package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JTextField;

@SuppressWarnings("serial")
public class Editable extends JTextField implements KeyListener {
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

  public Editable() {
    this(""); }
  
  public Editable(String string) {
    this(string, BorderFactory.createEmptyBorder(5, 5, 5, 5)); }
  
  public Editable(String string, String title) {
    this(string, BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), title)); }
  
  public Editable(String string, Border border) {
    super();
    this.saved = string;
    setBorder(border);
    setText(string);
    addKeyListener(this); }

  public void edited() { } 

  public void editing() { } }