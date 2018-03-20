package org.nulllab.nullengine.core.common;

@FunctionalInterface
public interface Callback<T, A> {

  public T call(A argument);

}
