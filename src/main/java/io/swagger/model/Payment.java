package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CreditorAccount;
import io.swagger.model.DebtorAccount;
import io.swagger.model.InstructedAmount;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * **NOTE:** May be completely merged with &#x60;&#x60;&#x60;transaction&#x60;&#x60;&#x60;.  A &#x60;&#x60;&#x60;payment&#x60;&#x60;&#x60; is a planned payment/transaction that has not yet been carried out.  Details about a payment. Used by: * /payments/due/{accountNumber}: Returning a list of payments, with _empty_ PaymentDetails * /payments/due/{accountNumber}/details: Returning a list of payments, with PaymentDetails
 */
@ApiModel(description = "**NOTE:** May be completely merged with ```transaction```.  A ```payment``` is a planned payment/transaction that has not yet been carried out.  Details about a payment. Used by: * /payments/due/{accountNumber}: Returning a list of payments, with _empty_ PaymentDetails * /payments/due/{accountNumber}/details: Returning a list of payments, with PaymentDetails")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-13T18:43:45.652Z")

public class Payment   {
  @JsonProperty("debtorAccount")
  private DebtorAccount debtorAccount = null;

  @JsonProperty("creditorAccount")
  private CreditorAccount creditorAccount = null;

  @JsonProperty("instructedAmount")
  private InstructedAmount instructedAmount = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PENDING("PENDING"),
    
    APPROVED("APPROVED"),
    
    REJECTED("REJECTED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  public Payment debtorAccount(DebtorAccount debtorAccount) {
    this.debtorAccount = debtorAccount;
    return this;
  }

  /**
   * Get debtorAccount
   * @return debtorAccount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public DebtorAccount getDebtorAccount() {
    return debtorAccount;
  }

  public void setDebtorAccount(DebtorAccount debtorAccount) {
    this.debtorAccount = debtorAccount;
  }

  public Payment creditorAccount(CreditorAccount creditorAccount) {
    this.creditorAccount = creditorAccount;
    return this;
  }

  /**
   * Get creditorAccount
   * @return creditorAccount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CreditorAccount getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(CreditorAccount creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

  public Payment instructedAmount(InstructedAmount instructedAmount) {
    this.instructedAmount = instructedAmount;
    return this;
  }

  /**
   * Get instructedAmount
   * @return instructedAmount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public InstructedAmount getInstructedAmount() {
    return instructedAmount;
  }

  public void setInstructedAmount(InstructedAmount instructedAmount) {
    this.instructedAmount = instructedAmount;
  }

  public Payment status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(example = "APPROVED", value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.debtorAccount, payment.debtorAccount) &&
        Objects.equals(this.creditorAccount, payment.creditorAccount) &&
        Objects.equals(this.instructedAmount, payment.instructedAmount) &&
        Objects.equals(this.status, payment.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(debtorAccount, creditorAccount, instructedAmount, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    debtorAccount: ").append(toIndentedString(debtorAccount)).append("\n");
    sb.append("    creditorAccount: ").append(toIndentedString(creditorAccount)).append("\n");
    sb.append("    instructedAmount: ").append(toIndentedString(instructedAmount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

