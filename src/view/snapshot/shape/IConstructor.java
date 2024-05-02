package view.snapshot.shape;

/**
 * this is IConstructor interface.
 */
public interface IConstructor {
  /**
   * this is create function.
   * @param name String.
   * @param x double.
   * @param y double.
   * @param firstDimension double.
   * @param secondDimension double.
   * @param red double.
   * @param green double.
   * @param blue double.
   * @return shape.
   */
  IShape create(String name, double x, double y, double firstDimension,
                    double secondDimension, double red, double green, double blue);
}
