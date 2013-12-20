package se.zarac.lu.sysa.grupp4a.biler.gui;

import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class PersonFinder extends JPanel implements /*KeyListener, */DocumentListener {
  protected GUI gui;
  protected Biler biler;
  protected JTextField input;
  protected JPanel output;
  protected JPanel meta;
  protected JLabel metaLabel;
  protected JPanel result;

  public PersonFinder(GUI gui) {
    this.gui = gui;
    this.biler = gui.getBiler();

    setLayout(new BorderLayout());

    input = new JTextField();
    input.getDocument().addDocumentListener(this);

    output = new JPanel();
    output.setLayout(new BorderLayout());

    meta = new JPanel();
    meta.setLayout(new BorderLayout());
    metaLabel = new JLabel("Haven't found anything yet.");
    metaLabel.setHorizontalAlignment(SwingConstants.CENTER);
    meta.add(metaLabel);
    output.add(metaLabel, BorderLayout.NORTH);

    result = new JPanel();
    result.setLayout(new FlowLayout());
    output.add(result, BorderLayout.CENTER);

    add(input, BorderLayout.NORTH);
    add(output, BorderLayout.CENTER);
    findPerson(); }

  public void findPerson() {
    String key = input.getText();
    List<Person> matches = biler.findPerson(key);
    metaLabel.setText("Found " + matches.size() + " persons.");
    result.removeAll();
    Iterator<Person> p = matches.iterator();
    System.out.println("matches for " + key + ": " + matches);
    while (p.hasNext()) {
      Person person = p.next();
      PersonView view = new PersonView(person);
      result.add(view); }

    result.revalidate();
    result.repaint(); }

  /* @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent arg0) { }

    @Override
    public void keyTyped(KeyEvent arg0) { } */

  @Override
  public void changedUpdate(DocumentEvent arg0) {
    System.out.println("changed update"); }

  @Override
  public void insertUpdate(DocumentEvent arg0) {
    findPerson(); }

  @Override
  public void removeUpdate(DocumentEvent arg0) {
    findPerson(); }    

  protected class PersonView extends JLabel implements MouseListener {
    protected Person person;

    public PersonView(Person person) {
      this.person = person;
      setText(person.getName());
      addMouseListener(this); }

    @Override
    public void mouseClicked(MouseEvent arg0) {
      gui.view(person); }

    @Override
    public void mouseEntered(MouseEvent arg0) { }

    @Override
    public void mouseExited(MouseEvent arg0) { }

    @Override
    public void mousePressed(MouseEvent arg0) { }

    @Override
    public void mouseReleased(MouseEvent arg0) { } } }