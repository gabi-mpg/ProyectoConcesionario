package models;

import controllers.ControllerConexion;
import entidades.Cliente;
import entidades.Moto;
import entidades.Venta;
import models.ClienteModel;
import models.MotoModel;

import java.sql.*;
import java.util.ArrayList;

public class VentaModel {

    private ArrayList<Venta> listaVentas;
    private ControllerConexion cnControl;
    private ClienteModel modelC;
    private MotoModel modelM;
    private Connection conexion;

    public VentaModel(){
        listaVentas = new ArrayList<>();
        cnControl = new ControllerConexion();
        modelC = new ClienteModel();
        modelM = new MotoModel();
        conexion = cnControl.conectar();
        saveVentas();
    }

    private void saveVentas(){
        listaVentas.clear();
        String sql = "SELECT * FROM t_ventas";

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                int idVenta = rs.getInt("IDVenta");
                String matricula = rs.getString("Matricula");
                String dni = rs.getString("DNI");
                float precio = rs.getFloat("Precio");
                String idVendedor = rs.getString("IDVendedor");
                int existe = rs.getInt("existe");
                Venta venta = new Venta(idVenta, matricula, dni, precio, idVendedor, existe);
                listaVentas.add(venta);
            }
//            for(Venta v : listaVentas){
//                System.out.println(v.toString());
//            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Venta buscarVenta(String pk){
        //saveVentas();
        for(Venta v : listaVentas){
            if (v.getMatricula().equals(pk)){
                return v;

            }
        }
        return null;
    }

    public Venta buscarVenta(int pk){
        //saveVentas();
        for(Venta v : listaVentas){
            if (v.getIdVenta() == (pk)){
                return v;
            }
        }
        return null;
    }

    public ArrayList<Venta> buscarVentasCliente(String dni){
        ArrayList<Venta> listaVCliente = new ArrayList<>();
        for (Venta v : listaVentas){
            if (v.getDni().equalsIgnoreCase(dni)){
                listaVCliente.add(v);
            }
        }
        return  listaVCliente;
    }

    public ArrayList<Venta> buscarVentasNick(String nick){
        ArrayList<Venta> listaVCliente = new ArrayList<>();
        for (Venta v : listaVentas){
            if (v.getIdVendedor().equalsIgnoreCase(nick)){
                listaVCliente.add(v);
            }
        }
        return  listaVCliente;
    }

    public boolean ventaExiste(String pk){
        return buscarVenta(pk) != null;
    }

    public boolean ventaExiste(int pk){
        return buscarVenta(pk) != null;
    }



    public ArrayList<Venta> getListaVentas(){
        saveVentas();
        return listaVentas;
    }

    public boolean buscarExistencia(String matricula, String dni){
        return modelM.motoExiste(matricula) && modelC.clienteExiste(dni);
    }

    public Moto buscarMoto(String matricula){
        return modelM.buscarMoto(matricula);
    }

    public Cliente buscarCliente(String DNI){
        return modelC.buscarCliente(DNI);
    }
    public void addVenta(Venta venta){
        //saveVentas();
        String sql = "INSERT INTO t_ventas (Matricula, DNI, Precio, IDVendedor, existe) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, venta.getMatricula());
            pst.setString(2, venta.getDni());
            pst.setDouble(3, venta.getPrecio());
            pst.setString(4, venta.getIdVendedor());//esto no lo pediremos al usuario
            pst.setInt(5,1);
            //sino que lo mandaremos directamente segun quien haya iniciado sesion
            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando la venta: " + e);
        }

        getListaVentas();
    }

    //Cambiar a cero removeVEntas
    /*public boolean removeVenta(int pk){
        saveVentas();
        String sql = "delete from t_ventas where IDVenta = ?";
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
    }*/

    public boolean removeVenta(String pk){
        //saveVentas();
        String sql = "{call sp_eliminarVenta(?)}";
        try {
            CallableStatement cst = conexion.prepareCall(sql);
            cst.setString(1, pk);
            cst.execute();
            //updateExiste(0, pk);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public void updateExiste(int exists, int pk){
        Venta venta = buscarVenta(pk);
        venta.setExiste(exists);
        updateVentaLista(venta);
        updateVenta(venta);
    }

    public boolean updateVenta(Venta venta){
        //saveVentas();
        String sql = "UPDATE t_ventas set Precio = ?, existe = ? where IDVenta = ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setDouble(1, venta.getPrecio());
            pst.setInt(2, 1);
            pst.setInt(3, venta.getIdVenta());
            pst.executeUpdate();
            updateVentaLista(venta);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean cambiarExiste(Venta venta){
        //saveVentas();
        String sql = "UPDATE t_ventas set existe = ? where Matricula = ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, venta.isExiste());
            pst.setString(2, venta.getMatricula());
            pst.executeUpdate();
            updateVentaLista(venta);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    private void updateVentaLista(Venta venta){
        for (Venta v : listaVentas){
            if (v.getIdVenta() == venta.getIdVenta()){
                v.setMatricula(venta.getMatricula());
                v.setDni(venta.getDni());
                v.setPrecio(venta.getPrecio());
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
