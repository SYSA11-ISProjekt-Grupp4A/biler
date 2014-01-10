package se.zarac.lu.sysa.grupp4a.biler.gui.views.edit;

import java.awt.GridLayout;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.Editable;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;

@SuppressWarnings("serial")
public class Person extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Person person;

  protected Editable number;
  protected Editable name;  
  
  public Person(final se.zarac.lu.sysa.grupp4a.biler.models.Person person, final GUI gui) {
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
    
    JPanel row = new JPanel(new GridLayout(1, 0));
    row.add(new Button("Back") {
      public void click() {
        gui.view(person); } } );
    
    row.add(new Button("Save") {
      public void click() {
        Person.this.person.setPersonNumber(number.getText());
        Person.this.person.setName(name.getText());
        biler.save(person); } } );
    
    row.add(new Button("Remove") {
      public void click() {
        Person.this.person.setPersonNumber(number.getText());
        Person.this.person.setName(name.getText());
        biler.remove(person);
        gui.view("Persons"); } } );
    add(row);
    
    /* add(new JLabel("Bookings : "));
    add(gui.createView(gui.getBiler().getBookings())); */ } }