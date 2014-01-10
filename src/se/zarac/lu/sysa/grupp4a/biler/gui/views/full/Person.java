package se.zarac.lu.sysa.grupp4a.biler.gui.views.full;

import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Person extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Person person;
  
  public Person(final se.zarac.lu.sysa.grupp4a.biler.models.Person person, final GUI gui) {
    super(gui);
    this.person = person;

    add(new JLabel(person.toString()));

    add(new JLabel(person.getName()));

    add(new JLabel(person.getPersonNumber()));

    View view = gui.createView(person.getAddresses(), GUI.ViewTypes.Short);
    System.out.println("view = " + view);
    add(view);
    
    //add(gui.createView(person.getPhoneNumbers(), GUI.ViewTypes.Short));
    
    add(new Button("Edit") {
      public void click() {
        gui.view(person, GUI.ViewTypes.Edit); } } ); } }