package view.snapshot;

import java.awt.*;

/**
 * this is IAbleToDisplay function.
 */
public interface IAbleToDisplay {
  /**
   * this is the graphical display function.
   * @param g Graphics.
   */
  public void graphicalDisplay(Graphics g);

  /**
   * this is web display function.
   * @param output Appendable.
   */
  public void webDisplay(Appendable output);
}
