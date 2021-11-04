import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import javax.swing.plaf.ColorUIResource;

/**
 * This class is used to control the input form the user. This class will be
 * passed to the Controller.
 * 
 * @author alann
 *
 */
public class InputController {

  String[] args;
  String in;
  String view;
  String out;
  String speed;
  JFrame frame = new JFrame();
  UIManager frameColour = new UIManager();

  /**
   * This class loops the arguments passed by the user and only sets them to
   * fields of the class if they meet the requirements oultined in the swithc
   * statement below.
   * 
   * @param args from CL
   */
  public InputController(String[] args) {
    this.args = args;
    this.speed = "1";
    this.out = "system.out";
    frameColour.put("OptionPane.background", new ColorUIResource(102, 255, 255));
    frameColour.put("Panel.background", new ColorUIResource(102, 255, 255));

    try {
      for (int i = 0; i < this.args.length; i += 2) {

        switch (args[i].toLowerCase().strip()) {

          case "-in":
            this.in = args[i + 1];

            try {
              BufferedReader file = new BufferedReader(new FileReader(this.in));
              file.close();
              break;
            } catch (IOException b) {

              JOptionPane.showMessageDialog(frame,
                  "file does not exist or the file name was misspelled", "FileRead Error",
                  JOptionPane.ERROR_MESSAGE);
              break;
            }

          case "-view":
            this.view = args[i + 1];

            if (this.view.equals("text") || this.view.equals("svg") || this.view.equals("visual")) {
              break;
            } else {
              JOptionPane.showMessageDialog(frame,
                  "Please enter a correct view. Options are:\ntext\nsvg\nvisual", "View Error",
                  JOptionPane.ERROR_MESSAGE);
              throw new IllegalArgumentException("Error");

            }
          case "-out":
            this.out = args[i + 1];
            if (this.out.equals("out.svg") || this.out.equals("system.out")
                || this.out.equals("out.system")) {
              break;

            } else {
              JOptionPane.showMessageDialog(frame,
                  "Please enter a correct out. Options are:\nout.system\nout.svg", "Out Error",
                  JOptionPane.ERROR_MESSAGE);
              throw new IllegalArgumentException("Error");
            }

          case "-speed":
            this.speed = args[i + 1];
            if (Integer.parseInt(this.speed) < 0) {
              JOptionPane.showMessageDialog(frame, "Please enter a number greater than zero",
                  "Speed Error", JOptionPane.ERROR_MESSAGE);
              throw new IllegalArgumentException("Please enter a number gretaer than zero");
            }
            break;
          default:
             //No cases
        }
      }
    } catch (ArrayIndexOutOfBoundsException a) {

      System.out.println("need an additional Argument at the end of the command lind input");
    }

  }

  /**
   * Return the input String from CL.
   * 
   * @return String
   */
  public String getTextFileName() {

    return this.in;
  }

  /**
   * Return the out version from CL.
   * 
   * @return String
   */
  public String getOut() {

    return this.out;
  }

  /**
   * Return the view from the CL.
   * 
   * @return String
   */
  public String getView() {

    return this.view;
  }

  /**
   * Return the speed from the CL.
   * 
   * @return int
   */
  public int getSpeed() {
    int speed = Integer.parseInt(this.speed);
    return speed;
  }

}
