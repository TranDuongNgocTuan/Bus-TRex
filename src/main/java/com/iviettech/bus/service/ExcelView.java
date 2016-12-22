package com.iviettech.bus.service;

import com.iviettech.bus.entity.TicketEntity;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class ExcelView extends AbstractExcelView {
    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        List<TicketEntity> ticketEntityList = (List<TicketEntity>) model.get("tho");

        HSSFSheet sheet = workbook.createSheet("Tickets");
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Id");
        header.createCell(1).setCellValue("Full Name");
        header.createCell(2).setCellValue("Booked time");
        header.createCell(3).setCellValue("Number phone");
        header.createCell(4).setCellValue("Total price");
        header.createCell(5).setCellValue("Seat");
        header.createCell(6).setCellValue("Number seats");
        header.createCell(7).setCellValue("Gmail");
        header.createCell(8).setCellValue("Bus station arrival");
        header.createCell(9).setCellValue("Bus station departure");
        header.createCell(10).setCellValue("Code ticket");

        int rowNum = 1;
        for (TicketEntity ticketEntity : ticketEntityList) {
            HSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(ticketEntity.getId());
            row.createCell(1).setCellValue(ticketEntity.getFullName());
            row.createCell(2).setCellValue(ticketEntity.getBookTime());
            row.createCell(3).setCellValue(ticketEntity.getNumberphone());
            row.createCell(4).setCellValue(ticketEntity.getTotalprice());
            row.createCell(5).setCellValue(ticketEntity.getSeat());
            row.createCell(6).setCellValue(ticketEntity.getNumberSeats());
            row.createCell(7).setCellValue(ticketEntity.getGmail());
            row.createCell(8).setCellValue(ticketEntity.getBusstationEntityArrival().getName());
            row.createCell(6).setCellValue(ticketEntity.getBusstationEntityDeparture().getName());
            row.createCell(7).setCellValue(ticketEntity.getCodeTicket());
        }

    }
}
