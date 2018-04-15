package org.nulllab.nullengine.openworld.world.entities.player;

import org.nulllab.nullengine.openworld.ServiceLocator;
import org.nulllab.nullengine.openworld.character.Character;

public class Player extends Character {

  public static final String DEFAULT_PACK_ID = "characters:player";

  public Player() {
    super(ServiceLocator.getInstance().getInputKeyboard());
//    getGraphics().setObjectSprites(getServiceLocator().getSpriteManager().getSheetPackage(DEFAULT_PACK_ID));
  }

}
