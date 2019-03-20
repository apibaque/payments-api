package io.swagger.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.client.ApiException;
import io.swagger.client.api.PaymentControllerApi;
import io.swagger.client.model.PaymentDTO;
import io.swagger.client.model.PaymentDTO.StatusEnum;
import io.swagger.client.notification.ApiClient;
import io.swagger.client.notification.api.ConciliationApi;
import io.swagger.client.notification.model.GosocketPaymentDataModelsRedbancAccountPayment;
import io.swagger.client.notification.model.GosocketPaymentDataModelsRedbancAmountPayment;
import io.swagger.client.notification.model.GosocketPaymentDataModelsRedbancPaymentModel;
import io.swagger.client.notification.model.GosocketPaymentDataModelsRedbancRedbancPaymentModel;
import io.swagger.model.Payment;
import io.swagger.model.PaymentOrderRequest;
import io.swagger.model.PaymentOrderResponse;




public final class PaymentFacade {

	private static final PaymentControllerApi paymentApi = new PaymentControllerApi();
    private final static ConciliationApi api = new ConciliationApi();
    
    private static final Logger log = LoggerFactory.getLogger(PaymentFacade.class);

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
			final PaymentDTO paymentDTO = objectMapper.readValue(jsonInString, PaymentDTO.class);
			paymentDTO.setId(body.getOrderId());
			paymentDTO.setTransactionId(transactionId);
			paymentDTO.setModificationDate(new Date());
			paymentDTO.setStatus(StatusEnum.APPROVED);
			
			
			//
			
			Thread thread  = new Thread() {
				
				public void run() {
					try {
						log.info("=== BEGIN NOTIFICATION PROCESS GOSOCKET ===");
						
						
						ApiClient notificacion = new ApiClient();
						GosocketPaymentDataModelsRedbancPaymentModel payment = new GosocketPaymentDataModelsRedbancPaymentModel();
						
						notificacion.setUsername(System.getenv("userGS"));
						notificacion.setPassword(System.getenv("credentialGS"));
				    	
						notificacion.addDefaultHeader("Content-Type", "application/json");
						notificacion.addDefaultHeader("Accept", "application/json");
				    	
				    	
				    	api.setApiClient(notificacion);  
						
				    	GosocketPaymentDataModelsRedbancRedbancPaymentModel model = new GosocketPaymentDataModelsRedbancRedbancPaymentModel() ;
				    	model.setOrderId(paymentDTO.getId().toString());
				    	model.setTransactionId(paymentDTO.getTransactionId());
				    	
				    	GosocketPaymentDataModelsRedbancAccountPayment creditorAccount = new GosocketPaymentDataModelsRedbancAccountPayment();
				    	creditorAccount.setDestinationDNI(paymentDTO.getCreditorAccount().getDestinationDNI());
				    	creditorAccount.setIdentification(paymentDTO.getCreditorAccount().getIdentification());
				    	creditorAccount.setName(paymentDTO.getCreditorAccount().getName());
				    	
						payment.setCreditorAccount(creditorAccount);
				    	
						GosocketPaymentDataModelsRedbancAccountPayment debtorAccount = new GosocketPaymentDataModelsRedbancAccountPayment();
						debtorAccount.setDestinationDNI(paymentDTO.getDebtorAccount().getDestinationDNI());
						debtorAccount.setIdentification(paymentDTO.getDebtorAccount().getIdentification());
						debtorAccount.setName(paymentDTO.getDebtorAccount().getName());

						
						payment.setDebtorAccount(debtorAccount);
						
						GosocketPaymentDataModelsRedbancAmountPayment instructedAmount = new GosocketPaymentDataModelsRedbancAmountPayment();
				    	instructedAmount.amount(Integer.getInteger(paymentDTO.getInstructedAmount().getAmount().toString()));
				    	instructedAmount.setCurrency(152);
				    	
						payment.setInstructedAmount(instructedAmount);	
						
				    	payment.setStatus(paymentDTO.getStatus().toString());  
				        
				    	model.setPayment(payment);
						
				    	String response = api.conciliationRedbancConfirm1(model);
				         
				        System.out.println("Response conciliationRedbancConfirmTest: " + response);
				        log.info("Response conciliationRedbancConfirmTest: " + response);
				        
				        log.info("=== END NOTIFICATION PROCESS GOSOCKET ===");
						
						
						
					}catch(Exception e) {
						log.error("RESPONSE: " + e.getMessage()); 
						log.error("=== ERROR NOTIFICATION PROCESS GOSOCKET ===");
					}
				}
				
			};
			thread.start();
			
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
			paymentDTO.setCreationDate(new Date());
			paymentApi.addUserUsingPOST(paymentDTO);
		} catch (IOException e) {
			throw new ApiException();
		} 

	}

}
