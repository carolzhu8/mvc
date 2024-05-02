package view.web;

import view.IView;

/**
 * this is web interface.
 */
public interface IWeb extends IView {
  /**
   * this is to output file name function.
   * @param fileName String.
   */
  public void outputTo(String fileName);
}
