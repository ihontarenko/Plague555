package org.nulllab.sorrowland.app.scene;

import org.nulllab.nullengine.core.common.Probability;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sheet.SpriteSheet;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteBatch;
import org.nulllab.nullengine.core.input.Keyboard;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.World;
import org.nulllab.nullengine.openworld.character.Breed;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.character.Skills;
import org.nulllab.nullengine.openworld.character.level.Level;
import org.nulllab.nullengine.openworld.object.ObjectHelper;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;
import org.nulllab.nullengine.openworld.object.component.graphics.Graphics;
import org.nulllab.nullengine.openworld.world.Camera;
import org.nulllab.sorrowland.app.graphics.sheet.*;
import org.nulllab.sorrowland.app.graphics.sheet.characters.*;
import org.nulllab.sorrowland.app.graphics.sprite.Nature1Sprites;
import org.nulllab.sorrowland.app.graphics.sprite.PlayerSprites;
import org.nulllab.sorrowland.app.graphics.sprite.TilesASprites;
import org.nulllab.sorrowland.app.graphics.sprite.TilesBSprites;
import org.nulllab.sorrowland.app.manager.Manager;
import org.nulllab.sorrowland.app.scene.view.WorldTestView;
import org.nulllab.ui.gui.GUIFrame;
import org.nulllab.ui.process.scene.Scene;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.Context;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class WorldTestScene extends Scene<AbstractView> {

  private Character character;
  private World world;

  private SpriteBatch spriteBatch;

  public WorldTestScene(Context context) {
    super(context);
  }

  @Override
  protected void doInitialize() {
    registerView("default", WorldTestView.class, getContext(), this);
    setActiveView("default");

    ServiceLocator serviceLocator = ServiceLocator.getInstance();

    serviceLocator.addService(ObjectHelper.class);
    serviceLocator.addService(CollisionDetector.class);
    serviceLocator.addService(Keyboard.class, getContext().getInputKey());

//    for (int i = 1; i < 100; i++) {
//      Level level = new Level(i);
//      System.out.println("lvl: " + i + ", health: " + 100* level.getScale());
//    }

    int health = 100;
    int lvl = 100;
    Level level = new Level(1);
    Level level1 = new Level(37);

    Probability probability = new Probability(45);

    if (probability.generate()) {
      System.out.println(String.format("%d %% was probability what you see this", (int)probability.getProbability()));
    }

    Skills skills = new Skills();

    health = health + (int)(health / 10 * level.getScale());

    System.out.println(health);
    System.out.println(level.getCalculator().getExperience(13));



    skills.getDefense();
    skills.getDexterity();
    skills.getIntellegence();


    Breed trollDarkElf = new Breed("Troll");
    trollDarkElf.setParentBreed(new Breed("Dark Elf"));
    trollDarkElf.getParent().setParentBreed(new Breed("Zombie Genom"));
    System.out.println(trollDarkElf.getFullName("/"));

//    Orc orc = new Orc();
//    orc.getBreed().setParentBreed(new Breed("Dwarf"));
//    System.out.println(orc);

    SpriteManager spriteManager = new SpriteManager();
    serviceLocator.addService(spriteManager.getClass(), spriteManager);

    spriteManager.addSheetPackage(new A01ASheetPackage());
    spriteManager.addSheetPackage(new A01BSheetPackage());
    spriteManager.addSheetPackage(new A02ASheetPackage());
    spriteManager.addSheetPackage(new A02BSheetPackage());
    spriteManager.addSheetPackage(new A02CSheetPackage());
    spriteManager.addSheetPackage(new A02DSheetPackage());
    spriteManager.addSheetPackage(new A03ASheetPackage());
    spriteManager.addSheetPackage(new A03BSheetPackage());
    spriteManager.addSheetPackage(new A03CSheetPackage());
    spriteManager.addSheetPackage(new A03DSheetPackage());
    spriteManager.addSheetPackage(new A03ESheetPackage());
    spriteManager.addSheetPackage(new A03FSheetPackage());
    spriteManager.addSheetPackage(new A03GSheetPackage());

    spriteManager.addSheetPackage(new OrcAssassinAPackage());
    spriteManager.addSheetPackage(new Monster1ShadowLeggyPackage());
    spriteManager.addSheetPackage(new IconsSheetPackage());
    spriteManager.addSheetPackage(new TileSet2SheetPackage());
    spriteManager.addSheetPackage(new TileSet1SheetPackage());
    spriteManager.addSheetPackage(new Nature1SheetPackage());

    spriteManager.addSpritePackage(new TilesASprites());
    spriteManager.addSpritePackage(new TilesBSprites());
    spriteManager.addSpritePackage(new PlayerSprites());
    spriteManager.addSpritePackage(new Nature1Sprites());

//    System.out.println(serviceLocator.getService(InputComponent.class));
//    System.exit(1);

    character = new Character(trollDarkElf, serviceLocator.getInputKeyboard());
    character.layerUp();

    Graphics graphics = character.getGraphics();
    graphics.setObjectSprites(new PlayerSprites());
    graphics.setSprite(graphics.getObjectSprites().getStandWest());

//    new Character(new ElfBreed());

//    character.getSkills().getDefense();

//    System.exit(1);

    // new TrollElf();

    System.out.println("before map parse...");

//    WorldMapLoader reader = new WorldMapLoader("map/World1.map");
//    reader.toMapData();


    world = new World();
    world.initialize();

    world.addGameObject(character);

    character.getPhysics().setOuterBounds(world.getWorldMap().getBound());
    character.getObservable().addObserver(world.getCamera().getObserver());

    Camera camera = world.getCamera();
    GUIFrame frame = getContext().getGuiWindow().getMainFrame();

    frame.setSize(camera.getWidth(), camera.getHeight());

    serviceLocator.addService(World.class, world);

    System.out.println("SpatialHash Size: " + world.getSpatialHash().getObjects().size());
  }

  @Override
  public void doUpdate(float nano) {
    getGuiWindow().getCanvas().setDefaultColor(0xffcccccc);

    if (getInputKey().isPressed(KeyEvent.VK_ESCAPE)) {
      getSceneManager().setActiveScene(Manager.STATE_INTRO);
    }

    world.update(nano);

//    character.update(nano);
  }

  @Override
  public void render(Canvas canvas) {
    world.render(canvas);

//    Camera camera = world.getCamera();


//    List<GameObject> objects = character.getCollision().getNearestSolidObjects();

//    canvas.setColor(0x55ff0000);
//
//    objects.forEach(object -> {
//      double x = object.getX() - camera.getX();
//      double y = object.getY() - camera.getY();
//
//      canvas.drawFilledRectangle(x, y, object.getWidth(), object.getHeight());
//    });

//    Bounds2D spatialBounds = character.getBounds().getSpatialBounds();
//    Bounds2D innerBounds   = character.getBounds().getInnerBounds();

//    canvas.setColor(0x5500ff00);
//    canvas.drawRectangle(spatialBounds.getX() - camera.getX(), spatialBounds.getY()  - camera.getY(), spatialBounds.getWidth(), spatialBounds.getHeight());
//    canvas.setColor(0x550000ff);
//    canvas.drawRectangle(innerBounds.getX() - camera.getX(), innerBounds.getY()  - camera.getY(), innerBounds.getWidth(), innerBounds.getHeight());

//    character.render(canvas);
  }
}
