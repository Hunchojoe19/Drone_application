package com.joe.drone.service.pdfService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface PdfService {
    void export(HttpServletResponse httpServletResponse) throws IOException;
}
