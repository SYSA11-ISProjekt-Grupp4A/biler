package se.zarac.lu.sysa.grupp4a.biler.gui;

import java.lang.reflect.Field;
import java.util.Map;
import se.zarac.lu.sysa.grupp4a.biler.Model;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class FilterView<T extends Model> extends ShortView {
  protected Map<String, Object> settings;
  protected View parent;
  
  public FilterView(final GUI gui, Field field, View parent) {
    super(gui); }

  @SuppressWarnings("unchecked")
  public FilterView(final GUI gui, Class<T> model, View parent) {
    super(gui);
    this.parent = parent;
    //settings = gui.getBiler().getFilterSettings(model);    
    add(new JLabel(model.getSimpleName() + " filters"));
    try {
      Field field = model.getDeclaredField("filterSettings");
      settings = (Map<String, Object>)field.get(null);
      if (settings.size() > 0) {
        for (Map.Entry<String, Object> entry : settings.entrySet()) {
          add(new Setting(gui, entry.getKey(), entry.getValue())); } } }
    catch (NoSuchFieldException e) { }
    catch (IllegalArgumentException e) {
      e.printStackTrace(); }
    catch (IllegalAccessException e) {
      e.printStackTrace(); }
    
    /* for (Field field : class1.getDeclaredFields()) {
      System.out.println("FIELD = " + field.getType());
      if (field.getName() == "serialVersionUID") continue;
      if (field.getType() == String.class) {
        System.out.println("IT IS A STRING!!");
        add(new Editable("", field.getName()) {
          public void edited() {
            System.out.println("EDITED");
            gui.reDraw(); } } ); }
      else if (field.getType() == int.class) {
        System.out.println("IT IS AN INTEGER!!");
        add(new Editable("", field.getName())); }
      else {
        add(new JLabel("." + field.getName())); } } */ }
  
  protected class Setting extends View {
    public Setting(final GUI gui, final String key, Object value) {
      super(gui);
      add(new Editable(value.toString(), key) {
        public void editing() {
          settings.put(key, getText());
          if (parent != null) {
            parent.update();
            parent.draw(); } } } ); } } }