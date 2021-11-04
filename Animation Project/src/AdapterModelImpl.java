import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * This Adaptermodel class is the implementation of the AdapterModel interface.
 * It will clone the data structures from the modelImpl class.
 * 
 * @author alann
 *
 */

public class AdapterModelImpl implements AdapterModel {

  IModel model;

  public AdapterModelImpl(IModel model) {
    this.model = model;
  }

  @Override
  public PriorityQueue<Shape> clonePriorityQueue() {
    PriorityQueue<Shape> arrayCopy = this.model.getPQ();
    return arrayCopy;
  }

  @Override
  public Map<String, List<Shape>> cloneTreeMap() {
    Map<String, List<Shape>> mapCopy = this.model.getHash();
    return mapCopy;
  }

  @Override
  public Canvas cloneCanvas() {
    Canvas copyCanvas = this.model.getCanvas();
    return copyCanvas;
  }

  @Override
  public ArrayList<String> cloneArray() {
    ArrayList<String> copyArray = this.model.getAL();
    return copyArray;
  }

}
