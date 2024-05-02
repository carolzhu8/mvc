package view;

/**
 * this is view interface.
 */
public interface IView {
  /**
   * this is a load function.
   * @param dataFromModel String.
   */
  public void load(String dataFromModel);

  /**
   * this is a display function.
   */
  public void display();
}
