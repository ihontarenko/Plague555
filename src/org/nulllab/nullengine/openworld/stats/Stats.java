package org.nulllab.nullengine.openworld.stats;

import java.util.HashMap;
import java.util.Map;

abstract public class Stats {

  private Map<String, Double> values;

  public Stats() {
    values = new HashMap<>();
  }

  public Double getValue(String keyName) {
    return values.get(keyName);
  }

  public void setValue(String keyName, Double value) {
    values.put(keyName, value);
  }

  public boolean hasValue(String keyName) {
    return values.containsKey(keyName);
  }

  public void subtractWith(Stats stats) {
    stats.getValues().forEach(this::subtractWith);
  }

  public void foldWith(Stats stats) {
    stats.getValues().forEach(this::foldWith);
  }

  public void subtractWith(String keyName, Double value) {
    if (hasValue(keyName)) {
      value = getValue(keyName) - value;
    }

    setValue(keyName, value);
  }

  public void foldWith(String keyName, Double value) {
    if (hasValue(keyName)) {
      value = getValue(keyName) + value;
    }

    setValue(keyName, value);
  }

  public Map<String, Double> getValues() {
    return values;
  }

}
