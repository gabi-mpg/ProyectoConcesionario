/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static utils.Utilidades.reescalarImagen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    

    public boolean establecerConexionComprobar(){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conexion = DriverManager.getConnection(bbdd,user,clave);
        estado = true;
        crearBaseDatos();
        return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
             estado = false;
             return false;
        }
    }

    public Connection conectar(){
        try{
            String[] valores = new config().getConfig();
            conexion = DriverManager.getConnection(valores[0], valores[1], valores[2]);
            crearBaseDatos();
            return conexion;
        }catch(SQLException e){
            System.err.println("Error en la conexión local " + e);
        }
        return null;
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
                crearTablas();
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
    
    public boolean crearTablas(){
        try {
            conexion.setAutoCommit(false);
            PreparedStatement exe = conexion.prepareStatement("CREATE DATABASE Concesionario;");
            exe.executeUpdate();
            conexion.prepareStatement("use Concesionario;").executeUpdate();
            exe = conexion.prepareStatement(
                    "CREATE TABLE t_clientes("
                            + "DNI varchar(9) primary key,"
                            + "Nombre varchar(30),"
                            + "Apellido varchar(30),"
                            + "Direccion varchar(30),"
                            + "existe tinyint);");
            exe.executeUpdate();

            exe = conexion.prepareStatement(
                    "CREATE TABLE t_motos("
                            + "Matricula varchar(15) not null primary key,"
                            + "Marca varchar(30) not null,"
                            + "Color varchar(15),"
                            + "Tanque tinyint," +
                            "existe tinyint);");
            exe.executeUpdate();

            exe = conexion.prepareStatement(
                    "Create table t_usuarios("
                            + "nick varchar(30) not null primary key,"
                            + "Nombre varchar(20) not null,"
                            + "Apellidos varchar(40) not null,"
                            +"Contrasena varchar(15) not null,"
                            + "nivelPermiso char(1)," +
                            "existe tinyint);");
            exe.executeUpdate();

            exe = conexion.prepareStatement(
                    "Create table t_ventas("
                            + "IDVenta int (10) AUTO_INCREMENT not null,"
                            + "Matricula varchar(15) not null,"
                            + "DNI varchar(9),"
                            + "Precio decimal(10,2),"
                            + "IDVendedor varchar(30), "
                            + "existe bit(1),"
                            + "foreign key (Matricula) references t_motos(Matricula),"
                            + "foreign key (DNI) references t_clientes(DNI),"
                            + "foreign key (IDVendedor) references t_usuarios(nick),"
                            + "constraint pk_venta primary key (IDVenta,Matricula));");
            exe.executeUpdate();
            conexion.commit();
            crearRegistros();
            conexion.setAutoCommit(true);
            return true;

        } catch (SQLException ex) {
            if (conexion != null){
                System.out.println(ex.getMessage());
                System.out.println(ex.getLocalizedMessage());
                System.out.println(ex.getErrorCode());
                try {
                    conexion.rollback();
                    conexion.setAutoCommit(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return false;
        }
    }

    public boolean crearRegistros(){
        try{
            conexion.setAutoCommit(false);
            PreparedStatement exe = conexion.prepareStatement(
                    "INSERT INTO t_usuarios (nick,Nombre, Apellidos, Contrasena, nivelPermiso, existe) VALUES" +
                    "('fenixabi','Gabriela','Mercado Pérez','gabriela123',1,1)," +
                    "('delcorral','Christian','Del Corral Remedios','delco123',1,1)," +
                    "('eduardo','Eduardo','Bethencourt Herrera','edu123',2,1)," +
                    "('invitado','-','-','1234',3,1)");
            exe.executeUpdate();
            conexion.commit();
            conexion.setAutoCommit(true);

            return crearProcedures() && insertarDatos();

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
                conexion.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        }
    }

    private boolean crearProcedures(){
        String ruta = System.getProperty("user.dir") + File.separator + "PROCEDURES.txt";
        File inserts = new File(ruta);
        FileReader fr;
        BufferedReader br;
        String separador;
        String line;
        String todo = "";
        String[] procedures;
        try {
            fr = new FileReader(inserts);
            br = new BufferedReader(fr);
            separador = "\\*";
            conexion.setAutoCommit(false);
            while ((line = br.readLine()) != null){
                todo += line + "\n";
            }
            procedures = todo.split(separador);
            for (String p : procedures){
                PreparedStatement exe = conexion.prepareStatement(p);
                exe.executeUpdate();
            }
//            String drop = "drop procedure if exists sp_eliminarcliente; ";
//            String procedure = "CREATE PROCEDURE sp_eliminarcliente(IN idcliente varchar(9)) " +
//                    "BEGIN " +
//                    "UPDATE t_clientes SET existe = 0 where DNI like idcliente; " +
//                    "END";
//            PreparedStatement exe = conexion.prepareStatement(procedure);
//            exe.executeUpdate();
//            exe = conexion.prepareStatement(drop);
//            exe.executeUpdate();
            conexion.commit();
            conexion.setAutoCommit(true);
            br.close();
            return true;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("NO PROCEDURES");
            try {
                conexion.rollback();
                conexion.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        }
    }

    private boolean insertarDatos(){
        String ruta = System.getProperty("user.dir") + File.separator + "INSERTS.txt";
        File inserts = new File(ruta);

        try {
            FileReader fr = new FileReader(inserts);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            conexion.setAutoCommit(false);
            while ((line = br.readLine()) != null){
                PreparedStatement exe = conexion.prepareStatement(line);
                exe.executeUpdate();
            }
            conexion.commit();
            conexion.setAutoCommit(true);
            return true;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
                conexion.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
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
        if(establecerConexionComprobar()){
            try {
                Statement s = conexion.createStatement();
                ResultSet r = s.executeQuery("SELECT contrasena,nivelPermiso from t_usuarios where nick='"+nombreUsuario+"'");
                if(r.next()) {
                    if(contrasena.equals(r.getString("Contrasena"))){
                        return r.getInt("nivelPermiso");
                    }else{
                        return -3;
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
