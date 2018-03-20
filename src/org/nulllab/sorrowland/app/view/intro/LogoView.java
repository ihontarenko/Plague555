package org.nulllab.sorrowland.app.view.intro;

import org.nulllab.nullengine.core.common.resource.ImageLoader;
import org.nulllab.ui.gui.GUIWindow;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.AppContext;
import org.nulllab.nullengine.core.geometry.Dimension;
import org.nulllab.nullengine.core.graphics.StringDrawer;
import org.nulllab.nullengine.core.graphics.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.sprite.SpriteSheet;
import org.nulllab.sorrowland.app.config.AppConfiguration;
import org.nulllab.sorrowland.app.controller.IntroController;
import org.nulllab.sorrowland.app.manager.Manager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class LogoView extends AbstractView<IntroController, AbstractView> {

  private AppConfiguration configuration;
  private Sprite           logoSprite;
  private StringDrawer     stringDrawer;

  private int counter     = 0xff;
  private int incrementer = 1;
  private int waitTimes   = 0x2ff;
  private int alpha       = 0;

  public LogoView(AppContext context, IntroController controller) {
    super(context, controller);
  }

  @Override
  public void doInitialize() {
    configuration = (AppConfiguration) getContext().getConfiguration();

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
  public void render(Graphics2D g2d) {
    super.render(g2d);
    logoSprite.draw(g2d, 0, 0);
    drawFading(g2d);
    stringDrawer.draw(g2d, 100, 500);
  }

  private void drawFading(Graphics2D g2d) {
    calculateOpacity();
    Color color = new Color(0, 0, 0, alpha);
    g2d.setColor(color);
    g2d.fillRect(0, 0, configuration.getWidth(), configuration.getHeight());
  }

  private void calculateOpacity() {
    if (waitTimes > 0 && counter == 0) {
      waitTimes--;
    } else if (waitTimes == 0 && 0xff == counter) {
      getAppManager().setActiveController(Manager.STATE_MENU);
    } else {
      incrementer = (0xff == counter || counter == 0) ? incrementer * -1 : incrementer;
      alpha = 0xff ^ (0xff - (counter += incrementer));
    }
  }

}
