package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import se.zarac.lu.sysa.grupp4a.biler.gui.Editable;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;

@SuppressWarnings("serial")
public class Person extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Person person;

  protected Editable number;
  protected Editable name;  
  
  public Person(final se.zarac.lu.sysa.grupp4a.biler.models.Person person, GUI gui) {
    super(gui);
    this.person = person;

    number = new Editable(person.getPersonNumber()) {
      public void edited() {
        Person.this.person.setPersonNumber(getText());
        person.save(); } };
    add(number);
        
    name = new Editable(person.getName()) {
      public void edited() {
        Person.this.person.setName(getText());
        person.save(); } };
    add(name);
    
    /* add(new JLabel("Bookings : "));
    add(gui.createView(gui.getBiler().getBookings())); */ } }