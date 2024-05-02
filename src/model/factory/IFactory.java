package model.factory;

import model.shape.IShape;

/**
 * this is interface.
 */
public interface IFactory {
  /**
   * this is to create shape function.
   * @param type String.
   * @param name String.
   * @param x double.
   * @param y double.
   * @param firstDimension double.
   * @param secondDimension double.
   * @param red double.
   * @param green double.
   * @param blue double.
   * @return IShape.
   */
  public IShape create(String type, String name, double x, double y, double firstDimension, double secondDimension, double red, double green, double blue);
}
