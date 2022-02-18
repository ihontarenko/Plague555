package org.borisovich.core.core.values;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@SuppressWarnings({"unchecked", "unused"})
abstract public class DirtyMap<T> extends HashMap<String, T> {

  public <V> V castValueTo(String keyName) {
    return (V) get(keyName);
  }

  public Integer getIntegerValue(String keyName) {
    return tryParseNumber(keyName, Integer.class);
  }

  public Long getLongValue(String keyName) {
    return Long.parseLong(getStringValue(keyName));
  }

  public Double getDoubleValue(String keyName) {
    return Double.parseDouble(getStringValue(keyName));
  }

  public Float getFloatValue(String keyName) {
    return this.<Float>castValueTo(keyName);
  }

  public Byte getByteValue(String keyName) {
    return this.<Byte>castValueTo(keyName);
  }

  public Boolean getBooleanValue(String keyName) {
    return Boolean.valueOf(getStringValue(keyName));
  }

  public Character getCharValue(String keyName) {
    return getStringValue(keyName).charAt(0);
  }

  public String getStringValue(String keyName) {
    return String.valueOf(get(keyName));
  }

  public <N extends Number> N tryParseNumber(String value, Class<N> numberClass) {
    String methodName  = "valueOf";
    N      parsedValue = null;

    try {
      Method method = numberClass.getDeclaredMethod(methodName, String.class);
      parsedValue = (N) method.invoke(null, value);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    } finally {
      try {
        if (parsedValue == null) {
          parsedValue = numberClass.newInstance();
        }
      } catch (InstantiationException | IllegalAccessException exception) {
        exception.printStackTrace();
      }
    }

    return parsedValue;
  }

}
