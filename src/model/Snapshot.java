package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.shape.IShape;

/**
 * this is snapshot class.
 */
public class Snapshot implements ISnapshot {
  private String id;
  private String time;
  private String description;
  private List<IShape> shapes;

  private static final String DEFAULT_DES = "UNKNOWN";

  /**
   * this is constructor.
   * @param shapes a list of shapes.
   * @param description String.
   */
  public Snapshot(List<IShape> shapes, String description) { // passing in all the shapes
    ArrayList<IShape> copy = new ArrayList<>(); // make a copy of all the shapes from the model and put them in the snapshot
    for (IShape shape : shapes) {
      copy.add(shape.makeCopy());
    }
    this.shapes = copy; // storing the copy inside the snapshot's shapes

    // check description
    if (description == null) {
      this.description = DEFAULT_DES;
    } else {
      this.description = description;
    }

    //get curr time
    Date currentDate = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String timeStamp = format.format(currentDate);
    this.time = timeStamp;
    format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
    id = format.format(currentDate);
  }

  /**
   * this is to get ID.
   * @return string.
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * this is to get Description.
   * @return String.
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * this is toString,
   * @return String.
   */
  @Override
  public String toString() {
    String prefix = "Snapshot ID: " + id + "\n"
            + "Timestamp: " + time + "\n"
            + "Description: " + description + "\n"
            + "Shape Information:\n";
    String shapeInfo = "";
    for (IShape shape : shapes) {
      shapeInfo += shape;
    }
    return prefix + shapeInfo;
  }
}
