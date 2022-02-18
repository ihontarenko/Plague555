package org.borisovich.core.core.values;

import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings({"unchecked", "unused"})
public class DoubleValues extends DirtyMap<Double> {

  public Double getValue(String keyName) {
    double defaultValue = 0.0D;

    if (!hasValue(keyName))
      setValue(keyName, defaultValue);

    return getDoubleValue(keyName);
  }

  public void setValue(String keyName, Double value) {
    put(keyName, value);
  }

  public boolean hasValue(String keyName) {
    return containsKey(keyName);
  }

  public void decreaseValue(String keyName, Double value) {
    subtractWith(keyName, value);
  }

  public void increaseValue(String keyName, Double value) {
    addWith(keyName, value);
  }

  public void averageWith(DoubleValues values) {
    values.forEach(this::averageWith);
  }

  public void subtractWith(DoubleValues values) {
    values.forEach(this::subtractWith);
  }

  public void addWith(DoubleValues values) {
    values.forEach(this::addWith);
  }

  public void averageWith(String keyName, Double value) {
    setValue(keyName, (getValue(keyName) + value) / 2);
  }

  public void subtractWith(String keyName, Double value) {
    setValue(keyName, getValue(keyName) - value);
  }

  public void addWith(String keyName, Double value) {
    setValue(keyName, getValue(keyName) + value);
  }

  @Override
  public String toString() {
    AtomicReference<String> values = new AtomicReference<>("");

    this.forEach((keyName, value) -> values.set(String.format("%s %s: %f,", values, keyName, value)));

    return String.format("[%s]: {%s}", getClass().getSimpleName(), values);
  }

}
