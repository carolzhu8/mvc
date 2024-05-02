package model.shape;
import java.util.Objects;

import model.color.Color;

/**
 * this is AbstractShape class.
 */
public abstract class AbstractShape implements IShape {
  private String name;
  private ShapeType type;
  private double x;
  private double y;
  private double firstDimension;
  private double secondDimension;
  private Color color;
  private static final String DEFAULT_NAME = "NAME";
  private static final ShapeType DEFAULT_TYPE = ShapeType.UNKNOWN;

  private static final double DEFAULT_X = 0;
  private static final double DEFAULT_Y = 0;
  private static final double DEFAULT_DIMENSION = 5;
  private static final double MIN_DIMENSION = 0;

  private static final Color DEFAULT_COLOR = new Color(0,0,0);

  /**
   * this is constructor.
   */
  public AbstractShape() {
    this.name = DEFAULT_NAME;
    this.type = DEFAULT_TYPE;
    this.x = DEFAULT_X;
    this.y = DEFAULT_Y;
    this.firstDimension = DEFAULT_DIMENSION;
    this.secondDimension = DEFAULT_DIMENSION;
    this.color = DEFAULT_COLOR;
  }

  /**
   * this is constructor.
   * @param name String.
   * @param type ShapeType.
   * @param x double.
   * @param y double.
   * @param firstDimension double.
   * @param secondDimension double.
   * @param red double.
   * @param green double.
   * @param blue double.
   */
  public AbstractShape(String name, ShapeType type, double x, double y, double firstDimension, double secondDimension, double red, double green, double blue) {
    if (!checkStrInput(name)) { // name invalid
      this.name = DEFAULT_NAME;
    } else {
      this.name = name;
    }
    this.type = type;
    this.x = x;
    this.y = y;
    this.firstDimension = processDimension(firstDimension);
    this.secondDimension = processDimension(secondDimension);
    this.color = new Color(red, green, blue);
  }

  /**
   * this is to get name.
   * @return name.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * this is to get type.
   * @return type.
   */
  @Override
  public ShapeType getType() {
    return type;
  }

  /**
   * this is to get X.
   * @return x
   */
  @Override
  public double getX() {
    return x;
  }

  /**
   * this is to get Y.
   * @return y.
   */
  @Override
  public double getY() {
    return y;
  }

  /**
   * this is to get color.
   * @return color.
   */
  @Override
  public Color getColor() {
    return new Color(this.color);
  }

  /**
   * this is to set color.
   * @param red double.
   * @param green double.
   * @param blue double.
   */
  @Override
  public void setColor(double red, double green, double blue) {
    this.color = new Color(red, green, blue);
  }

  /**
   * this is to get first dimension.
   * @return firstDimension.
   */
  @Override
  public double getFirstDimension() {
    return firstDimension;
  }

  /**
   * this is to get second dimension.
   * @return double.
   */
  @Override
  public double getSecondDimension() {
    return secondDimension;
  }

  /**
   * this is to set name.
   * @param s String.
   */
  @Override
  public void setName(String s) {
    if(!checkStrInput(s)){
      this.name = DEFAULT_NAME;
      return;
    }
    this.name = s;
  }

  /**
   * this is to set type.
   * @param type ShapeType.
   */
  @Override
  public void setType(ShapeType type) {
    this.type = type;
  }

  /**
   * this is to setX.
   * @param x double.
   */
  @Override
  public void setX(double x) {
    this.x = x;
  }

  /**
   * this is to set Y.
   * @param y double.
   */
  @Override
  public void setY(double y) {
    this.y = y;
  }

  /**
   * this is to set first dimension.
   * @param dimension double.
   */
  @Override
  public void setFirstDimension(double dimension) {
    this.firstDimension = dimension;
  }

  /**
   * this is to set second dimension.
   * @param dimension double.
   */
  @Override
  public void setSecondDimension(double dimension) {
    this.secondDimension = dimension;
  }

  /**
   * this is move function.
   * @param x double.
   * @param y double.
   */
  @Override
  public void move(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * this is resize function.
   * @param firstDimension double.
   * @param secondDimension double.
   */
  @Override
  public void resize(double firstDimension, double secondDimension) {
    this.firstDimension = processDimension(firstDimension);
    this.secondDimension = processDimension(secondDimension);
  }

  /**
   * this is equals function.
   * @param o object.
   * @return true or false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractShape that = (AbstractShape) o;
    return Objects.equals(name, that.name);
  }

  /**
   * this is hashcode.
   * @return int.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  /**
   * this is to get toString.
   * @return String.
   */
  @Override
  public String toString() {
    return String.format("Name: %s\nType: %s\n", this.name, this.type.getTypeName());
  }

  /**
   * this is to check str input.
   * @param str String.
   * @return true or false.
   */
  private boolean checkStrInput(String str) {
    if (str == null || str.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * this is to check dimension.
   * @param dimension double.
   * @return dimension.
   */
  private double processDimension(double dimension){
    if (dimension <= MIN_DIMENSION){
      return DEFAULT_DIMENSION;
    }
    return dimension;
  }
}
