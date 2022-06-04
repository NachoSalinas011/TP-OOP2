package com.springboot.clienteapp.util;
import com.lowagie.text.*; 
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.springboot.clienteapp.models.entity.Perfil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

@Component("/views/perfiles/listarPerfil")
public class ListarPerfilPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document, com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked")
        List<Perfil> listaPerfiles = (List<Perfil>) model.get("perfiles");

        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-20, -20, 40,20);
        document.open();

        PdfPTable tablaTitulo = new PdfPTable(1);
        PdfPCell celda = null;


        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.white);
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,12,Color.BLACK);
        Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);


        celda = new PdfPCell(new Phrase("LISTADO PERFILES", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(142,39,54));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(30);
        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        PdfPTable tablaPerfil = new PdfPTable(2);
        tablaPerfil.setWidths(new float[]{0.8f,2f});

        celda = new PdfPCell(new Phrase("ID",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPerfil.addCell(celda);

        celda = new PdfPCell(new Phrase("PERFILES",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPerfil.addCell(celda);

       for (Perfil perfil:listaPerfiles){

           celda = new PdfPCell(new Phrase(perfil.getId_perfil().toString(),fuenteDataCeldas));
           celda.setPadding(5);
           tablaPerfil.addCell(celda);

           celda = new PdfPCell(new Phrase(perfil.getNombrePerfil(),fuenteDataCeldas));
           celda.setPadding(5);
           tablaPerfil.addCell(celda);


       }
        document.add(tablaTitulo);
        document.add(tablaPerfil);
    }
}
