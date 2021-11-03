package ActivityTracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * This is the segment types model
 */
@ApiModel(description = "This is the segment types model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T01:21:42.638116-04:00[America/Toronto]")

public class SegmentTypes   {
  @JsonProperty("date")
  private String date;

  @JsonProperty("type")
  private String type;

  @JsonProperty("startTime")
  private String startTime;

  @JsonProperty("endTime")
  private String endTime;

  @JsonProperty("lastupdated")
  private String lastupdated;

  public SegmentTypes date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public SegmentTypes type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public SegmentTypes startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public SegmentTypes endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public SegmentTypes lastupdated(String lastupdated) {
    this.lastupdated = lastupdated;
    return this;
  }

  /**
   * Get lastupdated
   * @return lastupdated
  */
  @ApiModelProperty(value = "")


  public String getLastupdated() {
    return lastupdated;
  }

  public void setLastupdated(String lastupdated) {
    this.lastupdated = lastupdated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SegmentTypes segmentTypes = (SegmentTypes) o;
    return Objects.equals(this.date, segmentTypes.date) &&
        Objects.equals(this.type, segmentTypes.type) &&
        Objects.equals(this.startTime, segmentTypes.startTime) &&
        Objects.equals(this.endTime, segmentTypes.endTime) &&
        Objects.equals(this.lastupdated, segmentTypes.lastupdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, type, startTime, endTime, lastupdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SegmentTypes {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    lastupdated: ").append(toIndentedString(lastupdated)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

