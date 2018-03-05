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
    long  lastTime         = System.nanoTime();
    float lostTime         = 0;
    float totalElapsedTime = 0;
    int[] counters         = {0, 0, 0, 0};

    this.initialize();

    while (isRunning) {

      long nowTime     = System.nanoTime();
      long elapsedTime = nowTime - lastTime;
      lastTime = nowTime;

      lostTime += (elapsedTime / (ONE_NANO_SECOND / updateRate));
      totalElapsedTime += elapsedTime;

      boolean readyToRender = false;

      while (lostTime > 1) {
        update(elapsedTime);
        lostTime--;

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

      if (totalElapsedTime >= ONE_NANO_SECOND) {
        executionInfo = String.format(" [FPS: %d, UPD: %d, LOST: %d, FREE %d]", counters[0], counters[1], counters[2], counters[3]);
        totalElapsedTime = 0;
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
