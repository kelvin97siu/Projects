
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.Timer;
import javax.swing.border.Border;

/**
 * The purpose of this class is to take the text file input that has been
 * converted into a priority queue and draw each shape for each second/tick for
 * the duration of the priority queue. The class is broken down into Setting up
 * the Jpanel so we can draw on it, then using the paintComponent Method and an
 * actionlistener to continously draw each shape as it appears in the priority
 * Queue. The Tweener method is used to break up the shape objects that have a
 * duration of longer than one second into individual shapes.
 * 
 * @author alann
 *
 */

public class AnimationPanel extends JPanel implements ActionListener {

  private Timer timer;

  // Second will be used to track and control our runtime of
  // our animations
  private double seconds;
  private PriorityQueue<Shape> pQ;
  private InputController controller;
  private int speed;
  Canvas canvas;
  private JButton resetButton = new JButton("Reset Time");
  private JButton startButton = new JButton("Start");
  private JButton pauseButton = new JButton("Pause");
  private JButton increaseSpeedButton = new JButton("Increase Speed");
  private JButton decreaseSpeedButton = new JButton("Decrease Speed");

  /**
   * Our Constructor class with take our model and Controller as input. We need
   * our model for the priority Queue and we need the InputController so we can
   * set the time from the user
   * 
   * @param model the model.
   * @param speed the speed of the shape.
   */
  AnimationPanel(PriorityQueue<Shape> pQ, Double speed, Canvas canvas) {

    // This is just to set the border of the JPane
    // This border adds some flare to the JPane
    Border lineBorder = BorderFactory.createLineBorder(new Color(50, 250, 200), 3);
    this.setBorder(lineBorder);
    this.canvas = canvas;

    // Here are five buttons that will provide some functionality to our JPane
    // The detailed code behind these buttons will be added in the ActionListener
    // method

    // The Reset Button will force the second variable to go back to one.
    // This will reset our animation back to square one.
    resetButton.setBounds(10, 10, 10, 10);

    // The Animation will not run until this method button is pushed.
    // This is button will always unpause a paused animation.
    startButton.setBounds(25, 10, 10, 10);

    // This button will pause an animation.
    pauseButton.setBounds(40, 10, 10, 10);

    // This button will double the animation speed
    increaseSpeedButton.setBounds(55, 10, 10, 10);

    // This button will decrease the animation speed by half
    decreaseSpeedButton.setBounds(70, 10, 10, 10);

    // Following buttons to our JPanel
    this.add(decreaseSpeedButton);
    this.add(increaseSpeedButton);
    this.add(pauseButton);
    this.add(startButton);
    this.add(resetButton);

    // Set size of the Jpanel to be the Frame Size
    this.setPreferredSize(new Dimension((this.canvas.getCanvasX()), this.canvas.getCanvasY()));

    this.pQ = pQ;

    this.speed = (int) (speed * 100);
    this.seconds = 1;
    this.timer = new Timer(this.speed, this);

    // The Following lines of code set the actionlistener
    // Then adds them to the Jpane item.
    pauseButton.setActionCommand("Pause");
    pauseButton.addActionListener(this);

    decreaseSpeedButton.setActionCommand("Decrease Speed");
    decreaseSpeedButton.addActionListener(this);

    increaseSpeedButton.setActionCommand("Increase Speed");
    increaseSpeedButton.addActionListener(this);

    resetButton.setActionCommand("Reset");
    resetButton.addActionListener(this);

    startButton.setActionCommand("Start");
    startButton.addActionListener(this);

  }

  /**
   * This method is used to convert a shape into a series of shapes If a shape has
   * a time duration (end-startTime) larger than one, we need to make a new shape
   * per second of the original object.
   * 
   * @param shape   Shape object
   * @param seconds a double from our constructor
   * @return
   */
  public Shape tweener(Shape shape, double seconds) {

    double difference = shape.getEndTime() - shape.getTime();

    // If the difference is one we return the object, if not we need to break the
    // object up
    if (difference != 0) {
      // This is used to tracker how much time a shape has left before its outside
      // the range of the second tracker.
      double tweenerFactor = seconds - shape.getTime();

      // For each variable (x,y,width,height, R,G,B) we need to take the average
      // position
      // of these objects so we can return it. This is essentially just linear
      // interpolation.
      double xDifference = shape.getStartX()
          + ((shape.getEndX() - shape.getStartX()) / difference * tweenerFactor);
      double yDifference = shape.getStartY()
          + ((shape.getEndY() - shape.getStartY()) / difference * tweenerFactor);
      double wDifference = shape.getWidth()
          + ((shape.getEndWidth() - shape.getWidth()) / difference * tweenerFactor);
      double hDifference = shape.getHeight()
          + ((shape.getEndHeight() - shape.getHeight()) / difference * tweenerFactor);
      double rDifference = shape.getRed()
          + ((shape.getEndRed() - shape.getRed()) / difference * tweenerFactor);
      double gDifference = shape.getGreen()
          + ((shape.getEndGreen() - shape.getGreen()) / difference * tweenerFactor);
      double bDifference = shape.getBlue()
          + ((shape.getEndBlue() - shape.getBlue()) / difference * tweenerFactor);

      // Since the shape object is formatted differently, we need to check the type of
      // the shape object, so we can make a new
      // version of that object.
      String typeCheck = shape.getShapeType();

      if (typeCheck.equals("Rectangle")) {
        Shape newShape = new Rectangle("rectangle", shape.getTime(), xDifference, yDifference,
            wDifference, hDifference, rDifference, gDifference, bDifference, shape.getEndTime(),
            shape.getEndX(), shape.getEndY(), shape.getEndWidth(), shape.getEndHeight(),
            shape.getEndRed(), shape.getEndGreen(), shape.getEndBlue());
        return newShape;
      } else if (typeCheck.equals("Oval")) {
        Shape newShape = new Circle("Circle", shape.getTime(), xDifference, yDifference,
            wDifference, hDifference, rDifference, gDifference, bDifference, shape.getEndTime(),
            shape.getEndX(), shape.getEndY(), shape.getEndWidth(), shape.getEndHeight(),
            shape.getEndRed(), shape.getEndGreen(), shape.getEndBlue());
        return newShape;
      } else if (typeCheck.equals("Triangle")) {
        Shape newShape = new Triangle("triangle", shape.getTime(), xDifference, yDifference,
            wDifference, hDifference, rDifference, gDifference, bDifference, shape.getEndTime(),
            shape.getEndX(), shape.getEndY(), shape.getEndWidth(), shape.getEndHeight(),
            shape.getEndRed(), shape.getEndGreen(), shape.getEndBlue());
        return newShape;
      }

    }
    return shape;
    // Return if the object is only appearing for one second.

  }

  /**
   * This method will draw each shape passed to it by the For each loop.
   */
  public void paintComponent(Graphics g) {

    // Paint background
    super.paintComponent(g);
    this.setBackground(new Color(255, 255, 255));

    // We have to iterate through our priority Queue so we can determine which
    // objects need
    // to be painted.
    for (Shape shape : this.pQ) {
      if (shape.getTime() <= seconds && seconds <= shape.getEndTime()) {

        Shape shape2 = tweener(shape, seconds);
        if (shape2 != null) {

          // We need to Typecast our graphics g into a 2D graphic
          Graphics g2D = (Graphics2D) g;
          // Each Shape needs a colour so we will set the colour before we make the shape.
          g2D.setColor(
              new Color((int) shape2.getRed(), (int) shape2.getGreen(), (int) shape2.getBlue()));

          // This will pick which shape to make.
          switch (shape2.getShapeType()) {
            case "Rectangle":
              g2D.fillRect((int) shape2.getStartX(), (int) shape2.getStartY(),
                  (int) shape2.getWidth(), (int) shape2.getHeight());
              break;
            case "Circle":
              g2D.fillOval((int) shape2.getStartX(), (int) shape2.getStartY(),
                  (int) shape2.getWidth(), (int) shape2.getHeight());
              break;
            case "Triangle":
              int x1 = (int) shape2.getStartX();
              int x2 = (int) (shape2.getStartX() + shape2.getWidth() / 2);
              int x3 = (int) (shape2.getStartX() + shape2.getWidth());
              int y1 = (int) (shape2.getStartY() + shape2.getHeight());
              int y2 = (int) shape2.getStartY();
              int y3 = (int) (shape2.getStartY() + shape2.getHeight());
              int[] xpoints = { x1, x2, x3 };
              int[] ypoints = { y1, y2, y3 };
              g2D.fillPolygon(xpoints, ypoints, 3);
              break;
            default:
            //No cases

          }

        }
      }
    }
    // Increments our Counter.
    this.seconds = this.seconds + 1;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    String action = e.getActionCommand();
    if (e.getSource() == timer) {
      repaint();
    }

    else if (action.equals("Pause")) {
      this.timer.stop();
    } else if (action.equals("Decrease Speed")) {
      this.speed = this.speed * 2;
      this.timer = new Timer(this.speed, this);
      this.timer.start();
    } else if (action.equals("Start")) {
      this.timer.start();
    } else if (action.equals("Increase Speed")) {
      this.speed = (int) (this.speed * 0.5);
      this.timer = new Timer((int) (this.speed * 0.5), this);
      this.timer.start();
    } else if (action.equals("Reset")) {

      this.timer = new Timer(this.speed, this);
      this.timer.restart();
      this.seconds = 1;
    }

  }

}
