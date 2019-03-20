package io.swagger.api;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.client.ApiException;
import io.swagger.client.model.PaymentDTO;
import io.swagger.model.Payment.StatusEnum;
import io.swagger.model.PaymentOrderConsentResponse;
import io.swagger.model.PaymentOrderRequest;
import io.swagger.model.PaymentOrderResponse;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-05T19:08:49.617Z")

@Controller
public class PaymentOrderApiController implements PaymentOrderApi {

    private static final String ACCEPT = "Accept";

	private static final String ERROR_PROCESS_SERVICE = "Error process service";

	private static final String ERROR_SERIALIZE_RESPONSE = "Couldn't serialize response for content type application/json";

	private static final Logger log = LoggerFactory.getLogger(PaymentOrderApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

//    @Autowired
//    PropertyConfiguration property;
    
    @org.springframework.beans.factory.annotation.Autowired
    public PaymentOrderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PaymentOrderResponse> getPayment(@Pattern(regexp="^\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}$") @Size(min=36,max=36) @ApiParam(value = "Order id Number of current payment",required=true) @PathVariable("orderId") String orderId,@ApiParam(value = "The JWT Token generated from Get API Token" ) @RequestHeader(value="x-dnbapi-jwt", required=false) String xDnbapiJwt,@ApiParam(value = "The API key from your app page in DNB Developer" ) @RequestHeader(value="x-api-key", required=false) String xApiKey) {
    	String accept = request.getHeader(ACCEPT);
    	// log.debug(property.getEndpoint());
    	
        if (accept != null && accept.contains("application/json")) {
            try {
            	log.info("[getPayment] : Get payment for order ID " + orderId);
            	return new ResponseEntity<PaymentOrderResponse>(PaymentFacade.getPayment(orderId), HttpStatus.OK);
            } catch (ApiException e) {
            	log.error("Service error: " + e.getResponseBody());
            	return new ResponseEntity<PaymentOrderResponse>(HttpStatus.valueOf(e.getCode()));
			}
        }

        return new ResponseEntity<PaymentOrderResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

	@SuppressWarnings("unlikely-arg-type")
	public ResponseEntity<PaymentOrderResponse> paymentOrder(@ApiParam(value = "" ,required=true )  @Valid @RequestBody PaymentOrderRequest body,@ApiParam(value = "The JWT Token generated from Get API Token" ) @RequestHeader(value="x-dnbapi-jwt", required=false) String xDnbapiJwt,@ApiParam(value = "The API key from your app page in DNB Developer" ) @RequestHeader(value="x-api-key", required=false) String xApiKey) {
        String accept = request.getHeader(ACCEPT);
        if (accept != null && accept.contains("application/json")) {
            try {
            	log.info("[postPaymentUpdate] : Process payment: " + body);
            	
            	PaymentDTO dto = PaymentFacade.updatePaymentOrder(body);

            	
            	PaymentOrderResponse response = new PaymentOrderResponse();
            	response.setOrderId(dto.getId());
            	response.setTransactionId(new BigDecimal(dto.getTransactionId()));
          
            	response.setOperationDate(org.threeten.bp.DateTimeUtils.toInstant(dto.getCreationDate()));            	 
            	
            	getStatusEnum(dto,body);
            	response.setPayment(body.getPayment());            	           

                return new ResponseEntity<PaymentOrderResponse>(response, HttpStatus.OK);
            } catch (ApiException e) {
            	log.error(ERROR_PROCESS_SERVICE, e);
                return new ResponseEntity<PaymentOrderResponse>(HttpStatus.valueOf(e.getCode()));
			}
            
            
        }

        return new ResponseEntity<PaymentOrderResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    private void getStatusEnum(PaymentDTO dto, PaymentOrderRequest body) {
    	if(dto.getStatus().name().equals(StatusEnum.APPROVED.name()))
    		body.getPayment().setStatus(StatusEnum.APPROVED);
    	else if(dto.getStatus().name().equals(StatusEnum.REJECTED.name()))
    		body.getPayment().setStatus(StatusEnum.REJECTED);
    	else
    		body.getPayment().setStatus(StatusEnum.PENDING);
		
	}

	public ResponseEntity<PaymentOrderConsentResponse> paymentOrderConsent(@ApiParam(value = "" ,required=true )  @Valid @RequestBody PaymentOrderRequest body,@ApiParam(value = "The JWT Token generated from Get API Token" ) @RequestHeader(value="x-dnbapi-jwt", required=false) String xDnbapiJwt,@ApiParam(value = "The API key from your app page in DNB Developer" ) @RequestHeader(value="x-api-key", required=false) String xApiKey) {
        String accept = request.getHeader(ACCEPT);
        if (accept != null && accept.contains("application/json")) {
            try {
            	log.info("[getPayment] : Add new payment: " + body);
            	PaymentFacade.addPaymentOrder(body);
                return new ResponseEntity<PaymentOrderConsentResponse>(objectMapper.readValue("{  \"orderId\" : \"" + body.getOrderId() + "\",  \"description\" : \"Payment order consent created\"}", PaymentOrderConsentResponse.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error(ERROR_SERIALIZE_RESPONSE, e);
                return new ResponseEntity<PaymentOrderConsentResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (ApiException e) {
            	log.error(ERROR_PROCESS_SERVICE, e);
            	return new ResponseEntity<PaymentOrderConsentResponse>(HttpStatus.valueOf(e.getCode()));
			} 
        }
        return new ResponseEntity<PaymentOrderConsentResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
