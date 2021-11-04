/**
 * Will create A shape object.
 * @author alann
 *
 */
public class Circle extends AbstractShape {
  final String type = "circle";
  double hStart; 
  double wStart;
  double hEnd; 
  double wEnd; 

  /**
   * Initialize a Circle Object.
   * @param name String name of the circle object.
   * @param tStart double starting time of the object.
   * @param xStart double starting x coordinate of the object.
   * @param yStart double starting y coordinate of the object.
   * @param wStart double starting width of the object.
   * @param hStart double starting height of the object.
   * @param rStart double starting red component of the object.
   * @param gStart double starting green component of the object.
   * @param bStart double starting blue component of the object.
   * @param tEnd double ending time of the object.
   * @param xEnd double ending x coordinate of the object.
   * @param yEnd double ending y coordinate of the object.
   * @param wEnd double ending width of the object.
   * @param hEnd double ending height of the object.
   * @param rEnd double ending red component of the object.
   * @param gEnd double ending green component of the object.
   * @param bEnd double ending blue component of the object.
   */
  public Circle(String name,
          double tStart, double xStart, double yStart, double wStart, double hStart, 
          double rStart, double gStart, double bStart,
          double tEnd, double xEnd, double yEnd, double wEnd, double hEnd, 
          double rEnd, double gEnd, double bEnd) {
    super(name,
             tStart,  xStart,  yStart, wStart, hStart,
             rStart,  gStart,  bStart,
             tEnd,  xEnd,  yEnd, wEnd, hEnd, 
             rEnd,  gEnd,  bEnd);
  }

  /**
   * Returns a string of the shape Type.
   */
  public String getShapeType() {
    return "Circle";
  }
}
