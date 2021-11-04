
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * This adapter interface is used to convert an Imodel interface into a
 * AdapterModle interface so we can pass data Structures to the views.
 * 
 * @author alann
 *
 */

public interface AdapterModel {

  /**
   * This is used to get a clone of the Priority Queue from the model.
   * 
   * @return the priority queue.
   */
  public PriorityQueue<Shape> clonePriorityQueue();

  /**
   * This is used to get SortMap clone from the model.
   * 
   * @return the tree map.
   */
  public Map<String, List<Shape>> cloneTreeMap();

  /**
   * This is used to get a clone of the Canvas from the model.
   * 
   * @return the clone version of canvas.
   */
  public Canvas cloneCanvas();

  /**
   * This is used to get a clone of the Canvas form the model.
   * 
   * @return the array list.
   */
  public ArrayList<String> cloneArray();

}
