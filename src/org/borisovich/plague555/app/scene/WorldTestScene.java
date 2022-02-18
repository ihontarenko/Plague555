package org.borisovich.plague555.app.scene;

import org.borisovich.core.core.audio.AudioManager;
import org.borisovich.core.core.common.Probability;
import org.borisovich.core.core.event.Event;
import org.borisovich.core.core.event.Observable;
import org.borisovich.core.core.event.Observer;
import org.borisovich.core.core.graphics.Canvas;
import org.borisovich.core.core.graphics.spritesheet.SpriteManager;
import org.borisovich.core.core.graphics.spritesheet.sprite.SpriteBatch;
import org.borisovich.core.core.input.Keyboard;
import org.borisovich.core.openworld.ServiceLocator;
import org.borisovich.core.openworld.World;
import org.borisovich.core.openworld.character.Character;
import org.borisovich.core.openworld.character.level.Level;
import org.borisovich.core.openworld.object.GameObject;
import org.borisovich.core.openworld.object.ObjectHelper;
import org.borisovich.core.openworld.object.collision.CollisionDetector;
import org.borisovich.core.openworld.object.component.graphics.Graphics;
import org.borisovich.core.openworld.object.event.OnCollideEvent;
import org.borisovich.core.openworld.object.event.OnMoveEvent;
import org.borisovich.core.openworld.world.Camera;
import org.borisovich.core.openworld.world.entities.monsters.Orc;
import org.borisovich.plague555.app.graphics.sheet.characters.*;
import org.borisovich.plague555.app.graphics.sheet.IconsSheetPackage;
import org.borisovich.plague555.app.graphics.sheet.Nature1SheetPackage;
import org.borisovich.plague555.app.graphics.sheet.TileSet1SheetPackage;
import org.borisovich.plague555.app.graphics.sheet.TileSet2SheetPackage;
import org.borisovich.sorrowland.app.graphics.sheet.characters.*;
import org.borisovich.plague555.app.graphics.sprite.Nature1Sprites;
import org.borisovich.plague555.app.graphics.sprite.PlayerSprites;
import org.borisovich.plague555.app.graphics.sprite.TilesASprites;
import org.borisovich.plague555.app.graphics.sprite.TilesBSprites;
import org.borisovich.plague555.app.scene.view.WorldTestView;
import org.borisovich.ui.gui.GUIFrame;
import org.borisovich.ui.process.scene.Scene;
import org.borisovich.ui.process.view.AbstractView;
import org.borisovich.ui.service.Context;

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

    try {
      registerView("default", WorldTestView.class, getContext(), this);
      setActiveView("default");

      ServiceLocator serviceLocator = ServiceLocator.getInstance();

      serviceLocator.addService(ObjectHelper.class);
      serviceLocator.addService(CollisionDetector.class);
      serviceLocator.addService(Keyboard.class, getContext().getInputKey());

      Level level  = new Level(1);

      Probability probability = new Probability(45);

      if (probability.generate()) {
        System.out.println(String.format("%d %% was probability what you see this", (int) probability.getProbability()));
      }


      System.out.println(level.getCalculator().getExperience(13));

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

      audioManager = serviceLocator.getAudioManager();
      audioManager.addAudio("walk", "sounds/footstep_grass.wav", .25D);
      audioManager.addAudio("collide", "sounds/footstep_stone.wav", 1D);

      audioManager.get("walk").setVolume(2F);

      System.out.println("before map parse...");

      world = new World();
      world.initialize();

//      character = new Character(serviceLocator.getInputKeyboard());
          character = new Orc(serviceLocator.getInputKeyboard());
//          character = new Troll(serviceLocator.getInputKeyboard());
      //    character = new Raven(serviceLocator.getInputKeyboard());

      Observable<GameObject> observable = character.getObservable();

      Graphics graphics = character.getGraphics();
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


    } catch (Exception e) {
      e.printStackTrace();
    }
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
