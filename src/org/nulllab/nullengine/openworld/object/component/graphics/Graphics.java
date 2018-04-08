package org.nulllab.nullengine.openworld.object.component.graphics;

import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.SpritePackage;
import org.nulllab.nullengine.openworld.character.Sprites;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.Component;
import org.nulllab.nullengine.openworld.object.geometry.Direction;

import java.util.List;
import java.util.Map;

public class Graphics extends Component implements GraphicsInterface {

  private Map<Direction, String> spritesMap;
  private Sprite                 sprite;
  private Sprites                objectSprites;

  @Override
  public void setGameObject(GameObject object) {
    super.setGameObject(object);
    spritesMap = getServiceLocator().getGameObjectUtils().getMovement().getSpritesMapDirection();
  }

  @Override
  public void setDirectionSprite(Direction direction) {
    setSprite(objectSprites.getSprite(spritesMap.get(direction)));
  }

  @Override
  public Sprites getObjectSprites() {
    return objectSprites;
  }

  @Override
  public void setObjectSprites(Sprites objectSprites) {
    this.objectSprites = objectSprites;
  }

  @Override
  public Sprite getSprite() {
    return sprite;
  }

  @Override
  public void setSprite(Sprite sprite) {
    this.sprite = sprite;
  }

  @Override
  public void setSpriteFromPackage(String id) {
    SpriteManager spriteManager = getServiceLocator().getSpriteManager();
    List<String>  idParts       = SpriteManager.getIDParts(id);
    SpritePackage spritePackage = spriteManager.getSpritePackage(idParts.get(0));

    setSprite(spritePackage.getSprite(idParts.get(1)));
  }

}
