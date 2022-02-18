package org.borisovich.core.core.event;

abstract class SubscribableObserver<T> extends Observer<T> {

  abstract String[] eventList();

}
