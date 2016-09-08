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

    public static void createPdf(OutputStream outputStream, TicketEntity ticketEntity) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, outputStream);

        document.open();

        document.addTitle("Test PDF");
        document.addSubject("Testing email PDF");
        document.addKeywords("iText, email");
        document.addAuthor("Tuan");
        document.addCreator("Tuan");

        String myString = ticketEntity.getCodeTicket();
        BarcodeQRCode qrcode = new BarcodeQRCode(myString.trim(), 1, 1, null);
        Image qrcodeImage = null;
        try {
            qrcodeImage = qrcode.getImage();
        } catch (BadElementException e) {
            e.printStackTrace();
        }
//        qrcodeImage.setAbsolutePosition(10,500);
//        qrcodeImage.scalePercent(200);

        PdfPTable table = new PdfPTable(5);
        table.setWidths(new float[]{ 2f, 1.2f, 4.6f, 1.2f, 2f});
        table.setWidthPercentage(100);
        table.getDefaultCell().setBorderWidth(Rectangle.NO_BORDER);

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN,30);
        font.setColor(BaseColor.RED);
//        Font font2 = new Font(BaseFont.createFont("src/main/resources/font/VietFontsWeb1_ttf/vuArial.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED));

        FontFactory.register("/home/tran/Documents/Project/jv09-t-rex/src/main/webapp/resource/fonts/VietFontsWeb1_ttf/vuArial.ttf", "vuArial");
        Font font2 = FontFactory.getFont("vuArial", BaseFont.IDENTITY_H,
                BaseFont.EMBEDDED, 10);

        PdfPCell cell;
        cell = new PdfPCell(qrcodeImage, true);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setRowspan(6);
        cell.setBorderWidthLeft(2.5f);
        cell.setBorderWidthTop(2.5f);
        cell.setBorderWidthBottom(2.5f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("VÉ XE BUÝT", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(4);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Mã vé"));
        cell.setFixedHeight(20f);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthLeft(1f);
        cell.setBorderWidthTop(1f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(ticketEntity.getCodeTicket()));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthTop(1f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Ngày đi", font2));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthTop(1f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(ticketEntity.getBusesEntity().getDate().toString()));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthTop(1f);
        cell.setBorderWidthRight(1f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Điểm đi", font2));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthLeft(1f);
        cell.setFixedHeight(20f);
        table.addCell(cell);


        table.addCell(new Phrase(ticketEntity.getBusstationEntityDeparture().getAddress(), font2));
        table.addCell(new Phrase("Giời đi", font2));
        cell = new PdfPCell(new Phrase("12:04:08"));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthRight(1f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Điểm đến", font2));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthLeft(1f);
        cell.setFixedHeight(20f);
        table.addCell(cell);

        table.addCell(new Phrase(ticketEntity.getBusstationEntityArrival().getAddress(), font2));
        table.addCell(new Phrase("Giời điến", font2));

        cell = new PdfPCell(new Phrase("12:04:08"));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthRight(1f);
        table.addCell(cell);


        cell = new PdfPCell(new Phrase("Hãng xe", font2));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setFixedHeight(20f);
        cell.setBorderWidthLeft(1f);
        table.addCell(cell);

        table.addCell(new Phrase(ticketEntity.getBusesEntity().getTimeTableScheduleEntity().getScheduleEntity().getBusServicesEntity().getName(), font2));
        table.addCell(new Phrase("Biển số xe", font2));

        cell = new PdfPCell(new Phrase(ticketEntity.getBusesEntity().getTimeTableScheduleEntity().getBusEntity().getLicensePlate()));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthRight(1f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Họ Tên", font2));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthBottom(1f);
        cell.setBorderWidthLeft(1f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(ticketEntity.getFullName(), font2));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthBottom(1f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Số ghế", font2));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthBottom(1f);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(ticketEntity.getSeat(), font2));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidthRight(1f);
        cell.setBorderWidthBottom(1f);
        table.addCell(cell);


        document.add(table);
        document.close();
    }
}

