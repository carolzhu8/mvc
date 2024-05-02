package view.snapshot;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import view.snapshot.shape.IShape;

/**
 * this is Snapshot class.
 */
public class Snapshot implements ISnapshot {
  private String id;
  private String description;
  private List<IShape> shapeList;

  /**
   * this is a constructor.
   * @param id String.
   * @param description String.
   */
  public Snapshot(String id, String description) {
    this.id = id;
    this.description = description;
    shapeList = new ArrayList<>();
  }

  /**
   * this is to get id function.
   * @return id.
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * this is to get description.
   * @return description.
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * this is to add shape.
   * @param shape IShape.
   */
  @Override
  public void addShape(IShape shape) {
    this.shapeList.add(shape);
  }

  /**
   * this is graphicalDisplay function.
   * @param g Graphics.
   */
  @Override
  public void graphicalDisplay(Graphics g) {
    for (IShape shape : shapeList) {
      shape.graphicalDisplay(g);
    }
  }

  /**
   * this is webDisplay function.
   * @param output Appendable.
   */
  @Override
  public void webDisplay(Appendable output) {
    try {
      output.append("<div>\n");
      output.append("<h2>ID:" + this.id + "</h2>\n");
      output.append("<h2>Description:" + this.description + "</h2>\n");
      output.append("<svg width=\"1000\" height=\"1000\">\n");
      for (IShape shape : shapeList) {
        shape.webDisplay(output);
      }
      output.append("</svg>\n</div>\n");
    } catch (IOException e) {
      return;
    }
  }
}
