package se.zarac.lu.sysa.grupp4a.biler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Model implements Serializable {
  private static final long serialVersionUID = 5678656957190670757L;
  
  public static Map<String, Object> filterSettings;
  static {
    filterSettings = new HashMap<String, Object>();
    filterSettings.put("id", new String()); }
  
  protected String id;

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    return (id.equals(((Model)obj).getId())); }

  public Model() {
    this(UUID.randomUUID().toString()); }
  
  public Model(String id) {
    this.id = id; }

  // TODO passing biler is kinda nasty, but works for now.
  //  having to pass a reference to each Model is also nasty (and brings serialization issues)
  //  making the Models inner classes of Biler brings the same serialization issues (but nice Model instantiation, e.g. biler.new Product())
  public boolean filter(Biler biler) {
    System.out.println("Model.filter() " + this + filterSettings); 
    String val = (String)filterSettings.get("id");
    if (val.length() > 0
        && Model.this.id.indexOf((String)filterSettings.get("id")) < 0) {
      return false; }
    
    System.out.println("Model.filter() passed " + this);
    return true; }

  public String getId() {
    return id; }

  public String toString() {
    return "{" + getClass().getSimpleName() + ":" + hashCode() + ":" + id + "}"; } }