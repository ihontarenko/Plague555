package org.nullapp.sorrowland.core.process;

import org.nullapp.sorrowland.core.common.Initializable;
import org.nullapp.sorrowland.core.container.ObjectContainer;
import org.nullapp.sorrowland.core.renderer.AbstractRenderer;
import org.nullapp.sorrowland.core.state.AbstractManager;
import org.nullapp.sorrowland.core.state.AbstractState;

import java.awt.*;

abstract public class AbstractProcess<Manager extends AbstractManager, State extends AbstractState, Renderer extends AbstractRenderer>
    implements Process<AbstractProcess>, Initializable {

  private Manager                   appManager;
  private State                     state;
  private ObjectContainer<Renderer> renderers;
  private boolean                   isInitialized;
  private boolean                   isPaused;
  private int                       priority;

  public AbstractProcess(Manager appManager, State state) {
    this.renderers = new ObjectContainer<>();
    this.appManager = appManager;
    this.state = state;
    initialize();
  }

  public abstract void doUpdate(float nano);

  public void registerRenderer(String name, Renderer renderer) {
    renderers.setObject(name, renderer);
  }

  public Renderer getRenderer(String name) {
    return renderers.getObject(name);
  }

  public ObjectContainer<Renderer> getRenderers() {
    return renderers;
  }

  public Manager getAppManager() {
    return appManager;
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

  abstract protected void doInitialize();

}
