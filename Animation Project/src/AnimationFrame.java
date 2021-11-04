
import java.util.PriorityQueue;

import javax.swing.JFrame;

/**
 * This class is used to implement the Animation Frame. This class is used to
 * format the Frame by packing the JPanel and other formats on the Frame.
 * 
 * @author alann
 *
 */
public class AnimationFrame extends JFrame {

  AnimationPanel panel;
  Canvas canvas;

  /**
   * This constructor is a conduit between the Jpanel and AnimationView class.
   * This class will setup a JFrame so it can be initialized in our AnimationView
   * Class.
   * 
   * @param pQ     PriorityQueue from our Model
   * @param speed  user input from the CL
   * @param canvas USer input from the CL
   */
  public AnimationFrame(PriorityQueue<Shape> pQ, double speed, Canvas canvas) {
    panel = new AnimationPanel(pQ, speed, canvas);
    this.canvas = canvas;
    int center = (int) (this.canvas.getCanvasW()) / 2;

    // String space is used to format the title of our JFrame
    String space = " ";
    String title = "Animation View";
    for (int i = 0; i <= center; i++) {
      space = space + " ";
    }

    // Add panel on the Frame
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(panel);
    this.pack();
    this.setLocationRelativeTo(null);

    // adds a title to our Frame
    this.setTitle(space + title);
    this.setVisible(true);

  }

}
