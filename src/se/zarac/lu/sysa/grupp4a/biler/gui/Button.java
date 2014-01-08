package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JButton;

@SuppressWarnings("serial")
public abstract class Button extends JButton implements ActionListener {
  public abstract void click();
  
  public Button(String string) {
    super(string);
    Border border = BorderFactory.createEmptyBorder(7, 10, 7, 10);
    setBorder(border);
    addActionListener(this); }

  @Override
  public void actionPerformed(ActionEvent e) {
    click(); } }
