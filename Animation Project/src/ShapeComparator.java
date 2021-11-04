import java.util.Comparator;

/**
 * Used to Format our PriorityQueue in our Model.
 * @author alann
 *
 */
public class ShapeComparator implements Comparator<Shape> {

  @Override
  public int compare(Shape o1, Shape o2) {
    if (o1.getTime() > o2.getTime()) {
      return 1;
    } else if (o1.getTime() < o2.getTime()) {
      return -1;
    }
    return 0;
  }
}
