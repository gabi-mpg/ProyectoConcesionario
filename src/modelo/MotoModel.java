package modelo;

import controllers.ControllerConexion;
import entidades.Moto;

import java.sql.*;
import java.util.ArrayList;

public class MotoModel{

    private static ArrayList<Moto> listaMotos = new ArrayList<>();
    private static ControllerConexion cnControl = new ControllerConexion();
    private static Connection conexion;

    public MotoModel(){
        listaMotos = new ArrayList<>();
        cnControl = new ControllerConexion();
        conexion = cnControl.getConexion();
        //conexion = conectar();
        saveMotos();
    }

    private static void saveMotos(){
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
                Moto moto = new Moto(matricula, marca, color, tanque);
                listaMotos.add(moto);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static Moto buscarMoto(String pk){
        saveMotos();
        for(Moto m : listaMotos){
            if (m.getMatricula().equalsIgnoreCase(pk)){
                return m;
            }
        }
        return null;
    }

    public static boolean motoExiste(String pk){
        return buscarMoto(pk) != null;
    }

    public static void listarMoto(String pk){
        if (buscarMoto(pk) != null){
            System.out.println(buscarMoto(pk).toString());
        } else{
            System.out.println("La moto no existe en la bd");
        }

    }

    public static ArrayList<Moto> getListaMotos(){
        saveMotos();
        return listaMotos;
    }

    public static void addMoto(Moto moto){
        saveMotos();
        String sql = "INSERT INTO t_motos values (?, ?, ?, ?)";
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

        getListaMotos();
    }

    public static boolean removeMoto(String matricula){
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
    }

    public static boolean updateMoto(Moto moto){
        System.out.println(moto.toString());
        saveMotos();
        String sql = "UPDATE t_motos set Marca = ?, Color = ?, Tanque = ? where matricula like ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, moto.getMarca());
            pst.setString(2, moto.getColor());
            pst.setInt(3, moto.getTanque());
            pst.setString(4, moto.getMatricula());
            pst.executeUpdate();
            updateMotoLista(moto);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    private static void updateMotoLista(Moto moto){
        for (Moto m : listaMotos){
            if (m.getMatricula().equalsIgnoreCase(moto.getMatricula())){
                m.setColor(moto.getColor());
                m.setMarca(moto.getMarca());
                m.setTanque(moto.getTanque());
            }
        }
    }

    public static void conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/concesionario?useSSL=false", "root", "");
            conexion = cn;
        }catch(SQLException e){
            System.err.println("Error en la conexión local " + e);
        }
    }

    public static void main(String[] args) {
        Moto moto = new Moto("0677fwj", "ducati", "roja", 70);
        addMoto(moto);
        listarMoto("0677fwj");
        moto.setColor("blanco");
        updateMoto(moto);
        //removeMoto("0677fwj");
        listarMoto("0677fwj");
    }

}
