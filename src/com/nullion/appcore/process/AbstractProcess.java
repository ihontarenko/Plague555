package com.nullion.appcore.process;

import com.nullion.appcore.common.Initializable;
import com.nullion.appcore.container.ServiceLocator;
import com.nullion.appcore.renderer.AbstractRenderer;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.service.AppContextAware;
import com.nullion.appcore.state.AbstractState;

import java.awt.*;

abstract public class AbstractProcess<State extends AbstractState, Renderer extends AbstractRenderer>
    implements Process<AbstractProcess>, Initializable, AppContextAware {

  private AppContext               context;
  private State                    state;
  private ServiceLocator<Renderer> renderers;
  private boolean                  isInitialized;
  private boolean                  isPaused;
  private int                      priority;

  public AbstractProcess(AppContext context, State state) {
    this.context = context;
    this.renderers = new ServiceLocator<>();
    this.state = state;
    initialize();
  }

  public abstract void doUpdate(float nano);

  public void registerRenderer(String name, Renderer renderer) {
    renderers.setObject(name, renderer);
  }

  public void registerRenderer(String name, Class rendererClass, Object... arguments) {
    renderers.registerService(name, rendererClass, arguments);
  }

  public Renderer getRenderer(String name) {
    return renderers.getObject(name);
  }

  public ServiceLocator<Renderer> getRenderers() {
    return renderers;
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

  @Override
  public int compareTo(AbstractProcess process) {
    return this.getPriority() - process.getPriority();
  }

  @Override
  public void render(Graphics2D g2d) {
    renderers.forEach((s, renderer) -> renderer.render(g2d));
  }

  @Override
  public void pause() {
    isPaused = true;
  }

  @Override
  public void resume() {
    isPaused = false;
  }

  @Override
  public boolean isPaused() {
    return isPaused;
  }

  @Override
  public void update(float nano) {
    if (!isPaused()) {
      doUpdate(nano);
    }
  }

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
  public AppContext getContext() {
    return context;
  }

  abstract protected void doInitialize();

}
