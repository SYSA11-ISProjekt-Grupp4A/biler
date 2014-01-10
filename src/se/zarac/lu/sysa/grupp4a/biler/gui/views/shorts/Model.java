package se.zarac.lu.sysa.grupp4a.biler.gui.views.shorts;

import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;

@SuppressWarnings("serial")
public class Model extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.Model model;
  
  public Model(final se.zarac.lu.sysa.grupp4a.biler.Model model, final GUI gui) {
    super(gui);
    this.model = model;
    add(new Button(model.toString()) {
      public void click() {
        gui.view(Model.this.model, GUI.ViewTypes.Full); } } ); } }