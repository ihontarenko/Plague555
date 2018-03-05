package org.plagueinc.sorrowland.renderer.intro;

import org.plagueinc.sorrowland.controller.intro.IntroController;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.core.renderer.Renderer;
import org.plagueinc.sorrowland.manager.GameStateManager;
import org.plagueinc.sorrowland.state.IntroState;

import java.awt.*;

public class Animation2Renderer extends AbstractRenderer<GameStateManager, IntroState, IntroController, AbstractRenderer> {

  public Animation2Renderer(GameStateManager stateManager, IntroState state, IntroController controller) {
    super(stateManager, state, controller);
  }

  @Override
  public void doInitialize() {

  }

  @Override
  public void draw(Graphics2D g2d) {
    super.draw(g2d);

    g2d.setColor(Color.RED);
    g2d.drawOval(50, 50, 150, 150);
    g2d.drawString(getClass().getSimpleName(), 200, 200);
  }

}
