package org.plagueinc.sorrowland.renderer.menu;

import org.plagueinc.sorrowland.core.common.resource.ImageLoader;
import org.plagueinc.sorrowland.core.gfx.Sprite;
import org.plagueinc.sorrowland.core.gfx.SpriteSheet;
import org.plagueinc.sorrowland.core.process.AbstractProcess;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.core.state.AbstractState;
import org.plagueinc.sorrowland.gfx.font.BoxySpriteFontMap;
import org.plagueinc.sorrowland.manager.AppManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Date;

public class MenuRenderer extends AbstractRenderer<AppManager, AbstractState, AbstractProcess, AbstractRenderer> {

  private SpriteSheet       sheet;
  private BoxySpriteFontMap spriteFontMap;

  public MenuRenderer(AppManager appManager, AbstractState state, AbstractProcess process) {
    super(appManager, state, process);
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
