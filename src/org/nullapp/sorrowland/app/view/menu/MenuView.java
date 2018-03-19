package org.nullapp.sorrowland.app.view.menu;

import org.nullapp.appCore.common.resource.ImageLoader;
import org.nullapp.appCore.process.view.AbstractView;
import org.nullapp.appCore.service.AppContext;
import org.nullapp.gameCore.gfx.StringDrawer;
import org.nullapp.gameCore.gfx.sprite.SpriteAnimated;
import org.nullapp.gameCore.gfx.sprite.SpriteSheet;
import org.nullapp.sorrowland.app.config.AppConfiguration;
import org.nullapp.sorrowland.app.controller.MenuController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class MenuView extends AbstractView<MenuController, AbstractView> {

  private SpriteSheet      sheet;
  private SpriteAnimated   spriteAnimated;
  private StringDrawer     spriteFontMap;
  private AppConfiguration configuration;

  public MenuView(AppContext context, MenuController controller) {
    super(context, controller);
  }

  @Override
  public void doInitialize() {
    spriteFontMap = getContext().getStringDrawer();

    try {
      sheet = new SpriteSheet(ImageIO.read(new ImageLoader("common/bigset.png").getFileStream()), 24);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.printf("BigSet Size: %d%n", sheet.count());

    spriteAnimated = new SpriteAnimated(sheet, 10, 3);
  }

  @Override
  public void render(Graphics2D g2d) {

    super.render(g2d);

    spriteFontMap.setString(getClass().getName());

    spriteAnimated.draw(g2d, 10, 10);

    spriteFontMap.draw(g2d, 100, 100);
  }
}
