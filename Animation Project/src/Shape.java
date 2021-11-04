/**
 * Sets the outline of our Shape Class to 
 * 15 different methods. 
 * @author kelvin97siu
 *
 */
public interface Shape {

  /**
   * The type of shape.
   * @return type of shape.
   */
  public String getShapeType();

  /**
   * The starting time of shape.
   * @return starting time of shape.
   */
  public double getTime();
  
  /**
   * The starting x coordinate position of shape.
   * @return starting x coordinate position of shape.
   */
  public double getStartX();

  /**
   * The starting y coordinate position of shape.
   * @return starting y coordinate position of shape.
   */
  public double getStartY();

  /**
   * The starting width of shape.
   * @return starting width of shape.
   */
  public double getWidth();
  
  /**
   * The starting height of shape.
   * @return starting height of shape.
   */
  public double getHeight();

  /**
   * The starting red RGB color component of shape.
   * @return starting red color component of shape.
   */
  public double getRed();

  /**
   * The starting green RGB color component of shape.
   * @return starting green color component of shape.
   */
  public double getGreen();

  /**
   * The starting blue RGB color component of shape.
   * @return starting blue color component of shape.
   */
  public double getBlue();
  
  /**
   * The ending time of shape.
   * @return ending time of shape.
   */
  public double getEndTime();

  /**
   * The ending x coordinate position of shape.
   * @return ending x coordinate position of shape.
   */
  public double getEndX();

  /**
   * The ending y coordinate position of shape.
   * @return ending y coordinate position of shape.
   */
  public double getEndY();

  /**
   * The ending width of shape.
   * @return ending width of shape.
   */
  public double getEndWidth();

  /**
   * The ending height of shape.
   * @return ending height of shape.
   */
  public double getEndHeight();

  /**
   * The ending red RGB color component of shape.
   * @return ending red color component of shape.
   */
  public double getEndRed();

  /**
   * The ending green RGB color component of shape.
   * @return ending green color component of shape.
   */
  public double getEndGreen();

  /**
   * The ending blue RGB color component of shape.
   * @return ending blue color component of shape.
   */
  public double getEndBlue();

  /**
   * The name of the shape.
   * @return name of the shape.
   */
  public String getStringName();
}
