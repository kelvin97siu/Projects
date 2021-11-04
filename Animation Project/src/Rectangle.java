/**
 * This class is a subclass used to create a Rectangle shape Object.
 * 
 * @author alann
 *
 */

public class Rectangle extends AbstractShape {

  /**
   * Initalizes the Rectangle Object.
   * 
   * @param name   the name of the object.
   * @param tStart double the starting time of the object.
   * @param xStart double the starting x coordinate of the object.
   * @param yStart double the starting y coordinate of the object.
   * @param wStart double the starting width of the object.
   * @param hStart double the starting height of the object.
   * @param rStart double the starting red component of the object.
   * @param gStart double the starting green component of the object.
   * @param bStart double the starting blue component of the object.
   * @param tEnd   double the ending time of the object.
   * @param xEnd   double the ending x coordinate of object.
   * @param yEnd   double the ending y coordinate of object.
   * @param wEnd   double the ending width of the object.
   * @param hEnd   double the ending height of the object.
   * @param rEnd   double the ending red component of the object.
   * @param gEnd   double the ending green component of the object.
   * @param bEnd   double the ending blue component of the object.
   */
  public Rectangle(String name, double tStart, double xStart, double yStart, double wStart,
      double hStart, double rStart, double gStart, double bStart, double tEnd, double xEnd,
      double yEnd, double wEnd, double hEnd, double rEnd, double gEnd, double bEnd) {
    super(name, tStart, xStart, yStart, wStart, hStart, rStart, gStart, bStart, tEnd, xEnd, yEnd,
        wEnd, hEnd, rEnd, gEnd, bEnd);
  }

  /**
   * Returns the type of the Rectangle Class.
   */
  public String getShapeType() {
    return "Rectangle";
  }
}
