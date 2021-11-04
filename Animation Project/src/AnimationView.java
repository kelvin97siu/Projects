
import java.util.PriorityQueue;

/**
 * This class implments our JFrmae class. This class will display a GUI view in
 * a pop up window.
 * 
 * @author alann
 *
 */
public class AnimationView implements ViewInterface {

  /**
   * Contructor for animation view.
   * @param pQ     Priority Queue from AnimationModel
   * @param speed  from CL input
   * @param canvas from CL input
   */
  public AnimationView(PriorityQueue<Shape> pQ, double speed, Canvas canvas) {
    AnimationFrame frame = new AnimationFrame(pQ, speed, canvas);

  }

  @Override
  public String displayView() {
    return null;
  }

}
