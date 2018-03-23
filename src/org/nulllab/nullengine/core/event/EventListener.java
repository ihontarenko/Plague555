package org.nulllab.nullengine.core.event;

import java.util.Map;

@SuppressWarnings("unused")
public class EventListener<T> {

  private Map<String, Observable<T>> listeners;

  public void addSubscriber(SubscribableObserver<T> observer) {
    for (String eventName : observer.eventList()) {
      addListener(eventName, observer);
    }
  }

  public void addListener(String eventName, Observer<T> listener) {
    Observable<T> observable;

    try {
      observable = listeners.get(eventName);
    } catch (NullPointerException e) {
      observable = new InnerObservable();
      listeners.put(eventName, observable);
    }

    observable.addObserver(listener);
  }

  public boolean hasListeners(String eventName) {
    return listeners.containsKey(eventName);
  }

  public void removeListener(String eventName) {
    listeners.remove(eventName);
  }

  public void dispatchEvent(T observable, Event event) {
    if (listeners.containsKey(event.getName())) {
      listeners.get(event.getName()).notify(observable, event);
    }
  }

  private class InnerObservable extends Observable<T> {
    @Override
    public void notify(T observable) {
      super.notify(observable);
    }
  }

}
