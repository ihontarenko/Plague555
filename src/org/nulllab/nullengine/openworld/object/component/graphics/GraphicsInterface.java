package org.nulllab.nullengine.openworld.object.component.graphics;

import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.openworld.character.Sprites;
import org.nulllab.nullengine.openworld.object.Direction;

public interface GraphicsInterface {

  void setDirectionSprite(Direction direction);

  Sprites getObjectSprites();

  void setObjectSprites(Sprites objectSprites);

  Sprite getSprite();

  void setSprite(Sprite sprite);

  void setSpriteFromPackage(String id);

}
