package com.joe.drone.service.pdfService;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.joe.drone.dto.response.BatteryResponse;
import com.joe.drone.service.Task;
import com.joe.drone.service.pdfService.PdfService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PdfServiceImpl implements PdfService {
        private List<BatteryResponse> batteryResponseList;
        private final Task task;
    @Override
    public void export(HttpServletResponse response) throws IOException {
        batteryResponseList = task.checkDronesBatteries();
        Document document = new Document(PageSize.A2);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Battery Report for all drones", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.5f, 2.5f, 2.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }

    private String formatDate(LocalDate localDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dateTimeFormatter.format(localDate);
    }

    private void writeTableData(PdfPTable table) {
        for (BatteryResponse batteryResponse : batteryResponseList) {
            table.addCell(String.valueOf(batteryResponse.getSerialNumber()));
            table.addCell(String.valueOf(batteryResponse.getDroneModel()));
            table.addCell(String.valueOf(batteryResponse.getBatteryLevel()));
        }

    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Serial Number", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Drone Model", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Battery Level", font));
        table.addCell(cell);
    }

}
