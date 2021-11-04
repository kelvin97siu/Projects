/**
 * Class is used to create a Triangle Object.
 * 
 * @author alann
 *
 */

public class Triangle extends AbstractShape {
  /**
   * Initialize a Triangle Object.
   * 
   * @param name   the name of the object.
   * @param tStart the starting time of the object.
   * @param xStart the starting x coordinate of the object.
   * @param yStart the starting y coordinate of the object.
   * @param wStart the starting width of the object.
   * @param hStart the starting height of the object.
   * @param rStart the starting red component of the object.
   * @param gStart the starting green component of the object.
   * @param bStart the starting blue component of the object.
   * @param tEnd   the ending time of the object.
   * @param xEnd   the ending x coordinate of the object.
   * @param yEnd   the ending y coordinate of the object.
   * @param wEnd   the ending width of the object.
   * @param hEnd   the ending height of the object.
   * @param rEnd   the ending red component of the object.
   * @param gEnd   the ending green component of the object.
   * @param bEnd   the ending blue component of the object.
   */
  public Triangle(String name, double tStart, double xStart, double yStart, double wStart,
      double hStart, double rStart, double gStart, double bStart, double tEnd, double xEnd,
      double yEnd, double wEnd, double hEnd, double rEnd, double gEnd, double bEnd) {
    super(name, tStart, xStart, yStart, wStart, hStart, rStart, gStart, bStart, tEnd, xEnd, yEnd,
        wEnd, hEnd, rEnd, gEnd, bEnd);
  }

  /**
   * Will show that this shape object is a triangle.
   */
  public String getShapeType() {
    return "Triangle";
  }
}
