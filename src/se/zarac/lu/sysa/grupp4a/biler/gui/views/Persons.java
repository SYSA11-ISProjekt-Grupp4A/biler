package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class Persons extends View implements /*KeyListener, */DocumentListener {
  protected GUI gui;
  protected Biler biler;
  protected JTextField input;
  protected JPanel output;
  protected JPanel meta;
  protected JLabel metaLabel;
  protected JPanel result;

  public Persons(GUI gui) {
    super();
    this.gui = gui;
    this.biler = gui.getBiler();

    //setBackground(Color.BLACK);
    setLayout(new BorderLayout());

    // input
    input = new JTextField();
    input.getDocument().addDocumentListener(this);    
    add(input, BorderLayout.NORTH);

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
    result.setLayout(new FlowLayout());
    output.add(result, BorderLayout.CENTER);

    add(output, BorderLayout.CENTER);
    
    // do initial empty search
    findPerson(); }

  public void findPerson() {
    // what to find
    String key = input.getText();
    // find it/them
    List<se.zarac.lu.sysa.grupp4a.biler.models.Person> matches = biler.findPerson(key);
    // draw it/them
    metaLabel.setText("Found " + matches.size() + " persons.");
    result.removeAll();
    Iterator<se.zarac.lu.sysa.grupp4a.biler.models.Person> p = matches.iterator();
    while (p.hasNext()) {
      result.add(new PersonView(p.next())); }

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

  protected class PersonView extends JButton implements MouseListener {
    protected se.zarac.lu.sysa.grupp4a.biler.models.Person person;

    public PersonView(se.zarac.lu.sysa.grupp4a.biler.models.Person person) {
      super(person.getName());
      this.person = person;
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
    public void mouseReleased(MouseEvent arg0) { } }

  public JTextField getInput() {
    return input; } }