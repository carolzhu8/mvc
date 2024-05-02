package view.snapshot.shape;

import java.util.HashMap;
import java.util.Map;

/**
 * this is ShapeFactory class.
 */
public class ShapeFactory implements IShapeFactory {
  private Map<String, IConstructor> constructors;

  /**
   * this is constructor.
   */
  public ShapeFactory() {
    constructors = new HashMap<>();
    constructors.put(Oval.class.getSimpleName().toUpperCase(), Oval::new);
    constructors.put(Rectangle.class.getSimpleName().toUpperCase(),Rectangle::new);
  }

  /**
   * this is to create shape.
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
  @Override
  public IShape createShape(String typeName, String name, double x, double y,
                            double firstDimension, double secondDimension,
                            double red, double green, double blue) {
    IConstructor constructor = constructors.get(typeName.toUpperCase());
    if (constructor == null) {
      return null;
    }

    IShape shape = constructor.create(name, x, y, firstDimension, secondDimension, red, green, blue);
    return shape;
  }
}
