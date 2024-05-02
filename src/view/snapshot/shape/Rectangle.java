package view.snapshot.shape;

import java.awt.*;
import java.io.IOException;

/**
 * this is Rectangle function.
 */
public class Rectangle extends AbstractShape {
  public Rectangle(String name, double x, double y,
                   double width, double height,
                   double redValue, double greenValue, double blueValue) {
    super("Rectangle", name, x, y, width, height, redValue, greenValue, blueValue);
  }

  /**
   * this is graphicalDisplay function.
   * @param g Graphics.
   */
  @Override
  public void graphicalDisplay(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color((int) getRed(), (int) getGreen(), (int) getBlue()));
    g2d.fillRect((int) (getX()), (int) (getY()),
            (int) (getFirstDimension()), (int) (getSecondDimension()));
  }

  /**
   * this is webDisplay function.
   * @param output Appendable.
   */
  @Override
  public void webDisplay(Appendable output) {
    String shapeInWeb = String.format("<rect id=\"%s\" x=\"%.1f\" y=\"%.1f\" "
                    + "width=\"%.1f\" height=\"%.1f\" fill=\"rgb(%.1f, %.1f, %.1f)\" />\n",
            this.getName(), getX(), getY(), getFirstDimension(),getSecondDimension(),
            getRed(), getGreen(), getBlue());
    try {
      output.append(shapeInWeb);
    } catch (IOException e) {
      return;
    }
  }
}
