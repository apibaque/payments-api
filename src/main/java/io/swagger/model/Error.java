package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ErrorErrorDetails;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The HTTP status code (&#x60;&#x60;&#x60;httpStatus&#x60;&#x60;&#x60;) is the main classifier. A DNB-specific &#x60;&#x60;&#x60;errorNumber&#x60;&#x60;&#x60;is also provided as a lookup reference.   The &#x60;&#x60;&#x60;errorDocumentation&#x60;&#x60;&#x60; is a URI to further information about the endpoint, with uesful infomration about correct usage.  The &#x60;&#x60;&#x60;errorDetails&#x60;&#x60;&#x60;is specific information about the one or more errors that have occurred.  **Note:** We strive to offer the best possible information about all errors. This depends on the information offered by the backend systems, and in some cases there is limited information available from the underlying solutions. In these cases, the errors may contain empty fields, and/or information that is difficult to interpret.  Example &#x60;&#x60;&#x60;error&#x60;&#x60;&#x60; (TODO: Work in progress: May need an update): &#x60;&#x60;&#x60; {   \&quot;errorDocumentation\&quot;: \&quot;https://developer.dnb.no/something-useful-goes-here/\&quot;,   \&quot;errorDetails\&quot;: [     {       \&quot;errorNumber\&quot;: \&quot;123450\&quot;,       \&quot;errorField\&quot;: \&quot;accountNumber\&quot;,       \&quot;errorDescription\&quot;: \&quot;accountNumber must be digits only\&quot;     },     {       \&quot;errorNumber\&quot;: \&quot;123451\&quot;,       \&quot;errorField\&quot;: \&quot;dateFrom\&quot;,       \&quot;errorDescription\&quot;: \&quot;dateFrom must be in ISO8601 date format\&quot;     }   ] } &#x60;&#x60;&#x60;
 */
@ApiModel(description = "The HTTP status code (```httpStatus```) is the main classifier. A DNB-specific ```errorNumber```is also provided as a lookup reference.   The ```errorDocumentation``` is a URI to further information about the endpoint, with uesful infomration about correct usage.  The ```errorDetails```is specific information about the one or more errors that have occurred.  **Note:** We strive to offer the best possible information about all errors. This depends on the information offered by the backend systems, and in some cases there is limited information available from the underlying solutions. In these cases, the errors may contain empty fields, and/or information that is difficult to interpret.  Example ```error``` (TODO: Work in progress: May need an update): ``` {   \"errorDocumentation\": \"https://developer.dnb.no/something-useful-goes-here/\",   \"errorDetails\": [     {       \"errorNumber\": \"123450\",       \"errorField\": \"accountNumber\",       \"errorDescription\": \"accountNumber must be digits only\"     },     {       \"errorNumber\": \"123451\",       \"errorField\": \"dateFrom\",       \"errorDescription\": \"dateFrom must be in ISO8601 date format\"     }   ] } ```")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-13T18:43:45.652Z")

public class Error   {
  @JsonProperty("errorDocumentation")
  private String errorDocumentation = null;

  @JsonProperty("errorDetails")
  @Valid
  private List<ErrorErrorDetails> errorDetails = null;

  public Error errorDocumentation(String errorDocumentation) {
    this.errorDocumentation = errorDocumentation;
    return this;
  }

  /**
   * URI to developer documentation for this error.
   * @return errorDocumentation
  **/
  @ApiModelProperty(example = "errors", value = "URI to developer documentation for this error.")


  public String getErrorDocumentation() {
    return errorDocumentation;
  }

  public void setErrorDocumentation(String errorDocumentation) {
    this.errorDocumentation = errorDocumentation;
  }

  public Error errorDetails(List<ErrorErrorDetails> errorDetails) {
    this.errorDetails = errorDetails;
    return this;
  }

  public Error addErrorDetailsItem(ErrorErrorDetails errorDetailsItem) {
    if (this.errorDetails == null) {
      this.errorDetails = new ArrayList<ErrorErrorDetails>();
    }
    this.errorDetails.add(errorDetailsItem);
    return this;
  }

  /**
   * Details about the cause of this error (or errors). May contain information about an invalid parameter, or another specific problem.
   * @return errorDetails
  **/
  @ApiModelProperty(value = "Details about the cause of this error (or errors). May contain information about an invalid parameter, or another specific problem.")

  @Valid

  public List<ErrorErrorDetails> getErrorDetails() {
    return errorDetails;
  }

  public void setErrorDetails(List<ErrorErrorDetails> errorDetails) {
    this.errorDetails = errorDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.errorDocumentation, error.errorDocumentation) &&
        Objects.equals(this.errorDetails, error.errorDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorDocumentation, errorDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    errorDocumentation: ").append(toIndentedString(errorDocumentation)).append("\n");
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
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

