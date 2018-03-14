package com.nullion.appcore.state;

import com.nullion.appcore.common.Initializable;
import com.nullion.appcore.common.Renderable;
import com.nullion.appcore.common.Updateable;
import com.nullion.appcore.container.ServiceLocator;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.service.AppContextAware;

import java.awt.*;
import java.util.Objects;

abstract public class AbstractManager<S extends AbstractState>
    implements Renderable, Updateable, Initializable, AppContextAware {

  private boolean           isInitialized;
  private ServiceLocator<S> states;
  private S                 activeState;
  private ProcessMode       processMode;
  private AppContext        context;

  public AbstractManager(AppContext context) {
    this.context = context;
    this.states = new ServiceLocator<>();
    initialize();
  }

  abstract protected void doInitialize();

  public ProcessMode getProcessMode() {
    return processMode;
  }

  public void setProcessMode(ProcessMode processMode) {
    this.processMode = processMode;
  }

  public S getActiveState() {
    Objects.requireNonNull(activeState, String.format("Not defined 'ActiveState' for %s", getClass().getSimpleName()));
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

  public void registerState(String name, S state) {
    states.setObject(name, state);
  }

  public void registerState(String name, Class clazz, Object... arguments) {
    states.registerService(name, clazz, arguments);
  }

  public ServiceLocator<S> getStates() {
    return states;
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

  @Override
  public void reinitialize() {

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

  @Override
  public AppContext getContext() {
    return context;
  }
}
