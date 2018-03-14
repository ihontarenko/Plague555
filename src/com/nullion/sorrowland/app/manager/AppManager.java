package com.nullion.sorrowland.app.manager;

import com.nullion.appcore.io.InputKey;
import com.nullion.sorrowland.app.state.IntroState;
import com.nullion.sorrowland.app.state.MenuState;
import com.nullion.appcore.state.AbstractManager;
import com.nullion.appcore.state.AbstractState;
import com.nullion.appcore.service.AppContext;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AppManager extends AbstractManager<AbstractState> {

  final static public String STATE_INTRO     = "STATE_INTRO";
  final static public String STATE_MENU = "STATE_MENU";
  final static public String STATE_GAME_PLAY = "STATE_GAME_PLAY";

  public AppManager(AppContext context) {
    super(context);
  }

  @Override
  public void doInitialize() {
    registerState(STATE_INTRO, IntroState.class, getContext());
    registerState(STATE_MENU, MenuState.class, getContext());

    setActiveState(STATE_INTRO);
  }
}