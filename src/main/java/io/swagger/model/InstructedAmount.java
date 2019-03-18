package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InstructedAmount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-13T18:43:45.652Z")

public class InstructedAmount   {
  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("currency")
  private BigDecimal currency = null;

  public InstructedAmount amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * minimum: 1000
   * maximum: 500000
   * @return amount
  **/
  @ApiModelProperty(example = "100000.0", required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("1000") @DecimalMax("500000") 
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public InstructedAmount currency(BigDecimal currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * minimum: 1
   * maximum: 999
   * @return currency
  **/
  @ApiModelProperty(example = "152.0", required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("1") @DecimalMax("999") 
  public BigDecimal getCurrency() {
    return currency;
  }

  public void setCurrency(BigDecimal currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstructedAmount instructedAmount = (InstructedAmount) o;
    return Objects.equals(this.amount, instructedAmount.amount) &&
        Objects.equals(this.currency, instructedAmount.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstructedAmount {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

