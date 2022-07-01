package com.java.util;



import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.Model.entidades.Servicio;
import com.java.service.ServicioService;
import com.java.service.impl.ServicioServiceImpl;


import javax.servlet.ServletContext;
import java.io.FileOutputStream;
import java.util.List;

public class Reporteador {

    public Reporteador() {
    }

    public void generaPDF(String nombre, ServletContext contexto) {
        try {

            //---------------------------------------------------------------------------------------------------------------------
            Document document = new Document(PageSize.A4, 20, 20, 20, 20);
            //document.set
            String ruta = contexto.getRealPath("/");//ruta de los JSPs

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "/reporte.pdf"));

            System.out.println(ruta + "reporte.pdf");
            document.open();
            float[] widths = {0.50f, 0.95f, 0.95f,0.95f,0.95f,0.95f,0.95f};
            float[] cabecera = {1.20f, 0.23f, 0.20f};
            float[] rotulo = {1.00f};
            float[] footer = {0.27f, 0.70f, 0.13f, 0.13f, 0.2f, 0.2f};

            Paragraph p = null;
            PdfPTable table = null;
            PdfPCell cell = null;

            Font negrita = FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK);
            Font text = FontFactory.getFont("Arial", 9, Font.NORMAL, BaseColor.BLACK);
            Font normal = FontFactory.getFont("Arial", 10, Font.NORMAL, BaseColor.BLACK);

            Font linea = FontFactory.getFont("Arial", 10, Font.UNDERLINE, BaseColor.BLACK);
            /**
             * ***Insertando imagenes al PDF *************
             */
            Image logo = Image.getInstance(ruta + "/img/logo1.jpg");
           logo.scaleAbsolute(45, 50);
           logo.setAbsolutePosition(540, 790);
            document.add(logo);

            p = new Paragraph("                                                                       ");
            document.add(p);
            document.add(p);

            table = new PdfPTable(cabecera);

            p = new Paragraph("Señores", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph(nombre);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);
            document.add(table);
            //---------------------------------------------------------
            table = new PdfPTable(rotulo);

            p = new Paragraph("Listado de Servicios Pendientes :", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            table.setTotalWidth(533);
            table.setLockedWidth(true);

            document.add(table);

            p = new Paragraph("                                                                       ");
            document.add(p);

            //---------------------------------------------------------
            table = new PdfPTable(widths);

            //Codigo
            p = new Paragraph("Codigo", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);

            //Nombres
            p = new Paragraph("Fecha y Hora", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);

            //Total a  Pa
            p = new Paragraph("Nombre Cliente", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);

            p = new Paragraph("Direccion", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);

            p = new Paragraph("Telefono", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);
            document.add(table);

            p = new Paragraph("Electro", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);
            document.add(table);

            p = new Paragraph("Tecnico", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);
            document.add(table);
            p = new Paragraph("                                                                       ");
            document.add(p);

            //---------------------------------------------------------------------------------------------------
            ServicioService list= new ServicioServiceImpl();
            List<Servicio> xlist=list.mostrar();


            for (int i = 0; i < xlist.size(); i++) {
                table = new PdfPTable(widths);

                //Codigo
                p = new Paragraph(String.valueOf( ((xlist.get(i))).getIdServicio()), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //Nombres
                p = new Paragraph((xlist.get(i)).getFecha()+" "+(xlist.get(i)).getHora(), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //Nombre
                p = new Paragraph(String.valueOf( ((xlist.get(i))).getElectrodomestico().getCliente().getNombre()), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //Direccion
                p = new Paragraph(String.valueOf( ((xlist.get(i))).getElectrodomestico().getCliente().getDireccion()), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //Telefono
                p = new Paragraph(String.valueOf( ((xlist.get(i))).getElectrodomestico().getCliente().getTelefono()), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //Electro
                p = new Paragraph(String.valueOf( ((xlist.get(i))).getElectrodomestico().getNombre()), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);


                //Tecnico
                p = new Paragraph(String.valueOf( ((xlist.get(i))).getHorarioTecnico().getTecnico().getNombre()), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                document.add(table);

            }

            //-------------------------------------------------------------------------------
            p = new Paragraph("                                                                       ");
            document.add(p);

            table = new PdfPTable(footer);
            p = new Paragraph("Atentamente,     ", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            table.setTotalWidth(533);
            table.setLockedWidth(true);

            document.add(table);

            document.close();

            //---------------------------------------------------------------------------------------------------------------------
        } catch (Exception de) {

            System.out.println("error: " + de.toString());
        }

    }

}
