package view.graphical;

import java.awt.*;

import javax.swing.*;

import view.snapshot.ISnapshot;

/**
 * this is the panel to draw snapshot.
 */
public class SnapshotPanel extends JPanel implements ISnapshotPanel{
  private ISnapshot snapshot;

  /**
   * this is the constructor.
   */
  public SnapshotPanel() {
    setBackground(Color.WHITE);
    this.setPreferredSize(new Dimension(1000, 1000));
  }

  /**
   * this is to set the panel content.
   * @param snapshot ISnapshot.
   */
  @Override
  public void setPanelContent(ISnapshot snapshot) {
    this.snapshot = snapshot;
  }

  /**
   * this is to paint the component.
   * @param g Graphics.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    snapshot.graphicalDisplay(g);
  }
}
