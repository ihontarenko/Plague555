package org.nullapp.sorrowland.core.process;

import org.nullapp.sorrowland.core.common.RunnableProcess;

public interface Process<P> extends RunnableProcess<P> {

  public void pause();

  public void resume();

  public boolean isPaused();

}
