package model.color;

import java.util.Objects;

/**
 * this is a color class. it represents each color in rgb value
 */
public class Color {
  private double redValue;
  private double greenValue;
  private double blueValue;

  private static final double MIN_VALUE = 0.0;
  private static final double MAX_VALUE = 255.0;  //rgb

  /**
   * this is a constructor.
   * @param redValue double.
   * @param greenValue double.
   * @param blueValue double.
   */
  public Color(double redValue, double greenValue, double blueValue) {
    this.redValue = checkColor(redValue);
    this.greenValue = checkColor(greenValue);
    this.blueValue = checkColor(blueValue);
  }

  /**
   *this is copy constructor.
   * @param that Color.
   */
  public Color(Color that) {
    this(that.redValue, that.greenValue, that.blueValue);
  }

  /**
   * this is to check if color is valid.
   * @param color double.
   * @return color.
   */
  private double checkColor(double color){
    if (color > MAX_VALUE){
      return MAX_VALUE;
    }
    if(color < MIN_VALUE){
      return MIN_VALUE;
    }
    return color;
  }

  /**
   * this is to get the red value.
   * @return double.
   */
  public double getRedValue() {
    return redValue;
  }

  /**
   * this is to get the green value.
   * @return double.
   */
  public double getGreenValue() {
    return greenValue;
  }

  /**
   * this is to get blue value.
   * @return double.
   */
  public double getBlueValue() {
    return blueValue;
  }

  /**
   * this is equals function.
   * @param o Object.
   * @return true or false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Color color = (Color) o;
    return Double.compare(redValue, color.redValue) == 0
            && Double.compare(greenValue, color.greenValue) == 0
            && Double.compare(blueValue, color.blueValue) == 0;
  }

  /**
   * this is hash code.
   * @return int.
   */
  @Override
  public int hashCode() {
    return Objects.hash(redValue, greenValue, blueValue);
  }

  /**
   * this is to string function.
   * @return String.
   */
  @Override
  public String toString() {
    return String.format("Color: (%.1f, %.1f, %.1f)", redValue, greenValue, blueValue);
  }

//  public static void main(String[] args) {
//    Color color = new Color(100, 100, 100);
//    System.out.println(color);
//  }
}
