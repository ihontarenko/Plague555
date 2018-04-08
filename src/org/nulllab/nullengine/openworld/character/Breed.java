package org.nulllab.nullengine.openworld.character;

public class Breed {

  public static final String UNNAMED_BREED = "Unnamed Breed";

  public static final String HEALTH = "HEALTH";
  public static final String MANA = "MANA";

  private String name;
  private Breed  parent;
  private Values values;

  public Breed() {
    this(UNNAMED_BREED);
  }

  public Breed(String name) {
    this.values = new Values();
    this.name = name;
  }

  public Breed(Breed parent, String name) {
    this(name);
    setParentBreed(parent);
  }

  public double getHealth() {
    return getValue(HEALTH);
  }

  public void setHealth(Double health) {
    setValue(HEALTH, health);
  }

  public double getMana() {
    return getValue(MANA);
  }

  public void setMana(Double mana) {
    setValue(MANA, mana);
  }

  public double getValue(String keyName) {
    return values.getValue(keyName);
  }

  public void setValue(String keyName, Double value) {
    values.setValue(keyName, value);
  }

  public Values getValues() {
    return values;
  }

  public String getName() {
    return name;
  }

  public String getFullName() {
    return getFullName("-");
  }

  public String getFullName(String separator) {
    String name = getName();
    Breed parent = getParent();

    while (parent != null) {
      name =  String.format("%s%s%s", name, separator, parent.getName());
      parent = parent.getParent();
    }

    return name;
  }

  public Breed getParent() {
    return parent;
  }

  public void setParentBreed(Breed breed) {
    this.values.addWith(breed.getValues());
    this.parent = breed;
  }

  @Override
  public String toString() {
    return String.format("Breed (%s) {Name: %s, FullName: %s, Values: %s}",
        getClass().getSimpleName(), getName(), getFullName("_"), getValues());
  }
}
