package model.shape;

/**
 * this is Rectangle class.
 */
public class Rectangle extends AbstractShape {
  private static final ShapeType TYPE = ShapeType.RECTANGLE;

  /**
   * this is default constructor.
   */
  public Rectangle() {
  }

  /**
   * this is constructor.
   * @param name String.
   * @param x double.
   * @param y double.
   * @param firstDimension double.
   * @param secondDimension double.
   * @param red double.
   * @param green double.
   * @param blue double.
   */
  public Rectangle(String name, double x, double y, double firstDimension, double secondDimension, double red, double green, double blue) {
    super(name, TYPE, x, y, firstDimension, secondDimension, red, green, blue);
  }

  /**
   * this is make copy of rectangle.
   * @return Ishape.
   */
  @Override
  public IShape makeCopy() {
    return new Rectangle(getName(), getX(), getY(), getFirstDimension(), getSecondDimension(), getColor().getRedValue(), getColor().getGreenValue(), getColor().getBlueValue());
  }

  /**
   * this is to string.
   * @return String.
   */
  @Override
  public String toString() {
    String nameAndType = super.toString();
    return nameAndType + String.format("Min corner: (%.1f, %.1f), Width: %.1f, Height: %.1f, %s\n", this.getX(),getY(),getFirstDimension(), getSecondDimension(), getColor().toString());
  }
}
