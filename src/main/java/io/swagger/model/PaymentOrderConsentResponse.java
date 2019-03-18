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
 * The payment response object of operation payments, which should be specified in the &#x60;&#x60;&#x60;type&#x60;&#x60;&#x60; property: * &#x60;&#x60;&#x60;orderId&#x60;&#x60;&#x60;: The Go Socket identification number specified by the receiving end, often described in the invoice.  * &#x60;&#x60;&#x60;transactionId&#x60;&#x60;&#x60;: A transaction identification number. * &#x60;&#x60;&#x60;operationDate&#x60;&#x60;&#x60;: A date of operation by payment.  * &#x60;&#x60;&#x60;payment&#x60;&#x60;&#x60;: A data of an payment opertation.
 */
@ApiModel(description = "The payment response object of operation payments, which should be specified in the ```type``` property: * ```orderId```: The Go Socket identification number specified by the receiving end, often described in the invoice.  * ```transactionId```: A transaction identification number. * ```operationDate```: A date of operation by payment.  * ```payment```: A data of an payment opertation.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-13T18:43:45.652Z")

public class PaymentOrderConsentResponse   {
  @JsonProperty("orderId")
  private String orderId = null;

  @JsonProperty("description")
  private String description = null;

  public PaymentOrderConsentResponse orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  **/
  @ApiModelProperty(example = "3F2504E0-4F89-11D3-9A0C-0305E82C3301", required = true, value = "")
  @NotNull

@Pattern(regexp="^\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}$") @Size(min=36,max=36) 
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public PaymentOrderConsentResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "Payment order consent created", required = true, value = "")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentOrderConsentResponse paymentOrderConsentResponse = (PaymentOrderConsentResponse) o;
    return Objects.equals(this.orderId, paymentOrderConsentResponse.orderId) &&
        Objects.equals(this.description, paymentOrderConsentResponse.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentOrderConsentResponse {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

