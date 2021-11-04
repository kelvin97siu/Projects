import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This in our main Class. It is used to initialize our whole program.
 * 
 * @author alann
 *
 */
public class Main {

  /**
   * Will force our program to start. It will move the model and InputController
   * into the Controller. Then it will call a Controller method to output a view.
   * 
   * @param args from CL
   * @throws IOException if File Error Occurs
   */
  public static void main(String[] args) throws IOException {

    InputController inputcontrol = new InputController(args);

    File file = new File(inputcontrol.getTextFileName());
    InputStream in = new FileInputStream(file);
    IModel model1 = AnimationReader.parseFile(new InputStreamReader(in), new ModelBuilder());
    Controller control = new Controller(model1, inputcontrol);
    control.chooseView();

  }

}
