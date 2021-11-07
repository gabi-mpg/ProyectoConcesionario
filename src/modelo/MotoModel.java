package modelo;

import controllers.ControllerConexion;
import entidades.Moto;

import java.sql.*;
import java.util.ArrayList;

public class MotoModel{

    private static ArrayList<Moto> listaMotos;
    private static ControllerConexion cnControl;
    private static Connection conexion;

    public MotoModel(){
        this.listaMotos = new ArrayList<>();
        this.cnControl = new ControllerConexion();
        this.conexion = cnControl.getConexion();
    }

    private static void saveMotos(){
        listaMotos.clear();
        String sql = "SELECT * FROM t_moto";

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                String matricula = rs.getString("Matricula");
                String color = rs.getString("Color");
                String marca = rs.getString("Marca");
                int tanque = rs.getInt("Tanque");
                Moto moto = new Moto(matricula, marca, color, tanque);
                listaMotos.add(moto);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static Moto buscarMoto(String pk){
        for(Moto m : listaMotos){
            if (m.getMatricula().equalsIgnoreCase(pk)){
                return m;
            }
        }

        return null;
    }

    public static ArrayList<Moto> getListaMotos(){
        saveMotos();
        return listaMotos;
    }

    public static ArrayList<Moto> addMoto(Moto moto){
        String sql = "INSERT INTO t_moto values (?, ?, ?, ?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, moto.getMatricula());
            pst.setString(2, moto.getMarca());
            pst.setString(3, moto.getColor());
            pst.setInt(4, moto.getTanque());

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando la moto. " + e);
        }

        return getListaMotos();
    }

}
