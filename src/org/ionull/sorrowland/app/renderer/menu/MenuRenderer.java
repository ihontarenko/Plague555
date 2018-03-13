package org.ionull.sorrowland.app.renderer.menu;

import org.ionull.sorrowland.app.process.MenuProcess;
import org.ionull.sorrowland.app.state.MenuState;
import org.ionull.sorrowland.core.common.resource.ImageLoader;
import org.ionull.sorrowland.core.gfx.Sprite;
import org.ionull.sorrowland.core.gfx.SpriteSheet;
import org.ionull.sorrowland.core.renderer.AbstractRenderer;
import org.ionull.sorrowland.core.service.AppContext;
import org.ionull.sorrowland.app.gfx.font.BoxySpriteFontMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Date;

public class MenuRenderer extends AbstractRenderer<MenuState, MenuProcess, AbstractRenderer> {

  private SpriteSheet       sheet;
  private BoxySpriteFontMap spriteFontMap;

  public MenuRenderer(AppContext context, MenuState state, MenuProcess process) {
    super(context, state, process);
  }

  @Override
  public void doInitialize() {
    spriteFontMap = new BoxySpriteFontMap();
    try {
      sheet = new SpriteSheet(ImageIO.read(new ImageLoader("ui/fonts/boxy.png").getFileStream()), 18, 16);
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
    g2d.drawString("Троль", 250, 250);

    String string = new Date().toString();

    int scale = 1;

    for (int i = 0; i < string.length(); i++) {
      new Sprite(sheet, scale, spriteFontMap.getPosition(string.charAt(i))).draw(g2d, 50 + (sheet.getSizeX() * scale) * i, 300);
    }

  }
}
