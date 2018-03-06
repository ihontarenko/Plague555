package org.plagueinc.sorrowland.core.renderer;

import org.plagueinc.sorrowland.core.common.Initializable;
import org.plagueinc.sorrowland.core.container.ObjectContainer;
import org.plagueinc.sorrowland.core.controller.AbstractController;
import org.plagueinc.sorrowland.core.state.AbstractState;
import org.plagueinc.sorrowland.core.state.AbstractStateManager;

import java.awt.*;

abstract public class AbstractRenderer<Manager extends AbstractStateManager, State extends AbstractState, Controller extends AbstractController, RendererType extends AbstractRenderer>
    implements Renderer<RendererType, ObjectContainer<RendererType>>, Initializable, Comparable<RendererType> {

  private ObjectContainer<RendererType> innerRenderers;
  private Controller                    controller;
  private Manager                       stateManager;
  private State                         state;
  private RendererType                  parent;
  private boolean                       isInitialized;
  private int                           priority;

  public AbstractRenderer(Manager sm, State state, Controller controller) {
    this.controller = controller;
    this.stateManager = sm;
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

  public Controller getController() {
    return controller;
  }

  public Manager getStateManager() {
    return stateManager;
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
