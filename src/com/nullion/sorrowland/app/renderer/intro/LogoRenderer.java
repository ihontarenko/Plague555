package com.nullion.sorrowland.app.renderer.intro;

import com.nullion.appcore.common.resource.ImageLoader;
import com.nullion.appcore.geometry.Dimension;
import com.nullion.appcore.gfx.Sprite;
import com.nullion.appcore.gfx.SpriteSheet;
import com.nullion.appcore.gui.GUIWindow;
import com.nullion.appcore.renderer.AbstractRenderer;
import com.nullion.appcore.service.AppContext;
import com.nullion.sorrowland.app.process.IntroProcess;
import com.nullion.sorrowland.app.state.IntroState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class LogoRenderer extends AbstractRenderer<IntroState, IntroProcess, AbstractRenderer> {

  private Sprite logoSprite;

  public LogoRenderer(AppContext context, IntroState state, IntroProcess process) {
    super(context, state, process);
  }

  @Override
  public void doInitialize() {
    InputStream inputStream = new ImageLoader("common/nullion-logo.jpg").getFileStream();
    GUIWindow window = getContext().getGuiWindow();
    Dimension dimension = new Dimension(window.getWidth(), window.getHeight());

    try {
      SpriteSheet spriteSheet = new SpriteSheet(ImageIO.read(inputStream));
      this.logoSprite = new Sprite(spriteSheet);
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.logoSprite.setDimension(dimension);
  }

  @Override
  public void render(Graphics2D g2d) {
    super.render(g2d);

    this.logoSprite.draw(g2d, 0, 0);


  }

}
