package se.zarac.lu.sysa.grupp4a.biler.gui.views.edit;

import java.awt.GridLayout;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;

@SuppressWarnings("serial")
public class Model extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.Model model;
  
  public Model(final se.zarac.lu.sysa.grupp4a.biler.Model model, final GUI gui) {
    super(gui);
    this.model = model;
    add(new JLabel(model.toString()));
    add(new JLabel("I don't know what to edit, 'cause I'm just a basic Model Edit View."));
    JPanel menu = new JPanel(new GridLayout(0, 1));
    menu.add(new Button("Remove") {
      public void click() {
        System.out.println("remove it");
        biler.remove(Model.this.model); } } );
    add(menu); } }