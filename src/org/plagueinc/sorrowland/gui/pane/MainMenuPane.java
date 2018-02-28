package org.plagueinc.sorrowland.gui.pane;

import javax.swing.*;
import java.awt.*;

public class MainMenuPane extends JPanel {

  private JButton startButton;

  public MainMenuPane() {
    super(new BorderLayout());

    setBackground(Color.decode("#b24926"));
    setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.WHITE));
    setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

    startButton = new JButton("Hello World!");
    startButton.setBackground(Color.decode("#7acef4"));
    add(startButton);
  }

  public JButton getStartButton() {
    return startButton;
  }

}
