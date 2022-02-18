package org.borisovich.core.core.loop;

import org.borisovich.core.core.common.Initializable;

import java.util.Arrays;

@SuppressWarnings({"unused", "unchecked"})
abstract public class Loop implements Runnable, Initializable {

  final public static int   THREAD_IDLE_TIME = 1;
  final public static float ONE_NANO_SECOND  = 1E+9F;

  private boolean   isRunning;
  private float     updateRate;
  private String    executionInfo = String.format("%s is running...", getClass().getSimpleName());
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
    this(Loop.class.getSimpleName(), 60F);
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
    String  executionInfoTemplate = "fps:%.0f, upd:%.0f+%.0f, free:%.0f, render:%.4fs, frames:%d, time: %.2fs";
    float   delayed               = 0;
    float   nanoPerUpdate         = ONE_NANO_SECOND / updateRate;
    float   totalTime             = 0;
    float[] counters              = {0, 0, 0, 0, 0};
    long[]  updateTimer           = {System.nanoTime(), 0, 0};
    long[]  loopTimer             = {System.nanoTime(), 0, 0};
    long    oneSecondTimer        = 0;
    long    totalFrames           = 0;
    boolean readyToRender         = false;

    this.initialize();

    while (isRunning) {

      // get current system time in nano-seconds
      loopTimer[1] = System.nanoTime();
      // diff between previous and current time
      loopTimer[2] = loopTimer[1] - loopTimer[0];
      // flip previous-current variables
      loopTimer[0] = loopTimer[1];

      // count for one second
      oneSecondTimer += loopTimer[2];

      // total time of thread run
      totalTime += loopTimer[2];

      // calculate how many times we need run update
      delayed += (loopTimer[2] / nanoPerUpdate);

      // execute few times for actualize updated data
      while (delayed > 1) {

        // get current system time in nano-seconds
        updateTimer[1] = System.nanoTime();
        // diff between previous and current time
        updateTimer[2] = updateTimer[1] - updateTimer[0];
        // flip previous-current variables
        updateTimer[0] = updateTimer[1];

        // scene update method
        update(updateTimer[2]);
        delayed--;

        // updates counter
        counters[1]++;

        if (readyToRender) {
          // lost frame counter
          counters[2]++;
        }

        // after all updates scene ready to render
        readyToRender = true;
      }

      // scene render if ready
      if (readyToRender) {
        render();
        // fps counter
        counters[0]++;
      } else {
        // free frame counter
        counters[3]++;
        // let's rest for scene
        try {
          Thread.sleep(THREAD_IDLE_TIME);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      // reset flag for render logic
      readyToRender = false;

      // update execution info property
      if (oneSecondTimer >= ONE_NANO_SECOND) {
        totalFrames += counters[0];
        executionInfo = String.format(executionInfoTemplate, counters[0], counters[1], counters[2], counters[3],
            loopTimer[2] / ONE_NANO_SECOND, totalFrames, totalTime / ONE_NANO_SECOND);
        // reset stat variables
        oneSecondTimer = 0;
        Arrays.fill(counters, 0);
      }
    }
  }

  abstract protected void update(float elapsed);

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
