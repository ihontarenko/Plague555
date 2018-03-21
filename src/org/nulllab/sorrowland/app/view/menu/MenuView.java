package org.nulllab.sorrowland.app.view.menu;

import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.Context;
import org.nulllab.nullengine.core.common.time.Timer;
import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.geometry.intersection.spatialhash.SpatialHash;
import org.nulllab.nullengine.core.graphics.StringDrawer;
import org.nulllab.nullengine.core.graphics.sprite.SpriteAnimated;
import org.nulllab.nullengine.core.graphics.sprite.SpriteSheet;
import org.nulllab.nullengine.core.common.resource.ImageLoader;
import org.nulllab.sorrowland.app.config.Configuration;
import org.nulllab.sorrowland.app.scene.MenuScene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class MenuView extends AbstractView<MenuScene, AbstractView> {

  private SpriteSheet    sheet;
  private SpriteAnimated spriteAnimated;
  private StringDrawer   spriteFontMap;
  private Configuration  configuration;
  private SpatialHash    spatialHash;
  private Set<Integer>   integerList;
  private Bound2D        bound2D;
  private Object2D       object1;
  private Object2D       object2;
  private Object2D       object3;
  private Timer          timer;
  private Input          input;

  private int velocity = 1;

  public MenuView(Context context, MenuScene controller) {
    super(context, controller);
  }

  @Override
  public void doInitialize() {
    timer = new Timer(0.1);

    input = getContext().getInputKey();

    spriteFontMap = getContext().getStringDrawer();

    configuration = (Configuration) getContext().getConfiguration();
    configuration.initialize();

    bound2D = new Bound2D(10, 10, 780, 580);
    spatialHash = new SpatialHash(bound2D, 3);
    object1 = new Object2D(120, 150, 40, 40);

    spatialHash.insert(object1);
    spatialHash.insert(new Object2D(120, 150, 150, 50));
    spatialHash.insert(new Object2D(250, 190, 200, 200));

    for (int i = 0; i < 10000; i++) {
      spatialHash.insert(new Object2D(10, 150, 50, 50));
    }

    integerList = spatialHash.calculateObjectKeys(object1);

    InputStream inputStream = new ImageLoader("common/vx_chara01_b.png").getFileStream();

    try {
      sheet = new SpriteSheet(ImageIO.read(inputStream), 32, 48);
    } catch (IOException e) {
      e.printStackTrace();
    }

    spriteAnimated = new SpriteAnimated(sheet, 5, 1, 9, 11);
    spriteAnimated.setDirection(SpriteAnimated.Direction.PINGPONG);
  }

  @Override
  public void render(Canvas canvas) {

    super.render(canvas);

    if (input.isPressed(KeyEvent.VK_1, true)) {
      System.out.println("one is pressed...");
    }

    spriteFontMap.setString("exp: ");

    spriteAnimated.draw(canvas, 10, 10);

    spriteFontMap.draw(canvas, 100, 100);
    if (object1.getMaxX() > bound2D.getMaxX()) {
      velocity = -1;
    }

    if (object1.getX() < bound2D.getX()) {
      velocity = 1;
    }

    int size = spatialHash.getSize();

    spatialHash.reinsert(object1);

    object1.setX(object1.getX() + velocity);

//    canvas.setColor(Color.WHITE);

//    for (int x = bound2D.getX(); x < bound2D.getMaxX(); x += size) {
//      for (int y = bound2D.getY(); y < bound2D.getMaxY(); y += size) {
//        g2d.drawRect(x, y, size, size);
//      }
//    }

    spriteAnimated.draw(canvas, 10, 10);

    canvas.setColor(Color.RED.getRGB());
    canvas.drawRectangle(bound2D.getX(), bound2D.getY(), bound2D.getWidth(), bound2D.getHeight());

//    for (Object2D object2D : spatialHash.getObjects()) {
//      g2d.setColor(Color.GREEN);
//      spatialHash.getObjectKeys(object2D).forEach(key -> g2d.drawRect(spatialHash.getXPixel(key), spatialHash.getYPixel(key), size, size));
//      g2d.setColor(Color.MAGENTA);
//      g2d.drawRect(object2D.getX(), object2D.getY(), object2D.getWidth(), object2D.getHeight());
//    }

//    System.out.println("retrieved: " + spatialHash.retrieve(object1).size());

//    g2d.setColor(Color.RED);
//    g2d.drawRect(object1.getX(), object1.getY(), object1.getWidth(), object1.getHeight());

//    for (Object2D object2D : spatialHash.retrieve(object1)) {
//      g2d.drawRect(object2D.getX(), object2D.getY(), object2D.getWidth(), object2D.getHeight());
//    }
  }
}
