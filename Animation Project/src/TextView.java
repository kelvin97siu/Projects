import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * This class is used to format our Model input into a formatted Text File.
 * 
 * @author alann
 *
 */

public class TextView implements ViewInterface {
  private Map<String, List<Shape>> map;
  private PriorityQueue<Shape> pQ;
  String out;

  /**
   * This will initlaize out Text Class.
   * 
   * @param map Treemap from Model Class
   * @param out from CL Input
   * @param pQ  from Model Class
   */
  public TextView(Map<String, List<Shape>> map, String out, PriorityQueue<Shape> pQ) {
    this.map = map;
    this.pQ = pQ;
    this.out = out;
  }

  @Override
  public String displayView() {
    String output = "";
    for (String key : this.map.keySet()) {
      Shape shape = this.map.get(key).get(0);
      String line1 = "";
      String line2 = "";

      if (shape.getShapeType().equals("Rectangle")) {
        line1 = "with corner at " + "(" + shape.getStartX() + "," + shape.getStartY() + "), ";
        line2 = "width " + shape.getWidth() + " and " + "height " + shape.getHeight();
      } else if (shape.getShapeType().equals("Oval") || (shape.getShapeType().equals("Circle"))) {
        line1 = "with center at " + "(" + shape.getStartX() + "," + shape.getStartY() + "), ";
        line2 = "radius " + shape.getWidth() + " and " + shape.getHeight();
      }

      output = output + "Create " + "(" + shape.getRed() + "," + shape.getBlue() + ","
          + shape.getGreen() + ") coloured " + shape.getShapeType().toLowerCase() + " " + key + " "
          + line1 + line2 + "\n";
    }

    String output2 = "";
    for (String key : this.map.keySet()) {
      double appear = this.map.get(key).get(0).getTime();
      double disappear = this.map.get(key).get(this.map.get(key).size() - 1).getEndTime();

      output2 = output2 + key + " appears at time " + "t=" + appear + " and disappears at "
          + "time " + "t=" + disappear + "\n";
    }

    String output3 = "";
    for (Shape shape : this.pQ) {
      // while (this.model.iterator().hasNext()) {
      AnimationImpl animation = new AnimationImpl(shape);
      output3 = output3 + animation.toString();
    }

    return output + "\n" + output2 + "\n" + output3;
  }

}
