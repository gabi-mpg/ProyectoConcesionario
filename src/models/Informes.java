package models;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controllers.VentaCRUD;
import entidades.Moto;
import entidades.Venta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que recoge toda la logica para crear los informes (informes incrustados) de la aplicacion.
 */
public class Informes {

    Document informe;
    VentaCRUD cnVentas;

    /**
     * Constructor de la clase en el que asignamos valores a las variables de la misma y llamamos
     * al metodo que agrega los headers al documento de informe.
     * @param cnVentas Recibe una instancia del Controller de Ventas
     * @param tipoInforme Parametro que indica el tipo de informe a generar.
     * @param rutaPDF Ruta donde se guardara el documento.
     */
    public Informes(VentaCRUD cnVentas, String tipoInforme, String rutaPDF){
        this.informe = new Document();
        this.cnVentas = cnVentas;
        agregarHeader(tipoInforme, rutaPDF);
    }

    /**
     * Metodo que crea el informe en la ruta establecida, genera el nombre usando el tipo de informe dado, abre el documneto y le agrega el Header al informe.
     * Luego crea el Header, agregandole la foto.
     * @param tipoInforme Recibe el tipo de informe a generar.
     * @param rutaPDF Ruta donde se creara el informe.
     */
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

    }

    /**
     * Metodo que genera un informe general de ventas, mostrando todos los datos de todas las ventas. Para ello agrega la fila con los tipos
     * de datos y luego fila a fila todas las ventas.
     * @return Devuelve un boolean segun el exito de la accion.
     */
    public boolean generarInformeVentas(){
        try{
            ArrayList<Venta> listaVentas = cnVentas.getListaVentas();

            float[] anchosTablaDatos = {150, 150, 150, 150, 150};
            PdfPTable tablaDatos = new PdfPTable(anchosTablaDatos);

            Paragraph espacios = new Paragraph("\n");

            Paragraph p_titulo = new Paragraph("VENTAS GENERAL",
                    FontFactory.getFont("Times New Roman", 14, BaseColor.BLACK));
            p_titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_IDVenta = new Paragraph("ID Venta", FontFactory.getFont("Times New Roman", 9, BaseColor.RED));
            p_n_IDVenta.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Matricula = new Paragraph("Matricula", FontFactory.getFont("Times New Roman", 9, BaseColor.RED));
            p_n_Matricula.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_DNI = new Paragraph("Comprador", FontFactory.getFont("Times New Roman", 9, BaseColor.RED));
            p_n_DNI.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Vendedor = new Paragraph("Vendedor", FontFactory.getFont("Times New Roman", 9, BaseColor.RED));
            p_n_Vendedor.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Precio = new Paragraph("Precio", FontFactory.getFont("Times New Roman", 9, BaseColor.RED));
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

    /**
     * Metodo que genera un informe de ventas hechas a un cliente dado, mostrando los datos de las ventas que se han hecho a ese cliente. Para ello agrega la fila con los tipos
     * de datos y luego fila a fila todas las ventas de una lista filtrada.
     * @param DNI Recibe el dni del cliente del que se quieren recoger las ventas que se le han hecho.
     * @return Devuelve un boolean segun el exito de la accion.
     */
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
            String titulo = "VENTAS DEL CLIENTE CON DNI " + DNI;
            Paragraph p_titulo = new Paragraph(titulo, FontFactory.getFont("Times New Roman", 14, BaseColor.BLACK));
            p_titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_IDVenta = new Paragraph("ID Venta", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_IDVenta.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Matricula = new Paragraph("Matricula", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
            p_n_Matricula.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_DNI = new Paragraph("Comprador", FontFactory.getFont("Times New Roman", 9, BaseColor.BLUE));
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

    /**
     * Metodo que genera un informe de ventas segun una marca dada, mostrando los datos de las ventas quese han realizado de esa marca. Para ello agrega la fila con los tipos
     * de datos y luego fila a fila todas las ventas de una lista filtrada.
     * @param marca Recibe la marca de moto de la que se quieren recoger las ventas.
     * @return Devuelve un boolean segun el exito de la accion.
     */
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

            //Collections.sort(listaVentasFiltrada, new Venta());

            float[] anchosTablaDatos = {150, 150, 150, 150, 150};
            PdfPTable tablaDatos = new PdfPTable(anchosTablaDatos);

            Paragraph espacios = new Paragraph("\n");
            String titulo = "VENTAS DE MOTOS " + marca.toUpperCase();
            Paragraph p_titulo = new Paragraph(titulo, FontFactory.getFont("Times New Roman", 14, BaseColor.DARK_GRAY));
            p_titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_IDVenta = new Paragraph("ID Venta", FontFactory.getFont("Times New Roman", 9, BaseColor.DARK_GRAY));
            p_n_IDVenta.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Matricula = new Paragraph("Matricula", FontFactory.getFont("Times New Roman", 9, BaseColor.DARK_GRAY));
            p_n_Matricula.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_DNI = new Paragraph("Comprador", FontFactory.getFont("Times New Roman", 9, BaseColor.DARK_GRAY));
            p_n_DNI.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Vendedor = new Paragraph("Vendedor", FontFactory.getFont("Times New Roman", 9, BaseColor.DARK_GRAY));
            p_n_Vendedor.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Precio = new Paragraph("Precio", FontFactory.getFont("Times New Roman", 9, BaseColor.DARK_GRAY));
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

    /**
     * Metodo que genera un informe de ventas segun un usuario dado, mostrando los datos de las ventas que ha realizado ese usaurio. Para ello agrega la fila con los tipos
     * de datos y luego fila a fila todas las ventas de una lista filtrada.
     * @param nick Recibe el nick del usaurio del que se quieren recoger las ventas.
     * @return Devuelve un boolean segun el exito de la accion.
     */
    public boolean generarInformeVentasUsuario(String nick){
        try{
            ArrayList<Venta> listaVentas = cnVentas.getListaVentas();
            ArrayList<Venta> listaVentasFiltrada = new ArrayList<>();

            for (Venta v : listaVentas){
                if (v.getIdVendedor().equalsIgnoreCase(nick)){
                    listaVentasFiltrada.add(v);
                }
            }

            //Collections.sort(listaVentasFiltrada, new Venta());

            float[] anchosTablaDatos = {100, 100, 100, 100, 100};
            PdfPTable tablaDatos = new PdfPTable(anchosTablaDatos);

            Paragraph espacios = new Paragraph("\n");

            String titulo = "VENTAS DEL/LA VENDEDOR/A " + nick.toUpperCase();
            Paragraph p_titulo = new Paragraph(titulo, FontFactory.getFont("Times New Roman", 14, BaseColor.MAGENTA));
            p_titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_IDVenta = new Paragraph("ID Venta", FontFactory.getFont("Times New Roman", 9, BaseColor.MAGENTA));
            p_n_IDVenta.setAlignment(Element.ALIGN_MIDDLE);

            Paragraph p_n_Matricula = new Paragraph("Matricula", FontFactory.getFont("Times New Roman", 9, BaseColor.MAGENTA));
            p_n_Matricula.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_DNI = new Paragraph("nick", FontFactory.getFont("Times New Roman", 9, BaseColor.MAGENTA));
            p_n_DNI.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Vendedor = new Paragraph("Vendedor", FontFactory.getFont("Times New Roman", 9, BaseColor.MAGENTA));
            p_n_Vendedor.setAlignment(Element.ALIGN_CENTER);

            Paragraph p_n_Precio = new Paragraph("Precio", FontFactory.getFont("Times New Roman", 9, BaseColor.MAGENTA));
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
