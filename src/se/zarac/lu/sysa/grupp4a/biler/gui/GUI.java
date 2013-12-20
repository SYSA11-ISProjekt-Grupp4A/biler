package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.models.Booking;
import se.zarac.lu.sysa.grupp4a.biler.models.Person;

@SuppressWarnings("serial")
public class GUI extends JFrame {
  protected Biler biler;

  // ze aktivitiez
  protected JPanel personFinder;

  public GUI(Biler biler) {
    this.biler = biler;
    setSize(640, 480);
    //        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
    setResizable(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(0, 1));
    personFinder = new PersonFinder(this);
    add(personFinder);
    // TODO bug-1 : needs to be set here AND after JFrame is instantiated
    setVisible(true); }

  public Biler getBiler() {
    return biler; }

  public void view(Person person) {
    getContentPane().removeAll();
    add(new PersonView(person));
    revalidate(); }

  public void view(Booking booking) {
    removeAll();
    System.out.println("!NI!" + booking); } }