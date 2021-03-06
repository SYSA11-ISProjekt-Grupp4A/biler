package se.zarac.lu.sysa.grupp4a.biler.gui.views.activities;

import java.awt.GridBagLayout;
import java.util.Timer;
import java.util.TimerTask;
import se.zarac.lu.sysa.grupp4a.biler.gui.GUI;
import se.zarac.lu.sysa.grupp4a.biler.gui.View;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JLabel;
import se.zarac.lu.sysa.grupp4a.biler.gui.styles.handson.JPanel;

@SuppressWarnings("serial")
public class Splash extends View {
  protected String text;
  protected int milliseconds;
  protected JPanel panel;
  protected JLabel label;
  
  /**
   * Splash something.
   * 
   * @param gui Because it's a View.
   */
  public Splash(GUI gui) {
    this(gui, "Herrow! o/", 5000); }
  
  /**
   * Splash something.
   * 
   * @param gui Because it's a View.
   * @param text The text to splash.
   * @param seconds For how long.
   */
  public Splash(GUI gui, String text, int milliseconds) {
    super(gui);
    this.text = text;
    this.milliseconds = milliseconds;
    setLayout(new GridBagLayout());
    label = new JLabel(text);
    add(label); }
    
  @Override
  public void postView() {
    super.postView();
    timeOut(milliseconds); }
  
  protected void timeOut(int seconds) {
    Timer timer = new Timer();
    timer.schedule(new Task(timer), milliseconds); }

  protected class Task extends TimerTask {
    protected Timer timer;
    
    public Task(Timer timer) {
      this.timer = timer; }

    public void run() {
      gui.view("About");
      timer.cancel(); } } }