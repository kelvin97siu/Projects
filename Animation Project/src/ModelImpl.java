import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Model implementation.
 * @author kelvin97siu
 *
 */
public class ModelImpl implements Iterable<Shape>, IModel {
  private PriorityQueue<Shape> pQueue;
  private SortedMap<String, List<Shape>> hashmap;
  private ArrayList<String> namelst;
  private Canvas canvas;

  /**
   * Constructs model implementation object.
   */
  public ModelImpl() {
    this.pQueue = new PriorityQueue<Shape>(1, new ShapeComparator());
    this.hashmap = new TreeMap<String, List<Shape>>();
    this.namelst = new ArrayList<String>();
  }
  
  @Override
  public void add(Shape shape) throws IllegalArgumentException {
    if (!this.hashmap.containsKey(shape.getStringName())) {
      this.hashmap.put(shape.getStringName(), new ArrayList<Shape>());
      this.hashmap.get(shape.getStringName()).add(shape);
      pQueue.add(shape);
    }

    else if (checkTime(this.hashmap.get(shape.getStringName()), shape)) {
      pQueue.add(shape);
      this.hashmap.get(shape.getStringName()).add(shape);
    }

    else {
      throw new IllegalArgumentException(
          "Unable to add element since the item exists in this timeframe");
    }
  }

  private boolean checkTime(List<Shape> list, Shape shape) {
    for (Shape eachshape : list) {
      if (shape.getTime() > eachshape.getTime() && shape.getTime() < eachshape.getEndTime()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public Iterator<Shape> iterator() {
    return new ModelImplIterator(this.pQueue);
  }

  @Override
  public Map<String, List<Shape>> getHash() {
    return this.hashmap;
  }

  @Override
  public PriorityQueue<Shape> getPQ() {
    return this.pQueue;
  }

  @Override
  public Canvas getCanvas() {
    return this.canvas;
  }

  @Override
  public void setCanvas(int x, int y, int width, int height) {
    this.canvas = new Canvas(x, y, width, height);
  }

  @Override
  public ArrayList<String> getAL() {
    return this.namelst;
  }

  @Override
  public void addAL(String name) {
    this.namelst.add(name);
  }

  /**
   * Iterator for priority queue.
   * @author kelvin97siu
   *
   */
  private class ModelImplIterator implements Iterator<Shape> {
    private PriorityQueue<Shape> pQueue;

    private ModelImplIterator(PriorityQueue<Shape> pQueue) {
      this.pQueue = pQueue;
    }

    @Override
    public boolean hasNext() {
      return (pQueue.peek() != null);
    }

    @Override
    public Shape next() {
      if (pQueue.peek() != null) {
        return pQueue.poll();
      }
      return null;
    }
  }
}
