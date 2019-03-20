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
 * CreditorAccount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-13T18:43:45.652Z")

public class CreditorAccount   {
  @JsonProperty("identification")
  private String identification = null;

  @JsonProperty("secondaryIdentification")
  private String secondaryIdentification = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("destinationDNI")
  private String destinationDNI = null;

  public CreditorAccount identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * Get identification
   * @return identification
  **/
  @ApiModelProperty(example = "00000001002000000000", required = true, value = "")
  @NotNull

@Pattern(regexp="^\\d{8,20}$")
  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public CreditorAccount secondaryIdentification(String secundaryIdentification) {
    this.secondaryIdentification = secundaryIdentification;
    return this;
  }

  /**
   * Get secondaryIdentification
   * @return secondaryIdentification
  **/
  @ApiModelProperty(example = "03700", required = true, value = "")
  @NotNull

@Pattern(regexp="^\\d{5}$") 
  public String getSecondaryIdentification() {
    return secondaryIdentification;
  }

  public void setSecondaryIdentification(String secundaryIdentification) {
    this.secondaryIdentification = secundaryIdentification;
  }

  public CreditorAccount name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Santander", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreditorAccount destinationDNI(String destinationDNI) {
    this.destinationDNI = destinationDNI;
    return this;
  }

  /**
   * Get destinationDNI
   * @return destinationDNI
  **/
  @ApiModelProperty(example = "14000000", required = true, value = "")
  @NotNull

@Pattern(regexp="^\\d{7,8}$") @Size(min=7,max=8) 
  public String getDestinationDNI() {
    return destinationDNI;
  }

  public void setDestinationDNI(String destinationDNI) {
    this.destinationDNI = destinationDNI;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditorAccount creditorAccount = (CreditorAccount) o;
    return Objects.equals(this.identification, creditorAccount.identification) &&
        Objects.equals(this.secondaryIdentification, creditorAccount.secondaryIdentification) &&
        Objects.equals(this.name, creditorAccount.name) &&
        Objects.equals(this.destinationDNI, creditorAccount.destinationDNI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identification, secondaryIdentification, name, destinationDNI);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditorAccount {\n");
    
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    secundaryIdentification: ").append(toIndentedString(secondaryIdentification)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    destinationDNI: ").append(toIndentedString(destinationDNI)).append("\n");
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

