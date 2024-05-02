package view.snapshot.shape;

/**
 * this is abstract shape class.
 */
public abstract class AbstractShape implements IShape {
  private String typeName;
  private String name;
  private double x;
  private double y;
  private double firstDimension;
  private double secondDimension;
  private double redValue;
  private double greenValue;
  private double blueValue;

  /**
   * this is a constructor.
   * @param typeName String.
   * @param name String.
   * @param x double.
   * @param y double.
   * @param firstDimension double.
   * @param secondDimension double.
   * @param redValue double.
   * @param greenValue double.
   * @param blueValue double.
   */
  public AbstractShape(String typeName, String name, double x, double y,
                       double firstDimension, double secondDimension,
                       double redValue, double greenValue, double blueValue) {
    this.typeName = typeName;
    this.name = name;
    this.x = x;
    this.y = y;
    this.firstDimension = firstDimension;
    this.secondDimension = secondDimension;
    this.redValue = redValue;
    this.greenValue = greenValue;
    this.blueValue = blueValue;
  }

  /**
   * this is to get name function.
   * @return name.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * this is to get type name function.
   * @return typename.
   */
  @Override
  public String getTypeName() {
    return typeName;
  }

  /**
   * this is to get x.
   * @return x.
   */
  @Override
  public double getX() {
    return x;
  }

  /**
   * this is to get y.
   * @return y.
   */
  @Override
  public double getY() {
    return y;
  }

  /**
   * this is to get first dimension.
   * @return first dimension.
   */
  @Override
  public double getFirstDimension() {
    return firstDimension;
  }

  /**
   * this is to get second dimension.
   * @return second dimension.
   */
  @Override
  public double getSecondDimension() {
    return secondDimension;
  }

  /**
   * this is to get red.
   * @return red value.
   */
  @Override
  public double getRed() {
    return redValue;
  }

  /**
   * this is to get green.
   * @return green value.
   */
  @Override
  public double getGreen() {
    return greenValue;
  }

  /**
   * this is to get blue.
   * @return blue value.
   */
  @Override
  public double getBlue() {
    return blueValue;
  }
}
