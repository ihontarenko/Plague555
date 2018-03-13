package org.ionull.sorrowland.app.renderer.intro;

import org.ionull.sorrowland.app.process.IntroProcess;
import org.ionull.sorrowland.core.renderer.AbstractRenderer;
import org.ionull.sorrowland.app.state.IntroState;
import org.ionull.sorrowland.core.service.AppContext;

import java.awt.*;

public class Animation1Renderer extends AbstractRenderer<IntroState, IntroProcess, AbstractRenderer> {

  public Animation1Renderer(AppContext context, IntroState state, IntroProcess process) {
    super(context, state, process);
  }

  @Override
  public void doInitialize() { }

  @Override
  public void render(Graphics2D g2d) {
    super.render(g2d);

    g2d.setColor(Color.WHITE);
    g2d.drawOval(10, 10, 50, 50);
    g2d.drawString(getClass().getSimpleName(), 100, 100);
  }

}
