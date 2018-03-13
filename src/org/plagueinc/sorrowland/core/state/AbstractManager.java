package org.plagueinc.sorrowland.core.state;

import org.plagueinc.sorrowland.core.common.Initializable;
import org.plagueinc.sorrowland.core.common.Renderable;
import org.plagueinc.sorrowland.core.common.Updateable;
import org.plagueinc.sorrowland.core.container.ObjectContainer;
import org.plagueinc.sorrowland.service.AppContext;

import java.awt.*;

abstract public class AbstractManager<S extends AbstractState> implements Renderable, Updateable, Initializable {

  private boolean                            isInitialized;
  private ObjectContainer<S> states;
  private S                                  activeState;
  private ProcessMode                        processMode;
  private AppContext                         appContext;

  public AbstractManager(AppContext context) {
    states = new ObjectContainer<>();
    setAppContext(context);
    initialize();
  }

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      setProcessMode(ProcessMode.ACTIVE);
      doInitialize();
    }
  }

  abstract protected void doInitialize();

  public ProcessMode getProcessMode() {
    return processMode;
  }

  public void setProcessMode(ProcessMode processMode) {
    this.processMode = processMode;
  }

  public S getActiveState() {
    return activeState;
  }

  public void setActiveState(S activeState) {
    this.activeState = activeState;
  }

  public void setActiveState(String name) {
    setActiveState(getState(name));
  }

  public S getState(String name) {
    return states.getObject(name);
  }

  public AppContext getAppContext() {
    return appContext;
  }

  public void setAppContext(AppContext appContext) {
    this.appContext = appContext;
  }

  public void registerState(String name, S state) {
    states.setObject(name, state);
  }

  public ObjectContainer<S> getStates() {
    return states;
  }

  @Override
  public void render(Graphics2D g2d) {
    switch (getProcessMode()) {
      case BATCH:
        getStates().forEach((keyName, state) -> state.render(g2d));
        break;
      case ACTIVE:
        getActiveState().render(g2d);
        break;
    }

  }

  @Override
  public void update(float nano) {
    switch (getProcessMode()) {
      case BATCH:
        states.forEach((keyName, state) -> state.update(nano));
        break;
      case ACTIVE:
        getActiveState().update(nano);
        break;
    }
  }

}
