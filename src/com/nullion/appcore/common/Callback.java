package com.nullion.appcore.common;

@FunctionalInterface
public interface Callback<T, A> {

  public T call(A argument);

}
