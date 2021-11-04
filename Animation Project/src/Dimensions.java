/**
 * Check and sets the Dimensions used to passed to our Shape Object.
 * 
 * @author alann
 *
 */

public class Dimensions {
  private double width;
  private double height;

  /**
   * Initializes a Dimension Object.
   * 
   * @param width  double.
   * @param height double.
   * @throws IllegalArgumentException if width or height is less than or equal to
   *                                  zero.
   */
  public Dimensions(double width, double height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width or height cannot be zero or less than zero");
    }

    this.width = width;
    this.height = height;
  }

  /**
   * Return the width of this object.
   * 
   * @return int width.
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * return the height of this object.
   * 
   * @return int height.
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Return the width of Dimensions.
   * 
   * @param width int.
   */
  public void setWidth(double width) {
    this.width = width;
  }

  /**
   * Return the Height of the Dimensions.
   * 
   * @param height int.
   */
  public void setHieght(double height) {
    this.height = height;
  }

}
