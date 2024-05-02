package view.Reader;


import java.util.ArrayList;
import java.util.List;

import view.snapshot.ISnapshot;
import view.snapshot.Snapshot;
import view.snapshot.shape.IShape;
import view.snapshot.shape.IShapeFactory;
import view.snapshot.shape.ShapeFactory;


/**
 *  this is to read data from model.
 */
public class Reader implements IReader {

  private List<ISnapshot> snapshots;
  private IShapeFactory factory;

  /**
   * this is constructor.
   */
  public Reader() {
    snapshots = new ArrayList<>();
    factory = new ShapeFactory();
  }

  /**
   * this is read function.
   * @param content String.
   * @return snapshot.
   */
  @Override
  public List<ISnapshot> read(String content) {
    String[] split = content.split("Snapshot ID: ");
    for (String s : split) {
      if (s.isEmpty()) {
        continue;
      }
      this.snapshots.add(parseShapeFromString("Snapshot ID: " + s));
    }
    return this.snapshots;
  }

  /**
   * this is to parse shape from string.
   * @param snapshotString String.
   * @return snapshot.
   */
  private ISnapshot parseShapeFromString(String snapshotString) {
    String[] lines = snapshotString.split("\n");
    String snapshotId = lines[0].substring("Snapshot ID: ".length());
    String snapshotDescription = lines[2].substring("Description: ".length());
    Snapshot snapshot = new Snapshot(snapshotId, snapshotDescription);
    int i = 0;
    while (i < lines.length) {
      if (lines[i].startsWith("Name: ")) {
        IShape shape = parseShapeFromString(lines[i], lines[i + 1], lines[i + 2]);
        if (shape != null) {
          snapshot.addShape(shape);
        }
        i += 3;
      } else {
        i++;
      }
    }
    return snapshot;
  }

  /**
   * this is to parse shape from String.
   * @param nameLine String.
   * @param typeLine String.
   * @param infoLine String.
   * @return shape.
   */
  private IShape parseShapeFromString(String nameLine, String typeLine, String infoLine) {
    String name = nameLine.substring("Name: ".length());
    String type = typeLine.substring("Type: ".length());
    List<Double> doublesFromString = getDoublesFromString(infoLine);
    double x = doublesFromString.get(0);
    double y = doublesFromString.get(1);
    double firstDimension = doublesFromString.get(2);
    double secondDimension= doublesFromString.get(3);
    double red = doublesFromString.get(4);
    double green = doublesFromString.get(5);
    double blue = doublesFromString.get(6);
    IShape shape = factory.createShape(type, name, x, y, firstDimension, secondDimension, red, green, blue);
    return shape;
  }

  /**
   * this is to get doubles from String.
   * @param s String.
   * @return result.
   */
  private List<Double> getDoublesFromString(String s) {
    List<Double> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c) || c == '.') {
        sb.append(c);
      } else if (sb.length() > 0) {
        double num = Double.parseDouble(sb.toString());
        result.add(num);
        sb.setLength(0);
      }
    }
    return result;
  }
}
