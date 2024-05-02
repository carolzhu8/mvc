package model;

import java.util.ArrayList;
import java.util.List;

import model.factory.IFactory;
import model.factory.ShapeFactory;
import model.shape.IShape;

/**
 * this is to a model class.
 */
public class Model implements IModel {
  private IFactory shapeFactory;
  private String progressionLog;
  private List<IShape> shapes;
  private List<ISnapshot> snapshots;

  /**
   * this is a constructor.
   */
  public Model() {
    this.shapeFactory = new ShapeFactory();
    this.shapes = new ArrayList<>();
    this.snapshots = new ArrayList<>();
    this.progressionLog = "This is the progression log:\n";
  }

  /**
   * this is to see if shape was created successfully.
   * @param type String.
   * @param name String.
   * @param x double.
   * @param y double.
   * @param firstDimension double.
   * @param secondDimension double.
   * @param red double.
   * @param green double.
   * @param blue double.
   * @return true or false.
   */
  @Override
  public boolean create(String type, String name, double x, double y, double firstDimension, double secondDimension, double red, double green, double blue) {
    if (ifContains(name)) { // already exist
      return false;
    }
    IShape shape = shapeFactory.create(type, name, x, y, firstDimension, secondDimension, red, green, blue);
    if (shape == null) {
      return false;
    }
    shapes.add(shape);  // store the shapes into the model

    // add to progression log
    progressionLog += getCurShapes();
    progressionLog += "=====================\n";
    return true;
  }

  /**
   * this is to see if shape got moved successfully.
   * @param name String.
   * @param x double.
   * @param y double.
   * @return true or false.
   */
  @Override
  public boolean move(String name, double x, double y) {
    for (IShape shape : shapes) {
      if (shape.getName().equals(name)) {
        shape.move(x, y);
        // add to progression log
        progressionLog += getCurShapes();
        progressionLog += "=====================\n";
        return true;
      }
    }
    return false;
  }

  /**
   * this is to see the shape got resized successfully or not.
   * @param name String.
   * @param firstDimension double.
   * @param secondDimension double.
   * @return true or false.
   */
  @Override
  public boolean resize(String name, double firstDimension, double secondDimension) {
    for (IShape shape : shapes) {
      if (shape.getName().equals(name)) {
        shape.resize(firstDimension, secondDimension);
        // add to progression log
        progressionLog += getCurShapes();
        progressionLog += "=====================\n";
        return true;
      }
    }
    return false;
  }

  /**
   * this is to check if color got set successfully.
   * @param name String.
   * @param red double.
   * @param green double.
   * @param blue double.
   * @return true or false.
   */
  @Override
  public boolean setColor(String name, double red, double green, double blue) {
    for (IShape shape : shapes) {
      if (shape.getName().equals(name)) {
        shape.setColor(red,green,blue);
        // add to progression log
        progressionLog += getCurShapes();
        progressionLog += "=====================\n";
        return true;
      }
    }
    return false;
  }

  /**
   * this is to see if the shape is contained.
   * @param name String.
   * @return true or false.
   */
  @Override
  public boolean ifContains(String name) {
    for (IShape shape : shapes) {
      if (shape.getName().equals(name)) {
        // add to progression log
        progressionLog += getCurShapes();
        progressionLog += "=====================\n";
        return true;
      }
    }
    return false;
  }

  /**
   * this is to see if shape got deleted successfully.
   * @param name String.
   * @return true or false.
   */
  @Override
  public boolean delete(String name) {
    for (int i = 0; i < shapes.size(); i++) {
      if (shapes.get(i).getName().equals(name)) {
        shapes.remove(i);
        // add to progression log
        progressionLog += getCurShapes();
        progressionLog += "=====================\n";
        return true;
      }
    }
    return false;
  }

  /**
   * this is to make a snapshot.
   * @param description String.
   */
  @Override
  public void makeSnapshot(String description) {
    this.snapshots.add(new Snapshot(this.shapes, description));
  }

  /**
   * this is to get all the snapshots.
   * @return String.
   */
  @Override
  public String getAllSnapshots() {
    String result = "";
    for (ISnapshot snapshot : snapshots) {
      result += snapshot.toString();
      result += "\n";
    }
    return result;
  }

  /**
   * this is to get the ID list.
   * @return String.
   */
  @Override
  public List<String> getSnapshotsIDList() {
    List<String> IDList = new ArrayList<>();
    for (ISnapshot snapshot : snapshots) {
      IDList.add(snapshot.getId());
    }
    return IDList;
  }

  /**
   * this is to get log.
   * @return String.
   */
  @Override
  public String getLog() {
    return progressionLog;
  }

  /**
   * this is to get current shapes.
   * @return String.
   */
  private String getCurShapes(){
    String result = "";
    for (IShape shape : shapes) {
      result += shape.toString();
      result += "\n";
    }
    return result;
  }

//
//  public static void main(String[] args) {
//    Model model = new Model();
//    model.create("oval", "my oval", 5,5,5,5,0,0,0);
//    model.makeSnapshot("My first snapshot");
//    model.create("rectangle", "my rect", 5,5,5,5,0,0,0);
//    model.makeSnapshot("My second snapshot");
//    System.out.println(model.getAllSnapshots());
//    System.out.println(model.getLog());
//  }

}
