package se.zarac.lu.sysa.grupp4a.biler.gui.views.full;

import java.lang.reflect.Field;
import se.zarac.lu.sysa.grupp4a.biler.gui.Button;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class Model extends View {
  protected se.zarac.lu.sysa.grupp4a.biler.Model model;
  
  public Model(final se.zarac.lu.sysa.grupp4a.biler.Model model, final GUI gui) {
    super(gui);
    this.model = model;
    add(new JLabel(model.toString()));
    add(new Button("Edit") {
      public void click() {
        gui.view(Model.this.model, GUI.ViewTypes.Edit); } } );
    for (Field field : model.getClass().getFields()) {
      try {
        if (field.getName() == "filterSettings") continue;
        System.out.println("field.getType()" + field.getType());
        Object f = field.get(model);
        System.out.println("field.get(model)" + f);
        if (f instanceof se.zarac.lu.sysa.grupp4a.biler.Model)
          add(gui.createView(f, GUI.ViewTypes.Short));
        else
          add(new JLabel(field.getName() + " = " + f)); }
      catch (IllegalArgumentException e) {
        e.printStackTrace(); }
      catch (IllegalAccessException e) {
        e.printStackTrace(); } } } }