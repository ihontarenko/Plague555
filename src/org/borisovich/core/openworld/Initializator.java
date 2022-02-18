package org.borisovich.core.openworld;

import org.borisovich.core.core.common.Initializable;

abstract public class Initializator implements Initializable {

  private boolean initialized;

  @Override
  final public boolean isInitialized() {
    return initialized;
  }

  @Override
  final public void initialize() {
    if (!isInitialized()) {
      doInitialize();
      initialized = true;
    }
  }

  @Override
  final public void reinitialize() {

  }

  abstract public void doInitialize();

}
