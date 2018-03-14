package com.nullion.sorrowland.app.renderer.menu;

import com.nullion.appcore.common.resource.ImageLoader;
import com.nullion.appcore.gfx.Sprite;
import com.nullion.appcore.gfx.SpriteSheet;
import com.nullion.appcore.renderer.AbstractRenderer;
import com.nullion.appcore.service.AppContext;
import com.nullion.sorrowland.app.config.AppConfiguration;
import com.nullion.sorrowland.app.gfx.font.BoxySpriteFontMap;
import com.nullion.sorrowland.app.process.MenuProcess;
import com.nullion.sorrowland.app.state.MenuState;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MenuRenderer extends AbstractRenderer<MenuState, MenuProcess, AbstractRenderer> {

  private SpriteSheet       sheet;
  private BoxySpriteFontMap spriteFontMap;
  private AppConfiguration  configuration;

  public MenuRenderer(AppContext context, MenuState state, MenuProcess process) {
    super(context, state, process);
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
    g2d.drawString(getClass().getSimpleName(), 200, 200);
    g2d.drawString(configuration.getProperty("app.version"), 250, 250);

    String string = configuration.getAppFullName();// new Date().toString();

    int scale = 1;

    for (int i = 0; i < string.length(); i++) {
      new Sprite(sheet, scale, spriteFontMap.getPosition(string.charAt(i))).draw(g2d, 50 + (sheet.getSizeX() * scale) * i, 300);
    }

  }
}
