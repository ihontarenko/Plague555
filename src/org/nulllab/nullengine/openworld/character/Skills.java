package org.nulllab.nullengine.openworld.character;

public class Skills {

  public static final String VITALITY     = "VITALITY";
  public static final String STRENGTH     = "STRENGTH";
  public static final String DEXTERITY    = "DEXTERITY";
  public static final String ATTACK       = "ATTACK";
  public static final String DEFENSE      = "DEFENSE";
  public static final String INTELLIGENCE = "INTELLIGENCE";

  private Values values;

  public Skills() {
    this.values = new Values();
  }

  public void setVitality(Double value) {
    values.setValue(VITALITY, value);
  }

  public void setStrength(Double value) {
    values.setValue(STRENGTH, value);
  }

  public void setDexterity(Double value) {
    values.setValue(DEXTERITY, value);
  }

  public void setAttack(Double value) {
    values.setValue(ATTACK, value);
  }

  public void setDefense(Double value) {
    values.setValue(DEFENSE, value);
  }

  public void setIntelligence(Double value) {
    values.setValue(INTELLIGENCE, value);
  }

  public Double getVitality() {
    return values.getValue(VITALITY);
  }

  public Double getStrength() {
    return values.getValue(STRENGTH);
  }

  public Double getDexterity() {
    return values.getValue(DEXTERITY);
  }

  public Double getAttack() {
    return values.getValue(ATTACK);
  }

  public Double getDefense() {
    return values.getValue(DEFENSE);
  }

  public Double getIntellegence() {
    return values.getValue(INTELLIGENCE);
  }

  public Values getValues() {
    return values;
  }

}
