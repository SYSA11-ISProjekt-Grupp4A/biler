package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Item extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.models.Item item;
  
  public Item(final se.zarac.lu.sysa.grupp4a.biler.models.Item item, final GUI gui) {
    super(gui);
    this.item = item;
    add(new Button("Edit") {
      public void click() {
        gui.view(item, GUI.ViewTypes.Edit); } } );
    add(new Button("Full") {
      public void click() {
        gui.view(item, GUI.ViewTypes.Full); } } );
    add(new Button("Short") {
      public void click() {
        gui.view(item, GUI.ViewTypes.Short); } } );
    add(new Button("View") {
      public void click() {
        gui.view(item, GUI.ViewTypes.View); } } );
    add(new JLabel(item.toString())); } }