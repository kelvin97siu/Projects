/**
 * Represent animation of shape.
 * 
 * @author kelvin97siu
 *
 */
public interface Animation {

  /**
   * The text view string format of a shape movement.
   * 
   * @param shape the shape object.
   * @return the string format of a shape movement.
   */
  public String move(Shape shape);

  /**
   * The text view string format of a shape with a color change.
   * 
   * @param shape the shape object.
   * @return the string format of a shape color change.
   */
  public String colour(Shape shape);

  /**
   * The text view string format of a shape that re-scales.
   * 
   * @param shape the shape object.
   * @return the string format of a shape that is re-scaled.
   */
  public String resize(Shape shape);

  /**
   * Converts the shape movement to SVG format.
   * 
   * @param shape the shape object.
   * @return the shape movement in SVG format.
   */
  public String svgmove(Shape shape);

  /**
   * Converts the shape color to SVG format.
   * 
   * @param shape the shape object.
   * @return the shape color change in SVG format.
   */
  public String svgcolour(Shape shape);

  /**
   * Converts the shape size to SVG format.
   * 
   * @param shape the shape object.
   * @return the shape resizing in SVG format.
   */
  public String svgresize(Shape shape);

  /**
   * The move, color and resize SVG format of a shape.
   * 
   * @return the string containing all changes to a shape in SVG format.
   */
  public String svgString();

  /**
   * Sets the speed of shape.
   * 
   * @param tempo the number of ticks.
   */
  public void setTempo(int tempo);
}
