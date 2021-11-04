/**
 * This class is used at the backend support to set the parameters and
 * limitations on what a canvas can or cannot be.
 * 
 * @author alann
 *
 */

public class Canvas {
  private int cx;
  private int cy;
  private int cwidth;
  private int cheight;

  /**
   * Contructs canvas object.
   * 
   * @param cx      x coordinate of the canvas.
   * @param cy      y coordinate of the canvas.
   * @param cwidth  width of the canvas.
   * @param cheight height of the canvas.
   */
  public Canvas(int cx, int cy, int cwidth, int cheight) {

    this.cx = cx;
    this.cy = cy;
    this.cwidth = cwidth;
    this.cheight = cheight;
  }

  /**
   * Returns the x Coordinate of the Canvas.
   * 
   * @return an int value
   */
  public int getCanvasX() {
    return this.cx;
  }

  /**
   * Get the Y Coordinate of the Canvas.
   * 
   * @return an int value
   */
  public int getCanvasY() {
    return this.cy;
  }

  /**
   * Get the Width value of the Canvas.
   * 
   * @return an int vlaue
   */
  public int getCanvasW() {
    return this.cwidth;
  }

  /**
   * Get the Height Value of the Canvas.
   * 
   * @return an int value
   */
  public int getCanvasH() {
    return this.cheight;
  }
}
