package se.zarac.lu.sysa.grupp4a.biler.gui.views.shorts;

import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;

@SuppressWarnings("serial")
public class Person extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Person person;
  
  public Person(final se.zarac.lu.sysa.grupp4a.biler.models.Person person, final GUI gui) {
    super(gui);
    this.person = person;
    add(new Button(person.getName()) {
      public void click() {
        gui.view(person, GUI.ViewTypes.Full); } } ); } }