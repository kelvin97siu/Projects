import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

/**
 * Junit Testing Suite for Animation.
 * 
 * @author kelvin97siu
 *
 */
public class AnimationTest {

  /**
   * Test move method.
   */
  @Test
  public void testMove() {
    String expected;
    String actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Rectangle rectangle = new Rectangle("rectangle", startTime, startX, startY, width, height,
          red, green, blue, endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "rectangle moves from (%.1f,%.1f) to (%.1f,%.1f) from time t=%.1f to t=%.1f", startX,
          startY, endX, endY, startTime, endTime);

      AnimationImpl animation = new AnimationImpl(rectangle);
      actual = animation.move(rectangle);
      assertEquals(expected, actual);
    }

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Oval oval = new Oval("oval", startTime, startX, startY, width, height, red, green, blue,
          endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "oval moves from (%.1f,%.1f) to (%.1f,%.1f) from time t=%.1f to t=%.1f", startX, startY,
          endX, endY, startTime, endTime);

      AnimationImpl animation = new AnimationImpl(oval);
      actual = animation.move(oval);
      assertEquals(expected, actual);
    }

  }

  /**
   * Test colour method.
   */
  @Test
  public void testColour() {
    String expected;
    String actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Rectangle rectangle = new Rectangle("rectangle", startTime, startX, startY, width, height,
          red, green, blue, endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "rectangle changes color from (%.1f,%.1f,%.1f) "
          + "to (%.1f,%.1f,%.1f) from time t=%.1f to t=%.1f",
          red, green, blue, endRed, endGreen, endBlue, startTime, endTime);

      AnimationImpl animation = new AnimationImpl(rectangle);
      actual = animation.colour(rectangle);
      assertEquals(expected, actual);
    }

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Oval oval = new Oval("oval", startTime, startX, startY, width, height, red, green, blue,
          endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "oval changes color from (%.1f,%.1f,%.1f) "
          + "to (%.1f,%.1f,%.1f) from time t=%.1f to t=%.1f",
          red, green, blue, endRed, endGreen, endBlue, startTime, endTime);

      AnimationImpl animation = new AnimationImpl(oval);
      actual = animation.colour(oval);
      assertEquals(expected, actual);
    }
  }

  /**
   * Test resize.
   */
  @Test
  public void testResize() {
    String expected;
    String actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Rectangle rectangle = new Rectangle("rectangle", startTime, startX, startY, width, height,
          red, green, blue, endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "rectangle scales from Width: %.1f, Height: %.1f to "
          + "Width: %.1f, Height:%.1f from time t=%.1f to t=%.1f\n",
          width, height, endWidth, endHeight, startTime, endTime);

      AnimationImpl animation = new AnimationImpl(rectangle);
      actual = animation.resize(rectangle);
      assertEquals(expected, actual);
    }

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Oval oval = new Oval("oval", startTime, startX, startY, width, height, red, green, blue,
          endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "oval scales from Width: %.1f, Height: %.1f to "
          + "Width: %.1f, Height:%.1f from time t=%.1f to t=%.1f\n",
          width, height, endWidth, endHeight, startTime, endTime);

      AnimationImpl animation = new AnimationImpl(oval);
      actual = animation.resize(oval);
      assertEquals(expected, actual);
    }
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    String expected;
    String actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;
    int sec = 1000;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      if (((width - endWidth) == 0) || (height - endHeight) == 0) {
        continue;
      }

      if ((endX - startX) == 0 || ((endY - startY) == 0)) {
        continue;
      }

      Rectangle rectangle = new Rectangle("rectangle", startTime, startX, startY, width, height,
          red, green, blue, endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "rectangle moves from (%.1f,%.1f) to (%.1f,%.1f) "
          + "from time t=%.1f to t=%.1f\n", startX,
          startY, endX, endY, startTime, endTime)
          + String.format(
              "rectangle changes color from (%.1f,%.1f,%.1f) "
              + "to (%.1f,%.1f,%.1f) from time t=%.1f to t=%.1f\n",
              red, green, blue, endRed, endGreen, endBlue, startTime, endTime)
          + String.format(
              "rectangle scales from Width: %.1f, Height: %.1f "
              + "to Width: %.1f, Height:%.1f from time t=%.1f to t=%.1f\n",
              width, height, endWidth, endHeight, startTime, endTime);

      AnimationImpl animation = new AnimationImpl(rectangle);
      actual = animation.toString();
      assertEquals(expected, actual);
    }

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      if (((width - endWidth) == 0) || (height - endHeight) == 0) {
        continue;
      }

      if ((endX - startX) == 0 || ((endY - startY) == 0)) {
        continue;
      }

      Oval oval = new Oval("oval", startTime, startX, startY, width, height, red, green, blue,
          endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "oval moves from (%.1f,%.1f) to (%.1f,%.1f) "
          + "from time t=%.1f to t=%.1f\n", startX, startY,
          endX, endY, startTime, endTime)
          + String.format(
              "oval changes color from (%.1f,%.1f,%.1f) "
              + "to (%.1f,%.1f,%.1f) from time t=%.1f to t=%.1f\n",
              red, green, blue, endRed, endGreen, endBlue, startTime, endTime)
          + String.format(
              "oval scales from Width: %.1f, Height: %.1f "
              + "to Width: %.1f, Height:%.1f from time t=%.1f to t=%.1f\n",
              width, height, endWidth, endHeight, startTime, endTime);

      AnimationImpl animation = new AnimationImpl(oval);
      actual = animation.toString();
      assertEquals(expected, actual);
    }
  }

  /**
   * Test svg move method.
   */
  @Test
  public void testSVGMove() {
    String expected;
    String actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;
    int sec = 1000;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = 100;
      double startY = 100;
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = 150;
      double endY = 150;
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Rectangle rectangle = new Rectangle("rectangle", startTime, startX, startY, width, height,
          red, green, blue, endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"x\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          startTime * sec, (endTime - startTime) * sec, startX, endX)
          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"y\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />",
              startTime * sec, (endTime - startTime) * sec, startY, endY);

      AnimationImpl animation = new AnimationImpl(rectangle);
      actual = animation.svgmove(rectangle);
      assertEquals(expected, actual);
    }

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = 100;
      double startY = 100;
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = 150;
      double endY = 150;
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Oval oval = new Oval("rectangle", startTime, startX, startY, width, height, red, green, blue,
          endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"cx\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          startTime * sec, (endTime - startTime) * sec, startX, endX)
          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"cy\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />",
              startTime * sec, (endTime - startTime) * sec, startY, endY);

      AnimationImpl animation = new AnimationImpl(oval);
      actual = animation.svgmove(oval);
      assertEquals(expected, actual);
    }
  }

  /**
   * Test svg color method.
   */
  @Test
  public void testSVGColour() {
    String expected;
    String actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;
    int sec = 1000;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Rectangle rectangle = new Rectangle("rectangle", startTime, startX, startY, width, height,
          red, green, blue, endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"fill\" from=\"rgb(%.1f,%.1f,%.1f)\" "
              + "to=\"rgb(%.1f,%.1f,%.1f)\" fill=\"freeze\" />",
          startTime * sec, (endTime - startTime) * sec, red, green, blue, endRed, endGreen,
          endBlue);

      AnimationImpl animation = new AnimationImpl(rectangle);
      actual = animation.svgcolour(rectangle);
      assertEquals(expected, actual);
    }

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      Oval oval = new Oval("oval", startTime, startX, startY, width, height, red, green, blue,
          endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"fill\" from=\"rgb(%.1f,%.1f,%.1f)\" "
              + "to=\"rgb(%.1f,%.1f,%.1f)\" fill=\"freeze\" />",
          startTime * sec, (endTime - startTime) * sec, red, green, blue, endRed, endGreen,
          endBlue);

      AnimationImpl animation = new AnimationImpl(oval);
      actual = animation.svgcolour(oval);
      assertEquals(expected, actual);
    }
  }

  /**
   * Test svg resize.
   */
  @Test
  public void testSVGResize() {
    String expected;
    String actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;
    int sec = 1000;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      if (((width - endWidth) == 0) || (height - endHeight) == 0) {
        continue;
      }

      Rectangle rectangle = new Rectangle("rectangle", startTime, startX, startY, width, height,
          red, green, blue, endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"width\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          startTime * sec, (endTime - startTime) * sec, width, endWidth) 
          
          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"height\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />",
              startTime * sec, (endTime - startTime) * sec, height, endHeight);

      AnimationImpl animation = new AnimationImpl(rectangle);
      actual = animation.svgresize(rectangle);
      assertEquals(expected, actual);
    }

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      if (((width - endWidth) == 0) || (height - endHeight) == 0) {
        continue;
      }

      Oval oval = new Oval("oval", startTime, startX, startY, width, height, red, green, blue,
          endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"rx\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          startTime * sec, (endTime - startTime) * sec, width, endWidth) 
          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"ry\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />",
              startTime * sec, (endTime - startTime) * sec, height, endHeight);

      AnimationImpl animation = new AnimationImpl(oval);
      actual = animation.svgresize(oval);
      assertEquals(expected, actual);
    }
  }

  /**
   * test svg string method.
   */
  @Test
  public void testSVGString() {
    String expected;
    String actual;

    Random rand = new Random(329);
    double start = 1;
    double end = 100;
    int sec = 1000;

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      if (((width - endWidth) == 0) || (height - endHeight) == 0) {
        continue;
      }

      if ((endX - startX) == 0 || ((endY - startY) == 0)) {
        continue;
      }

      Rectangle rectangle = new Rectangle("rectangle", startTime, startX, startY, width, height,
          red, green, blue, endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"x\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          startTime * sec, (endTime - startTime) * sec, startX, endX)
          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"y\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
              startTime * sec, (endTime - startTime) * sec, startY, endY)

          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\""
                  + "attributeName=\"fill\" from=\"rgb(%.1f,%.1f,%.1f)\" "
                  + "to=\"rgb(%.1f,%.1f,%.1f)\" "
                  + "fill=\"freeze\" />\n",
              startTime * sec, (endTime - startTime) * sec, red, green, blue, endRed, endGreen,
              endBlue)

          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"width\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
              startTime * sec, (endTime - startTime) * sec, width, endWidth)

          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"height\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />",
              startTime * sec, (endTime - startTime) * sec, height, endHeight);

      AnimationImpl animation = new AnimationImpl(rectangle);
      actual = animation.svgString();
      assertEquals(expected, actual);
    }

    // Random start and end time
    for (int i = 0; i < 5000; i++) {
      double startTime = 1 + (rand.nextDouble() * (1000 - 1));
      double startX = start + (rand.nextDouble() * (end - start));
      double startY = start + (rand.nextDouble() * (end - start));
      double width = start + (rand.nextDouble() * (end - start));
      double height = start + (rand.nextDouble() * (end - start));
      double red = (rand.nextDouble() * (255));
      double green = (rand.nextDouble() * (255));
      double blue = (rand.nextDouble() * (255));

      double endTime = 1 + (rand.nextDouble() * (1000 - 1));
      double endX = start + (rand.nextDouble() * (end - start));
      double endY = start + (rand.nextDouble() * (end - start));
      double endWidth = start + (rand.nextDouble() * (end - start));
      double endHeight = start + (rand.nextDouble() * (end - start));
      double endRed = (rand.nextDouble() * (255));
      double endGreen = (rand.nextDouble() * (255));
      double endBlue = (rand.nextDouble() * (255));

      if (endTime < startTime) {
        continue;
      }

      if (((width - endWidth) == 0) || (height - endHeight) == 0) {
        continue;
      }

      if ((endX - startX) == 0 || ((endY - startY) == 0)) {
        continue;
      }

      Oval oval = new Oval("oval", startTime, startX, startY, width, height, red, green, blue,
          endTime, endX, endY, endWidth, endHeight, endRed, endGreen, endBlue);

      expected = String.format(
          "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
              + "attributeName=\"cx\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
          startTime * sec, (endTime - startTime) * sec, startX, endX)
          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"cy\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
              startTime * sec, (endTime - startTime) * sec, startY, endY)

          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"fill\" from=\"rgb(%.1f,%.1f,%.1f)\" "
                  + "to=\"rgb(%.1f,%.1f,%.1f)\" "
                  + "fill=\"freeze\" />\n",
              startTime * sec, (endTime - startTime) * sec, red, green, blue, endRed, endGreen,
              endBlue)

          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"rx\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
              startTime * sec, (endTime - startTime) * sec, width, endWidth)

          + String.format(
              "<animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                  + "attributeName=\"ry\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />",
              startTime * sec, (endTime - startTime) * sec, height, endHeight);

      AnimationImpl animation = new AnimationImpl(oval);
      actual = animation.svgString();
      assertEquals(expected, actual);
    }
  }
}
