package org.nullapp.sorrowland.core.renderer;

import org.nullapp.sorrowland.core.common.Initializable;
import org.nullapp.sorrowland.core.container.ObjectContainer;
import org.nullapp.sorrowland.core.process.AbstractProcess;
import org.nullapp.sorrowland.core.state.AbstractState;
import org.nullapp.sorrowland.core.state.AbstractManager;

import java.awt.*;

abstract public class AbstractRenderer<Manager extends AbstractManager, State extends AbstractState, Process extends AbstractProcess, RendererType extends AbstractRenderer>
    implements Renderer<RendererType, ObjectContainer<RendererType>>, Initializable, Comparable<RendererType> {

  private ObjectContainer<RendererType> innerRenderers;
  private Process                       process;
  private Manager                       appManager;
  private State                         state;
  private RendererType                  parent;
  private boolean                       isInitialized;
  private int                           priority;

  public AbstractRenderer(Manager appManager, State state, Process process) {
    this.process = process;
    this.appManager = appManager;
    this.state = state;
    this.innerRenderers = new ObjectContainer<>();
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
  public int compareTo(RendererType renderer) {
    return this.getPriority() - renderer.getPriority();
  }

  @Override
  public RendererType getParent() {
    return parent;
  }

  @Override
  public void setParent(RendererType renderer) {
    parent = renderer;
  }

  @Override
  public ObjectContainer<RendererType> getInnerRenderers() {
    return innerRenderers;
  }

  @Override
  public RendererType getInnerRenderer(String name) {
    return null;
  }

  @Override
  public void registerInnerRenderer(String name, RendererType renderer) {
    innerRenderers.setObject(name, renderer);
  }

  @Override
  public void render(Graphics2D g2d) {
    if (getInnerRenderers().size() > 0) {
      getInnerRenderers().forEach((s, renderer) -> renderer.render(g2d));
    }
  }

  public Process getProcess() {
    return process;
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

}
