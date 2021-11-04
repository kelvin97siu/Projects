import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This is used to test our Controller Input.
 * 
 * @author alann
 *
 */
public class InputControllerTest {

  // Setup Correct Value
  String[] args = { "-view", "svg", "-out", "out.svg", "-in", "buildings.txt" };
  String[] args2 = { "-in", "smalldemo.txt", "-view", "text", "-speed", "2" };
  String[] args3 = { "-in", "smalldemo.txt", "-view", "text" };
  String[] args4 = { "-in", "smalldemo.txt", "-speed", "50", "-view", "visual" };

  // Bad inputs
  // Bad View
  String[] args6 = { "-view", "svgert", "-out", "out.svg", "-in", "buildings.txt" };
  // Bad textfile
  String[] args7 = { "-in", "smalldemo", "-view", "text", "-speed", "2" };
  // Bad out
  String[] args8 = { "-view", "svg", "-out", "out.svgvevev", "-in", "buildings.txt" };
  // Bad speed
  String[] args9 = { "-in", "smalldemo.txt", "-view", "text", "-speed", "-2" };

  InputController controller;

  /**
   * TestView of our input controller.
   */
  @Test
  public void testView() {
    controller = new InputController(args);
    String actual = controller.getView();
    assertEquals("svg", actual);

    controller = new InputController(args2);
    String actual2 = controller.getView();
    assertEquals("text", actual2);

    controller = new InputController(args3);
    String actual3 = controller.getView();
    assertEquals("text", actual3);

    controller = new InputController(args4);
    String actual4 = controller.getView();
    assertEquals("visual", actual4);

  }

  /**
   * Test to see when CL input Fails.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFailView() {
    controller = new InputController(args6);
    controller.getView();
    // String actual = controller.view();

  }

  /**
   * Test to see if we get correct TextFile name.
   */
  @Test
  public void testTextFileName() {
    controller = new InputController(args);
    String actual = controller.getTextFileName();
    assertEquals("buildings.txt", actual);

    controller = new InputController(args2);
    String actual2 = controller.getTextFileName();
    assertEquals("smalldemo.txt", actual2);

    controller = new InputController(args3);
    String actual3 = controller.getTextFileName();
    assertEquals("smalldemo.txt", actual3);

    controller = new InputController(args4);
    String actual4 = controller.getTextFileName();
    assertEquals("smalldemo.txt", actual4);

  }

  /**
   * Test to see if we can get an IOException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFailFileName() {
    controller = new InputController(args7);
    controller.getTextFileName();

  }

  /**
   * Test to see if we can get the correct output.
   */
  @Test
  public void testOut() {
    controller = new InputController(args);
    String actual = controller.getOut();
    assertEquals("out.svg", actual);

    controller = new InputController(args2);
    String actual2 = controller.getOut();
    assertEquals("system.out", actual2);

    controller = new InputController(args3);
    String actual3 = controller.getOut();
    assertEquals("system.out", actual3);

    controller = new InputController(args4);
    String actual4 = controller.getOut();
    assertEquals("system.out", actual4);

  }

  /**
   * Test to see if the output will fail.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFailOut() {
    controller = new InputController(args8);
    controller.getOut();

  }

  /**
   * Test to see if the speed will be the correct int.
   */
  @Test
  public void testSpeed() {
    controller = new InputController(args);
    int actual = controller.getSpeed();
    assertEquals(1, actual);

    controller = new InputController(args2);
    int actual2 = controller.getSpeed();
    assertEquals(2, actual2);

    controller = new InputController(args3);
    int actual3 = controller.getSpeed();
    assertEquals(1, actual3);

    controller = new InputController(args4);
    int actual4 = controller.getSpeed();
    assertEquals(50, actual4);

  }

  /**
   * Make sure int is positive.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFailSpeed() {
    controller = new InputController(args9);
    controller.getSpeed();

  }

}
