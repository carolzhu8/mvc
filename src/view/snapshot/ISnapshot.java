package view.snapshot;

import java.util.List;

import view.snapshot.shape.IShape;

/**
 * this is ISnapshot interface.
 */
public interface ISnapshot extends IAbleToDisplay {
  /**
   * this is to get ID.
   * @return String ID.
   */
  public String getId();

  /**
   * this is to get description.
   * @return String.
   */
  public String getDescription();

  /**
   * this is to add shape.
   * @param shape IShape.
   */
  public void addShape(IShape shape);
}
