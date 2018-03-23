package org.nulllab.nullengine.core.event;

abstract class SubscribableObserver<T> extends Observer<T> {

  abstract String[] eventList();

}
