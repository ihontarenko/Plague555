package org.nulllab.appCore.process.controller;

import org.nulllab.appCore.common.RunnableProcess;

public interface ControllerInterface extends RunnableProcess {

  public void pause();

  public void resume();

  public boolean isPaused();

}
