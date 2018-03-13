package org.plagueinc.sorrowland.core.entity;

import org.plagueinc.sorrowland.core.common.Initializable;

import java.util.Arrays;

abstract public class Loop implements Runnable, Initializable {

  final public static int   THREAD_IDLE_TIME = 1;
  final public static float ONE_NANO_SECOND  = 1E+9F;

  private boolean   isRunning;
  private float     updateRate;
  private String    executionInfo;
  private Thread    thread;
  private String    name;

  public Loop(String name) {
    this(name, 300F);
  }

  protected Loop(String name, float updateRate) {
    isRunning = false;
    this.updateRate = updateRate;
    this.name = name;
  }

  public Loop() {
    this(Loop.class.getSimpleName(), 300F);
  }

  public synchronized void start() {
    if (!isRunning) {
      isRunning = true;
      thread = new Thread(this);
      thread.setName(name);
      thread.start();
    }
  }

  public synchronized void stop() {
    if (isRunning) {
      isRunning = false;

      try {
        this.thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      this.close();
    }
  }

  public synchronized void close() {
    stop();
  }

  @Override
  public void run() {
    float   lagTime        = 0;
    float   nanoPerUpdate  = 0;
    float[] counters       = {0, 0, 0, 0, 0};
    long    previousTime   = System.nanoTime();
    long    oneSecondTimer = 0;
    long    totalFrames    = 0;
    long    currentTime;
    long    elapsed;

    this.initialize();

    while (isRunning) {

      currentTime = System.nanoTime();
      elapsed = currentTime - previousTime;

      oneSecondTimer += elapsed;

      previousTime = currentTime;
      lagTime += elapsed / (ONE_NANO_SECOND / updateRate);
      nanoPerUpdate = elapsed / lagTime;

      boolean readyToRender = false;

      while (lagTime > 1) {
        update(nanoPerUpdate);
        lagTime--;

        counters[1]++;
        if (readyToRender) {
          counters[2]++;
        } else {
          readyToRender = true;
        }
      }

      if (readyToRender) {
        render();
        counters[0]++;
      } else {
        counters[3]++;
        try {
          Thread.sleep(THREAD_IDLE_TIME);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      if (oneSecondTimer >= ONE_NANO_SECOND) {
        totalFrames += counters[0];
        executionInfo = String.format("fps:%.0f, upd:%.0f, lost:%.0f, free:%.0f upd:%.4fs, render:%.4fs, frames:%d",
            counters[0], counters[1], counters[2], counters[3],
            nanoPerUpdate / ONE_NANO_SECOND, elapsed / ONE_NANO_SECOND, totalFrames);
        oneSecondTimer = 0;
        Arrays.fill(counters, 0);
      }

    }
  }

  abstract protected void update(float elapsedTime);

  abstract protected void render();

  public float getUpdateRate() {
    return updateRate;
  }

  public void setUpdateRate(float updateRate) {
    this.updateRate = updateRate;
  }

  public String getExecutionInfo() {
    return executionInfo;
  }

  public String getName() {
    return name;
  }

}
