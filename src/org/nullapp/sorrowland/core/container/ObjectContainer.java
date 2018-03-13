package org.nullapp.sorrowland.core.container;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectContainer<Clazz> extends AbstractObjectContainer<Clazz> {

  public static class Instantiator {

    public static Object createInstance(String className) {
      return createInstance(className, className);
    }

    public static Object createInstance(String className, Object ...arguments) {
      Constructor<?> constructor = getConstructor(className, arguments);
      Object instance = null;

      try {
        instance = constructor.newInstance(arguments);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }

      return instance;
    }

    public static Constructor<?> getConstructor(String className) {
      return getConstructor(className, className);
    }

    public static Constructor<?> getConstructor(String className, Object ...arguments) {
      Constructor<?> constructor = null;

      try {
        Class<?> clazz = Class.forName(className);
        constructor = clazz.getConstructor(toClassArray(arguments));
      } catch (ClassNotFoundException | NoSuchMethodException e) {
        e.printStackTrace();
      }

      return constructor;
    }

    public static Class<?>[] toClassArray(Object ...arguments) {
      Class<?>[] classes = new Class[arguments.length];
      int counter = 0;

      for (Object object : arguments) {
        classes[counter++] = object.getClass();
      }

      return classes;
    }

  }

}
