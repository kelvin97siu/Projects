/**
 * This class is used to minimize duplicate code to the subclasses for Shape.
 * Since Shapes will all have similar coordinates/features, we can use a super
 * call to minimize code.
 * 
 * @author kelvin97siu
 *
 */
public abstract class AbstractShape implements Shape {
  protected Position startPosition;
  protected Position endPosition;
  protected Duration time;
  protected Colour startColour;
  protected Colour endColour;
  protected double wStart;
  protected double hStart;
  protected Dimensions startDimensions;
  protected Dimensions endDimensions;
  protected String name;

  /**
   * We are using a constructor that will take 15 parameters. These parameters
   * will dictate coordinates and colour scheme for the life of the shape object.
   * 
   * @param name   the name of shape.
   * @param tStart the start time of shape.
   * @param xStart the x coordinate start position of shape.
   * @param yStart the y coordinate start position of shape.
   * @param wStart the starting width of shape.
   * @param hStart the starting height of shape.
   * @param rStart the starting red component of shape.
   * @param gStart the starting green component of shape.
   * @param bStart the starting blue component of shape.
   * @param tEnd   the end time of shape.
   * @param xEnd   the x coordinate end position of shape.
   * @param yEnd   the y coordinate end position of shape.
   * @param wEnd   the ending width of shape.
   * @param hEnd   the ending height of shape.
   * @param rEnd   the ending red component of shape.
   * @param gEnd   the ending green component of shape.
   * @param bEnd   the ending blue component of shape.
   */
  public AbstractShape(String name, double tStart, double xStart, double yStart, double wStart,
      double hStart, double rStart, double gStart, double bStart,

      double tEnd, double xEnd, double yEnd, double wEnd, double hEnd, double rEnd, double gEnd,
      double bEnd) {

    this.name = name;

    this.startPosition = new Position(xStart, yStart);
    this.endPosition = new Position(xEnd, yEnd);

    this.time = new Duration(tStart, tEnd);

    this.startColour = new Colour(rStart, gStart, bStart);
    this.endColour = new Colour(rEnd, gEnd, bEnd);

    this.startDimensions = new Dimensions(wStart, hStart);
    this.endDimensions = new Dimensions(wEnd, hEnd);
  }

  @Override
  public double getStartX() {
    return this.startPosition.getXcoord();
  }

  @Override
  public double getStartY() {
    return this.startPosition.getYcoord();
  }

  @Override
  public double getWidth() {
    return this.startDimensions.getWidth();
  }

  @Override
  public double getHeight() {
    return this.startDimensions.getHeight();
  }

  public double getRed() {
    return this.startColour.getRed();
  }

  public double getGreen() {
    return this.startColour.getGreen();
  }

  public double getBlue() {
    return this.startColour.getBlue();
  }

  public double getTime() {
    return this.time.getStartTime();
  }

  public double getEndX() {
    return this.endPosition.getXcoord();
  }

  public double getEndY() {
    return this.endPosition.getYcoord();
  }

  public double getEndWidth() {
    return this.endDimensions.getWidth();
  }

  public double getEndHeight() {
    return this.endDimensions.getHeight();
  }

  public double getEndRed() {
    return this.endColour.getRed();
  }

  public double getEndGreen() {
    return this.endColour.getGreen();
  }

  public double getEndBlue() {
    return this.endColour.getBlue();
  }

  public double getEndTime() {
    return this.time.getEndTime();
  }

  public String getStringName() {
    return this.name;
  }

  @Override
  public String toString() {
    return this.name + " " + this.time.getStartTime() + " " + this.startPosition.getXcoord() + " "
        + this.startPosition.getYcoord() + " " + this.startDimensions.getWidth() + " "
        + this.startDimensions.getHeight() + " " + this.startColour.getRed() + " "
        + this.startColour.getBlue() + " " + this.startColour.getGreen() + "\n" +

        this.time.getEndTime() + " " + this.endPosition.getXcoord() + " "
        + this.endPosition.getYcoord() + " " + this.endDimensions.getWidth() + " "
        + this.endDimensions.getHeight() + " " + this.endColour.getRed() + " "
        + this.endColour.getBlue() + " " + this.endColour.getGreen();
  }
}
