package org.plagueinc.sorrowland.service;

import org.plagueinc.sorrowland.core.context.AbstractAppContext;
import org.plagueinc.sorrowland.manager.AppManager;

public class AppContext extends AbstractAppContext {

  private AppManager appManager;

  public AppManager getAppManager() {
    return appManager;
  }

  public void setAppManager(AppManager appManager) {
    this.appManager = appManager;
  }

}
