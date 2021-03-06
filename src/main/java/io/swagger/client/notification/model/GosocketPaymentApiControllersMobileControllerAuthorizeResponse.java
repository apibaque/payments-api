/*
 * Gosocket Payment API
 * Synchronize payments API
 *
 * OpenAPI spec version: v1
 * Contact: developerteam@gosocket.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.notification.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * GosocketPaymentApiControllersMobileControllerAuthorizeResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-13T18:41:34.367Z")
public class GosocketPaymentApiControllersMobileControllerAuthorizeResponse {
  @SerializedName("Status")
  private String status = null;

  @SerializedName("AvailableAmount")
  private Double availableAmount = null;

  public GosocketPaymentApiControllersMobileControllerAuthorizeResponse status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GosocketPaymentApiControllersMobileControllerAuthorizeResponse availableAmount(Double availableAmount) {
    this.availableAmount = availableAmount;
    return this;
  }

   /**
   * Get availableAmount
   * @return availableAmount
  **/
  @ApiModelProperty(value = "")
  public Double getAvailableAmount() {
    return availableAmount;
  }

  public void setAvailableAmount(Double availableAmount) {
    this.availableAmount = availableAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GosocketPaymentApiControllersMobileControllerAuthorizeResponse gosocketPaymentApiControllersMobileControllerAuthorizeResponse = (GosocketPaymentApiControllersMobileControllerAuthorizeResponse) o;
    return Objects.equals(this.status, gosocketPaymentApiControllersMobileControllerAuthorizeResponse.status) &&
        Objects.equals(this.availableAmount, gosocketPaymentApiControllersMobileControllerAuthorizeResponse.availableAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, availableAmount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GosocketPaymentApiControllersMobileControllerAuthorizeResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    availableAmount: ").append(toIndentedString(availableAmount)).append("\n");
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

