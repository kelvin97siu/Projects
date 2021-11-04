/**
 * AnimationImpl implements the Animation interface.
 * 
 * @author kelvin97siu
 *
 */
public class AnimationImpl implements Animation {
  private Shape shape;
  private int tempo = 1;

  /**
   * Constructor for animation implementation.
   * 
   * @param shape the shape object.
   */
  public AnimationImpl(Shape shape) {
    this.shape = shape;
  }

  @Override
  public String move(Shape shape) {
    if (shape.getStartX() - shape.getEndX() != 0 || shape.getStartY() - shape.getEndY() != 0) {
      return String.format("%s moves from (%.1f,%.1f) to (%.1f,%.1f) from time t=%.1f to t=%.1f",
          shape.getStringName(), shape.getStartX(), shape.getStartY(), shape.getEndX(),
          shape.getEndY(), shape.getTime(), shape.getEndTime());
    }
    return "";
  }

  @Override
  public String colour(Shape shape) {
    if (shape.getRed() - shape.getEndRed() != 0 || shape.getGreen() - shape.getEndGreen() != 0
        || shape.getBlue() - shape.getEndBlue() != 0) {

      return String.format(
          "%s changes color from (%.1f,%.1f,%.1f) to (%.1f,%.1f,%.1f) from time t=%.1f to t=%.1f",
          shape.getStringName(), shape.getRed(), shape.getGreen(), shape.getBlue(),
          shape.getEndRed(), shape.getEndGreen(), shape.getEndBlue(), shape.getTime(),
          shape.getEndTime());
    }
    return "";
  }

  @Override
  public String resize(Shape shape) {
    if (shape.getWidth() - shape.getEndWidth() != 0
        || shape.getHeight() - shape.getEndHeight() != 0) {

      return String.format(
          "%s scales from Width: %.1f, Height: %.1f to Width: %.1f, "
          + "Height:%.1f from time t=%.1f to t=%.1f\n",
          shape.getStringName(), shape.getWidth(), shape.getHeight(), shape.getEndWidth(),
          shape.getEndHeight(), shape.getTime(), shape.getEndTime());
    }
    return "";
  }

  @Override
  public String toString() {
    String output = "";

    if (move(shape).equals("")) {
      output = output + "";
    } else {
      output = output + move(shape) + "\n";
    }

    if (colour(shape).equals("")) {
      output.trim();
    } else {
      output = output + colour(shape) + "\n";
    }

    if (resize(shape).equals("")) {
      output.trim();
    } else {
      output = output + resize(shape);
    }
    return output;
  }

  @Override
  public String svgmove(Shape shape) {
    int sec = 1000 / tempo;
    String xcoord = "";
    String ycoord = "";

    if (shape.getShapeType().equals("Rectangle")) {
      xcoord = "x";
      ycoord = "y";
    } else if (shape.getShapeType().equals("Oval") || shape.getShapeType().equals("Circle")) {
      xcoord = "cx";
      ycoord = "cy";
    }

    String output = "";
    if (shape.getStartX() - shape.getEndX() != 0) {
      output = output + String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"%s\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          shape.getTime() * sec, (shape.getEndTime() - shape.getTime()) * sec, xcoord,
          shape.getStartX(), shape.getEndX());
    } else {
      output.trim();
    }

    if (shape.getStartY() - shape.getEndY() != 0) {
      output = output + String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\""
              + " attributeName=\"%s\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          shape.getTime() * sec, (shape.getEndTime() - shape.getTime()) * sec, ycoord,
          shape.getStartY(), shape.getEndY());
    } else {
      output.trim();
    }
    return output.trim();
  }

  @Override
  public String svgcolour(Shape shape) {
    int sec = 1000 / tempo;

    if (shape.getRed() - shape.getEndRed() != 0 || shape.getGreen() - shape.getEndGreen() != 0
        || shape.getBlue() - shape.getEndBlue() != 0) {

      return String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"fill\" from=\"rgb(%.1f,%.1f,%.1f)\" "
              + "to=\"rgb(%.1f,%.1f,%.1f)\" fill=\"freeze\" />",
          shape.getTime() * sec, (shape.getEndTime() - shape.getTime()) * sec, shape.getRed(),
          shape.getGreen(), shape.getBlue(), shape.getEndRed(), shape.getEndGreen(),
          shape.getEndBlue());
    }
    return "";
  }

  @Override
  public String svgresize(Shape shape) {
    int sec = 1000 / tempo;

    String width = "";
    String height = "";

    if (shape.getShapeType().equals("Rectangle")) {
      width = "width";
      height = "height";
    } else if (shape.getShapeType().equals("Oval") || shape.getShapeType().equals("Circle")) {
      width = "rx";
      height = "ry";
    }

    String output = "";
    if (shape.getWidth() - shape.getEndWidth() != 0) {
      output = output + String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"%s\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          shape.getTime() * sec, (shape.getEndTime() - shape.getTime()) * sec, width,
          shape.getWidth(), shape.getEndWidth());
    } else {
      output.trim();
    }

    if (shape.getHeight() - shape.getEndHeight() != 0) {
      output = output + String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\""
              + " attributeName=\"%s\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          shape.getTime() * sec, (shape.getEndTime() - shape.getTime()) * sec, height,
          shape.getHeight(), shape.getEndHeight());

    } else {
      output.trim();
    }

    return output.trim();
  }

  @Override
  public String svgString() {
    String output = "";

    if (svgmove(shape).equals("")) {
      output = output + "";
    } else {
      output = output + svgmove(shape) + "\n";
    }

    if (svgcolour(shape).equals("")) {
      output.trim();
    } else {
      output = output + svgcolour(shape) + "\n";
    }

    if (svgresize(shape).equals("")) {
      output.trim();
    } else {
      output = output + svgresize(shape);
    }
    return output;
  }

  @Override
  public void setTempo(int tempo) throws IllegalArgumentException {
    if (tempo < 1) {
      throw new IllegalArgumentException("Tempo cannot be less than 1");
    }
    this.tempo = tempo;
  }
}
