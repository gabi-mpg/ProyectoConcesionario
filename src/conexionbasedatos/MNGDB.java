/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbasedatos;

import static conexionbasedatos.Utilidades.reescalarImagen;
import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class MNGDB {
    
    private Connection conexion;
    private boolean estado;
    private Component padre;
    private final String RUTA_REC = System.getProperty("user.dir")+File.separator+
                           "Recourses"+File.separator;
    
    public MNGDB(Component padre){
        this.padre = padre;
        establecerConexion();
        if(estado){
          crearBaseDatos();
            System.out.println("wololooo");
            System.out.println("holiaaaa");
            System.out.println("hollaa gabilondaaaaaa aki adnamo weyando");
        }
    }
    
    
    
    public void establecerConexion(){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionURL = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String clave = "pass123";
        this.conexion = DriverManager.getConnection(connectionURL,usuario,clave);
        estado = true;
            System.out.println("conecteado");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            System.out.println("no");
             estado = false;
        }
    }
    
    
    
    public void crearBaseDatos(){
        if(!comprobarExsite("Concesionario")){
            String[] opciones = {"Crear BBDD", "Salir del programa"};
            int n = JOptionPane.showOptionDialog(
                    padre, 
                    "Deseas crear una nueva BBDD?", 
                    "No se encuentra la BBDD", 0, 0,
                    reescalarImagen(new ImageIcon(RUTA_REC+"BBDDError.png"),30,30),
                    opciones,
                    opciones[0]);
            if(n == 0){
                try {
                PreparedStatement exe = conexion.prepareStatement("CREATE DATABASE Concesionario;");
                exe.executeUpdate();
                crearTablas();
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }else{
                System.exit(0);
            }       
        }
    }
    
    public void crearTablas(){
        try {
          conexion.prepareStatement("use Concesionario;").executeUpdate();
          PreparedStatement exe = conexion.prepareStatement(
                   "CREATE TABLE t_clientes("
                  + "DNI varchar(9) primary key,"
                  + "Nombre varchar(30),"
                  + "Apellido varchar(30),"
                  + "Direcccion varchar(30));");
          exe.executeUpdate();
          
          exe = conexion.prepareStatement(
                  "CREATE TABLE t_motos("
                  + "Matricula varchar(15) not null primary key,"
                  + "Marca varchar(30) not null,"
                  + "Color varchar(15),"
                  + "Tanque tinyint);");
          exe.executeUpdate();
            
            exe = conexion.prepareStatement(
                  "Create table t_usuarios("
                  + "Nombre varchar(30) not null,"
                          +"Contrasena varchar(15) not null,"
                  + "IDUsuario int(3) AUTO_INCREMENT primary key,"
                  + "nivelPermiso char(1));");
            exe.executeUpdate();

            exe = conexion.prepareStatement(
                    "Create table t_ventas("
                            + "IDVenta int (10) AUTO_INCREMENT not null primary key,"
                            + "Matricula varchar(15) not null,"
                            + "DNI varchar(9),"
                            + "Precio decimal(10,2),"
                            + "IDVendedor int(3),"
                            + "foreign key (Matricula) references t_motos(Matricula),"
                            + "foreign key (DNI) references t_clientes(DNI),"
                            + "foreign key (IDVendedor) references t_usuarios(IDUsuario));");
            exe.executeUpdate();
            crearRegistros();
          
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void crearRegistros(){
        try{
            PreparedStatement exe = conexion.prepareStatement(
                    "INSERT INTO t_usuarios (Nombre, Contrasena, nivelPermiso) VALUES" +
                    " ('fenixabi','gabriela123',1)," +
                    "('delcorral','delco123',1)," +
                    "('eduardo','edu123',2)," +
                    "('invitado','1234',3);");
            exe.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    public boolean comprobarExsite(String nombreDatabase){
        try{
        PreparedStatement ps;
        ResultSet rs;

        ps = conexion.prepareStatement("show databases");
        rs = ps.executeQuery();

        while (rs.next()) {                
            if (rs.getString(1).equals(nombreDatabase)) {
                return true;
            }
        }
        return false;
    }catch (SQLException ex) {
        System.out.println("error: " + ex);
        return false;
        }
    }
    
    /**
     * 
     * @return True si se cierra la conexión
     * False si no se cierra o ya estaba cerrada
     */
    public void cerrarConexion(){
        try {
            conexion.close();
            this.estado = false;
        } catch (SQLException ex) {
            Logger.getLogger(MNGDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @return True si la conexión está cerrada, false si está abierta
     */
    public boolean estado(){
       return this.estado;
    }
    
    
    
    public void testQuery(String consulta){
        try {
            PreparedStatement s = conexion.prepareStatement(consulta);
            ResultSet r = s.executeQuery();
            //Cambiar al tipo de dato que vamos a recoger
            System.out.println("ID\tPropietario\tAnimal\tRaza");
            while(r.next()){
                System.out.print(r.getInt(1)+"\t");
                System.out.print(r.getString(2)+"\t\t");
                System.out.print(r.getString(3)+"\t");
                System.out.print(r.getString(4)+"\n");
                
            }
       
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
}
