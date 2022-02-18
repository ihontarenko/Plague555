package org.borisovich.ui.process.scene;

import org.borisovich.core.core.loop.RunnableProcess;

public interface SceneInterface extends RunnableProcess {

  public void pause();

  public void resume();

  public boolean isPaused();

}
