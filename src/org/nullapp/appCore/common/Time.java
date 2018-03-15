package org.nullapp.appCore.common;

public class Time {

  public static final float ONE_NANO_SECOND = 1000000000F;

  public static long nano() {
    return System.nanoTime();
  }

}
