/**
 * Colour is used to set the colour for each shape.
 * 
 * @author alann
 *
 */
public class Colour {
  private double red;
  private double green;
  private double blue;

  /**
   * Initialize a Colour object to be passed to our Shape Class.
   * 
   * @param red   double
   * @param green double
   * @param blue  double
   * @throws IllegalArgumentException throw IAE
   */
  public Colour(double red, double green, double blue) throws IllegalArgumentException {
    if (red < 0 || blue < 0 || green < 0 || red > 255 || blue > 255 || green > 255) {
      throw new IllegalArgumentException("Colours cannot be less than zero or greater than 255");
    }

    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Return this.red.
   * 
   * @return double red component.
   */
  public double getRed() {
    return this.red;
  }

  /**
   * Return blue colour.
   * 
   * @return double blue component.
   */
  public double getBlue() {
    return this.blue;
  }

  /**
   * Return green colour.
   * 
   * @return double green component.
   */
  public double getGreen() {
    return this.green;
  }

  /**
   * Set Red Colour.
   * 
   * @param red double component.
   */
  public void setRed(double red) {
    this.red = red;
  }

  /**
   * Set Blue Colour.
   * 
   * @param blue double component.
   */
  public void setBlue(double blue) {
    this.blue = blue;
  }

  /**
   * Set Green Colour.
   * 
   * @param green double component.
   */
  public void setGreen(double green) {
    this.green = green;
  }
}
