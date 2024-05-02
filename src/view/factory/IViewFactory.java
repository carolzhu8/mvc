package view.factory;

import view.IView;

/**
 * this is factory interface.
 */
public interface IViewFactory {
  /**
   * this is create function.
   * @param args command.
   * @return view.
   */
  public IView create(String[] args);
}
