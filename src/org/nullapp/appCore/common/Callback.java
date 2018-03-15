package org.nullapp.appCore.common;

@FunctionalInterface
public interface Callback<T, A> {

  public T call(A argument);

}
