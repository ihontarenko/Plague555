package org.nulllab.nullengine.openworld.object.component.graphics;

import org.nulllab.nullengine.core.graphics.spritesheet.SpriteManager;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.Sprite;
import org.nulllab.nullengine.core.graphics.spritesheet.sprite.pack.SpritePackage;
import org.nulllab.nullengine.openworld.character.Sprites;
import org.nulllab.nullengine.openworld.object.GameObject;
import org.nulllab.nullengine.openworld.object.component.Component;
import org.nulllab.nullengine.openworld.object.Direction;

import java.util.List;
import java.util.Map;

public class Graphics extends Component {

  private Map<Direction, String> spritesMap;
  private Sprite                 sprite;
  private Sprites                objectSprites;

  public Graphics(GameObject object) {
    super(object);
    this.spritesMap = getServiceLocator().getObjectHelper().getDirectionMaps().getSpritesMapDirection();
  }

  public void setGameObject(GameObject object) {
    super.setGameObject(object);
  }

  public void setDirectionSprite(Direction direction) {
    setSprite(objectSprites.getSprite(spritesMap.get(direction)));
  }

  public Sprites getObjectSprites() {
    return objectSprites;
  }

  public void setObjectSprites(Sprites objectSprites) {
    this.objectSprites = objectSprites;
  }

  public Sprite getSprite() {
    return sprite;
  }

  public void setSprite(Sprite sprite) {
    this.sprite = sprite;
  }

  public void setSpriteFromPackage(String id) {
    SpriteManager spriteManager = getServiceLocator().getSpriteManager();
    List<String>  idParts       = SpriteManager.getIDParts(id);
    SpritePackage spritePackage = spriteManager.getSpritePackage(idParts.get(0));

    setSprite(spritePackage.getSprite(idParts.get(1)));
  }

}
