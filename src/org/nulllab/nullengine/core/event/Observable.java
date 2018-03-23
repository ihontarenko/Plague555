package org.nulllab.nullengine.core.event;

import java.util.Set;

@SuppressWarnings("unused")
abstract public class Observable<T> {

  private Set<Observer<T>> observers;

  public void notify(T observable) {
    notify(observable, new NullEvent());
  }

  public void notify(T observable, Event event) {
    for (Observer<T> observer : observers) {
      observer.notify(observable, event);
    }
  }

  public void addObserver(Observer<T> observer) {
    observers.add(observer);
  }

  public boolean hasObserver(Observer<T> observer) {
    return observers.contains(observer);
  }

  public void removeObserver(Observer<T> observer) {
    observers.remove(observer);
  }

  public void removeAll() {
    observers.clear();
  }

}
