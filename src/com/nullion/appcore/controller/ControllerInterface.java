package com.nullion.appcore.controller;

import com.nullion.appcore.common.RunnableProcess;

public interface ControllerInterface extends RunnableProcess {

  public void pause();

  public void resume();

  public boolean isPaused();

}
