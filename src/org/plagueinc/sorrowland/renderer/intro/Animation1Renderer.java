package org.plagueinc.sorrowland.renderer.intro;

import org.plagueinc.sorrowland.controller.intro.IntroController;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.manager.GameStateManager;
import org.plagueinc.sorrowland.state.IntroState;

import java.awt.*;

public class Animation1Renderer extends AbstractRenderer<GameStateManager, IntroState, IntroController, AbstractRenderer> {

  public Animation1Renderer(GameStateManager stateManager, IntroState state, IntroController controller) {
    super(stateManager, state, controller);
  }

  @Override
  public void draw(Graphics2D g2d) {
    super.draw(g2d);

    g2d.setColor(Color.BLUE);
    g2d.drawOval(10, 10, 50, 50);
    g2d.drawString(getClass().getSimpleName(), 100, 100);
  }

}
