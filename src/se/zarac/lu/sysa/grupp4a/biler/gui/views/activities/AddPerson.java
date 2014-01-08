package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.Editable;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JButton;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JTextField;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;

@SuppressWarnings("serial")
public class AddPerson extends View {
  protected Button save;
  protected JTextField number;
  protected JTextField name;
  
  public AddPerson(final GUI gui) {
    super(gui);
    setLayout(new GridLayout(0, 1));
    number = new Editable();
    add(new JLabel("Person Number"));
    add(number);
    name = new Editable("");
    add(new JLabel("Name"));
    add(name);
    add(new JLabel(""));
    add(new Button("Add") {
      @Override
      public void click() {
        Person person = new Person(number.getText(), name.getText());
        gui.getBiler().add(person);
        person.save();
        gui.view(person); } } ); }
  
  @Override
  public void postView() {
    super.postView();
    number.setText(""); 
    name.setText(""); } }