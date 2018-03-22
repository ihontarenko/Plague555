package org.nulllab.sorrowland.app.graphics;

import org.nulllab.nullengine.core.graphics.sprite.SpriteSheetPackage;
import org.nulllab.nullengine.core.graphics.sprite.SpriteSheetParameters;

public class WorldTilesSpritePackage extends SpriteSheetPackage {

  public WorldTilesSpritePackage() {
    super("map/tiles1.png");
  }

  @Override
  public SpriteSheetParameters[] getSpriteSheetParameters() {
    return new SpriteSheetParameters[] {
        new SpriteSheetParameters(32, 32, 384, 288, 2, 1),
        new SpriteSheetParameters(32, 32, 320, 288, 2, 1),
        new SpriteSheetParameters(32, 32, 0, 288, 2, 1),
    };
  }

}
