package org.nulllab.ui.process.scene;

import org.nulllab.nullengine.core.loop.RunnableProcess;

public interface SceneInterface extends RunnableProcess {

  public void pause();

  public void resume();

  public boolean isPaused();

}
