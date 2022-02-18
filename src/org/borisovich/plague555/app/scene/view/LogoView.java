package org.borisovich.plague555.app.scene.view;

import org.borisovich.core.core.common.resource.ImageLoader;
import org.borisovich.core.core.common.time.Timer;
import org.borisovich.core.core.geometry.Dimension;
import org.borisovich.core.core.graphics.Canvas;
import org.borisovich.core.core.graphics.StringDrawer;
import org.borisovich.core.core.graphics.spritesheet.sprite.SpriteStatic;
import org.borisovich.core.core.graphics.spritesheet.sheet.SpriteSheet;
import org.borisovich.plague555.app.config.Configuration;
import org.borisovich.plague555.app.manager.Manager;
import org.borisovich.plague555.app.scene.IntroScene;
import org.borisovich.ui.gui.GUIWindow;
import org.borisovich.ui.process.view.AbstractView;
import org.borisovich.ui.service.Context;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

public class LogoView extends AbstractView<IntroScene, AbstractView> {

  private Configuration configuration;
  private SpriteStatic  logoSprite;
  private StringDrawer  stringDrawer;
  private Timer         timer;

  public LogoView(Context context, IntroScene controller) {
    super(context, controller);
  }

  @Override
  public void doInitialize() {
    configuration = (Configuration) getContext().getConfiguration();

    InputStream inputStream = new ImageLoader(configuration.getLogoPath()).getFileStream();
    GUIWindow   window      = getContext().getGuiWindow();
    Dimension   dimension   = new Dimension(window.getWidth(), window.getHeight());

    stringDrawer = getContext().getStringDrawer();
    stringDrawer.setString(configuration.getAppFullName());

    try {
      SpriteSheet spriteSheet = new SpriteSheet(ImageIO.read(inputStream));
      this.logoSprite = new SpriteStatic(spriteSheet);
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.logoSprite.setDimension(dimension);

    timer = new Timer(3);
  }

  @Override
  public void render(Canvas canvas) {
    super.render(canvas);

    logoSprite.draw(canvas, 0, 0);
    stringDrawer.draw(canvas, "github.com/nulllab | Ivan Hontarenko 2018", 10, 585);

    if (timer.isElapsedThenPurge()) {
      getSceneManager().setActiveScene(Manager.STATE_GAME_PLAY);
    }
  }

}
