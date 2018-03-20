package org.nulllab.ui.process.controller;

import org.nulllab.nullengine.core.loop.RunnableProcess;

public interface ControllerInterface extends RunnableProcess {

  public void pause();

  public void resume();

  public boolean isPaused();

}
