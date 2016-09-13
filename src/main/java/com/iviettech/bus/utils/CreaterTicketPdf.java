package com.iviettech.bus.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.iviettech.bus.entity.TicketEntity;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by tran on 09/09/2016.
 */
public class CreaterTicketPdf {

    public static void createDoc(Document document, TicketEntity ticketEntity) throws DocumentException {
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

    public static void createPdf(OutputStream outputStream, TicketEntity ticketEntity) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, outputStream);
        createDoc(document, ticketEntity);
    }
}
