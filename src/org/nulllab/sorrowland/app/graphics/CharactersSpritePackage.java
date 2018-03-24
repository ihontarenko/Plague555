package org.nulllab.sorrowland.app.graphics;

import org.nulllab.nullengine.core.ServiceLocator;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpritePackage;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.setup.SpriteSetup;

public class CharactersSpritePackage extends SpritePackage {

  public CharactersSpritePackage() {
    super(ServiceLocator.getInstance().getSpriteManager()
        .getSheetFromPackage(Characters1SheetPackage.class, "char1"));
  }

  @Override
  public SpriteSetup[] getSpriteSetup() {
    return new SpriteSetup[0];
  }


}
