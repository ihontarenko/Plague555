package com.nullion.appcore.container;

import com.nullion.appcore.common.Initializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unchecked", "unused"})
public class ServiceLocator<Clazz> extends AbstractObjectContainer<Clazz> {

  private Map<String, ServiceLocator.Service> services;

  public ServiceLocator() {
    services = new HashMap<>();
  }

  public Map<String, ServiceLocator.Service> getServices() {
    return services;
  }

  public void registerService(String name, Class<?> clazz) {
    registerService(name, new Service(clazz));
  }

  public void registerService(String name, Class<?> clazz, Object... arguments) {
    registerService(name, new Service(clazz, arguments));
  }

  public void registerService(String name, String className) {
    try {
      registerService(name, Class.forName(className));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void registerService(String name, String className, Object... arguments) {
    try {
      registerService(name, Class.forName(className), arguments);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void registerService(String name, Service service) {
    services.put(name, service);
  }

  public Clazz resolveService(String name) {
    return getService(name).resolve();
  }

  public void resolveAll() {
    getServices().forEach((name, service) -> {
      setObject(name, (Clazz) service.resolve());
    });
  }

  public boolean hasService(String name) {
    return services.containsKey(name);
  }

  public Service getService(String name) {
    return services.get(name);
  }

  @Override
  public Clazz getObject(String name) {
    if (hasService(name) && !hasObject(name)) {
      setObject(name, resolveService(name));
    }

    Clazz object = super.getObject(name);

    if (object instanceof Initializable) {
      ((Initializable) object).reinitialize();
    }

    return object;
  }

  @Override
  public void setObject(String name, Clazz object) {
    if (object instanceof Initializable) {
      ((Initializable) object).initialize();
    }

    super.setObject(name, object);
  }

  public class Service {

    private Class<?> clazz;
    private Object[] arguments;

    public Service(Class<?> clazz, Object... arguments) {
      this.clazz = clazz;
      this.arguments = arguments;
    }

    public Service(String className) throws ClassNotFoundException {
      this(Class.forName(className), className);
    }

    public Service(String className, Object... arguments) throws ClassNotFoundException {
      this(Class.forName(className), arguments);
    }

    public Service(Class<?> clazz) {
      this(clazz, clazz.getName());
    }

    public Clazz resolve() {
      return (Clazz) Instantiator.createInstance(getClassObject(), getArguments());
    }

    public boolean hasArguments() {
      return null != arguments;
    }

    public Class<?> getClassObject() {
      return clazz;
    }

    public Object[] getArguments() {
      return arguments;
    }

  }

  public static class Instantiator {

    public static Object createInstance(String className) {
      return createInstance(className, className);
    }

    public static Object createInstance(String className, Object... arguments) {
      Object instance = null;

      try {
        instance = createInstance(Class.forName(className), arguments);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

      return instance;
    }

    public static Object createInstance(Class<?> clazz) {
      return createInstance(clazz, clazz.getName());
    }

    public static Object createInstance(Class<?> clazz, Object... arguments) {
      Constructor<?> constructor = getConstructor(clazz, arguments);
      Object         instance    = null;

      try {
        instance = constructor.newInstance(arguments);
        System.out.printf("[ServiceLocator.Instantiator]: Create new instance of: %s%n", clazz.getName());
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }

      return instance;
    }

    public static Constructor<?> getConstructor(String className, Object... arguments) {
      Constructor<?> constructor = null;

      try {
        Class<?> clazz = Class.forName(className);
        constructor = getConstructor(clazz, arguments);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

      return constructor;
    }

    public static Constructor<?> getConstructor(String className) {
      return getConstructor(className, className);
    }

    public static Constructor<?> getConstructor(Class<?> className) {
      return getConstructor(className, className.getName());
    }

    public static Constructor<?> getConstructor(Class<?> clazz, Object... arguments) {
      Constructor<?> constructor = null;

      try {
        constructor = clazz.getConstructor(toClassArray(arguments));
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      }

      return constructor;
    }

    public static Class<?>[] toClassArray(Object... arguments) {
      Class<?>[] classes = new Class[arguments.length];
      int        counter = 0;

      for (Object object : arguments) {
        classes[counter++] = object.getClass();
      }

      return classes;
    }

  }

}
