package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ErrorErrorDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-13T18:43:45.652Z")

public class ErrorErrorDetails   {
  @JsonProperty("errorNumber")
  private Integer errorNumber = null;

  @JsonProperty("errorField")
  private String errorField = null;

  @JsonProperty("errorDetailsDescription")
  private String errorDetailsDescription = null;

  public ErrorErrorDetails errorNumber(Integer errorNumber) {
    this.errorNumber = errorNumber;
    return this;
  }

  /**
   * Get errorNumber
   * @return errorNumber
  **/
  @ApiModelProperty(value = "")


  public Integer getErrorNumber() {
    return errorNumber;
  }

  public void setErrorNumber(Integer errorNumber) {
    this.errorNumber = errorNumber;
  }

  public ErrorErrorDetails errorField(String errorField) {
    this.errorField = errorField;
    return this;
  }

  /**
   * Error cause. Not yet implemented.
   * @return errorField
  **/
  @ApiModelProperty(example = "accountNumber", value = "Error cause. Not yet implemented.")


  public String getErrorField() {
    return errorField;
  }

  public void setErrorField(String errorField) {
    this.errorField = errorField;
  }

  public ErrorErrorDetails errorDetailsDescription(String errorDetailsDescription) {
    this.errorDetailsDescription = errorDetailsDescription;
    return this;
  }

  /**
   * Error cause. Not yet implemented.
   * @return errorDetailsDescription
  **/
  @ApiModelProperty(example = "accountNumber must be digits only", value = "Error cause. Not yet implemented.")


  public String getErrorDetailsDescription() {
    return errorDetailsDescription;
  }

  public void setErrorDetailsDescription(String errorDetailsDescription) {
    this.errorDetailsDescription = errorDetailsDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorErrorDetails errorErrorDetails = (ErrorErrorDetails) o;
    return Objects.equals(this.errorNumber, errorErrorDetails.errorNumber) &&
        Objects.equals(this.errorField, errorErrorDetails.errorField) &&
        Objects.equals(this.errorDetailsDescription, errorErrorDetails.errorDetailsDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorNumber, errorField, errorDetailsDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorErrorDetails {\n");
    
    sb.append("    errorNumber: ").append(toIndentedString(errorNumber)).append("\n");
    sb.append("    errorField: ").append(toIndentedString(errorField)).append("\n");
    sb.append("    errorDetailsDescription: ").append(toIndentedString(errorDetailsDescription)).append("\n");
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

