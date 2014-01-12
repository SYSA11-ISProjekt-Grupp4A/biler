package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Model;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.FilterView;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.*;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class Persons extends View implements /*KeyListener, */DocumentListener {
  protected JTextField input;
  protected JPanel output;
  protected JPanel meta;
  protected JLabel metaLabel;
  protected JPanel result;
  protected Biler biler;

  public Persons(GUI gui) {
    super(gui);
    biler = gui.getBiler();

    setLayout(new BorderLayout());

    // input
    JPanel filters = new JPanel();
    filters.setLayout(new GridLayout(0, 1));
    filters.add(new FilterView<Model>(gui, Model.class, this));
    filters.add(new FilterView<Person>(gui, Person.class, this));
    add(filters, BorderLayout.NORTH);

    // output
    output = new JPanel();
    output.setLayout(new BorderLayout());

    meta = new JPanel();
    meta.setLayout(new BorderLayout());
    metaLabel = new JLabel("Haven't found anything yet.");
    metaLabel.setHorizontalAlignment(SwingConstants.CENTER);
    meta.add(metaLabel);
    output.add(metaLabel, BorderLayout.NORTH);

    result = new JPanel();
    result.setLayout(new GridBagLayout());
    output.add(result, BorderLayout.CENTER);

    add(output, BorderLayout.CENTER);
    
    // menu
    add(new Menu(), BorderLayout.SOUTH); }
  
  public void draw() {
    result.removeAll();
    Iterator<Entry<String, Model>> i = biler.indices.get(Person.class).entrySet().iterator();
    int count = 0;
    while (i.hasNext()) {
      Person person = (Person)i.next().getValue();
      System.out.println("## Filter Item " + person);
      if (person.filter(biler)) {
        count++;
        result.add(gui.createView(person, GUI.ViewTypes.Short)); } }
    metaLabel.setText("Found " + count + " persons.");
    super.draw(); }

  @Override
  public void changedUpdate(DocumentEvent arg0) {
    System.out.println("changed update"); }

  @Override
  public void insertUpdate(DocumentEvent arg0) {
    draw(); }

  @Override
  public void removeUpdate(DocumentEvent arg0) {
    draw(); }    

  protected class PersonView extends Button {
    protected se.zarac.lu.sysa.grupp4a.biler.models.Person person;

    public PersonView(se.zarac.lu.sysa.grupp4a.biler.models.Person person) {
      super(person.getName());
      this.person = person; }

    @Override
    public void click() {
      gui.view(person); } }

  public JTextField getInput() {
    return input; }

  @Override
  public void preView() {
    draw(); }
  
  @Override
  public void postView() {
    super.postView(); }

  public class Menu extends JPanel {
    public Menu() {
      add(new Button("Add") {
        public void click() {
          gui.view("AddPerson"); } } ); } } }