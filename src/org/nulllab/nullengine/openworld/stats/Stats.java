package org.nulllab.nullengine.openworld.stats;

import java.util.HashMap;
import java.util.Map;

public class Stats {

  private Map<String, Double> values;

  public Stats() {
    values = new HashMap<>();
  }

  public Double getValue(String keyName) {
    if (!hasValue(keyName)) {
      setValue(keyName, 0.0D);
    }

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
    setValue(keyName, getValue(keyName) - value);
  }

  public void foldWith(String keyName, Double value) {
    setValue(keyName, getValue(keyName) + value);
  }

  public Map<String, Double> getValues() {
    return values;
  }

}
