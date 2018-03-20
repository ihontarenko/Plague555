package org.nulllab.nullengine.core.common.time;

public class SystemTime {

  public static final float ONE_NANO_SECOND = 1000000000F;

  public static long nano() {
    return System.nanoTime();
  }

}
