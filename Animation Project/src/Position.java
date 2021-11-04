/**
 * This will initialize a position object for our shape Class.
 * 
 * @author alann
 *
 */

public class Position {
  private double xcoord;
  private double ycoord;

  /**
   * Initializes the position of our Objects.
   * 
   * @param x the x coordinate of the object.
   * @param y the y coordinate of the object.
   */
  public Position(double x, double y) {
    this.xcoord = x;
    this.ycoord = y;
  }

  /**
   * Return the X Coordinate of our Object.
   * 
   * @return double
   */
  public double getXcoord() {
    return this.xcoord;
  }

  /**
   * Return the Y Coordinate of our OBject.
   * 
   * @return double
   */
  public double getYcoord() {
    return this.ycoord;
  }

  /**
   * Sets the X Coordinate for our object.
   * 
   * @param x double
   */
  public void setXcoord(double x) {
    this.xcoord = x;
  }

  /**
   * Sets the Y Coordinate of our Object.
   * 
   * @param y double
   */
  public void setYCoord(double y) {
    this.ycoord = y;
  }
}
