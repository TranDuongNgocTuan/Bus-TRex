package com.iviettech.bus.controller;

/**
 * Created by tran on 04/09/2016.
 */

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.iviettech.bus.entity.TicketEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static com.iviettech.bus.utils.CreaterTicketPdf.createDoc;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilderController extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        TicketEntity ticketEntity = (TicketEntity) request.getAttribute("ticketFinish");
        createDoc(doc, ticketEntity);
    }

}