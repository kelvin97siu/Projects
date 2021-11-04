import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This Class used to convert out Model input into an SVG File.
 * 
 * @author alann
 *
 */
public class SVGView implements ViewInterface {
  private Map<String, List<Shape>> map;
  private int speed;
  private Canvas canvas;
  private ArrayList<String> array;

  /**
   * Initializes our SVG Class.
   * 
   * @param map    A Treemap form Model
   * @param speed  from CL USer input its a double
   * @param canvas from Model Class
   * @param array  From Model Class
   */
  public SVGView(Map<String, List<Shape>> map, int speed, Canvas canvas, ArrayList<String> array) {
    this.map = map;
    this.canvas = canvas;
    this.speed = speed;
    this.array = array;

  }

  @Override
  public String displayView() {
    String output = "";

    String line1 = String.format(
        "<svg width=\"%d\" height=\"%d\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" >",
        this.canvas.getCanvasW() + this.canvas.getCanvasX(),
        this.canvas.getCanvasH() + this.canvas.getCanvasY());

    output = output + line1 + "\n\n";

    String name = this.array.get(0);
    double appear = this.map.get(name).get(0).getTime();
    double disappear = this.map.get(name).get(this.map.get(name).size() - 1).getEndTime();

    String loop = "";
    loop = loop + "<rect>\n"
        + String.format(
            " <animate id=\"base\" begin=\"0;base.end\" dur=\"%.1fms\""
                + " attributeName=\"visibility\" from=\"hide\" to=\"hide\"/>\n",
            (disappear - appear) * 1000 / this.speed)
        + "</rect>\n\n";

    String line2 = "";
    String declare = "";
    String body = "";
    String end = "";
    String reinit = "";

    for (int i = 0; i < this.array.size(); i++) {

      String key = this.array.get(i);

      if (this.map.get(key).get(0).getShapeType().equals("Rectangle")) {
        Shape initShape = this.map.get(key).get(0);

        declare = String.format(
            "<rect id=\"%s\" x=\"%.1f\" y=\"%.1f\" width=\"%.1f\" height=\"%.1f\" "
                + "fill=\"rgb(%.1f,%.1f,%.1f)\" visibility=\"visible\" >\n",
            initShape.getStringName(), initShape.getStartX(), initShape.getStartY(),
            initShape.getWidth(), initShape.getHeight(), initShape.getRed(), initShape.getGreen(),
            initShape.getBlue());

        body = "";
        for (int j = 0; j < this.map.get(key).size(); j++) {
          Shape shape = this.map.get(key).get(j);
          AnimationImpl animation = new AnimationImpl(shape);
          animation.setTempo(speed);

          body = body + animation.svgString();
        }

        reinit = String
            .format("<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
                + "attributeName=\"x\" to=\"%.1f\" fill=\"freeze\" />\n", initShape.getStartX())
            + String.format("<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
                + "attributeName=\"y\" to=\"%.1f\" fill=\"freeze\" />\n", initShape.getStartY())
            + String.format(
                "<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
                    + "attributeName=\"fill\" to=\"rgb(%.1f,%.1f,%.1f)\" fill=\"freeze\" />\n",
                initShape.getRed(), initShape.getGreen(), initShape.getBlue())
            + String.format(
                "<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
                    + "attributeName=\"width\" to=\"%.1f\" fill=\"freeze\" />\n",
                initShape.getWidth())
            + String.format(
                "<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
                    + "attributeName=\"height\" to=\"%.1f\" fill=\"freeze\" />\n",
                initShape.getHeight());

        end = "</rect>\n";
      }

      else if (this.map.get(key).get(0).getShapeType().equals("Oval")
          || this.map.get(key).get(0).getShapeType().equals("Circle")) {
        Shape initShape = this.map.get(key).get(0);

        declare = String.format(
            "<ellipse id=\"%s\" cx=\"%.1f\" cy=\"%.1f\" rx=\"%.1f\" ry=\"%.1f\" "
                + "fill=\"rgb(%.1f,%.1f,%.1f)\" visibility=\"visible\" >\n",
            initShape.getStringName(), initShape.getStartX(), initShape.getStartY(),
            initShape.getWidth(), initShape.getHeight(), initShape.getRed(), initShape.getGreen(),
            initShape.getBlue());

        body = "";
        for (int j = 0; j < this.map.get(key).size(); j++) {
          Shape shape = this.map.get(key).get(j);
          AnimationImpl animation = new AnimationImpl(shape);
          animation.setTempo(speed);

          body = body + animation.svgString();
        }

        reinit = String.format("<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
            + "attributeName=\"cx\" to=\"%.1f\" fill=\"freeze\" />\n", initShape.getStartX())
            + String.format(
                "<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
                    + "attributeName=\"cy\" to=\"%.1f\" fill=\"freeze\" />\n",
                initShape.getStartY())
            + String.format(
                "<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
                    + "attributeName=\"fill\" to=\"rgb(%.1f,%.1f,%.1f)\" fill=\"freeze\" />\n",
                initShape.getRed(), initShape.getGreen(), initShape.getBlue())
            + String.format("<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
                + "attributeName=\"rx\" to=\"%.1f\" fill=\"freeze\" />\n", initShape.getWidth())
            + String.format(
                "<animate attributeType=\"xml\" begin=\"base.end\" dur=\"1ms\" "
                    + "attributeName=\"ry\" to=\"%.1f\" fill=\"freeze\" />\n",
                initShape.getHeight());

        end = "</ellipse>\n";
      }

      line2 = line2 + declare + body + reinit + end + "\n";
    }
    return output + loop + line2 + "</svg>";
  }

  /**
   * This will take the above method and convert it into an SVG file.
   * 
   * @param filename  String
   * @param sVGOutput String
   * @return A SVG File
   * @throws IOException if File not Found
   */
  public File createSVGFile(String filename, String sVGOutput) throws IOException {
    try {
      File filetxt = new File(filename);
      FileWriter writer = new FileWriter(filename);
      writer.write(sVGOutput);
      writer.close();

      return filetxt;
    } catch (IOException e) {
      throw new IOException("Invalid File");
    }
  }
}
