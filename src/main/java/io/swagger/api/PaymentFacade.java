package io.swagger.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.client.ApiException;
import io.swagger.client.api.PaymentControllerApi;
import io.swagger.client.model.PaymentDTO;
import io.swagger.client.model.PaymentDTO.StatusEnum;
import io.swagger.model.Payment;
import io.swagger.model.PaymentOrderRequest;
import io.swagger.model.PaymentOrderResponse;

public final class PaymentFacade {

	private static final PaymentControllerApi paymentApi = new PaymentControllerApi();

	private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	private PaymentFacade() {
	}

	public static PaymentOrderResponse getPayment(String orderId) throws ApiException {
		try {
			PaymentDTO paymentDTO = paymentApi.findByIdUsingGET(orderId);
			
			PaymentOrderResponse response = new PaymentOrderResponse();
			OffsetDateTime operationDate = OffsetDateTime.now();
			if (paymentDTO.getModificationDate() != null) {
				Instant instant = Instant.ofEpochMilli(paymentDTO.getModificationDate().getTime());
				operationDate = OffsetDateTime.ofInstant(instant, ZoneId.systemDefault());
			}
			
			response.setOperationDate(operationDate);
			response.setTransactionId(paymentDTO.getTransactionId() == null ? BigDecimal.valueOf(0) : new BigDecimal(paymentDTO.getTransactionId()));
			response.setOrderId(paymentDTO.getId());
			
			String jsonInString = objectMapper.writeValueAsString(paymentDTO);
			Payment payment = objectMapper.readValue(jsonInString, Payment.class);
			response.setPayment(payment);
			
			return response;
			
		} catch (IOException e) {
			throw new ApiException(e.getMessage());
		}
	}

	public static PaymentDTO updatePaymentOrder(PaymentOrderRequest body) throws ApiException {
		// Business Logic
		Random rand = new Random();
		int number = rand.nextInt(999999);
		String transactionId = String.valueOf(number);
		String jsonInString = null;
		try {
			jsonInString = objectMapper.writeValueAsString(body.getPayment());
			PaymentDTO paymentDTO = objectMapper.readValue(jsonInString, PaymentDTO.class);
			paymentDTO.setId(body.getOrderId());
			paymentDTO.setTransactionId(transactionId);
			paymentDTO.setModificationDate(new Date());
			paymentDTO.setStatus(StatusEnum.APPROVED);
			
			return paymentApi.updateUsingPOST(paymentDTO);
		} catch (IOException e) {
			throw new ApiException();
		} 

	}
	
	
	public static void addPaymentOrder(PaymentOrderRequest body) throws ApiException {
		// Business Logic
		String jsonInString = null;
		try {
			jsonInString = objectMapper.writeValueAsString(body.getPayment());
			PaymentDTO paymentDTO = objectMapper.readValue(jsonInString, PaymentDTO.class);
			paymentDTO.setId(body.getOrderId());
			paymentApi.addUserUsingPOST(paymentDTO);
		} catch (IOException e) {
			throw new ApiException();
		} 

	}

}
