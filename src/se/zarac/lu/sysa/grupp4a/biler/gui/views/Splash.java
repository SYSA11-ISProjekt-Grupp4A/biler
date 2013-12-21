package se.zarac.lu.sysa.grupp4a.biler.gui.views;

import java.awt.GridBagLayout;
import java.util.Timer;
import java.util.TimerTask;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;

@SuppressWarnings("serial")
public class Splash extends View {
  protected GUI gui;
  protected Timer timer;
  protected Task task;
  protected String text;
  protected JPanel panel;
  protected JLabel label;
  
  public Splash(GUI gui, String text) {
    this.gui = gui;
    this.text = text;
    task = new Task();
    panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    label = new JLabel(text);
    panel.add(label);
    // TODO center that sh1zn1t
    //text.setHorizontalAlignment(JLabel.CENTER);
    //text.setVerticalAlignment(JLabel.CENTER);
    //text.setVerticalTextPosition(JLabel.CENTER);
    //setAlignmentY(CENTER_ALIGNMENT);
    add(panel); }
  
  public void timeOut(int seconds) {
    timer = new Timer();
    timer.schedule(task, seconds * 1000); }
  
  protected class Task extends TimerTask {
    public void run() {
      gui.view(GUI.DEFAULT_ACTIVITY);
      timer.cancel(); } } }