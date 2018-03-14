package com.nullion.sorrowland.app.view.menu;

import com.nullion.appcore.common.resource.ImageLoader;
import com.nullion.appcore.gfx.sprite.Sprite;
import com.nullion.appcore.gfx.sprite.SpriteSheet;
import com.nullion.appcore.view.AbstractView;
import com.nullion.appcore.service.AppContext;
import com.nullion.sorrowland.app.config.AppConfiguration;
import com.nullion.sorrowland.app.gfx.font.BoxySpriteFontMap;
import com.nullion.sorrowland.app.controller.MenuController;
import com.nullion.sorrowland.app.state.MenuState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class MenuView extends AbstractView<MenuState, MenuController, AbstractView> {

  private SpriteSheet       sheet;
  private BoxySpriteFontMap spriteFontMap;
  private AppConfiguration  configuration;

  public MenuView(AppContext context, MenuState state, MenuController controller) {
    super(context, state, controller);
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
