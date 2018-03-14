package com.nullion.appcore.process;

import com.nullion.appcore.common.RunnableProcess;

public interface Process<P> extends RunnableProcess<P> {

  public void pause();

  public void resume();

  public boolean isPaused();

}
