package ActivityTracker.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is the records model
 */
@ApiModel(description = "This is the records model")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T01:21:42.638116-04:00[America/Toronto]")

public class Record   {
  @JsonProperty("date")
  private String date;

  @JsonProperty("calorieIdle")
  private Integer calorieIdle;

  @JsonProperty("lastupdated")
  private String lastupdated;

  public Record date(String date) {
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

  public Record calorieIdle(Integer calorieIdle) {
    this.calorieIdle = calorieIdle;
    return this;
  }

  /**
   * Get calorieIdle
   * @return calorieIdle
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getCalorieIdle() {
    return calorieIdle;
  }

  public void setCalorieIdle(Integer calorieIdle) {
    this.calorieIdle = calorieIdle;
  }

  public Record lastupdated(String lastupdated) {
    this.lastupdated = lastupdated;
    return this;
  }

  /**
   * Get lastupdated
   * @return lastupdated
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


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
    Record record = (Record) o;
    return Objects.equals(this.date, record.date) &&
        Objects.equals(this.calorieIdle, record.calorieIdle) &&
        Objects.equals(this.lastupdated, record.lastupdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, calorieIdle, lastupdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Record {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    calorieIdle: ").append(toIndentedString(calorieIdle)).append("\n");
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

