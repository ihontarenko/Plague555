package org.plagueinc.sorrowland.renderer.intro;

import org.plagueinc.sorrowland.controller.intro.IntroController;
import org.plagueinc.sorrowland.core.common.resource.ImageLoader;
import org.plagueinc.sorrowland.core.common.resource.PropertiesLoader;
import org.plagueinc.sorrowland.core.gfx.SpriteAnimated;
import org.plagueinc.sorrowland.core.gfx.SpriteSheet;
import org.plagueinc.sorrowland.core.renderer.AbstractRenderer;
import org.plagueinc.sorrowland.manager.StateManager;
import org.plagueinc.sorrowland.state.IntroState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class Animation2Renderer extends AbstractRenderer<StateManager, IntroState, IntroController, AbstractRenderer> {

  private SpriteSheet sheet;
  private SpriteSheet sheet2;
  private SpriteAnimated spriteAnimated;
  private SpriteAnimated spriteAnimated2;

  public Animation2Renderer(StateManager sm, IntroState state, IntroController controller) {
    super(sm, state, controller);
  }

  @Override
  public void doInitialize() {
    try {
      sheet = new SpriteSheet(ImageIO.read(new ImageLoader("ui/fonts/boxy.png").getFileStream()), 18, 16);
      sheet2 = new SpriteSheet(ImageIO.read(new ImageLoader("ui/fonts/font1.bmp").getFileStream()), 16, 18);

      System.out.println(sheet.inWidth() + " / " + sheet.inHeight());
      System.out.println(sheet.inWidth() + " / " + sheet2.inHeight());

      spriteAnimated = new SpriteAnimated(sheet, 5, 5);
      spriteAnimated2 = new SpriteAnimated(sheet2, 5, 1);

      spriteAnimated2.setTransparentColor(0xff000000);
      spriteAnimated2.setOpacity(0F);

      Properties properties = new PropertiesLoader("ui/fonts/boxy.properties").load();
      System.out.println(properties.getProperty("foo.bar"));

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
  }

}
