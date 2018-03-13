package org.nullapp.sorrowland.core.state;

import org.nullapp.sorrowland.core.common.Initializable;
import org.nullapp.sorrowland.core.common.RunnableProcess;
import org.nullapp.sorrowland.core.container.ObjectContainer;
import org.nullapp.sorrowland.core.process.AbstractProcess;

import java.awt.*;

abstract public class AbstractState<Manager extends AbstractManager, Process extends AbstractProcess>
    implements RunnableProcess<AbstractState>, Initializable {

  private ObjectContainer<Process> processes;
  private Manager                  appManager;
  private Process                  activeProcess;
  private ProcessMode              processMode;
  private boolean                  isInitialized;
  private int                      priority;

  public AbstractState(Manager appManager) {
    this.processes = new ObjectContainer<>();
    this.appManager = appManager;
    initialize();
  }

  public ProcessMode getProcessMode() {
    return processMode;
  }

  public void setProcessMode(ProcessMode processMode) {
    this.processMode = processMode;
  }

  public Process getActiveProcess() {
    return activeProcess;
  }

  public void setActiveProcess(Process process) {
    activeProcess = process;
  }

  public void setActiveProcess(String name) {
    setActiveProcess(getProcess(name));
  }

  public void registerProcess(String name, Process controller) {
    processes.setObject(name, controller);
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public Process getProcess(String name) {
    return processes.getObject(name);
  }

  public ObjectContainer<Process> getProcesses() {
    return processes;
  }

  public Manager getAppManager() {
    return appManager;
  }

  @Override
  public int compareTo(AbstractState state) {
    return this.getPriority() - state.getPriority();
  }

  @Override
  public void render(Graphics2D g2d) {
    switch (getProcessMode()) {
      case BATCH:
        getProcesses().forEach((s, controller) -> controller.render(g2d));
        break;
      case ACTIVE:
        getActiveProcess().render(g2d);
        break;
    }
  }

  @Override
  public void update(float nanoSeconds) {
    switch (getProcessMode()) {
      case BATCH:
        getProcesses().forEach((s, controller) -> controller.update(nanoSeconds));
        break;
      case ACTIVE:
        getActiveProcess().update(nanoSeconds);
        break;
    }
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
    }
  }

  abstract protected void doInitialize();

}
