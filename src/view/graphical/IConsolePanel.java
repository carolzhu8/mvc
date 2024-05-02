package view.graphical;

import java.awt.event.ActionListener;

/**
 * this is console panel interface.
 */
public interface IConsolePanel {
  /**
   * this is to set id.
   * @param id String.
   */
  public void setId(String id);

  /**
   * this is to set description.
   * @param description String.
   */
  public void setDescription(String description);

  /**
   * this is to set action listener.
   * @param listener ActionListener.
   */
  public void setActionListener(ActionListener listener);
}
