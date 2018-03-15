package org.nullapp.sorrowland.app.view.intro;

import org.nullapp.appCore.common.resource.ImageLoader;
import org.nullapp.appCore.gui.GUIWindow;
import org.nullapp.appCore.process.view.AbstractView;
import org.nullapp.appCore.service.AppContext;
import org.nullapp.gameCore.geometry.Dimension;
import org.nullapp.gameCore.gfx.StringDrawer;
import org.nullapp.gameCore.gfx.sprite.Sprite;
import org.nullapp.gameCore.gfx.sprite.SpriteSheet;
import org.nullapp.sorrowland.app.config.AppConfiguration;
import org.nullapp.sorrowland.app.controller.IntroController;
import org.nullapp.sorrowland.app.manager.Manager;

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
