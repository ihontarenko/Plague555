package org.plagueinc.sorrowland.renderer.intro;

import org.plagueinc.sorrowland.core.common.resource.ImageLoader;
import org.plagueinc.sorrowland.core.gfx.Sprite;
import org.plagueinc.sorrowland.core.gfx.SpriteAnimated;
import org.plagueinc.sorrowland.core.gfx.SpriteSheet;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.gfx.font.BoxySpriteFontMap;
import org.plagueinc.sorrowland.manager.AppManager;
import org.plagueinc.sorrowland.process.intro.IntroProcess;
import org.plagueinc.sorrowland.state.IntroState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Date;

public class Animation2Renderer extends AbstractRenderer<AppManager, IntroState, IntroProcess, AbstractRenderer> {

  private SpriteSheet           sheet;
  private SpriteSheet           sheet2;
  private SpriteAnimated        spriteAnimated;
  private SpriteAnimated        spriteAnimated2;
  private BoxySpriteFontMap     spriteFontMap;

  public Animation2Renderer(AppManager appManager, IntroState state, IntroProcess process) {
    super(appManager, state, process);
  }

  @Override
  public void doInitialize() {
    try {

      spriteFontMap = new BoxySpriteFontMap();

      sheet = new SpriteSheet(ImageIO.read(new ImageLoader("ui/fonts/boxy.png").getFileStream()), 18, 16);
      sheet2 = new SpriteSheet(ImageIO.read(new ImageLoader("ui/fonts/font1.bmp").getFileStream()), 16, 18);

      spriteAnimated = new SpriteAnimated(sheet, 10, 4);
      spriteAnimated2 = new SpriteAnimated(sheet2, 5, 5);

      spriteAnimated2.setTransparentColor(0xff000000);
      spriteAnimated2.setOpacity(0F);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void render(Graphics2D g2d) {
    super.render(g2d);

    g2d.setColor(Color.BLACK);
    g2d.drawOval(50, 50, 150, 150);
    g2d.drawString(getClass().getSimpleName(), 200, 200);

    spriteAnimated.draw(g2d, 50, 50);
    spriteAnimated2.draw(g2d, 300, 300);

    String string = new Date().toString();

    int scale = 1;

    for (int i = 0; i < string.length(); i++) {
      new Sprite(sheet, scale, spriteFontMap.getPosition(string.charAt(i))).draw(g2d, (sheet.getSizeX() * scale) * i, 300);
    }


  }

}
