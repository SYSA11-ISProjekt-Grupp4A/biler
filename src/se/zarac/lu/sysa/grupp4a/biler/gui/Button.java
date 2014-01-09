package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JButton;

@SuppressWarnings("serial")
public abstract class Button extends JButton implements ActionListener {
  public final static Border border = BorderFactory.createCompoundBorder(
      BorderFactory.createEmptyBorder(3, 5, 3, 5),
      BorderFactory.createEmptyBorder(3, 5, 3, 5));
  
  public abstract void click();
  
  public Button(String string) {
    super(string);
    setBorder(border);
    addActionListener(this); }

  @Override
  public void actionPerformed(ActionEvent e) {
    click(); } }
