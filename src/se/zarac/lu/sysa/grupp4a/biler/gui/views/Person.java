package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Person extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Person person;
  
  public Person(se.zarac.lu.sysa.grupp4a.biler.models.Person person) {
    this.person = person;
    add(new JLabel(person.getName()));
    add(new JLabel(person.getPersonNumber())); } }