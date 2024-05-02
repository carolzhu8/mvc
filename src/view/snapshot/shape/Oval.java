package view.snapshot.shape;


import java.awt.*;
import java.io.IOException;

/**
 * this is Oval class.
 */
public class Oval extends AbstractShape {
  /**
   * this is Oval constructor.
   * @param name String.
   * @param x double.
   * @param y double.
   * @param xRadius double.
   * @param yRadius double.
   * @param redValue double.
   * @param greenValue double.
   * @param blueValue double.
   */
  public Oval(String name, double x, double y,
              double xRadius, double yRadius,
              double redValue, double greenValue, double blueValue) {
    super("Oval", name, x, y, xRadius, yRadius, redValue, greenValue, blueValue);
  }

  /**
   * this is graphicalDisplay function.
   * @param g Graphics.
   */
  @Override
  public void graphicalDisplay(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color((int) this.getRed(), (int) this.getGreen(), (int) this.getBlue()));
    g2d.fillOval((int) (this.getX() - this.getFirstDimension()),
            (int) (this.getY() - this.getSecondDimension()),
            (int) (2 * getFirstDimension()),
            (int) (2 * getSecondDimension()));
  }

  /**
   * this is webDisplay function.
   * @param output Appendable.
   */
  @Override
  public void webDisplay(Appendable output) {
    String shapeInWeb = String.format("<ellipse id=\"%s\" cx=\"%.1f\" cy=\"%.1f\" "
            + "rx=\"%.1f\" ry=\"%.1f\" fill=\"rgb(%.1f, %.1f, %.1f)\" />\n",
            this.getName(), getX(), getY(), getFirstDimension(),getSecondDimension(),
            getRed(), getGreen(), getBlue());
    try {
      output.append(shapeInWeb);
    } catch (IOException e) {
      return;
    }
  }
}
