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
    // TODO remove (and save when needed)
    gui.getBiler().saveEverything();
    System.out.println("# Good bye! :)");
    System.exit(0); } }