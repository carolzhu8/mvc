package view.snapshot.shape;

/**
 * this is IShapeFactory interface.
 */
public interface IShapeFactory {
  /**
   * this is createShape interface.
   * @param typeName String.
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
  public IShape createShape(String typeName, String name, double x, double y,
                            double firstDimension, double secondDimension,
                            double red, double green, double blue);
}
