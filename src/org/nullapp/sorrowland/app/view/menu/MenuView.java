package org.nullapp.sorrowland.app.view.menu;

import org.nullapp.appCore.common.resource.ImageLoader;
import org.nullapp.appCore.service.AppContext;
import org.nullapp.appCore.process.view.AbstractView;
import org.nullapp.gameCore.gfx.sprite.Sprite;
import org.nullapp.gameCore.gfx.sprite.SpriteAnimated;
import org.nullapp.gameCore.gfx.sprite.SpriteSheet;
import org.nullapp.sorrowland.app.config.AppConfiguration;
import org.nullapp.sorrowland.app.controller.MenuController;
import org.nullapp.sorrowland.app.gfx.font.BoxySpriteFontMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class MenuView extends AbstractView<MenuController, AbstractView> {

  private SpriteSheet      sheet;
  private SpriteAnimated   spriteAnimated;
  private AppConfiguration configuration;

  public MenuView(AppContext context, MenuController controller) {
    super(context, controller);
  }

  @Override
  public void doInitialize() {
    configuration = (AppConfiguration) getContext().getConfiguration();
    configuration.initialize();

    InputStream inputStream = new ImageLoader("common/newchar03-3.png").getFileStream();

    try {
      sheet = new SpriteSheet(ImageIO.read(inputStream), 32, 32);
    } catch (IOException e) {
      e.printStackTrace();
    }

    spriteAnimated = new SpriteAnimated(sheet, 5, 1, 0, 2);
  }

  @Override
  public void render(Graphics2D g2d) {

    super.render(g2d);

    spriteAnimated.draw(g2d, 10, 10);
  }
}
