package com.iviettech.bus.controller;

import com.iviettech.bus.entity.BusesEntity;
import com.iviettech.bus.entity.PromotionTimeEntity;
import com.iviettech.bus.entity.TicketEntity;
import com.iviettech.bus.entity.TimeTableScheduleEntity;
import com.iviettech.bus.repository.*;
import com.iviettech.bus.utils.AESCrypter;
import com.iviettech.bus.utils.Configuration;
import com.iviettech.bus.utils.MailUtilGmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import urn.ebay.api.PayPalAPI.*;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Date;
import java.util.*;

/**
 * Created by tran on 29/08/2016.
 */
@Controller
public class TransferController {

    @Autowired
    TimeTableScheduleRepository timeTableScheduleRepository;

    @Autowired
    StatusBusesRepository statusBusesRepository;

    @Autowired
    BusesRepository busesRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    AESCrypter aesCrypter;

    @Autowired
    MailUtilGmail mailUtilGmail;

    @Autowired
    PromotionTimeRepository promotionTimeRepository;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/transfer")
    public String transfer(@RequestParam(value = "timeTableId") int timeTableId,
                           @ModelAttribute(value = "ticket") TicketEntity ticket,
                           HttpSession session,
                           Model model) {

        Date dateStartMove = (Date) session.getAttribute("dayStartMove");
        TimeTableScheduleEntity timeTableScheduleEntity = timeTableScheduleRepository.findOne(timeTableId);
        PromotionTimeEntity promotionTimeEntity = promotionTimeRepository.findByScheduleEntityIdAndStartAndEnd(timeTableScheduleEntity.getScheduleEntity().getId(), dateStartMove);

        TicketEntity ticketSession = (TicketEntity) session.getAttribute("ticket");
        ticketSession.setSeat(ticket.getSeat());
        ticketSession.setNumberSeats(ticket.getNumberSeats());

        int promotionSale = 0;
        if (promotionTimeEntity != null){
            promotionSale = promotionTimeEntity.getPromotionEntity().getSale();
        }
        ticketSession.setTotalprice(ticket.getTotalprice()-ticket.getTotalprice()*promotionSale/100);

        model.addAttribute("timeTableTicket", timeTableScheduleEntity);
        model.addAttribute("ticket", ticketSession);
        model.addAttribute("dayStartMove", session.getAttribute("dayStartMove"));
        model.addAttribute("promotion", promotionTimeEntity);
        session.setAttribute("ticket", ticketSession);
        session.setAttribute("timeTableTicket", timeTableScheduleEntity);

        return "transfer";
    }

    public void sendTicket(TicketEntity ticketEntity){
        String message2="";
        try {
            String body = "<h1 style='color:red;'> Dear "+ticketEntity.getFullName()+" </h1>";
            body += "<h2>Đây là vé của bạn</h2>";
            mailUtilGmail.sendEmail(ticketEntity.getGmail(), "conos.team@gmail.com", "Ticket Bus", body, ticketEntity ,true);
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
    }

    public String encryptedCodeTicket(TicketEntity ticketEntitySession) throws GeneralSecurityException {

        String text = ticketEntitySession.getBookTime().toString()+"-"+ticketEntitySession.getGmail();

        String key = "TTY6I9^hQuo!a1n0";
        String iv =  "Iay63!2Uy*)sQZhn"; // Initialization vector

        String encryptedCode = aesCrypter.encrypt(text, key, iv);

        encryptedCode = encryptedCode.substring(0, 8);

        return encryptedCode;
    }

    public BusesEntity findBusesEntity(Date dateStartMove, TimeTableScheduleEntity timeTableScheduleEntity){
        BusesEntity busesEntity = busesRepository.findByDateAndTimeTableScheduleEntityId(dateStartMove, timeTableScheduleEntity.getId());

        if (busesEntity == null){
            busesEntity = new BusesEntity();
            busesEntity.setDate(new Date(dateStartMove.getTime()));
            busesEntity.setTimeTableScheduleEntity(timeTableScheduleEntity);
            busesEntity.setStatusBusesEntity(statusBusesRepository.findOne(1));
            busesRepository.save(busesEntity);
        }
        return busesEntity;
    }

    @RequestMapping(value = "/postpaid")
    public String postPaid(HttpSession session) throws GeneralSecurityException {

        TicketEntity ticketEntitySession = (TicketEntity) session.getAttribute("ticket");
        TimeTableScheduleEntity timeTableScheduleEntity = (TimeTableScheduleEntity) session.getAttribute("timeTableTicket");
        Date dateStartMove = (Date) session.getAttribute("dayStartMove");

        BusesEntity busesEntity = findBusesEntity(dateStartMove, timeTableScheduleEntity);

        ticketEntitySession.setBookTime(new Date(Calendar.getInstance().getTimeInMillis()));
        ticketEntitySession.setBusesEntity(busesEntity);

        ticketEntitySession.setCodeTicket(encryptedCodeTicket(ticketEntitySession));

        ticketRepository.save(ticketEntitySession);

        sendTicket(ticketEntitySession);

        session.setAttribute("ticket", ticketEntitySession);

        return "transfersuccess";
    }


    @RequestMapping(value = "/SetExpressCheckoutForParallelPayment")
    public void setOnlinePayment(HttpServletRequest request,
                                HttpServletResponse response,
                                 HttpSession session) throws IOException {
        TicketEntity ticketEntity = (TicketEntity) session.getAttribute("ticket");
        HttpSession requestSession = request.getSession();
        requestSession.setAttribute("url", request.getRequestURI());
        response.setContentType("text/html");

        // Configuration map containing signature credentials and other required
        // configuration.
        // For a full list of configuration parameters refer at
        // (https://github.com/paypal/sdk-core-java/blob/master/README.md)
        Map<String, String> configurationMap = Configuration
                .getAcctAndConfig();

        // Creating service wrapper object to make an API call by loading
        // configuration map.
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(
                configurationMap);

        // # SetExpressCheckout API
        // The SetExpressCheckout API operation initiates an Express Checkout
        // transaction.
        // This sample code uses Merchant Java SDK to make API call. You can
        // download the SDKs
        // [here](https://github.com/paypal/sdk-packages/tree/gh-pages/merchant-sdk/java)
        if (request.getRequestURI().contains("SetExpressCheckoutForParallelPayment")) { // *************** SetExpressCheckout for parallel payment ************************
            SetExpressCheckoutRequestType setExpressCheckoutReq = new SetExpressCheckoutRequestType();
            SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();

            StringBuffer url = new StringBuffer();
            url.append("http://");
            url.append(request.getServerName());
            url.append(":");
            url.append(request.getServerPort());
            url.append(request.getContextPath());

            String returnURL = url.toString() + "/DoExpressCheckoutForParallelPayment";
            String cancelURL = url.toString() + "/SetExpressCheckoutForParallelPayment";

			/*
			 * (Required) URL to which the buyer's browser is returned after
			 * choosing to pay with PayPal. For digital goods, you must add
			 * JavaScript to this page to close the in-context experience. Note:
			 * PayPal recommends that the value be the final review page on
			 * which the buyer confirms the order and payment or billing
			 * agreement. Character length and limitations: 2048 single-byte
			 * characters
			 */
            details.setReturnURL(returnURL + "?currencyCodeType="
                    + request.getParameter("currencyCode"));

            details.setCancelURL(cancelURL);
			/*
			 * (Optional) Email address of the buyer as entered during checkout.
			 * PayPal uses this value to pre-fill the PayPal membership sign-up
			 * portion on the PayPal pages. Character length and limitations:
			 * 127 single-byte alphanumeric characters
			 */
            details.setBuyerEmail(ticketEntity.getGmail());

            SellerDetailsType seller_1 = new SellerDetailsType();
            seller_1.setPayPalAccountID("ittuan123-facilitator@gmail.com");
            PaymentDetailsType paymentDetails_1 = new PaymentDetailsType();
            paymentDetails_1.setSellerDetails(seller_1);
            paymentDetails_1.setPaymentRequestID("CART286-PAYMENT0");
            BasicAmountType orderTotal_1 = new BasicAmountType();
            orderTotal_1.setCurrencyID(CurrencyCodeType.fromValue("USD"));
            orderTotal_1.setValue(String.valueOf(ticketEntity.getTotalprice()/22000));
            paymentDetails_1.setOrderTotal(orderTotal_1);
            paymentDetails_1.setPaymentAction(PaymentActionCodeType
                    .fromValue("Sale"));

            List<PaymentDetailsType> payDetails = new ArrayList<PaymentDetailsType>();
            payDetails.add(paymentDetails_1);

            details.setPaymentDetails(payDetails);

            setExpressCheckoutReq.setSetExpressCheckoutRequestDetails(details);

            SetExpressCheckoutReq expressCheckoutReq = new SetExpressCheckoutReq();
            expressCheckoutReq
                    .setSetExpressCheckoutRequest(setExpressCheckoutReq);
            SetExpressCheckoutResponseType setExpressCheckoutResponse = null;

            try {
                setExpressCheckoutResponse = service
                        .setExpressCheckout(expressCheckoutReq);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (setExpressCheckoutResponse != null) {
                requestSession.setAttribute("lastReq", service.getLastRequest());
                requestSession.setAttribute("lastResp", service.getLastResponse());

                if (setExpressCheckoutResponse.getAck().toString()
                        .equalsIgnoreCase("SUCCESS")) {
                    requestSession.setAttribute("ecToken",
                            setExpressCheckoutResponse.getToken());
                    response.sendRedirect("https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="
                            + setExpressCheckoutResponse.getToken());
                } else {

                    requestSession.setAttribute("Error",
                            setExpressCheckoutResponse.getErrors());
                    response.sendRedirect(servletContext
                            .getContextPath() + "/Error.jsp");
                }

            }
        }
    }

    @RequestMapping(value = "/DoExpressCheckoutForParallelPayment")
    public String doOnlinePayment(HttpServletRequest request,
                                  HttpServletResponse response,
                                  HttpSession session) throws IOException, GeneralSecurityException {
        TicketEntity ticketEntity = (TicketEntity) session.getAttribute("ticket");
        HttpSession requestSession = request.getSession();
        requestSession.setAttribute("url", request.getRequestURI());
        response.setContentType("text/html");

        // Configuration map containing signature credentials and other required
        // configuration.
        // For a full list of configuration parameters refer at
        // (https://github.com/paypal/sdk-core-java/blob/master/README.md)
        Map<String, String> configurationMap = Configuration
                .getAcctAndConfig();

        // Creating service wrapper object to make an API call by loading
        // configuration map.
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(
                configurationMap);
        String path = null;
        if (request.getRequestURI().contains("DoExpressCheckoutForParallelPayment")) {  // *************** DoExpressCheckout for parallel payment ************************

            DoExpressCheckoutPaymentRequestType doCheckoutPaymentRequestType = new DoExpressCheckoutPaymentRequestType();
            DoExpressCheckoutPaymentRequestDetailsType doEcdetails = new DoExpressCheckoutPaymentRequestDetailsType();
				/*
				 * A timestamped token by which you identify to PayPal that you
				 * are processing this payment with Express Checkout. The token
				 * expires after three hours. If you set the token in the
				 * SetExpressCheckout request, the value of the token in the
				 * response is identical to the value in the request. Character
				 * length and limitations: 20 single-byte characters
				 */
            doEcdetails.setToken(request.getParameter("token"));
				/*
				 * Unique PayPal Customer Account identification number.
				 * Character length and limitations: 13 single-byte alphanumeric
				 * characters
				 */
            doEcdetails.setPayerID(request.getParameter("PayerID"));
				/*
				 * (Optional) How you want to obtain payment. If the transaction
				 * does not include a one-time purchase, this field is ignored.
				 * It is one of the following values: Sale � This is a final
				 * sale for which you are requesting payment (default).
				 * Authorization � This payment is a basic authorization subject
				 * to settlement with PayPal Authorization and Capture. Order �
				 * This payment is an order authorization subject to settlement
				 * with PayPal Authorization and Capture. Note: You cannot set
				 * this field to Sale in SetExpressCheckout request and then
				 * change this value to Authorization or Order in the
				 * DoExpressCheckoutPayment request. If you set the field to
				 * Authorization or Order in SetExpressCheckout, you may set the
				 * field to Sale. Character length and limitations: Up to 13
				 * single-byte alphabetic characters This field is deprecated.
				 * Use PaymentAction in PaymentDetailsType instead.
				 */


            doEcdetails.setPaymentAction(PaymentActionCodeType.fromValue("Sale"));

            SellerDetailsType seller_1 = new SellerDetailsType();
            seller_1.setPayPalAccountID("ittuan123-facilitator@gmail.com");
            PaymentDetailsType paymentDetails_1 = new PaymentDetailsType();
            paymentDetails_1.setSellerDetails(seller_1);
            paymentDetails_1.setPaymentRequestID("CART286-PAYMENT0");
            BasicAmountType orderTotal_1 = new BasicAmountType();
            orderTotal_1.setCurrencyID(CurrencyCodeType.fromValue("USD"));
            orderTotal_1.setValue(String.valueOf(ticketEntity.getTotalprice()/22000));
            paymentDetails_1.setOrderTotal(orderTotal_1);
            paymentDetails_1.setPaymentAction(PaymentActionCodeType
                    .fromValue("Sale"));
//				SellerDetailsType seller_2 = new SellerDetailsType();
//				seller_2.setPayPalAccountID(request.getParameter("receiverEmail_1"));
//				PaymentDetailsType paymentDetails_2 = new PaymentDetailsType();
//				paymentDetails_2.setSellerDetails(seller_2);
//				paymentDetails_2.setPaymentRequestID(request.getParameter("requestId_1"));
//				BasicAmountType orderTotal_2 = new BasicAmountType();
//				orderTotal_2.setCurrencyID(CurrencyCodeType.fromValue(request.getParameter("currencyCode")));
//				orderTotal_2.setValue(request.getParameter("orderTotal"));
//				paymentDetails_2.setOrderTotal(orderTotal_2);
//				paymentDetails_2.setPaymentAction(PaymentActionCodeType.fromValue(request.getParameter("paymentAction")));

            List<PaymentDetailsType> payDetails = new ArrayList<PaymentDetailsType>();
            payDetails.add(paymentDetails_1);

            doEcdetails.setPaymentDetails(payDetails);
            doCheckoutPaymentRequestType.setDoExpressCheckoutPaymentRequestDetails(doEcdetails);
            DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq = new DoExpressCheckoutPaymentReq();
            doExpressCheckoutPaymentReq.setDoExpressCheckoutPaymentRequest(doCheckoutPaymentRequestType);
            DoExpressCheckoutPaymentResponseType doCheckoutPaymentResponseType = null;

            try {
                doCheckoutPaymentResponseType = service
                        .doExpressCheckoutPayment(doExpressCheckoutPaymentReq);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.setContentType("text/html");

            if (doCheckoutPaymentResponseType != null) {
                //session.setAttribute("nextDescription"," \n Parallel Payment completed");
                requestSession.setAttribute("lastReq", service.getLastRequest());
                requestSession.setAttribute("lastResp", service.getLastResponse());
                if (doCheckoutPaymentResponseType.getAck().toString()
                        .equalsIgnoreCase("SUCCESS")) {
                    Map<Object, Object> map = new LinkedHashMap<Object, Object>();
                    map.put("Ack", doCheckoutPaymentResponseType.getAck());
                    Iterator<PaymentInfoType> iterator = doCheckoutPaymentResponseType
                            .getDoExpressCheckoutPaymentResponseDetails()
                            .getPaymentInfo().iterator();
                    int index = 1;
						/*
						 * Unique transaction ID of the payment. Note: If the
						 * PaymentAction of the request was Authorization or
						 * Order, this value is your AuthorizationID for use
						 * with the Authorization & Capture APIs. Character
						 * length and limitations: 19 single-byte characters
						 */
                    while (iterator.hasNext()) {
                        PaymentInfoType result = (PaymentInfoType) iterator
                                .next();
                        map.put("Transaction ID" + index,
                                result.getTransactionID());
                        index++;
                    }
                    requestSession.setAttribute(
                            "transactionId",
                            doCheckoutPaymentResponseType
                                    .getDoExpressCheckoutPaymentResponseDetails()
                                    .getPaymentInfo().get(0)
                                    .getTransactionID());
                    requestSession.setAttribute("map", map);
//                    response.sendRedirect(servletContext
//                            .getContextPath() + "/home.jsp");

                    TimeTableScheduleEntity timeTableScheduleEntity = (TimeTableScheduleEntity) session.getAttribute("timeTableTicket");
                    Date dateStartMove = (Date) session.getAttribute("dayStartMove");

                    BusesEntity busesEntity = findBusesEntity(dateStartMove, timeTableScheduleEntity);

                    ticketEntity.setBookTime(new Date(Calendar.getInstance().getTimeInMillis()));
//                    ticketEntity.set
                    ticketEntity.setCodeTicket(encryptedCodeTicket(ticketEntity));
                    ticketEntity.setBusesEntity(busesEntity);
                    ticketRepository.save(ticketEntity);
                    sendTicket(ticketEntity);
                    session.setAttribute("ticket", ticketEntity);
                    path = "transfersuccess";
                } else {

                    requestSession.setAttribute("Error",
                            doCheckoutPaymentResponseType.getErrors());
                    response.sendRedirect(servletContext
                            .getContextPath() + "/Error.jsp");
                    session.removeAttribute("ticket");
                    path = "error404transfer";
                }
            }

        }
        return path;
    }

}
