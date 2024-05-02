package view.snapshot.shape;

import view.snapshot.IAbleToDisplay;

/**
 * this is IShape interface.
 */
public interface IShape extends IAbleToDisplay {
  /**
   * this is getName function.
   * @return String.
   */
  public String getName();

  /**
   * this is to get type name.
   * @return String.
   */
  public String getTypeName();

  /**
   * this is to get x.
   * @return double x.
   */
  public double getX();

  /**
   * this is to get y.
   * @return y.
   */
  public double getY();

  /**
   * this is to get the first dimension.
   * @return double.
   */
  public double getFirstDimension();

  /**
   * this is to get second dimension.
   * @return double.
   */
  public double getSecondDimension();

  /**
   * this is to get red.
   * @return double red.
   */
  public double getRed();

  /**
   * this is to get green.
   * @return double green.
   */
  public double getGreen();

  /**
   * this is to get blue.
   * @return double blue.
   */
  public double getBlue();
}
