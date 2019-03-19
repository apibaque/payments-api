/*
 * Api Documentation
 * Api Documentation
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import io.swagger.annotations.ApiModelProperty;

/**
 * PaymentDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-05T15:32:10.832Z")
public class PaymentDTO {

	@SerializedName("id")
	private String id = null;

	@SerializedName("transactionId")
	private String transactionId = null;

	@SerializedName("creationDate")
	private Date creationDate = null;

	@SerializedName("modificationDate")
	private Date modificationDate = null;
	
	@SerializedName("creditorAccount")
	private CreditorAccountDTO creditorAccount = null;

	@SerializedName("debtorAccount")
	private DebtorAccountDTO debtorAccount = null;

	@SerializedName("instructedAmount")
	private InstructedAmountDTO instructedAmount = null;

	/**
	 * Gets or Sets status
	 */
	@JsonAdapter(StatusEnum.Adapter.class)
	public enum StatusEnum {
		
		PENDING("PENDING"),
		
		APPROVED("APPROVED"),

		REJECTED("REJECTED");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}

		public static class Adapter extends TypeAdapter<StatusEnum> {
			@Override
			public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
				jsonWriter.value(enumeration.getValue());
			}

			@Override
			public StatusEnum read(final JsonReader jsonReader) throws IOException {
				String value = jsonReader.nextString();
				return StatusEnum.fromValue(String.valueOf(value));
			}
		}
	}

	@SerializedName("status")
	private StatusEnum status = null;

	public PaymentDTO creditorAccount(CreditorAccountDTO creditorAccount) {
		this.creditorAccount = creditorAccount;
		return this;
	}

	/**
	 * Get creditorAccount
	 * 
	 * @return creditorAccount
	 **/
	@ApiModelProperty(value = "")
	public CreditorAccountDTO getCreditorAccount() {
		return creditorAccount;
	}

	public void setCreditorAccount(CreditorAccountDTO creditorAccount) {
		this.creditorAccount = creditorAccount;
	}

	public PaymentDTO debtorAccount(DebtorAccountDTO debtorAccount) {
		this.debtorAccount = debtorAccount;
		return this;
	}

	/**
	 * Get debtorAccount
	 * 
	 * @return debtorAccount
	 **/
	@ApiModelProperty(value = "")
	public DebtorAccountDTO getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(DebtorAccountDTO debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public PaymentDTO id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PaymentDTO instructedAmount(InstructedAmountDTO instructedAmount) {
		this.instructedAmount = instructedAmount;
		return this;
	}

	/**
	 * Get instructedAmount
	 * 
	 * @return instructedAmount
	 **/
	@ApiModelProperty(value = "")
	public InstructedAmountDTO getInstructedAmount() {
		return instructedAmount;
	}

	public void setInstructedAmount(InstructedAmountDTO instructedAmount) {
		this.instructedAmount = instructedAmount;
	}

	public PaymentDTO status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "")
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PaymentDTO paymentDTO = (PaymentDTO) o;
		return Objects.equals(this.creditorAccount, paymentDTO.creditorAccount)
				&& Objects.equals(this.debtorAccount, paymentDTO.debtorAccount)
				&& Objects.equals(this.id, paymentDTO.id) && Objects.equals(this.creationDate, paymentDTO.creationDate)
				&& Objects.equals(this.modificationDate, paymentDTO.modificationDate)
				&& Objects.equals(this.instructedAmount, paymentDTO.instructedAmount)
				&& Objects.equals(this.status, paymentDTO.status)
				&& Objects.equals(this.transactionId, paymentDTO.transactionId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(creditorAccount, debtorAccount, id, instructedAmount, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PaymentDTO {\n");

		sb.append("    creditorAccount: ").append(toIndentedString(creditorAccount)).append("\n");
		sb.append("    debtorAccount: ").append(toIndentedString(debtorAccount)).append("\n");
		sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
