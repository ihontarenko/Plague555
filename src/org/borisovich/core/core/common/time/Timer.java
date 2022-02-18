package org.borisovich.core.core.common.time;

@SuppressWarnings("unused")
public class Timer {

  private long   lastTime;
  private Factor factor;
  private double interval;

  public Timer(double interval) {
    this(Factor.SECOND, interval);
  }

  public Timer(Factor factor, double interval) {
    this.factor = factor;
    this.interval = interval;
    this.purge();
  }

  public boolean isElapsedThenPurge() {
    return isElapsed(true);
  }

  public boolean isElapsed() {
    return isElapsed(false);
  }

  public boolean isElapsed(boolean andPurge) {
    long    elapsed   = System.nanoTime() - lastTime;
    double  oneTick   = factor.getFactor() * interval;
    double  lostTimes = elapsed / oneTick;
    boolean isElapsed = lostTimes >= 1;

    if (isElapsed && andPurge) {
      purge();
    }

    return isElapsed;
  }

  public void purge() {
    this.lastTime = System.nanoTime();
  }

  public Factor getFactor() {
    return factor;
  }

  public double getInterval() {
    return interval;
  }

  public void setInterval(double interval) {
    this.interval = interval;
  }

  public enum Factor {

    NANO(1), MICRO(1E3D), MILLI(1E6D), SECOND(1E9D);

    private double factor;

    Factor(double factor) {
      this.factor = factor;
    }

    public double getFactor() {
      return factor;
    }
  }

}
