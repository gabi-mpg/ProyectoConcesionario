/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static utils.Utilidades.reescalarImagen;

import java.io.File;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class MNGDB {
    
    private Connection conexion;
    private boolean estado;
    public static final String RUTA_REC = System.getProperty("user.dir")+File.separator+
                           "Recourses"+File.separator;
    private  String bbdd,user,clave;

    public MNGDB(){
    }
    

    public boolean establecerConexion(){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conexion = DriverManager.getConnection(bbdd,user,clave);
        estado = true;
        crearBaseDatos();
        return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("no");
             estado = false;
             return false;
        }
    }
    
    
    
    public void crearBaseDatos(){
        if(!comprobarExsite("concesionario")){
            String[] opciones = {"Crear BBDD", "Salir del programa"};
            int n = JOptionPane.showOptionDialog(
                    null,
                    "Deseas crear una nueva BBDD?", 
                    "No se encuentra la BBDD", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                    reescalarImagen(new ImageIcon(RUTA_REC+"BBDDError.png"),30,30),
                    opciones,
                    opciones[0]);
            if(n == 0){
                try {
                PreparedStatement exe = conexion.prepareStatement("CREATE DATABASE Concesionario;");
                exe.executeUpdate();
                crearTablas();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }else{
                System.exit(0);
            }       
        }else{
            try {
                conexion.prepareStatement("use Concesionario;").executeUpdate();
            } catch (SQLException throwables) {
                System.out.println(throwables.getMessage());
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
                  + "nick varchar(30) not null primary key,"
                  + "Nombre varchar(20) not null,"
                  + "Apellidos varchar(40) not null,"
                  +"Contrasena varchar(15) not null,"
                  + "nivelPermiso char(1));");
            exe.executeUpdate();

            exe = conexion.prepareStatement(
                    "Create table t_ventas("
                            + "IDVenta int (10) AUTO_INCREMENT not null primary key,"
                            + "Matricula varchar(15) not null,"
                            + "DNI varchar(9),"
                            + "Precio decimal(10,2),"
                            + "IDVendedor varchar(30),"
                            + "foreign key (Matricula) references t_motos(Matricula),"
                            + "foreign key (DNI) references t_clientes(DNI),"
                            + "foreign key (IDVendedor) references t_usuarios(nick));");
            exe.executeUpdate();
            crearRegistros();
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void crearRegistros(){
        try{
            PreparedStatement exe = conexion.prepareStatement(
                    "INSERT INTO t_usuarios (nick,Nombre, Apellidos, Contrasena, nivelPermiso) VALUES" +
                    "('fenixabi','Gabriela','Mercado Pérez','gabriela123',1)," +
                    "('delcorral','Christian','Del Corral Remedios','delco123',1)," +
                    "('eduardo','Eduardo','Bethencourt Herrera','edu123',2)," +
                    "('invitado','-','-','1234',3);");
            exe.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
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
    public boolean cerrarConexion(){
        try {
            conexion.close();
            this.estado = false;
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public Connection getConexion(){
        return this.conexion;
    }

    
    
    public int iniciarSesion(String nombreUsuario, String contrasena){
        if(establecerConexion()){
            try {
                Statement s = conexion.createStatement();
                ResultSet r = s.executeQuery("SELECT contrasena,nivelPermiso from t_usuarios where nick='"+nombreUsuario+"'");
                if(r.next()) {
                    if(contrasena.equals(r.getString("Contrasena"))){
                        return r.getInt("nivelPermiso");
                    }else{
                        return 0;
                    }
                }else{
                    return -1;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return -2;
            }
        }else{
            return -4;
        }

    }

    public void setRegistros(String[] registros){
        this.bbdd = registros[0];
        this.user = registros[1];
        this.clave = registros[2];
    }


    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
