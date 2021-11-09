package modelo;

import controllers.ControllerConexion;
import entidades.Venta;

import java.sql.*;
import java.util.ArrayList;

public class VentaModel {

    private static ArrayList<Venta> listaVentas = new ArrayList<>();
    private static ControllerConexion cnControl = new ControllerConexion();
    private static Connection conexion;

    public VentaModel(){
        listaVentas = new ArrayList<>();
        cnControl = new ControllerConexion();
        conexion = cnControl.getConexion();
        //conexion = conectar();
        saveVentas();
    }

    private static void saveVentas(){
        listaVentas.clear();
        String sql = "SELECT * FROM t_ventas";

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                int idVenta = rs.getInt("IDVenta");
                String matricula = rs.getString("Matricula");
                String dni = rs.getString("DNI");
                double precio = rs.getDouble("Precio");
                int idVendedor = rs.getInt("IDVendedor");
                Venta venta = new Venta(idVenta, matricula, dni, precio, idVendedor);
                listaVentas.add(venta);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static Venta buscarVenta(int pk){
        saveVentas();
        for(Venta v : listaVentas){
            if (v.getIdVendedor() == pk){
                return v;
            }
        }
        return null;
    }

    public static void listarVenta(int pk){
        if (buscarVenta(pk) != null){
            System.out.println(buscarVenta(pk).toString());
        } else{
            System.out.println("La venta no existe en la bd");
        }

    }

    public static ArrayList<Venta> getListaVentas(){
        saveVentas();
        return listaVentas;
    }

    public static boolean buscarExistencia(String matricula, String dni){
        return MotoModel.motoExiste(matricula) && ClienteModel.clienteExiste(dni);
    }

    public static void addVenta(Venta venta){
        saveVentas();
        String sql = "INSERT INTO t_ventas values (?, ?, ?, ?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, venta.getMatricula());
            pst.setString(2, venta.getDni());
            pst.setDouble(3, venta.getPrecio());
            pst.setInt(4, venta.getIdVendedor());//esto no lo pediremos al usuario
            //sino que lo mandaremos directamente segun quien haya iniciado sesion

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando la venta. " + e);
        }

        getListaVentas();
    }

    public static boolean removeVenta(int pk){
        saveVentas();
        String sql = "delete from t_ventas where pk = ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, pk);
            pst.executeUpdate();
            listaVentas.removeIf(v -> v.getIdVenta() == (pk));
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean updateVenta(Venta venta){
        System.out.println(venta.toString());
        saveVentas();
        String sql = "UPDATE t_ventas set Matricula = ?, DNI = ?, Precio = ? where IDVenta = ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, venta.getMatricula());
            pst.setString(2, venta.getDni());
            pst.setDouble(3, venta.getPrecio());
            pst.setInt(4, venta.getIdVenta());
            pst.executeUpdate();
            updateVentaLista(venta);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    private static void updateVentaLista(Venta venta){
        for (Venta v : listaVentas){
            if (v.getIdVenta() == venta.getIdVenta()){
                v.setMatricula(venta.getMatricula());
                v.setDni(venta.getDni());
                v.setPrecio(venta.getPrecio());
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
}
