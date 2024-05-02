package model.shape;

/**
 * this is enum ShapeType.
 */
public enum ShapeType {
  OVAL("Oval"),
  RECTANGLE("Rectangle"),
  UNKNOWN("Unknown");
  private final String typeName;

  /**
   * this is constructor.
   * @param typeName String.
   */
  ShapeType(String typeName) {
    this.typeName = typeName;
  }

  /**
   * this is to get typename.
   * @return typename.
   */
  public String getTypeName() {
    return typeName;
  }
}
