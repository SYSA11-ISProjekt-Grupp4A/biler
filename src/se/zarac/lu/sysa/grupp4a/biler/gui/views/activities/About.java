package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.GridLayout;
import java.util.Map;
import se.zarac.lu.sysa.grupp4a.biler.Biler;
import se.zarac.lu.sysa.grupp4a.biler.Model;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;

@SuppressWarnings("serial")
public class About extends View {
  protected Biler biler;
  
  public About(GUI gui) {
    super(gui);
    biler = gui.getBiler();
    setLayout(new GridLayout(0,1)); }

  @Override
  public void preView() {
    super.preView();
    setInformation(); }
  
  protected void setInformation() {
    removeAll();

    add(new JLabel("Name : " + biler.getName()));
    add(new JLabel("Version : " + Biler.VERSION));
    add(new JLabel("Source : https://github.com/SYSA11-ISProjekt-Grupp4A/biler"));
    add(new JLabel("Authors : " + Biler.AUTHORS));
    add(new JLabel(""));

    for (Map.Entry<Class<Model>, Map<String, Model>> index : biler.indices.entrySet()) {
      add(new JLabel(index.getKey().getSimpleName() + " : " + index.getValue().size())); } } }