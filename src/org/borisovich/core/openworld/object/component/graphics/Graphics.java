package org.borisovich.core.openworld.object.component.graphics;

import org.borisovich.core.core.graphics.spritesheet.SpriteManager;
import org.borisovich.core.core.graphics.spritesheet.sprite.Sprite;
import org.borisovich.core.core.graphics.spritesheet.sprite.pack.SpritePackage;
import org.borisovich.core.openworld.character.Sprites;
import org.borisovich.core.openworld.object.GameObject;
import org.borisovich.core.openworld.object.component.Component;

import java.util.List;

public class Graphics extends Component {

  private Sprite                 sprite;
  private Sprites                objectSprites;

  public Graphics(GameObject object) {
    super(object);
  }

  public void setGameObject(GameObject object) {
    super.setGameObject(object);
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
