package model.shape;

import model.color.Color;

/**
 * this is an interface.
 */
public interface IShape {
  /**
   * this is to get name.
   * @return String.
   */
  public String getName();

  /**
   * this is to set name.
   * @param s String.
   */
  public void setName(String s);

  /**
   * this is to get Type
   * @return type.
   */
  public ShapeType getType();

  /**
   * this is to set type.
   * @param type ShapeType.
   */
  public void setType(ShapeType type);

  /**
   * this is to get X.
   * @return double.
   */
  public double getX();

  /**
   * this is to set X.
   * @param x double.
   */
  public void setX(double x);

  /**
   * this is to get Y.
   * @return double.
   */
  public double getY();

  /**
   * this is to set Y.
   * @param y double.
   */
  public void setY(double y);

  /**
   * this is to get first dimension.
   * @return double.
   */
  public double getFirstDimension();

  /**
   * this is to set first dimension.
   * @param dimension double.
   */
  public void setFirstDimension(double dimension);

  /**
   * this is get second dimension.
   * @return double.
   */
  public double getSecondDimension();

  /**
   * this is to set second dimension.
   * @param dimension double.
   */
  public void setSecondDimension(double dimension);

  /**
   * this is to move shape.
   * @param x double.
   * @param y double.
   */
  public void move(double x, double y);

  /**
   * this is to resize shape.
   * @param firstDimension double.
   * @param secondDimension double.
   */
  public void resize(double firstDimension, double secondDimension);

  /**
   * this is to get color.
   * @return color.
   */
  public Color getColor();

  /**
   * this is to set color.
   * @param red double.
   * @param green double.
   * @param blue double.
   */
  public void setColor(double red, double green, double blue);

  /**
   * this is to make copy.
   * @return IShape.
   */
  public IShape makeCopy();
}
