package org.nullapp.appCore.process.controller;

import org.nullapp.appCore.common.RunnableProcess;

public interface ControllerInterface extends RunnableProcess {

  public void pause();

  public void resume();

  public boolean isPaused();

}
