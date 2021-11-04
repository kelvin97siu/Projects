import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

/**
 * Junit Testing Suite for Shape.
 * 
 * @author kelvin97siu
 *
 */
public class ShapeTest {

  /**
   * Test getShapeType method.
   */
  @Test
  public void testGetShapeType() {
    String expected;
    String actual;

    Shape oval = new Oval("Oval", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);
    expected = "Oval";
    actual = oval.getShapeType();
    assertEquals(expected, actual);

    Shape rectangle = new Rectangle("Rectangle", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);
    expected = "Rectangle";
    actual = rectangle.getShapeType();
    assertEquals(expected, actual);

    Shape triangle = new Triangle("Triangle", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);
    expected = "Triangle";
    actual = triangle.getShapeType();
    assertEquals(expected, actual);

    Shape circle = new Circle("Circle", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);
    expected = "Circle";
    actual = circle.getShapeType();
    assertEquals(expected, actual);
  }

  /**
   * Test getTime and getEndTime methods for Ovals.
   */
  @Test
  public void testDurationOval() {
    double expected;
    double actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = start + (rand.nextDouble() * (end - start));
      double endTime = start + (rand.nextDouble() * (end - start));

      if (startTime > endTime) {
        continue;
      }

      Shape oval = new Oval("Oval", startTime, 0, 0, 1, 1, 0, 0, 0, endTime, 0, 0, 1, 1, 0, 0, 0);

      expected = startTime;
      actual = oval.getTime();
      assertEquals(expected, actual, 0.1);

      expected = endTime;
      actual = oval.getEndTime();
      assertEquals(expected, actual, 0.1);
    }

    // Start and end times that are equal
    for (int i = 0; i < 5000; i++) {
      double time = start + (rand.nextDouble() * (end - start));

      Shape oval = new Oval("Oval", time, 0, 0, 1, 1, 0, 0, 0, time, 0, 0, 1, 1, 0, 0, 0);

      expected = time;
      actual = oval.getTime();
      assertEquals(expected, actual, 0.1);

      expected = time;
      actual = oval.getEndTime();
      assertEquals(expected, actual, 0.1);
    }
  }

  /**
   * Test getTime and getEndTime methods for Rectangles.
   */
  @Test
  public void testDurationRectangle() {
    double expected;
    double actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = start + (rand.nextDouble() * (end - start));
      double endTime = start + (rand.nextDouble() * (end - start));

      if (startTime > endTime) {
        continue;
      }

      Shape rectangle = new Rectangle("Rectangle", startTime, 0, 0, 1, 1, 0, 0, 0, endTime, 0, 0, 1,
          1, 0, 0, 0);

      expected = startTime;
      actual = rectangle.getTime();
      assertEquals(expected, actual, 0.1);

      expected = endTime;
      actual = rectangle.getEndTime();
      assertEquals(expected, actual, 0.1);
    }

    // Start and end times that are equal
    for (int i = 0; i < 5000; i++) {
      double time = start + (rand.nextDouble() * (end - start));

      Shape rectangle = new Rectangle("Rectangle", time, 0, 0, 1, 1, 0, 0, 0, time, 0, 0, 1, 1, 0,
          0, 0);

      expected = time;
      actual = rectangle.getTime();
      assertEquals(expected, actual, 0.1);

      expected = time;
      actual = rectangle.getEndTime();
      assertEquals(expected, actual, 0.1);
    }
  }

  /**
   * Test invalid time.
   */
  @Test
  public void testInvalidDurationOval() {
    Shape oval;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;

    // Test negative values
    for (int i = 0; i < 5000; i++) {
      double startTime = start + (rand.nextDouble() * (end - start));
      double endTime = start + (rand.nextDouble() * (end - start));

      if (startTime >= endTime) {
        continue;
      }

      try {
        oval = new Oval("Oval", -startTime, 0, 0, 1, 1, 0, 0, 0, endTime, 0, 0, 1, 1, 0, 0, 0);
        fail("Valid start and end times");
      } catch (IllegalArgumentException e) {
        assertEquals("Start or End time cannot be less than 1", e.getMessage());
      }

      try {
        oval = new Oval("Oval", startTime, 0, 0, 1, 1, 0, 0, 0, -endTime, 0, 0, 1, 1, 0, 0, 0);
        fail("Valid start and end times");
      } catch (IllegalArgumentException e) {
        assertEquals("Start or End time cannot be less than 1", e.getMessage());
      }
    }

    // Test start time that are greater than the end time
    for (int i = 0; i < 5000; i++) {
      double startTime = start + (rand.nextDouble() * (end - start));
      double endTime = start + (rand.nextDouble() * (end - start));

      if (startTime < endTime) {
        continue;
      }

      try {
        oval = new Oval("Oval", startTime, 0, 0, 1, 1, 0, 0, 0, endTime, 0, 0, 1, 1, 0, 0, 0);
        fail("Valid start and end times");
      } catch (IllegalArgumentException e) {
        assertEquals("Invalid Start and End Time", e.getMessage());
      }
    }
  }

  /**
   * Test invalid time.
   */
  @Test
  public void testInvalidDurationRectangle() {
    Shape rectangle;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;

    // Test negative values
    for (int i = 0; i < 5000; i++) {
      double startTime = start + (rand.nextDouble() * (end - start));
      double endTime = start + (rand.nextDouble() * (end - start));

      if (startTime >= endTime) {
        continue;
      }

      try {
        rectangle = new Rectangle("rectangle", -startTime, 0, 0, 1, 1, 0, 0, 0, endTime, 0, 0, 1, 1,
            0, 0, 0);
        fail("Valid start and end times");
      } catch (IllegalArgumentException e) {
        assertEquals("Start or End time cannot be less than 1", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", startTime, 0, 0, 1, 1, 0, 0, 0, -endTime, 0, 0, 1, 1,
            0, 0, 0);
        fail("Valid start and end times");
      } catch (IllegalArgumentException e) {
        assertEquals("Start or End time cannot be less than 1", e.getMessage());
      }
    }

    // Test start time that are greater than the end time
    for (int i = 0; i < 5000; i++) {
      double startTime = start + (rand.nextDouble() * (end - start));
      double endTime = start + (rand.nextDouble() * (end - start));

      if (startTime < endTime) {
        continue;
      }

      try {
        rectangle = new Rectangle("rectangle", startTime, 0, 0, 1, 1, 0, 0, 0, endTime, 0, 0, 1, 1,
            0, 0, 0);
        fail("Valid start and end times");
      } catch (IllegalArgumentException e) {
        assertEquals("Invalid Start and End Time", e.getMessage());
      }
    }
  }

  /**
   * Test getX, getY, getxEnd and getyEnd methods for Oval Shape.
   */
  @Test
  public void testPositionGettersOval() {
    double expected;
    double actual;

    // 0 edge cases
    expected = 0;
    Shape oval = new Oval("Oval", 1, expected, expected, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);

    actual = oval.getStartX();
    assertEquals(expected, actual, 0.1);

    actual = oval.getStartY();
    assertEquals(expected, actual, 0.1);

    // Random positive and negative numbers for xStart and yStart
    Random rand = new Random(329);
    double start = 0;
    double end = 100;

    for (int i = 0; i < 1000; i++) {
      double xStart = start + (rand.nextDouble() * (end - start));
      double yStart = start + (rand.nextDouble() * (end - start));

      // Random positive numbers
      oval = new Oval("Oval", 1, xStart, yStart, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);

      expected = xStart;
      actual = oval.getStartX();
      assertEquals(expected, actual, 0.1);

      expected = yStart;
      actual = oval.getStartY();
      assertEquals(expected, actual, 0.1);

      // Random negative numbers
      oval = new Oval("Oval", 1, -xStart, -yStart, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);

      expected = -xStart;
      actual = oval.getStartX();
      assertEquals(expected, actual, 0.1);

      expected = -yStart;
      actual = oval.getStartY();
      assertEquals(expected, actual, 0.1);
    }

    // Random positive and negative numbers for xEnd and yEnd
    for (int i = 0; i < 1000; i++) {

      // Random positive numbers
      double xEnd = start + (rand.nextDouble() * (end - start));
      double yEnd = start + (rand.nextDouble() * (end - start));

      oval = new Oval("Oval", 1, 1, 1, 1, 1, 0, 0, 0, 2, xEnd, yEnd, 1, 1, 0, 0, 0);

      expected = xEnd;
      actual = oval.getEndX();
      assertEquals(expected, actual, 0.1);

      expected = yEnd;
      actual = oval.getEndY();
      assertEquals(expected, actual, 0.1);

      // Random negative numbers
      oval = new Oval("Oval", 1, 1, 1, 1, 1, 0, 0, 0, 2, -xEnd, -yEnd, 1, 1, 0, 0, 0);

      expected = -xEnd;
      actual = oval.getEndX();
      assertEquals(expected, actual, 0.1);

      expected = -yEnd;
      actual = oval.getEndY();
      assertEquals(expected, actual, 0.1);
    }
  }

  /**
   * Test getX, getY, getxEnd and getyEnd methods for Rectangle Shape.
   */
  @Test
  public void testPositionGettersRectangle() {
    double expected;
    double actual;

    // 0 edge cases
    expected = 0;
    Shape rectangle = new Rectangle("rectangle", 1, expected, expected, 1, 1, 0, 0, 0, 2, 0, 0, 1,
        1, 0, 0, 0);

    actual = rectangle.getStartX();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getStartY();
    assertEquals(expected, actual, 0.1);

    // Random positive and negative numbers for xStart and yStart
    Random rand = new Random(329);
    double start = 0;
    double end = 100;

    for (int i = 0; i < 1000; i++) {
      double xStart = start + (rand.nextDouble() * (end - start));
      double yStart = start + (rand.nextDouble() * (end - start));

      // Random positive numbers
      rectangle = new Rectangle("rectangle", 1, xStart, yStart, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0,
          0);

      expected = xStart;
      actual = rectangle.getStartX();
      assertEquals(expected, actual, 0.1);

      expected = yStart;
      actual = rectangle.getStartY();
      assertEquals(expected, actual, 0.1);

      // Random negative numbers
      rectangle = new Rectangle("rectangle", 1, -xStart, -yStart, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0,
          0, 0);

      expected = -xStart;
      actual = rectangle.getStartX();
      assertEquals(expected, actual, 0.1);

      expected = -yStart;
      actual = rectangle.getStartY();
      assertEquals(expected, actual, 0.1);
    }

    // Random positive and negative numbers for xEnd and yEnd
    for (int i = 0; i < 1000; i++) {

      // Random positive numbers
      double xEnd = start + (rand.nextDouble() * (end - start));
      double yEnd = start + (rand.nextDouble() * (end - start));

      rectangle = new Rectangle("rectangle", 1, 1, 1, 1, 1, 0, 0, 0, 2, xEnd, yEnd, 1, 1, 0, 0, 0);

      expected = xEnd;
      actual = rectangle.getEndX();
      assertEquals(expected, actual, 0.1);

      expected = yEnd;
      actual = rectangle.getEndY();
      assertEquals(expected, actual, 0.1);

      // Random negative numbers
      rectangle = new Rectangle("rectangle", 1, 1, 1, 1, 1, 0, 0, 0, 2, -xEnd, -yEnd, 1, 1, 0, 0,
          0);

      expected = -xEnd;
      actual = rectangle.getEndX();
      assertEquals(expected, actual, 0.1);

      expected = -yEnd;
      actual = rectangle.getEndY();
      assertEquals(expected, actual, 0.1);
    }
  }

  /**
   * Test getWidth, getHeight, getEndWidth, getEndHeight methods.
   */
  @Test
  public void testDimensionsGettersOval() {
    double expected;
    double actual;
    Shape oval;

    // Random positive numbers
    Random rand = new Random(329);
    double start = 1;
    double end = 100;

    for (int i = 0; i < 1000; i++) {
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));

      // Starting width and height
      oval = new Oval("Oval", 1, 0, 0, width, height, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);

      expected = width;
      actual = oval.getWidth();
      assertEquals(expected, actual, 0.1);

      expected = height;
      actual = oval.getHeight();
      assertEquals(expected, actual, 0.1);

      // Ending width and height
      oval = new Oval("Oval", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, width, height, 0, 0, 0);

      expected = width;
      actual = oval.getEndWidth();
      assertEquals(expected, actual, 0.1);

      expected = height;
      actual = oval.getEndHeight();
      assertEquals(expected, actual, 0.1);
    }
  }

  /**
   * Test getWidth, getHeight, getEndWidth, getEndHeight methods.
   */
  @Test
  public void testDimensionsGettersRectangle() {
    double expected;
    double actual;
    Shape rectangle;

    // Random positive numbers
    Random rand = new Random(329);
    double start = 1;
    double end = 100;

    for (int i = 0; i < 1000; i++) {
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));

      // Starting width and height
      rectangle = new Rectangle("Rectangle", 1, 0, 0, width, height, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0,
          0);

      expected = width;
      actual = rectangle.getWidth();
      assertEquals(expected, actual, 0.1);

      expected = height;
      actual = rectangle.getHeight();
      assertEquals(expected, actual, 0.1);

      // Ending width and height
      rectangle = new Rectangle("Rectangle", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, width, height, 0, 0,
          0);

      expected = width;
      actual = rectangle.getEndWidth();
      assertEquals(expected, actual, 0.1);

      expected = height;
      actual = rectangle.getEndHeight();
      assertEquals(expected, actual, 0.1);
    }
  }

  /**
   * Test invalid height and width for oval shape.
   */
  @Test
  public void testInvalidDimensionOval() {
    Shape oval;

    Random rand = new Random(329);
    double start = 0;
    double end = 1000;

    for (int i = 0; i < 1000; i++) {
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));

      // Negative width and heights
      try {
        oval = new Oval("Oval", 1, 0, 0, -width, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);
        fail("Valid width");
      } catch (IllegalArgumentException e) {
        assertEquals("Width or height cannot be zero or less than zero", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, -width, 1, 0, 0, 0);
        fail("Valid width");
      } catch (IllegalArgumentException e) {
        assertEquals("Width or height cannot be zero or less than zero", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, -height, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);
        fail("Valid height");
      } catch (IllegalArgumentException e) {
        assertEquals("Width or height cannot be zero or less than zero", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 1, -height, 0, 0, 0);
        fail("Valid height");
      } catch (IllegalArgumentException e) {
        assertEquals("Width or height cannot be zero or less than zero", e.getMessage());
      }
    }
  }

  /**
   * Test invalid height and width for rectangle shape.
   */
  @Test
  public void testInvalidDimensionRectangle() {
    Shape rectangle;

    Random rand = new Random(329);
    double start = 0;
    double end = 1000;

    for (int i = 0; i < 1000; i++) {
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));

      // Negative width and heights
      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, -width, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);
        fail("Valid width");
      } catch (IllegalArgumentException e) {
        assertEquals("Width or height cannot be zero or less than zero", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, -width, 1, 0, 0, 0);
        fail("Valid width");
      } catch (IllegalArgumentException e) {
        assertEquals("Width or height cannot be zero or less than zero", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, -height, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0,
            0);
        fail("Valid height");
      } catch (IllegalArgumentException e) {
        assertEquals("Width or height cannot be zero or less than zero", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 1, -height, 0, 0,
            0);
        fail("Valid height");
      } catch (IllegalArgumentException e) {
        assertEquals("Width or height cannot be zero or less than zero", e.getMessage());
      }
    }
  }

  /**
   * Test getRed, getGreen, getBlue, getEndRed, getEndGreen, and getEndBlue
   * methods.
   */
  @Test
  public void testColorGettersOval() {
    double expected;
    double actual;
    Shape oval;

    // Edge Case 0
    oval = new Oval("Oval", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);

    expected = 0;
    actual = oval.getRed();
    assertEquals(expected, actual, 0.1);

    actual = oval.getBlue();
    assertEquals(expected, actual, 0.1);

    actual = oval.getGreen();
    assertEquals(expected, actual, 0.1);

    actual = oval.getEndRed();
    assertEquals(expected, actual, 0.1);

    actual = oval.getEndBlue();
    assertEquals(expected, actual, 0.1);

    actual = oval.getEndGreen();
    assertEquals(expected, actual, 0.1);

    // Edge Case 255
    oval = new Oval("Oval", 1, 0, 0, 1, 1, 255, 255, 255, 2, 0, 0, 1, 1, 255, 255, 255);

    expected = 255;
    actual = oval.getRed();
    assertEquals(expected, actual, 0.1);

    actual = oval.getBlue();
    assertEquals(expected, actual, 0.1);

    actual = oval.getGreen();
    assertEquals(expected, actual, 0.1);

    actual = oval.getEndRed();
    assertEquals(expected, actual, 0.1);

    actual = oval.getEndBlue();
    assertEquals(expected, actual, 0.1);

    actual = oval.getEndGreen();
    assertEquals(expected, actual, 0.1);

    // Random positive numbers
    Random rand = new Random(329);
    double start = 0;
    double end = 255;

    for (int i = 0; i < 1000; i++) {
      double red = start + (rand.nextDouble() * (end - start));
      double blue = start + (rand.nextDouble() * (end - start));
      double green = start + (rand.nextDouble() * (end - start));

      oval = new Oval("Oval", 1, 0, 0, 1, 1, red, green, blue, 2, 0, 0, 1, 1, red, green, blue);

      // Start and end red
      expected = red;
      actual = oval.getRed();
      assertEquals(expected, actual, 0.1);

      actual = oval.getEndRed();
      assertEquals(expected, actual, 0.1);

      // Start and end blue
      expected = blue;
      actual = oval.getBlue();
      assertEquals(expected, actual, 0.1);

      actual = oval.getEndBlue();
      assertEquals(expected, actual, 0.1);

      // Start and end green
      expected = green;
      actual = oval.getGreen();
      assertEquals(expected, actual, 0.1);

      actual = oval.getEndGreen();
      assertEquals(expected, actual, 0.1);
    }
  }

  /**
   * Test getRed, getGreen, getBlue, getEndRed, getEndGreen, and getEndBlue
   * methods.
   */
  @Test
  public void testColorGettersRectangle() {
    double expected;
    double actual;
    Shape rectangle;

    // Edge Case 0
    rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0);

    expected = 0;
    actual = rectangle.getRed();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getBlue();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getGreen();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getEndRed();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getEndBlue();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getEndGreen();
    assertEquals(expected, actual, 0.1);

    // Edge Case 255
    rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, 255, 255, 255, 2, 0, 0, 1, 1, 255, 255,
        255);

    expected = 255;
    actual = rectangle.getRed();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getBlue();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getGreen();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getEndRed();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getEndBlue();
    assertEquals(expected, actual, 0.1);

    actual = rectangle.getEndGreen();
    assertEquals(expected, actual, 0.1);

    // Random positive numbers
    Random rand = new Random(329);
    double start = 0;
    double end = 255;

    for (int i = 0; i < 1000; i++) {
      double red = start + (rand.nextDouble() * (end - start));
      double blue = start + (rand.nextDouble() * (end - start));
      double green = start + (rand.nextDouble() * (end - start));

      rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, green, blue, 2, 0, 0, 1, 1, red,
          green, blue);

      // Start and end red
      expected = red;
      actual = rectangle.getRed();
      assertEquals(expected, actual, 0.1);

      actual = rectangle.getEndRed();
      assertEquals(expected, actual, 0.1);

      // Start and end blue
      expected = blue;
      actual = rectangle.getBlue();
      assertEquals(expected, actual, 0.1);

      actual = rectangle.getEndBlue();
      assertEquals(expected, actual, 0.1);

      // Start and end green
      expected = green;
      actual = rectangle.getGreen();
      assertEquals(expected, actual, 0.1);

      actual = rectangle.getEndGreen();
      assertEquals(expected, actual, 0.1);
    }
  }

  /**
   * Test invalid RBG color.
   */
  @Test
  public void testInvalidColorOval() {
    Shape oval;

    Random rand = new Random(329);
    double start = 0;
    double end = 255;

    // Negative numbers
    for (int i = 0; i < 1000; i++) {
      double red = start + (rand.nextDouble() * (end - start));
      double blue = start + (rand.nextDouble() * (end - start));
      double green = start + (rand.nextDouble() * (end - start));

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, -red, blue, green, 2, 0, 0, 1, 1, red, blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, -blue, green, 2, 0, 0, 1, 1, red, blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, blue, -green, 2, 0, 0, 1, 1, red, blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, -red, blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, red, -blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, red, blue, -green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }
    }

    // Numbers greater than 255
    start = 0;
    end = 256;
    for (int i = 0; i < 1000; i++) {
      double red = start + (rand.nextDouble() * (end - start));
      double blue = start + (rand.nextDouble() * (end - start));
      double green = start + (rand.nextDouble() * (end - start));

      double redI = 300 + (rand.nextDouble() * (300 - 256));
      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, redI, blue, green, 2, 0, 0, 1, 1, red, blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, redI, blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      double blueI = 300 + (rand.nextDouble() * (300 - 256));
      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, blueI, green, 2, 0, 0, 1, 1, red, blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, red, blueI, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      double greenI = 300 + (rand.nextDouble() * (300 - 256));
      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, blue, greenI, 2, 0, 0, 1, 1, red, blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        oval = new Oval("Oval", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, red, blue, greenI);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }
    }
  }

  /**
   * Test invalid RBG color.
   */
  @Test
  public void testInvalidColorRectangle() {
    Shape rectangle;

    Random rand = new Random(329);
    double start = 0;
    double end = 255;

    // Negative numbers
    for (int i = 0; i < 1000; i++) {
      double red = start + (rand.nextDouble() * (end - start));
      double blue = start + (rand.nextDouble() * (end - start));
      double green = start + (rand.nextDouble() * (end - start));

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, -red, blue, green, 2, 0, 0, 1, 1, red,
            blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, -blue, green, 2, 0, 0, 1, 1, red,
            blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, blue, -green, 2, 0, 0, 1, 1, red,
            blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, -red,
            blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, red,
            -blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, red,
            blue, -green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }
    }

    // Numbers greater than 255
    start = 0;
    end = 256;
    for (int i = 0; i < 1000; i++) {
      double red = start + (rand.nextDouble() * (end - start));
      double blue = start + (rand.nextDouble() * (end - start));
      double green = start + (rand.nextDouble() * (end - start));

      double redI = 300 + (rand.nextDouble() * (300 - 256));
      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, redI, blue, green, 2, 0, 0, 1, 1, red,
            blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, redI,
            blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      double blueI = 300 + (rand.nextDouble() * (300 - 256));
      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, blueI, green, 2, 0, 0, 1, 1, red,
            blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, red,
            blueI, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      double greenI = 300 + (rand.nextDouble() * (300 - 256));
      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, blue, greenI, 2, 0, 0, 1, 1, red,
            blue, green);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }

      try {
        rectangle = new Rectangle("rectangle", 1, 0, 0, 1, 1, red, blue, green, 2, 0, 0, 1, 1, red,
            blue, greenI);
        fail("Valid color input");

      } catch (IllegalArgumentException e) {
        assertEquals("Colours cannot be less than zero or greater than 255", e.getMessage());
      }
    }
  }
}
