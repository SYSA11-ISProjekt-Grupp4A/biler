package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import java.awt.GridLayout;
import se.zarac.lu.sysa.grupp4a.biler.gui.Editable;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Person extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Person person;

  protected Editable number;
  protected Editable name;  
  
  public Person(final se.zarac.lu.sysa.grupp4a.biler.models.Person person, GUI gui) {
    super(gui);
    this.person = person;
    
    setLayout(new GridLayout(0, 1));

    add(new JLabel("Person Number"));
    number = new Editable(person.getPersonNumber()) {
      public void edited() {
        Person.this.person.setPersonNumber(getText());
        biler.save(person); } };
    add(number);

    add(new JLabel("Name"));
    name = new Editable(person.getName()) {
      public void edited() {
        Person.this.person.setName(getText());
        biler.save(person); } };
    add(name);
    
    add(new JLabel("Press <ENTER> to save field."));
    
    /* add(new JLabel("Bookings : "));
    add(gui.createView(gui.getBiler().getBookings())); */ } }