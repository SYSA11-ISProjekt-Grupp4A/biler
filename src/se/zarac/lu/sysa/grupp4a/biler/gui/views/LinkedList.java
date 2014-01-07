package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import java.util.Iterator;
import java.util.List;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class LinkedList extends View {
  
  public LinkedList(Object obj, GUI gui) {
    super(gui);
    List<Object> list = (List<Object>)obj;
    Iterator<Object> iterator = list.iterator();
    add(new JLabel("[LinkedList"));
    while (iterator.hasNext()) {
      Object o = iterator.next();
      add(new JLabel("[Object " + o + "]")); }
    add(new JLabel("]")); } }