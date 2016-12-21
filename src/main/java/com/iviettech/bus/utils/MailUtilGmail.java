/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.bus.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.iviettech.bus.entity.TicketEntity;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import static com.iviettech.bus.utils.CreaterTicketPdf.createPdf;


/**
 *
 * @author tran
 */
@Component
public class MailUtilGmail {
//    public static void main(String[] args) {
//        try {
//            String body = "<h1 style='color:blue;'> Dear phatvu,</h1>";
//            body += "<h2>You've registered sucessfully to our website. Enjoy with us http://localhost:8080/user </h2>";
//
//            sendEmail("ittuan123@gmail.com", "conos.team@gmail.com", "Test email", body, ticketEntitySession, true);
//        } catch (Exception ex) {
//            System.out.println("Error : " + ex);
//        }
//    }
    
    public static void sendEmail(String to, String from, String subject, String body, TicketEntity ticketEntitySession, boolean bodyIsHTML)
            throws MessagingException, UnsupportedEncodingException{
        //1 - Get an email session
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        //2 - Create a message
        Message message = new MimeMessage(session);
//        message.setHeader("Content-Type", "text/plain; charset=UTF-8");
        message.setSubject(subject);
        if (bodyIsHTML) {
//            message.setContent(body, "text/html; charset=utf-8");
            message.setContent("<h1>Hello</h1>", "text/html");
        } else {
            message.setText(body);
        }
        ByteArrayOutputStream outputStream = null;
        //construct the text body part
        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setContent(body, "text/html; charset=utf-8"); //?

        //now write the PDF content to the output stream
        outputStream = new ByteArrayOutputStream();
        try {
            createPdf(outputStream, ticketEntitySession);
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] bytes = outputStream.toByteArray();

        //construct the pdf body part
        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
        MimeBodyPart pdfBodyPart = new MimeBodyPart();
        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
        pdfBodyPart.setFileName("test.pdf");

        //construct the mime multi part
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(textBodyPart);
        mimeMultipart.addBodyPart(pdfBodyPart);

        
        // 3 - address the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        message.setContent(mimeMultipart);
        
        // 4 - send the messag
        Transport transport = session.getTransport();
        transport.connect("conos.team@gmail.com", "axoninsight123");
        transport.sendMessage(message, message.getAllRecipients());
        System.out.println("Done");
        transport.close();
    }


}

