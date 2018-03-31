package org.nulllab.nullengine.openworld;

import org.nulllab.nullengine.core.common.Initializable;

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
