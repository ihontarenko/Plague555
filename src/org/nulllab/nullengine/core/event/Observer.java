package org.nulllab.nullengine.core.event;

@SuppressWarnings("unused")
abstract public class Observer<T> {

  public void notify(T observable, Event event) {
    onNotify(observable, event);
  }

  abstract void onNotify(T observable, Event event);

}
