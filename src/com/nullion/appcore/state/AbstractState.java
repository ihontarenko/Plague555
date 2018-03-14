package com.nullion.appcore.state;

import com.nullion.appcore.common.Initializable;
import com.nullion.appcore.common.RunnableProcess;
import com.nullion.appcore.container.ServiceLocator;
import com.nullion.appcore.process.AbstractProcess;
import com.nullion.appcore.service.AppContext;
import com.nullion.appcore.service.AppContextAware;

import java.awt.*;

abstract public class AbstractState<Process extends AbstractProcess>
    implements RunnableProcess<AbstractState>, Initializable, AppContextAware {

  private AppContext              context;
  private ServiceLocator<Process> processes;
  private Process                 activeProcess;
  private ProcessMode             processMode;
  private boolean                 isInitialized;
  private int                     priority;

  public AbstractState(AppContext context) {
    this.context = context;
    this.processes = new ServiceLocator<>();
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

  public void registerProcess(String name, Class clazz, Object... arguments) {
    processes.registerService(name, clazz, arguments);
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

  public ServiceLocator<Process> getProcesses() {
    return processes;
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

  @Override
  public void reinitialize() {

  }

  @Override
  public AppContext getContext() {
    return context;
  }

  abstract protected void doInitialize();

}
