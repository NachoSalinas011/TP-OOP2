package com.springboot.clienteapp.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springboot.clienteapp.models.entity.Perfil;
import com.springboot.clienteapp.models.entity.Usuario;

@Component("/views/usuarios/listar")
public class ListarUsuarioPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
        List<Usuario> listaUsuario = (List<Usuario>) model.get("usuarios");
		
		document.setPageSize(PageSize.LETTER.rotate());
	    document.setMargins(-20, -20, 40,20);
	    document.open();

	    PdfPTable tablaTitulo = new PdfPTable(1);
	    PdfPCell celda = null;
	    
	    Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.white);
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,12,Color.BLACK);
        Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);
        
        celda = new PdfPCell(new Phrase("LISTADO USUARIOS", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(142,39,54));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(30);
        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);
        
        PdfPTable tablaUsuario = new PdfPTable(10);
        tablaUsuario.setWidths(new float[]{0.8f,2f,	2f,2f,2f,2f,2f,2f,2f,2f});
        
        celda = new PdfPCell(new Phrase("ID",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaUsuario.addCell(celda);
        
        celda = new PdfPCell(new Phrase("NOMBRES",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaUsuario.addCell(celda);
        
        celda = new PdfPCell(new Phrase("APELLIDOS",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaUsuario.addCell(celda);
        
        celda = new PdfPCell(new Phrase("TIPO DOC",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaUsuario.addCell(celda);
        
        celda = new PdfPCell(new Phrase("NRO DOC",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaUsuario.addCell(celda);
        
        celda = new PdfPCell(new Phrase("CORREO",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaUsuario.addCell(celda);
        
        celda = new PdfPCell(new Phrase("USUARIO",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaUsuario.addCell(celda);
        
        celda = new PdfPCell(new Phrase("PERFIL",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaUsuario.addCell(celda);
        
        for (Usuario usuario:listaUsuario){

            celda = new PdfPCell(new Phrase(usuario.getIdUsuario().toString(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaUsuario.addCell(celda);

            celda = new PdfPCell(new Phrase(usuario.getNombre(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaUsuario.addCell(celda);
            
            celda = new PdfPCell(new Phrase(usuario.getApellido(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaUsuario.addCell(celda);
            
            celda = new PdfPCell(new Phrase(usuario.getTipoDoc(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaUsuario.addCell(celda);
            
            celda = new PdfPCell(new Phrase(usuario.getNroDoc(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaUsuario.addCell(celda);
            
            celda = new PdfPCell(new Phrase(usuario.getCorreo(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaUsuario.addCell(celda);
            
            celda = new PdfPCell(new Phrase(usuario.getNombreUsuario(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaUsuario.addCell(celda);
            
            celda = new PdfPCell(new Phrase(usuario.getPerfil().getNombrePerfil(),fuenteDataCeldas));
            celda.setPadding(5);
            tablaUsuario.addCell(celda);
       


        }
        
        document.add(tablaTitulo);
        document.add(tablaUsuario);
        
     
	}

}
