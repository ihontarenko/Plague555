package org.ionull.sorrowland.core.process;

import org.ionull.sorrowland.core.common.RunnableProcess;

public interface Process<P> extends RunnableProcess<P> {

  public void pause();

  public void resume();

  public boolean isPaused();

}
