
import java.io.IOException;

/**
 * This is our Controller Class is it used to moderate and control our program.
 * It will convert a Imodel class into an AdapterClass so we can pass inputs
 * into the Controller.
 * 
 * @author alann
 *
 */

public class Controller {

  AdapterModel model;
  InputController controller;

  /**
   * Initialize our Model Constructor.
   * 
   * @param model      IModel
   * @param controller InputController
   */
  public Controller(IModel model, InputController controller) {
    this.model = new AdapterModelImpl(model);
    this.controller = controller;

  }

  /**
   * This class uses a switch statement to choose which view to implement based on
   * the CL user input.
   * 
   * @return string output of chosen view.
   * @throws IOException file not found.
   */
  public String chooseView() throws IOException {
    String output = "";

    try {
      if (this.controller.getView().equals("text")) {
        TextView view = new TextView(this.model.cloneTreeMap(), this.controller.out,
            this.model.clonePriorityQueue());
        output = view.displayView();
        System.out.print(output);
      } else if (this.controller.getView().equals("svg")) {
        SVGView view = new SVGView(this.model.cloneTreeMap(), controller.getSpeed(),
            this.model.cloneCanvas(), this.model.cloneArray());

        view.createSVGFile("sd2.svg", view.displayView());
      } else if (this.controller.getView().equals("visual")) {

        AnimationView view = new AnimationView(this.model.clonePriorityQueue(),
            controller.getSpeed(), this.model.cloneCanvas());
        view.displayView();
      }

    } catch (IllegalArgumentException a) {
      throw new IllegalArgumentException("None of the input from the Controller is valid");
    }
    return output;
  }
}
