package view.graphical;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * this is the panel with buttons and snapshot id and snapshot description.
 */
public class ConsolePanel extends JPanel implements IConsolePanel {
  private JLabel idLabel;
  private JLabel descriptionLabel;
  private JPanel buttonPanel;
  private JButton preButton;
  private JButton selectButton;
  private JButton nextButton;
  private JButton quitButton;

  /**
   * this is a default constructor.
   */
  public ConsolePanel() {
    // initialize all labels and buttons
    idLabel = new JLabel();
    descriptionLabel = new JLabel();
    preButton = new JButton("<<Pre");
    selectButton = new JButton("Select");
    nextButton = new JButton("Next>>");
    quitButton = new JButton("Quit");
    preButton.setActionCommand("Pre");
    selectButton.setActionCommand("Select");
    nextButton.setActionCommand("Next");
    quitButton.setActionCommand("Quit");

    // set layout of buttonPanel and add buttons to it
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 4));
    buttonPanel.add(preButton);
    buttonPanel.add(selectButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(quitButton);

    // set layout of console panel and add all elements to it
    this.setLayout(new GridLayout(3, 1));
    this.setPreferredSize(new Dimension(500, 100));
    this.add(idLabel);
    this.add(descriptionLabel);
    this.add(buttonPanel);

  }

  /**
   * this is to set the action listener.
   * @param listener this is action listener.
   */
  @Override
  public void setActionListener(ActionListener listener) {
    this.preButton.addActionListener(listener);
    this.nextButton.addActionListener(listener);
    this.selectButton.addActionListener(listener);
    this.quitButton.addActionListener(listener);
  }

  /**
   * this is to set id.
   * @param id string.
   */
  @Override
  public void setId(String id) {
    this.idLabel.setText("ID: " + id);
  }

  /**
   * this is to set description.
   * @param description string.
   */
  @Override
  public void setDescription(String description) {
    this.descriptionLabel.setText("Description: " + description);
  }
}
