package org.ionull.sorrowland.core.renderer;

import org.ionull.sorrowland.core.common.Initializable;
import org.ionull.sorrowland.core.container.ServiceLocator;
import org.ionull.sorrowland.core.process.AbstractProcess;
import org.ionull.sorrowland.core.service.AppContext;
import org.ionull.sorrowland.core.service.AppContextAware;
import org.ionull.sorrowland.core.state.AbstractState;

import java.awt.*;

abstract public class AbstractRenderer<State extends AbstractState, Process extends AbstractProcess, RendererType extends AbstractRenderer>
    implements Renderer<RendererType, ServiceLocator<RendererType>>, Initializable, Comparable<RendererType>, AppContextAware {

  private AppContext                   context;
  private ServiceLocator<RendererType> innerRenderers;
  private Process                      process;
  private State                        state;
  private RendererType                 parent;
  private boolean                      isInitialized;
  private int                          priority;

  public AbstractRenderer(AppContext context, State state, Process process) {
    this.context = context;
    this.process = process;
    this.state = state;
    this.innerRenderers = new ServiceLocator<>();

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
  public ServiceLocator<RendererType> getInnerRenderers() {
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

  @Override
  public AppContext getContext() {
    return context;
  }

  public Process getProcess() {
    return process;
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
