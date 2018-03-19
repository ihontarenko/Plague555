package org.nullapp.sorrowland.app.view.menu;

import org.nullapp.appCore.common.resource.ImageLoader;
import org.nullapp.appCore.process.view.AbstractView;
import org.nullapp.appCore.service.AppContext;
import org.nullapp.gameCore.geometry.Bound2D;
import org.nullapp.gameCore.geometry.Object2D;
import org.nullapp.gameCore.geometry.intersection.spatialhash.SpatialHash;
import org.nullapp.gameCore.gfx.sprite.SpriteAnimated;
import org.nullapp.gameCore.gfx.sprite.SpriteSheet;
import org.nullapp.sorrowland.app.config.AppConfiguration;
import org.nullapp.sorrowland.app.controller.MenuController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MenuView extends AbstractView<MenuController, AbstractView> {

  private SpriteSheet      sheet;
  private SpriteAnimated   spriteAnimated;
  private AppConfiguration configuration;
  private SpatialHash      spatialHash;
  private List<Integer>    integerList;
  private Object2D         object2D;
  private Bound2D          bound2D;

  private int velocity = 1;

  public MenuView(AppContext context, MenuController controller) {
    super(context, controller);
  }

  @Override
  public void doInitialize() {
    configuration = (AppConfiguration) getContext().getConfiguration();
    configuration.initialize();

    bound2D = new Bound2D(120, 150, 600, 400);
    spatialHash = new SpatialHash(bound2D, 5);
    object2D = new Object2D(150, 200, 250, 250);

    integerList = spatialHash.getObjectKeys(object2D);

    InputStream inputStream = new ImageLoader("common/vx_chara01_b.png").getFileStream();

    try {
      sheet = new SpriteSheet(ImageIO.read(inputStream), 32, 48);
    } catch (IOException e) {
      e.printStackTrace();
    }

    spriteAnimated = new SpriteAnimated(sheet, 5, 1, 9, 11);
    spriteAnimated.setDirection(SpriteAnimated.Direction.PINPONG);
  }

  @Override
  public void render(Graphics2D g2d) {

    super.render(g2d);

    if (object2D.getMaxX() > bound2D.getMaxX()) {
      velocity = -1;
    }

    if (object2D.getX() < bound2D.getX()) {
      velocity = 1;
    }

    int size = spatialHash.getSize();

//    spatialHash.updateObject2D(object2D);

    object2D.setX(object2D.getX() + velocity);

    integerList = spatialHash.getObjectKeys(object2D);

    g2d.setColor(Color.WHITE);

    for (int x = bound2D.getX(); x < bound2D.getMaxX(); x += size) {
      for (int y = bound2D.getY(); y < bound2D.getMaxY(); y += size) {
        g2d.drawRect(x, y, size, size);
      }
    }

    System.out.println(object2D.getX());

    spriteAnimated.draw(g2d, 10, 10);

    g2d.setColor(Color.RED);
    g2d.drawRect(bound2D.getX(), bound2D.getY(), bound2D.getWidth(), bound2D.getHeight());

    g2d.setColor(Color.GREEN);

    integerList.forEach(key -> g2d.drawRect(spatialHash.getXPixel(key), spatialHash.getYPixel(key), size, size));

    g2d.setColor(Color.MAGENTA);
    g2d.drawRect(object2D.getX(), object2D.getY(), object2D.getWidth(), object2D.getHeight());
  }
}
