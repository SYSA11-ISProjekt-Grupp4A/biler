package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JButton;

@SuppressWarnings("serial")
public abstract class Button extends JButton implements ActionListener {
  public abstract void click();
  
  public Button(String string) {
    super(string);
    addActionListener(this); }

  @Override
  public void actionPerformed(ActionEvent e) {
    click(); } }
