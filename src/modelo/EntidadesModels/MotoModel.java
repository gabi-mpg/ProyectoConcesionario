package modelo.EntidadesModels;

import controllers.ControllerConexion;
import entidades.Moto;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class MotoModel{

    private ArrayList<Moto> listaMotos;
    private ControllerConexion cnControl;
    private Connection conexion;

    public MotoModel(){
        listaMotos = new ArrayList<>();
        cnControl = new ControllerConexion();
        conexion = cnControl.conectar();
        saveMotos();
    }

    private void saveMotos(){
        listaMotos.clear();
        String sql = "SELECT * FROM t_motos";

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                String matricula = rs.getString("Matricula");
                String color = rs.getString("Color");
                String marca = rs.getString("Marca");
                int tanque = rs.getInt("Tanque");
                int existe = rs.getByte("existe");
                Moto moto = new Moto(matricula, marca, color, tanque, existe);
                listaMotos.add(moto);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Moto buscarMoto(String pk){
        saveMotos();
        for(Moto m : listaMotos){
            if (m.getMatricula().equalsIgnoreCase(pk)){
                return m;
            }
        }
        return null;
    }

    public boolean motoExiste(String pk){
        return buscarMoto(pk) != null;
    }


    public ArrayList<Moto> getListaMotos(){
        saveMotos();
        return listaMotos;
    }

    public void addMoto(Moto moto){
        saveMotos();
        String sql = "INSERT INTO t_motos (Matricula, Marca, Color, Tanque, existe) values (?, ?, ?, ?,?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, moto.getMatricula());
            pst.setString(2, moto.getMarca());
            pst.setString(3, moto.getColor());
            pst.setInt(4, moto.getTanque());
            pst.setInt(5,moto.isExiste());

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando la moto. " + e);
        }

        getListaMotos();
    }

    /*public boolean removeMoto(String matricula){
        saveMotos();
        String sql = "delete from t_motos where matricula like ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, matricula);
            pst.executeUpdate();
            listaMotos.removeIf(m -> m.getMatricula().equalsIgnoreCase(matricula));
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }*/

    public boolean removeMoto(String matricula){
        saveMotos();
        String sql = "{call sp_eliminarmoto(?)}";
        try {
            CallableStatement cst = conexion.prepareCall(sql);
            cst.setString(1, matricula);
            cst.execute();
            updateExiste(0, matricula);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public void updateExiste(int exists, String matricula){
        Moto moto = buscarMoto(matricula);
        moto.setExiste(exists);
        updateMotoLista(moto);
        updateMoto(moto);
    }

    public boolean updateMoto(Moto moto){
        saveMotos();
        String sql = "UPDATE t_motos set Marca = ?, Color = ?, Tanque = ?, existe = ? where matricula like ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, moto.getMarca());
            pst.setString(2, moto.getColor());
            pst.setInt(3, moto.getTanque());
            pst.setString(5, moto.getMatricula());
            pst.setInt(4, moto.isExiste());
            pst.executeUpdate();
            updateMotoLista(moto);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    private void updateMotoLista(Moto moto){
        for (Moto m : listaMotos){
            if (m.getMatricula().equalsIgnoreCase(moto.getMatricula())){
                m.setColor(moto.getColor());
                m.setMarca(moto.getMarca());
                m.setTanque(moto.getTanque());
                m.setExiste(moto.isExiste());
            }
        }
    }

    public void conectar(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/concesionario?useSSL=false", "root", "");
        }catch(SQLException e){
            System.err.println("Error en la conexión local " + e);
        }
    }
}
