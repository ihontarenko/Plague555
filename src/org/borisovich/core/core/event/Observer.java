package org.borisovich.core.core.event;

@SuppressWarnings("unused")
abstract public class Observer<T> {

  public void notify(T observable, Event event) {
    onNotify(observable, event);
  }

  abstract public void onNotify(T observable, Event event);

}
