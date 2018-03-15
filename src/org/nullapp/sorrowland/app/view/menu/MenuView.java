package org.nullapp.sorrowland.app.view.menu;

import org.nullapp.appCore.common.resource.ImageLoader;
import org.nullapp.appCore.service.AppContext;
import org.nullapp.appCore.process.view.AbstractView;
import org.nullapp.gameCore.gfx.sprite.Sprite;
import org.nullapp.gameCore.gfx.sprite.SpriteSheet;
import org.nullapp.sorrowland.app.config.AppConfiguration;
import org.nullapp.sorrowland.app.controller.MenuController;
import org.nullapp.sorrowland.app.gfx.font.BoxySpriteFontMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class MenuView extends AbstractView<MenuController, AbstractView> {

  private SpriteSheet       sheet;
  private BoxySpriteFontMap spriteFontMap;
  private AppConfiguration  configuration;

  public MenuView(AppContext context, MenuController controller) {
    super(context, controller);
  }

  @Override
  public void doInitialize() {
    spriteFontMap = new BoxySpriteFontMap();
    configuration = (AppConfiguration) getContext().getConfiguration();
    configuration.initialize();

    InputStream inputStream = new ImageLoader("ui/fonts/boxy.png").getFileStream();

    try {
      sheet = new SpriteSheet(ImageIO.read(inputStream), 18, 16);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void render(Graphics2D g2d) {

    super.render(g2d);

    g2d.setColor(Color.ORANGE);
    g2d.drawOval(50, 50, 150, 150);

    String string = configuration.getAppFullName();

    int scale = 1;

    for (int i = 0; i < string.length(); i++) {
      new Sprite(sheet, scale, spriteFontMap.getPosition(string.charAt(i))).draw(g2d, 50 + (sheet.getSizeX() * scale) * i, 300);
    }
  }
}
