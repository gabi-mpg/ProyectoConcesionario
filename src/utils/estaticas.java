package utils;

import java.io.File;

public class estaticas {

    //Variable que almacena la ruta de la carpeta de imágenes
    public static final String RUTA_IMAGENES = System.getProperty("user.dir")+
            File.separator+"src"+File.separator+"views"+File.separator
            +"imagenes"+ File.separator;

    //Variables para identificar paneles en mainInterface
    public static final String PANEL_USUARIO = "usuario";
    public static final String PANEL_CLIENTE = "cliente";
    public static final String PANEL_MOTO = "moto";
    public static final String PANEL_VENTA = "venta";

}
