import java.util.HashMap;
import java.util.Map;

/**
 * Class reads file and converts info from file into a ModelImpl.
 * 
 * @author kelvin97siu
 *
 */
public class ModelBuilder implements AnimationBuilder<IModel> {
  private ModelImpl model = new ModelImpl();
  private Map<String, String> hashmap = new HashMap<String, String>();

  @Override
  public IModel build() {
    return this.model;
  }

  @Override
  public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
    model.setCanvas(x, y, width, height);
    return this;
  }

  @Override
  public AnimationBuilder<IModel> declareShape(String name, String type) {
    this.hashmap.put(name, type.toLowerCase());
    this.model.addAL(name);
    return this;
  }

  @Override
  public AnimationBuilder<IModel> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
      int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {

    if ((this.hashmap.get(name).equals("rectangle"))) {
      Shape rectangle = new Rectangle(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2,
          g2, b2);
      this.model.add(rectangle);
    } else if ((this.hashmap.get(name).equals("ellipse"))) {
      Shape oval = new Oval(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
      this.model.add(oval);
    } else if ((this.hashmap.get(name).equals("triangle"))) {
      Shape triangle = new Triangle(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2,
          g2, b2);
      this.model.add(triangle);
    }
    return this;
  }

}
