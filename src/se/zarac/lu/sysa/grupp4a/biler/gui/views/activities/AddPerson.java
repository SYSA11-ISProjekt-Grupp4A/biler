package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JButton;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JTextField;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;

@SuppressWarnings("serial")
public class AddPerson extends View implements ActionListener {
  protected JButton save;
  protected JTextField number;
  protected JTextField name;
  
  public AddPerson(GUI gui) {
    super(gui);
    setLayout(new GridLayout(0, 1));
    number = new JTextField();
    add(number);
    name = new JTextField();
    add(name);
    save = new JButton("Save");
    save.addActionListener(this);
    add(save); }
  
  @Override
  public void onView() {
    super.onView(); }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    Person person = new Person(number.getText(), name.getText());
    System.out.println("Person = " + person);
    gui.getBiler().add(person);
    gui.view(person); } }