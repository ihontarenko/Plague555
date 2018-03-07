package org.plagueinc.sorrowland.core.process;

import org.plagueinc.sorrowland.core.common.RunnableProcess;

public interface Process<P> extends RunnableProcess<P> {

  public void pause();

  public void resume();

  public boolean isPaused();

}
