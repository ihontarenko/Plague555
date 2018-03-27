package org.nulllab.nullengine.openworld.character;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Values {

  private Map<String, Double> values;

  public Values() {
    values = new HashMap<>();
  }

  public Double getValue(String keyName) {
    double defaultValue = 0.0D;

    if (!hasValue(keyName))
      setValue(keyName, defaultValue);

    return values.get(keyName);
  }

  public void setValue(String keyName, Double value) {
    values.put(keyName, value);
  }

  public boolean hasValue(String keyName) {
    return values.containsKey(keyName);
  }

  public void decreaseValue(String keyName, Double value) {
    subtractWith(keyName, value);
  }

  public void increaseValue(String keyName, Double value) {
    foldWith(keyName, value);
  }

  public void averageWith(Values values) {
    values.getValues().forEach(this::averageWith);
  }

  public void subtractWith(Values values) {
    values.getValues().forEach(this::subtractWith);
  }

  public void foldWith(Values values) {
    values.getValues().forEach(this::foldWith);
  }

  public void averageWith(String keyName, Double value) {
    setValue(keyName, (getValue(keyName) * value) / 2);
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

  @Override
  public String toString() {
    AtomicReference<String> values = new AtomicReference<>("");

    this.values.forEach((keyName, value) -> {
      values.set(String.format("%s %s: %f,", values, keyName, value));
    });

    return String.format("Values: {%s}", values);
  }

}
