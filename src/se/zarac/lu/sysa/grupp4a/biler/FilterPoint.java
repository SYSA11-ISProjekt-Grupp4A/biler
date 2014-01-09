package se.zarac.lu.sysa.grupp4a.biler;

import java.lang.reflect.Field;

public class FilterPoint {
  protected Field field;
  public FilterPoint(Field field) {
    System.out.println("FilterPoint(" + field + ") : " + field.getClass().getSimpleName());
    System.out.println(this.field.getClass().getSimpleName());
    this.field = field; } }