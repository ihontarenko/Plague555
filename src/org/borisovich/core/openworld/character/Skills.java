package org.borisovich.core.openworld.character;

import org.borisovich.core.core.values.DoubleValues;

@SuppressWarnings("unused")
public class Skills extends DoubleValues {

  public static final String VELOCITY     = "VELOCITY";
  public static final String VITALITY     = "VITALITY";
  public static final String STRENGTH     = "STRENGTH";
  public static final String DEXTERITY    = "DEXTERITY";
  public static final String ATTACK       = "ATTACK";
  public static final String DEFENSE      = "DEFENSE";
  public static final String INTELLIGENCE = "INTELLIGENCE";

  public void setIntelligence(Double value) {
    setValue(INTELLIGENCE, value);
  }

  public Double getVitality() {
    return getValue(VITALITY);
  }

  public void setVitality(Double value) {
    setValue(VITALITY, value);
  }

  public Double getStrength() {
    return getValue(STRENGTH);
  }

  public void setStrength(Double value) {
    setValue(STRENGTH, value);
  }

  public Double getDexterity() {
    return getValue(DEXTERITY);
  }

  public void setDexterity(Double value) {
    setValue(DEXTERITY, value);
  }

  public Double getAttack() {
    return getValue(ATTACK);
  }

  public void setAttack(Double value) {
    setValue(ATTACK, value);
  }

  public Double getDefense() {
    return getValue(DEFENSE);
  }

  public void setDefense(Double value) {
    setValue(DEFENSE, value);
  }

  public Double getIntellegence() {
    return getValue(INTELLIGENCE);
  }

  public void mergeWith(Skills skills) {
    skills.forEach((keyName, value) -> {
      switch (keyName) {
        case VELOCITY:
          averageWith(keyName, value);
          break;
        default:
          addWith(keyName, value);
      }
    });
  }

  @Override
  public Double put(String key, Double value) {
    return super.put(key.toUpperCase(), value);
  }
}
