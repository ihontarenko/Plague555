package org.nulllab.sorrowland.app.scene.view;

import org.nulllab.nullengine.core.common.resource.ImageLoader;
import org.nulllab.nullengine.core.common.time.Timer;
import org.nulllab.nullengine.core.geometry.Dimension;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.StringDrawer;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteStatic;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteSheet;
import org.nulllab.sorrowland.app.config.Configuration;
import org.nulllab.sorrowland.app.manager.Manager;
import org.nulllab.sorrowland.app.scene.IntroScene;
import org.nulllab.ui.gui.GUIWindow;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.Context;

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
      getSceneManager().setActiveScene(Manager.STATE_MENU);
    }
  }

}
