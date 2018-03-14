package com.nullion.sorrowland.app.view.intro;

import com.nullion.appcore.common.resource.ImageLoader;
import com.nullion.appcore.geometry.Dimension;
import com.nullion.appcore.gfx.sprite.Sprite;
import com.nullion.appcore.gfx.sprite.SpriteSheet;
import com.nullion.appcore.gui.GUIWindow;
import com.nullion.appcore.view.AbstractView;
import com.nullion.appcore.service.AppContext;
import com.nullion.sorrowland.app.config.AppConfiguration;
import com.nullion.sorrowland.app.controller.IntroController;
import com.nullion.sorrowland.app.state.IntroState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class LogoView extends AbstractView<IntroState, IntroController, AbstractView> {

  private Sprite logoSprite;

  public LogoView(AppContext context, IntroState state, IntroController controller) {
    super(context, state, controller);
  }

  @Override
  public void doInitialize() {
    AppConfiguration configuration = (AppConfiguration) getContext().getConfiguration();
    InputStream inputStream = new ImageLoader(configuration.getLogoPath()).getFileStream();
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
