package model.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import model.shape.IShape;
import model.shape.Oval;
import model.shape.Rectangle;
import model.shape.ShapeType;

/**
 * this is a ShapeFactory class.
 */
public class ShapeFactory implements IFactory {

  private Map<ShapeType, Supplier<IShape>> creators;

  /**
   *  this is a default constructor.
   */
  public ShapeFactory() {
    creators = new HashMap<>();
    this.creators.put(ShapeType.OVAL, Oval::new);
    this.creators.put(ShapeType.RECTANGLE, Rectangle::new);
  }

  /**
   * this is to create shape.
   * @param type String.
   * @param name String.
   * @param x double.
   * @param y double.
   * @param firstDimension double. rec that shares with oval.
   * @param secondDimension double.
   * @param red double.
   * @param green double.
   * @param blue double.
   * @return a shape.
   */
  @Override
  public IShape create(String type, String name, double x, double y, double firstDimension, double secondDimension, double red, double green, double blue) {
    Set<ShapeType> shapeTypes = creators.keySet();  // get the keys from dictionary
    for (ShapeType shapeType : shapeTypes) {
      if (type.equalsIgnoreCase(shapeType.getTypeName())) { // find target shape
        Supplier<IShape> method = creators.get(shapeType); // looking for the method from the more specific type
        IShape shape = method.get(); // calling default constructor
        shape.setType(shapeType);
        shape.setName(name);
        shape.setX(x);
        shape.setY(y);
        shape.setFirstDimension(firstDimension);
        shape.setSecondDimension(secondDimension);
        shape.setColor(red, green, blue);
        return shape;
      }
    }
    return null;
  }
}
