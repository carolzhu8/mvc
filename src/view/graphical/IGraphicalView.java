package view.graphical;

import java.awt.event.ActionListener;

import view.IView;

/**
 * this is graphical view interface.
 */
public interface IGraphicalView extends IView {
  /**
   * this is to set frame size.
   * @param width int.
   * @param height int.
   */
  public void setFrameSize(int width, int height);

  /**
   * this is to set action listener.
   * @param listener ActionListener.
   */
  public void setActionListener(ActionListener listener);

  /**
   * this is pre button.
   */
  public void pre();

  /**
   * this is next button.
   */
  public void next();

  /**
   * this is select button.
   */
  public void select();

  /**
   * this is quit button.
   */
  public void quit();
}
