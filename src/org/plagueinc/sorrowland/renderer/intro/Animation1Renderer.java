package org.plagueinc.sorrowland.renderer.intro;

import org.plagueinc.sorrowland.process.intro.IntroProcess;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.manager.AppManager;
import org.plagueinc.sorrowland.state.IntroState;

import java.awt.*;

public class Animation1Renderer extends AbstractRenderer<AppManager, IntroState, IntroProcess, AbstractRenderer> {

  public Animation1Renderer(AppManager appManager, IntroState state, IntroProcess process) {
    super(appManager, state, process);
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
