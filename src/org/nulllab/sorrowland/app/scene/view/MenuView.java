package org.nulllab.sorrowland.app.scene.view;

import org.nulllab.nullengine.core.common.time.Timer;
import org.nulllab.nullengine.core.geometry.Bound2D;
import org.nulllab.nullengine.core.geometry.Object2D;
import org.nulllab.nullengine.core.geometry.intersection.spatialhash.SpatialHash;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.StringDrawer;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteAnimated;
import org.nulllab.nullengine.core.input.Input;
import org.nulllab.nullengine.core.input.Keyboard;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.map.WorldMapLoader;
import org.nulllab.nullengine.openworld.map.Terrain;
import org.nulllab.sorrowland.app.config.Configuration;
import org.nulllab.sorrowland.app.graphics.sheet.*;
import org.nulllab.sorrowland.app.graphics.sheet.characters.*;
import org.nulllab.sorrowland.app.graphics.sprite.PlayerSprites;
import org.nulllab.sorrowland.app.scene.MenuScene;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.Context;

import java.awt.event.KeyEvent;
import java.util.List;

public class MenuView extends AbstractView<MenuScene, AbstractView> {

  private SpriteSheet        sheet;
  private SpriteAnimated     spriteAnimated;
  private StringDrawer       spriteFontMap;
  private Configuration      configuration;
  private SpatialHash        spatialHash;
  private List<Integer>      integerList;
  private Bound2D            bound2D;
  private Object2D           object1;
  private Object2D           object2;
  private Object2D           object3;
  private Timer              timer;
  private Input              input;
  private SpriteSheetPackage sheetPackage;
  private Terrain[][]        worldMap;
  private Sprite             sprite;
  private Character          character;

  private PlayerSprites spritePackage;

  private int velocity = 1;

  public MenuView(Context context, MenuScene controller) {
    super(context, controller);
  }

  @Override
  public void doInitialize() {

//    WorldMapLoader reader = new WorldMapLoader("map/World1.map");
//    reader.toMapData();

    System.out.println("before world map init...");

    int width  = 1200;
    int height = 800;

    worldMap = new Terrain[width][height];

    for (int w = 0; w < width; w++) {
      for (int h = 0; h < height; h++) {
        worldMap[w][h] = new Terrain(w, h, w, h);
      }
    }

    System.out.println("after world map init...");


    sheetPackage = new WorldTilesSpritePackage();

    timer = new Timer(0.1);

    input = getContext().getInputKey();

    spriteFontMap = getContext().getStringDrawer();

    configuration = (Configuration) getContext().getConfiguration();
    configuration.initialize();

    bound2D = new Bound2D(0, 0, 800, 600);
    spatialHash = new SpatialHash(bound2D, 5);
    object1 = new Object2D(120, 150, 40, 40);

    spatialHash.insert(object1);
    spatialHash.insert(new Object2D(120, 150, 150, 50));
    spatialHash.insert(new Object2D(250, 190, 200, 200));

    for (int i = 0; i < 10000; i++) {
      spatialHash.insert(new Object2D(10, 150, 50, 50));
    }

    int counter = 0;

    System.out.println(sheetPackage.getPackageName());

    SpriteManager spriteManager = new SpriteManager();
    spriteManager.addSheetPackage(sheetPackage);

    spriteManager.addSheetPackage(new A02ASheetPackage());
    spriteManager.addSheetPackage(new A01ASheetPackage());
    spriteManager.addSheetPackage(new A01BSheetPackage());
    spriteManager.addSheetPackage(new OrcAssassinAPackage());
    spriteManager.addSheetPackage(new Monster1ShadowLeggyPackage());
    spriteManager.addSheetPackage(new IconsSheetPackage());

    spriteManager.addSpritePackage(new PlayerSprites());

    SpriteSheet icons = spriteManager.getSheetFromPackage("iconSet", "set1");
    System.out.println(icons.count());
    /*for (SpriteSheet spriteSheet : .values()) {
      try {
        File outputFile = new File(String.format("resources/cached/icon%d.png", counter++));
        ImageIO.write(spriteSheet.getBufferedImage(), "png", outputFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }*/

//    character = new Character(/*new Breed(15.0D, "test")*/null);

    ServiceLocator serviceLocator = ServiceLocator.getInstance();

    serviceLocator.addService(SpriteManager.class, spriteManager);
    serviceLocator.addService(Keyboard.class, input);

    spritePackage = (PlayerSprites) spriteManager.getSpritePackage("mp1m6");
    System.out.println(spritePackage);
    sprite = spritePackage.getStandNorth();

    //    spriteAnimated = spriteManager.getSheetFromPackage(WorldTilesSpritePackage.class, "sheet3")

    spriteAnimated = new SpriteAnimated(icons, 5);
    spriteAnimated.setDirection(SpriteAnimated.Direction.PING_PONG);

    System.out.println(spriteAnimated.countImages());
//    System.out.println(character.getHealth());
  }

  @Override
  public void render(Canvas canvas) {

    super.render(canvas);

//    character.update(1.0f);

    if (input.isPressed(KeyEvent.VK_1, true)) {
      sprite = spritePackage.getStandSouth();
    } else if (input.isPressed(KeyEvent.VK_DOWN, true)) {
      sprite = spritePackage.getMoveSouth();
    } else if (input.isPressed(KeyEvent.VK_UP, true)) {
      sprite = spritePackage.getMoveNorth();
    } else if (input.isPressed(KeyEvent.VK_RIGHT, true)) {
      sprite = spritePackage.getMoveEast();
    } else if (input.isPressed(KeyEvent.VK_LEFT, true)) {
      sprite = spritePackage.getMoveWest();
    }

    spriteFontMap.setString("exp: 90813");

    //    spriteAnimated.draw(canvas, 0, 0);

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

    for (double x = bound2D.getX(); x < bound2D.getMaxX(); x += sprite.getWidth()) {
      for (double y = bound2D.getY(); y < bound2D.getMaxY(); y += sprite.getHeight()) {

        //                canvas.drawRectangle((int)x, (int)y, size, size);
        spriteAnimated.draw(canvas, x, y);
      }
    }

    sprite.draw(canvas, 200, 200);

//    character.render(canvas);

    //    canvas.setColor(Color.RED.getRGB());
    //    canvas.drawRectangle(bound2D.getPositionX(), bound2D.getPositionY(), bound2D.getWidth(), bound2D.getHeight());

    //    for (Object2D object2D : spatialHash.getObjects()) {
    //      g2d.setColor(Color.GREEN);
    //      spatialHash.getObjectKeys(object2D).forEach(key -> g2d.drawRect(spatialHash.getXPixel(key), spatialHash.getYPixel(key), size, size));
    //      g2d.setColor(Color.MAGENTA);
    //      g2d.drawRect(object2D.getPositionX(), object2D.getPositionY(), object2D.getWidth(), object2D.getHeight());
    //    }

    //    System.out.println("retrieved: " + spatialHash.retrieve(object1).size());

    //    g2d.setColor(Color.RED);
    //    g2d.drawRect(object1.getPositionX(), object1.getPositionY(), object1.getWidth(), object1.getHeight());

    //    for (Object2D object2D : spatialHash.retrieve(object1)) {
    //      g2d.drawRect(object2D.getPositionX(), object2D.getPositionY(), object2D.getWidth(), object2D.getHeight());
    //    }
  }
}
