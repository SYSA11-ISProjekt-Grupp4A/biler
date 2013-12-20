package se.zarac.lu.sysa.grupp4a.biler.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;

@SuppressWarnings("serial")
public class PersonView extends JPanel {
  protected Person person;
  
  public PersonView(Person person) {
    this.person = person;
    add(new JLabel(person.getName())); } }