package com.nullion.sorrowland.app.renderer.intro;

import com.nullion.appcore.common.resource.ImageLoader;
import com.nullion.appcore.gfx.Sprite;
import com.nullion.appcore.gfx.SpriteAnimated;
import com.nullion.appcore.gfx.SpriteSheet;
import com.nullion.appcore.renderer.AbstractRenderer;
import com.nullion.sorrowland.app.gfx.font.BoxySpriteFontMap;
import com.nullion.sorrowland.app.process.IntroProcess;
import com.nullion.sorrowland.app.state.IntroState;
import com.nullion.appcore.service.AppContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Date;

public class Animation2Renderer extends AbstractRenderer<IntroState, IntroProcess, AbstractRenderer> {

  private SpriteSheet           sheet;
  private SpriteSheet           sheet2;
  private SpriteAnimated        spriteAnimated;
  private SpriteAnimated        spriteAnimated2;
  private BoxySpriteFontMap     spriteFontMap;

  public Animation2Renderer(AppContext context, IntroState state, IntroProcess process) {
    super(context, state, process);
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
