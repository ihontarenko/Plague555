package org.nulllab.sorrowland.app.scene;

import org.nulllab.nullengine.core.audio.AudioManager;
import org.nulllab.nullengine.core.common.Probability;
import org.nulllab.nullengine.core.event.Event;
import org.nulllab.nullengine.core.event.Observable;
import org.nulllab.nullengine.core.event.Observer;
import org.nulllab.nullengine.core.geometry.Bounds2D;
import org.nulllab.nullengine.core.graphics.Canvas;
import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpriteBatch;
import org.nulllab.nullengine.core.input.Keyboard;
import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.World;
import org.nulllab.nullengine.openworld.character.Character;
import org.nulllab.nullengine.openworld.character.Skills;
import org.nulllab.nullengine.openworld.character.level.Level;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.ObjectHelper;
import org.nulllab.nullengine.openworld.object.collision.CollisionDetector;
import org.nulllab.nullengine.openworld.object.component.graphics.Graphics;
import org.nulllab.nullengine.openworld.object.event.OnCollideEvent;
import org.nulllab.nullengine.openworld.object.event.OnMoveEvent;
import org.nulllab.nullengine.openworld.world.Camera;
import org.nulllab.nullengine.openworld.world.entities.monsters.Chicken;
import org.nulllab.nullengine.openworld.world.entities.monsters.Troll;
import org.nulllab.sorrowland.app.graphics.sheet.IconsSheetPackage;
import org.nulllab.sorrowland.app.graphics.sheet.Nature1SheetPackage;
import org.nulllab.sorrowland.app.graphics.sheet.TileSet1SheetPackage;
import org.nulllab.sorrowland.app.graphics.sheet.TileSet2SheetPackage;
import org.nulllab.sorrowland.app.graphics.sheet.characters.*;
import org.nulllab.sorrowland.app.graphics.sprite.Nature1Sprites;
import org.nulllab.sorrowland.app.graphics.sprite.PlayerSprites;
import org.nulllab.sorrowland.app.graphics.sprite.TilesASprites;
import org.nulllab.sorrowland.app.graphics.sprite.TilesBSprites;
import org.nulllab.sorrowland.app.scene.view.WorldTestView;
import org.nulllab.ui.gui.GUIFrame;
import org.nulllab.ui.process.scene.Scene;
import org.nulllab.ui.process.view.AbstractView;
import org.nulllab.ui.service.Context;

public class WorldTestScene extends Scene<AbstractView> {

  private Character character;
  private World     world;

  private AudioManager audioManager;
  private SpriteBatch  spriteBatch;

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

    int   health = 100;
    int   lvl    = 100;
    Level level  = new Level(1);
    Level level1 = new Level(37);

    Probability probability = new Probability(45);

    if (probability.generate()) {
      System.out.println(String.format("%d %% was probability what you see this", (int) probability.getProbability()));
    }

    Skills skills = new Skills();

    health = health + (int) (health / 10 * level.getScale());

    System.out.println(health);
    System.out.println(level.getCalculator().getExperience(13));

    skills.getDefense();
    skills.getDexterity();
    skills.getIntellegence();

    SpriteManager spriteManager = new SpriteManager();

    serviceLocator.addService(spriteManager.getClass(), spriteManager);
    serviceLocator.addService(AudioManager.class, new AudioManager());

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


    audioManager = serviceLocator.getAudioManager();
    audioManager.addAudio("walk", "sounds/footstep_grass.wav", .25D);
    audioManager.addAudio("collide", "sounds/footstep_stone.wav", 1D);

    audioManager.get("walk").setVolume(2F);

//    audioManager.replay("walk");

//    new Character(new ElfBreed());

//    character.getSkills().getDefense();

//    System.exit(1);

    // new TrollElf();

    System.out.println("before map parse...");

//    WorldMapLoader reader = new WorldMapLoader("map/World1.map");
//    reader.toMapData();


    world = new World();
    world.initialize();

//    character = new Character(serviceLocator.getInputKeyboard());
//    character = new Orc(serviceLocator.getInputKeyboard());
//    character = new Troll(serviceLocator.getInputKeyboard());
    character = new Chicken(serviceLocator.getInputKeyboard());

    Observable<GameObject> observable = character.getObservable();

    Graphics graphics = character.getGraphics();
//    graphics.setObjectSprites(new PlayerSprites());
    graphics.setSprite(graphics.getObjectSprites().getStandWest());

    character.layerUp();
    character.getPhysics().setOuterBounds(world.getWorldMap().getBound());

    character.setX(300);
    character.setY(420);

    world.addGameObject(character);

    observable.addObserver(world.getCamera().getObserver());
    observable.addObserver(new Observer<GameObject>() {

      @Override
      public void onNotify(GameObject observable, Event event) {

        switch (event.getName()) {
          case OnMoveEvent.NAME:
            audioManager.replay("walk");
            break;
          case OnCollideEvent.NAME:
            audioManager.replay("collide");
            break;
        }
      }
    });

    Camera   camera = world.getCamera();
    GUIFrame frame  = getContext().getGuiWindow().getMainFrame();

    frame.setSize(camera.getWidth(), camera.getHeight());

    serviceLocator.addService(World.class, world);

    // single event call for camera alignment
    observable.notify(character, new OnMoveEvent());


    System.out.println("SpatialHash Size: " + world.getSpatialHash().getObjects().size());
  }

  @Override
  public void doUpdate(float nano) {
    world.update(nano);
  }

  @Override
  public void render(Canvas canvas) {
//    Camera   camera = world.getCamera();
//    Bounds2D bounds = character.getPhysics().getInnerBounds();

    world.render(canvas);
//    System.out.println(bounds);
//    canvas.drawRectangle(bounds.getX() - camera.getX(), bounds.getY() - camera.getY(), bounds.getWidth(), bounds.getHeight());
  }
}
