package org.plagueinc.sorrowland.renderer.intro;

import org.plagueinc.sorrowland.controller.intro.IntroController;
import org.plagueinc.sorrowland.core.common.resource.FontLoader;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.manager.GameStateManager;
import org.plagueinc.sorrowland.state.IntroState;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class Animation1Renderer extends AbstractRenderer<GameStateManager, IntroState, IntroController, AbstractRenderer> {

  private FontLoader fontLoader;

  public Animation1Renderer(GameStateManager stateManager, IntroState state, IntroController controller) {
    super(stateManager, state, controller);
  }

  @Override
  public void doInitialize() {
    fontLoader = new FontLoader("ui/fonts/PixelEmulator.otf");
  }

  @Override
  public void draw(Graphics2D g2d) {
    super.draw(g2d);

    Font font = fontLoader.getFont();
    font.deriveFont(10F);
    g2d.setFont(font);

    g2d.setColor(Color.BLUE);
    g2d.drawOval(10, 10, 50, 50);
    g2d.drawString(getClass().getSimpleName(), 100, 100);



//    FontRenderContext renderContext = g2d.getFontRenderContext();
//    GlyphVector vector = font.createGlyphVector(renderContext, "Test 123");


    g2d.setColor(Color.BLACK);
//    g2d.drawGlyphVector(vector, 250, 250);
  }

}
