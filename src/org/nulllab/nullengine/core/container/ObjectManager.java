package org.nulllab.nullengine.core.container;

import org.nulllab.nullengine.core.common.Initializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unchecked", "unused"})
public class ObjectManager<Clazz> extends AbstractObjectContainer<Clazz> {

  private Map<String, ObjectManager.Service> services;

  public ObjectManager() {
    services = new HashMap<>();
  }

  public Map<String, ObjectManager.Service> getServices() {
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
    super.setObject(name, object);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    this.forEach((key, object) -> stringBuilder.append(String.format("'%s': [%s]\n", key, object.getClass().getSimpleName())));
    getServices().forEach((key, object) -> stringBuilder.append(String.format("'%s': Service[%s]\n", key, object.getClassObject().getSimpleName())));

    return stringBuilder.toString();
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

    public static Object createInstance(Class<?> clazz, Object... arguments) {
      Constructor<?> constructor = getConstructor(clazz, arguments);
      Object         instance    = null;

      try {
        instance = constructor.newInstance(arguments);
        System.out.printf("[ObjectManager]: Create new instance of: %s%n", clazz.getName());
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
      Class<?>[]     classes     = toClassArray(arguments);

      try {
        constructor = clazz.getConstructor(classes);
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      }

      return constructor;
    }

    public static Class<?>[] toClassArray(Object... arguments) {
      Class<?>[] classes = null;

      if (null != arguments) {
        classes = new Class[arguments.length];
        int counter = 0;

        for (Object object : arguments) {
          classes[counter++] = object.getClass();
        }
      }

      return classes;
    }

  }

  public class Service {

    private Class<?> clazz;
    private Object[] arguments;

    public Service(Class<?> clazz, Object... arguments) {
      this.clazz = clazz;
      this.arguments = arguments;
    }

    public Service(String className, Object... arguments) throws ClassNotFoundException {
      this(Class.forName(className), arguments);
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
}
