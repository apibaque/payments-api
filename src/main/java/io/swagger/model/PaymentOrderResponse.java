package io.swagger.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The payment order object can be used for payments, which should be specified in the &#x60;&#x60;&#x60;type&#x60;&#x60;&#x60; property: * &#x60;&#x60;&#x60;orderId&#x60;&#x60;&#x60;: The Go Socket identification number specified by the receiving end, often described in the invoice.  * &#x60;&#x60;&#x60;transactionId&#x60;&#x60;&#x60;: A transaction identification number. * &#x60;&#x60;&#x60;operationDate&#x60;&#x60;&#x60;: A date of operation by payment.  * &#x60;&#x60;&#x60;payment&#x60;&#x60;&#x60;: A payment data of an operation of a payment orders.
 */
@ApiModel(description = "The payment order object can be used for payments, which should be specified in the ```type``` property: * ```orderId```: The Go Socket identification number specified by the receiving end, often described in the invoice.  * ```transactionId```: A transaction identification number. * ```operationDate```: A date of operation by payment.  * ```payment```: A payment data of an operation of a payment orders.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-13T18:43:45.652Z")

public class PaymentOrderResponse   {
  @JsonProperty("orderId")
  private String orderId = null;

  @JsonProperty("transactionId")
  private BigDecimal transactionId = null;

  @JsonProperty("operationDate")
  private OffsetDateTime operationDate = null;

  @JsonProperty("payment")
  private Payment payment = null;

  public PaymentOrderResponse orderId(String orderId) {
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

  public PaymentOrderResponse transactionId(BigDecimal transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * Get transactionId
   * minimum: 1
   * maximum: 999999999999
   * @return transactionId
  **/
  @ApiModelProperty(example = "5.2426965201E10", required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("1") @DecimalMax("999999999999") 
  public BigDecimal getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(BigDecimal transactionId) {
    this.transactionId = transactionId;
  }

  public PaymentOrderResponse operationDate(OffsetDateTime operationDate) {
    this.operationDate = operationDate;
    return this;
  }

  /**
   * Get operationDate
   * @return operationDate
  **/
  @ApiModelProperty(example = "1995-09-07T10:40:52Z", required = true, value = "")
  @NotNull

  @Valid

  public OffsetDateTime getOperationDate() {
    return operationDate;
  }

  public void setOperationDate(OffsetDateTime operationDate) {
    this.operationDate = operationDate;
  }

  public PaymentOrderResponse payment(Payment payment) {
    this.payment = payment;
    return this;
  }

  /**
   * Get payment
   * @return payment
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentOrderResponse paymentOrderResponse = (PaymentOrderResponse) o;
    return Objects.equals(this.orderId, paymentOrderResponse.orderId) &&
        Objects.equals(this.transactionId, paymentOrderResponse.transactionId) &&
        Objects.equals(this.operationDate, paymentOrderResponse.operationDate) &&
        Objects.equals(this.payment, paymentOrderResponse.payment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, transactionId, operationDate, payment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentOrderResponse {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    operationDate: ").append(toIndentedString(operationDate)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
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



public void setOperationDate(Instant instant) {
	 
	//org.threeten.bp.DateTimeUtils.toInstant - OffsetDateTime
	operationDate = OffsetDateTime.ofInstant(instant,	ZoneId.of("America/Santiago") );
	
}
}

