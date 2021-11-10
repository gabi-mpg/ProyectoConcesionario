package modelo;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controllers.VentaCRUD;
import entidades.Moto;
import entidades.Venta;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;

import com.itextpdf.text.*;

public class Informes {

    Document informe;
    VentaCRUD cnVentas;

    public Informes(VentaCRUD cnVentas, String tipoInforme, String rutaPDF){
        this.informe = new Document();
        this.cnVentas = cnVentas;
        agregarHeader(tipoInforme, rutaPDF);
    }

    private void agregarHeader(String tipoInforme, String rutaPDF){
        String ruta = rutaPDF + File.separator + tipoInforme + ".pdf";
        try {
            PdfWriter.getInstance(informe, new FileOutputStream(ruta));
            informe.open();
            String rutaImg = System.getProperty("user.dir")+
                    File.separator+"src"+File.separator+"views"+File.separator
                    +"Imagenes"+ File.separator + "imagenLogo.png";
            Image header = Image.getInstance(rutaImg);
            header.scaleToFit(300, 320);
            header.setAlignment(Chunk.ALIGN_LEFT);
            informe.add(header);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }//ventas, ventasclientes, ventasmarca, ventasusuario

    public boolean generarInformeVentas(){
        try{
            ArrayList<Venta> listaVentas = cnVentas.getListaVentas();

            float[] anchosTablaDatos = {150, 150, 150, 150, 150};
            PdfPTable tablaDatos = new PdfPTable(anchosTablaDatos);

            Paragraph espacios = new Paragraph("\n");

            Paragraph p_titulo = new Paragraph("VENTAS", FontFactory.getFont("Times New Roman", 14, BaseColor.BLACK));
            p_titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_IDVenta = new Paragraph("ID Venta", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_IDVenta.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Matricula = new Paragraph("Matricula", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Matricula.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_DNI = new Paragraph("DNI", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_DNI.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Vendedor = new Paragraph("Vendedor", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Vendedor.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Precio = new Paragraph("Precio", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Precio.setAlignment(Element.ALIGN_CENTER);

            tablaDatos.addCell(p_n_IDVenta);
            tablaDatos.addCell(p_n_Matricula);
            tablaDatos.addCell(p_n_DNI);
            tablaDatos.addCell(p_n_Vendedor);
            tablaDatos.addCell(p_n_Precio);

            for(Venta v : listaVentas){
                tablaDatos.addCell(String.valueOf(v.getIdVenta()));
                tablaDatos.addCell(v.getMatricula());
                tablaDatos.addCell(v.getDni());
                tablaDatos.addCell(v.getIdVendedor());
                tablaDatos.addCell(String.valueOf(v.getPrecio()));
            }

            try {
                informe.add(espacios);
                informe.add(espacios);
                informe.add(p_titulo);
                informe.add(espacios);
                informe.add(espacios);
                informe.add(tablaDatos);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            informe.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean generarInformeVentasClientes(String DNI){
        try{
            ArrayList<Venta> listaVentas = cnVentas.getListaVentas();
            ArrayList<Venta> listaVentasFiltrada = new ArrayList<>();

            for (Venta v : listaVentas){
                if (v.getDni().equalsIgnoreCase(DNI)){
                    listaVentasFiltrada.add(v);
                }
            }

            float[] anchosTablaDatos = {150, 150, 150, 150, 150};
            PdfPTable tablaDatos = new PdfPTable(anchosTablaDatos);

            Paragraph espacios = new Paragraph("\n");

            Paragraph p_titulo = new Paragraph("VENTAS", FontFactory.getFont("Times New Roman", 14, BaseColor.BLACK));
            p_titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_IDVenta = new Paragraph("ID Venta", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_IDVenta.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Matricula = new Paragraph("Matricula", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Matricula.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_DNI = new Paragraph("DNI", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_DNI.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Vendedor = new Paragraph("Vendedor", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Vendedor.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Precio = new Paragraph("Precio", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Precio.setAlignment(Element.ALIGN_CENTER);

            tablaDatos.addCell(p_n_IDVenta);
            tablaDatos.addCell(p_n_Matricula);
            tablaDatos.addCell(p_n_DNI);
            tablaDatos.addCell(p_n_Vendedor);
            tablaDatos.addCell(p_n_Precio);

            for(Venta v : listaVentasFiltrada){
                tablaDatos.addCell(String.valueOf(v.getIdVenta()));
                tablaDatos.addCell(v.getMatricula());
                tablaDatos.addCell(v.getDni());
                tablaDatos.addCell(v.getIdVendedor());
                tablaDatos.addCell(String.valueOf(v.getPrecio()));
            }

            try {
                informe.add(espacios);
                informe.add(espacios);
                informe.add(p_titulo);
                informe.add(espacios);
                informe.add(espacios);
                informe.add(tablaDatos);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            informe.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean generarInformeVentasMarca(String marca){
        try{
            ArrayList<Venta> listaVentas = cnVentas.getListaVentas();
            ArrayList<Venta> listaVentasFiltrada = new ArrayList<>();

            for (Venta v : listaVentas){
                Moto moto = cnVentas.buscarMoto(v.getMatricula());
                if (moto.getMarca().equalsIgnoreCase(marca)){
                    listaVentasFiltrada.add(v);
                }
            }

            float[] anchosTablaDatos = {150, 150, 150, 150, 150};
            PdfPTable tablaDatos = new PdfPTable(anchosTablaDatos);

            Paragraph espacios = new Paragraph("\n");

            Paragraph p_titulo = new Paragraph("VENTAS", FontFactory.getFont("Times New Roman", 14, BaseColor.BLACK));
            p_titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_IDVenta = new Paragraph("ID Venta", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_IDVenta.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Matricula = new Paragraph("Matricula", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Matricula.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_DNI = new Paragraph("marca", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_DNI.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Vendedor = new Paragraph("Vendedor", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Vendedor.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Precio = new Paragraph("Precio", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Precio.setAlignment(Element.ALIGN_CENTER);

            tablaDatos.addCell(p_n_IDVenta);
            tablaDatos.addCell(p_n_Matricula);
            tablaDatos.addCell(p_n_DNI);
            tablaDatos.addCell(p_n_Vendedor);
            tablaDatos.addCell(p_n_Precio);

            for(Venta v : listaVentasFiltrada){
                tablaDatos.addCell(String.valueOf(v.getIdVenta()));
                tablaDatos.addCell(v.getMatricula());
                tablaDatos.addCell(v.getDni());
                tablaDatos.addCell(v.getIdVendedor());
                tablaDatos.addCell(String.valueOf(v.getPrecio()));
            }

            try {
                informe.add(espacios);
                informe.add(espacios);
                informe.add(p_titulo);
                informe.add(espacios);
                informe.add(espacios);
                informe.add(tablaDatos);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            informe.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean generarInformeVentasUsuario(String nick){
        try{
            ArrayList<Venta> listaVentas = cnVentas.getListaVentas();
            ArrayList<Venta> listaVentasFiltrada = new ArrayList<>();

            for (Venta v : listaVentas){
                if (v.getIdVendedor().equalsIgnoreCase(nick)){
                    listaVentasFiltrada.add(v);
                }
            }

            float[] anchosTablaDatos = {150, 150, 150, 150, 150};
            PdfPTable tablaDatos = new PdfPTable(anchosTablaDatos);

            Paragraph espacios = new Paragraph("\n");

            Paragraph p_titulo = new Paragraph("VENTAS", FontFactory.getFont("Times New Roman", 14, BaseColor.BLACK));
            p_titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_IDVenta = new Paragraph("ID Venta", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_IDVenta.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Matricula = new Paragraph("Matricula", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Matricula.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_DNI = new Paragraph("nick", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_DNI.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Vendedor = new Paragraph("Vendedor", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Vendedor.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Precio = new Paragraph("Precio", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Precio.setAlignment(Element.ALIGN_CENTER);

            tablaDatos.addCell(p_n_IDVenta);
            tablaDatos.addCell(p_n_Matricula);
            tablaDatos.addCell(p_n_DNI);
            tablaDatos.addCell(p_n_Vendedor);
            tablaDatos.addCell(p_n_Precio);

            for(Venta v : listaVentasFiltrada){
                tablaDatos.addCell(String.valueOf(v.getIdVenta()));
                tablaDatos.addCell(v.getMatricula());
                tablaDatos.addCell(v.getDni());
                tablaDatos.addCell(v.getIdVendedor());
                tablaDatos.addCell(String.valueOf(v.getPrecio()));
            }

            try {
                informe.add(espacios);
                informe.add(espacios);
                informe.add(p_titulo);
                informe.add(espacios);
                informe.add(espacios);
                informe.add(tablaDatos);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            informe.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
