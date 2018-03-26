package org.nulllab.nullengine.openworld.character;

abstract public class Breed {

  public static final String HEALTH_KEY = "health";

  private String name;
  private Breed  parent;
  private Values values;

  public Breed(double health, String name) {
    this.values = new Values();
    this.values.setValue(HEALTH_KEY, health);
    this.name = name;
  }

  public Breed(Breed parent, double health, String name) {
    this(health, name);
    setParentBreed(parent);
  }

  public Values getValues() {
    return values;
  }

  public Breed getParent() {
    return parent;
  }

  public void setParentBreed(Breed breed) {
    this.values.foldWith(breed.getValues());
  }

  public double getHealth() {
    return getValues().getValue(HEALTH_KEY);
  }

}
