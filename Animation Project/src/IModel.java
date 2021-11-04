import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Model interface.
 * @author kelvin97siu
 *
 */
public interface IModel {
  
  /**
   * Adds shape to priority queue.
   * @param shape object.
   */
  public void add(Shape shape);
  
  /**
   * Get tree set.
   * @return tree set.
   */
  public Map<String, List<Shape>> getHash();
  
  /**
   * Get the priority queue.
   * @return the priority queue.
   */
  public PriorityQueue<Shape> getPQ();
  
  /**
   * Get the array list.
   * @return the array list.
   */
  public ArrayList<String> getAL();
  
  /**
   * Get the canvas.
   * @return the canvas.
   */
  public Canvas getCanvas();
  
  /**
   * Iterates priority queue. 
   * @return shape.
   */
  public Iterator<Shape> iterator();
  
  /**
   * Sets the canvas dimensions.
   * @param x the x coordinate of the canvas.
   * @param y the y coordinate of the canvas.
   * @param width the width of the canvas.
   * @param height the height of the canvas.
   */
  public void setCanvas(int x, int y, int width, int height);
  
  /**
   * Adds to the array list.
   * @param name the name of the shape.
   */
  public void addAL(String name);
}
