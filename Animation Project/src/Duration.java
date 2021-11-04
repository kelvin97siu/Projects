/**
 * This sets the time duration to be positive only.
 * 
 * @author alann
 *
 */

public class Duration {
  private double startTime;
  private double endTime;

  /**
   * Time has to be 1 and start has to be less than end time.
   * 
   * @param start double.
   * @param end   double.
   * @throws IllegalArgumentException when end < start time.
   */
  public Duration(double start, double end) throws IllegalArgumentException {
    if ((start < 1) || (end < 1)) {
      throw new IllegalArgumentException("Start or End time cannot be less than 1");
    }

    if (end < start) {
      throw new IllegalArgumentException("Invalid Start and End Time");
    }

    this.startTime = start;
    this.endTime = end;
  }

  /**
   * Return start time.
   * 
   * @return double start time.
   */
  public double getStartTime() {
    return this.startTime;
  }

  /**
   * Return End Time.
   * 
   * @return double end time.
   */
  public double getEndTime() {
    return this.endTime;
  }

}
