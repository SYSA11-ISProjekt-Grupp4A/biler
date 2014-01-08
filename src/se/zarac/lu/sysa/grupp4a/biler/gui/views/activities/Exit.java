package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;

@SuppressWarnings("serial")
public class Exit extends View {
  
  public Exit(GUI gui) {
    super(gui); }

  @Override
  public void preView() {
    super.preView();
    gui.getBiler().saveEverything();
    System.exit(0); } }