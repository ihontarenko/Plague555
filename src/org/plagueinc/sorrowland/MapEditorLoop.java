package org.plagueinc.sorrowland;

import org.plagueinc.sorrowland.editor.controller.EditorController;
import org.plagueinc.sorrowland.gui.GUIFrame;
import org.plagueinc.sorrowland.gui.GUIWindow;
import org.plagueinc.sorrowland.gui.pane.MainMenuPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MapEditorLoop extends AbstractLoop {

  @Override
  public void initialize() {

    if (!isInitialized()) {
      GUIWindow  gui = new GUIWindow(800, 600);

      gui.initialize();
      setGui(gui);

      gui.getCanvas().setDefaultColor(0xFF000000);

      JMenuBar menuBar = new JMenuBar();
      JMenu menu = new JMenu("Menu 1");

      JMenuItem menuItem = new JMenuItem("Item 1", KeyEvent.VK_LEFT);

      menuItem.addActionListener(e -> {
        JFileChooser saveFile = new JFileChooser();
        saveFile.showSaveDialog(null);
      });

      menu.add(menuItem);
      menuBar.add(menu);

      GUIFrame frame = gui.getMainFrame();

      frame.add(menuBar, BorderLayout.NORTH);
      frame.getContentPane().add(new MainMenuPane(), BorderLayout.EAST);
      frame.updateUI();

      setActiveController(getControllerContainer().getObject(EditorController.class));

      isInitialized = true;
    }

  }
}
