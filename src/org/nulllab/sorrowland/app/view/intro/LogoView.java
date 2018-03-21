package org.nulllab.sorrowland.app.view.intro;

import org.nulllab.nullengine.core.common.resource.ImageLoader;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.ui.gui.GUIWindow;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.Context;
import org.nulllab.nullengine.core.geometry.Dimension;
import org.nulllab.nullengine.core.graphics.StringDrawer;
import org.nulllab.nullengine.core.graphics.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.sprite.SpriteSheet;
import org.nulllab.sorrowland.app.config.Configuration;
import org.nulllab.sorrowland.app.scene.IntroScene;
import org.nulllab.sorrowland.app.manager.Manager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class LogoView extends AbstractView<IntroScene, AbstractView> {

  private Configuration configuration;
  private Sprite        logoSprite;
  private StringDrawer  stringDrawer;

  private int counter     = 0xff;
  private int incrementer = 1;
  private int waitTimes   = 0x2ff;
  private int alpha       = 0;

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
      this.logoSprite = new Sprite(spriteSheet);
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.logoSprite.setDimension(dimension);
  }

  @Override
  public void render(Canvas canvas) {
    super.render(canvas);
    logoSprite.draw(canvas, 0, 0);
//    drawFading(canvas);
    stringDrawer.draw(canvas, 100, 500);
  }

  private void drawFading(Canvas canvas) {
    calculateOpacity();
    Color color = new Color(0, 0, 0, alpha);
//    canvas.setColor(color);
//    canvas.fillRect(0, 0, configuration.getWidth(), configuration.getHeight());
  }

  private void calculateOpacity() {
    if (waitTimes > 0 && counter == 0) {
      waitTimes--;
    } else if (waitTimes == 0 && 0xff == counter) {
      getControllerManager().setActiveScene(Manager.STATE_MENU);
    } else {
      incrementer = (0xff == counter || counter == 0) ? incrementer * -1 : incrementer;
      alpha = 0xff ^ (0xff - (counter += incrementer));
    }
  }

}
