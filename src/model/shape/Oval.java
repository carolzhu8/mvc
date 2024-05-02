package model.shape;

/**
 * this is Oval class.
 */
public class Oval extends AbstractShape {
  private static final ShapeType TYPE = ShapeType.OVAL;

  /**
   * this is default constructor.
   */
  public Oval() {
    super();
  }

  /**
   * this is constructor.
   * @param name String.
   * @param x double.
   * @param y double.
   * @param xRadius double.
   * @param yRadius double.
   * @param red double.
   * @param green double.
   * @param blue double.
   */
  public Oval(String name, double x, double y, double xRadius, double yRadius, double red, double green, double blue) {
    super(name, TYPE, x, y, xRadius, yRadius, red, green, blue);
  }

  /**
   * this is makeCopy of oval.
   * @return Oval.
   */
  @Override
  public IShape makeCopy() {
    return new Oval(getName(), getX(), getY(), getFirstDimension(), getSecondDimension(), getColor().getRedValue(), getColor().getGreenValue(), getColor().getBlueValue());
  }

  /**
   * this is toString function.
   * @return String.
   */
  @Override
  public String toString() {
    String nameAndType = super.toString();
    return nameAndType + String.format("Center: (%.1f, %.1f), X radius: %.1f, Y radius: %.1f, %s\n", this.getX(), getY(), getFirstDimension(), getSecondDimension(), getColor().toString());
  }
}
