package se.zarac.lu.sysa.grupp4a.biler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Model implements Serializable {
  private static final long serialVersionUID = 5678656957190670757L;
  protected String id;
  
  public static Map<String, Object> filterSettings;
  static {
    filterSettings = new HashMap<String, Object>();
    filterSettings.put("id", new String()); }

  public Model() { 
    this(UUID.randomUUID().toString()); }
  
  public Model(String id) {
    this.id = id; }

  public boolean filter() {
    System.out.println("Model.filter() " + this); 
    String val = (String)filterSettings.get("id");
    if (val.length() > 0
        && Model.this.id.indexOf((String)filterSettings.get("id")) < 0) {
      return false; }
    
    System.out.println("Model.filter() passed " + this);
    return true; }

  public String getId() {
    return id; }

  public String toString() {
    return "{" + getClass().getSimpleName() + ":" + id + "}"; } }