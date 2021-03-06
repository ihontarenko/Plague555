package org.borisovich.ui.process;

import org.borisovich.core.core.common.Initializable;
import org.borisovich.core.core.container.ObjectManager;
import org.borisovich.core.core.graphics.Canvas;
import org.borisovich.core.core.graphics.Renderable;
import org.borisovich.core.core.loop.Updateable;
import org.borisovich.ui.process.scene.Scene;
import org.borisovich.ui.service.Context;
import org.borisovich.ui.service.ContextAware;

abstract public class SceneManager<C extends Scene>
    implements Renderable<Canvas>, Updateable, Initializable, ContextAware {

  private boolean          isInitialized;
  private ObjectManager<C> scenes;
  private C                activeScene;
  private ProcessMode      processMode;
  private Context          context;

  public SceneManager(Context context) {
    this.context = context;
    this.scenes = new ObjectManager<>();
    initialize();
  }

  abstract protected void doInitialize();

  public ProcessMode getProcessMode() {
    return processMode;
  }

  public void setProcessMode(ProcessMode processMode) {
    this.processMode = processMode;
  }

  public void registerController(String name, C controller) {
    scenes.setObject(name, controller);
  }

  public void registerController(String name, Class clazz, Object... arguments) {
    scenes.registerService(name, clazz, arguments);
  }

  public ObjectManager<C> getScenes() {
    return scenes;
  }

  public C getActiveScene() {
    return activeScene;
  }

  public void setActiveScene(String name) {
    setActiveScene(getScene(name));
  }

  public void setActiveScene(C activeController) {
    this.activeScene = activeController;
  }

  public C getScene(String name) {
    return scenes.getObject(name);
  }

  @Override
  public boolean isInitialized() {
    return isInitialized;
  }

  @Override
  public void initialize() {
    if (!isInitialized()) {
      setProcessMode(ProcessMode.ACTIVE);
      doInitialize();
      isInitialized = true;
    }
  }

  @Override
  public void reinitialize() {

  }

  @Override
  public void render(Canvas canvas) {
    switch (getProcessMode()) {
      case BATCH:
        getScenes().forEach((s, scene) -> scene.render(canvas));
        break;
      case ACTIVE:
        getActiveScene().render(canvas);
        break;
    }
  }

  @Override
  public void update(float nano) {
    switch (getProcessMode()) {
      case BATCH:
        getScenes().forEach((s, scene) -> scene.update(nano));
        break;
      case ACTIVE:
        getActiveScene().update(nano);
        break;
    }
  }

  @Override
  public Context getContext() {
    return context;
  }
}
