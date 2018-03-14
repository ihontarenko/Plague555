package com.nullion.appcore.view;

import com.nullion.appcore.service.AppContextAware;
import com.nullion.appcore.state.AbstractState;
import com.nullion.appcore.common.Initializable;
import com.nullion.appcore.container.ServiceLocator;
import com.nullion.appcore.controller.Controller;
import com.nullion.appcore.service.AppContext;

import java.awt.*;

abstract public class AbstractView<State extends AbstractState, C extends Controller, R extends AbstractView>
    implements View<R, ServiceLocator<R>>, Initializable, Comparable<R>, AppContextAware {

  private AppContext        context;
  private ServiceLocator<R> innerViews;
  private C                 controller;
  private State             state;
  private R                 parent;
  private boolean           isInitialized;
  private int               priority;

  public AbstractView(AppContext context, State state, C process) {
    this.context = context;
    this.controller = process;
    this.state = state;
    this.innerViews = new ServiceLocator<>();

    initialize();
  }

  abstract public void doInitialize();

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      doInitialize();
    }
  }

  @Override
  public void reinitialize() {

  }

  @Override
  public int compareTo(R view) {
    return this.getPriority() - view.getPriority();
  }

  @Override
  public R getParent() {
    return parent;
  }

  @Override
  public void setParent(R view) {
    parent = view;
  }

  @Override
  public ServiceLocator<R> getInnerViews() {
    return innerViews;
  }

  @Override
  public R getInnerView(String name) {
    return null;
  }

  @Override
  public void registerInnerView(String name, R view) {
    innerViews.setObject(name, view);
  }

  @Override
  public void render(Graphics2D g2d) {
    if (getInnerViews().size() > 0) {
      getInnerViews().forEach((s, view) -> view.render(g2d));
    }
  }

  @Override
  public AppContext getContext() {
    return context;
  }

  public C getController() {
    return controller;
  }

  public State getState() {
    return state;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

}
