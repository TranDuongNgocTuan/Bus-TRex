package com.iviettech.bus.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.iviettech.bus.entity.TicketEntity;

public class PDFBuilder extends AbstractITextPdfView{
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container

        List<TicketEntity> listTickets = (List<TicketEntity>) model.get("tho");

        doc.add(new Paragraph("Ticket Information"));

        doc.setPageSize(PageSize.A3.rotate());

        PdfPTable table = new PdfPTable(11);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{2.0f, 3.0f, 4.0f, 4.0f, 3.0f, 3.0f, 3.0f, 3.0f, 4.0f, 4.0f, 3.0f});
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);



        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(11);


        // write table header
        cell.setPhrase(new Phrase("Id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Full Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Booked time", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Number phone", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Total price", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Seat", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Number seats", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Gmail", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Bus station arrival", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Bus station departure", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Code ticket", font));
        table.addCell(cell);

        // write table row data
        for (TicketEntity aTicket : listTickets) {
            table.addCell(String.valueOf(aTicket.getId()));
            table.addCell(aTicket.getFullName());
            table.addCell(String.valueOf(aTicket.getBookTime()));
            table.addCell(aTicket.getNumberphone());
            table.addCell(String.valueOf(aTicket.getTotalprice()));
            table.addCell(aTicket.getSeat());
            table.addCell(String.valueOf(aTicket.getNumberSeats()));
            table.addCell(aTicket.getGmail());
            table.addCell(aTicket.getBusstationEntityArrival().getName());
            table.addCell(aTicket.getBusstationEntityDeparture().getName());
            table.addCell(aTicket.getCodeTicket());
        }

        doc.add(table);


    }

}
