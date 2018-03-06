package org.plagueinc.sorrowland.core.controller;

import org.plagueinc.sorrowland.core.common.Initializable;
import org.plagueinc.sorrowland.core.container.ObjectContainer;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.core.state.AbstractState;
import org.plagueinc.sorrowland.core.state.AbstractStateManager;

import java.awt.*;

abstract public class AbstractController<Manager extends AbstractStateManager, State extends AbstractState, Renderer extends AbstractRenderer>
    implements Controller<AbstractController>, Initializable {

  private Manager                   stateManager;
  private State                     state;
  private ObjectContainer<Renderer> renderers;
  private boolean                   isInitialized;

  public AbstractController(Manager stateManager, State state) {
    this.renderers = new ObjectContainer<>();
    this.stateManager = stateManager;
    this.state = state;
    initialize();
  }

  public void registerRenderer(String name, Renderer renderer) {
    renderers.setObject(name, renderer);
  }

  public org.plagueinc.sorrowland.core.renderer.Renderer getRenderer(String name) {
    return renderers.getObject(name);
  }

  public ObjectContainer<Renderer> getRenderers() {
    return renderers;
  }

  public Manager getStateManager() {
    return stateManager;
  }

  public State getState() {
    return state;
  }

  @Override
  public int compareTo(AbstractController controller) {
    return 0;
  }

  @Override
  public void render(Graphics2D g2d) {
    renderers.forEach((s, renderer) -> renderer.render(g2d));
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
