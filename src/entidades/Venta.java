package entidades;

import java.util.Comparator;

public class Venta implements Comparator<Venta> {

    private String matricula;
    private String dni;
    private double precio;
    private String idVendedor;
    private int idVenta;
    private int existe;

    public Venta(){

    }
    public Venta(int idVenta, String matricula, String dni, double precio, String idVendedor, int existe) {
        this.idVenta = idVenta;
        this.matricula = matricula;
        this.dni = dni;
        this.precio = precio;
        this.idVendedor = idVendedor;
        this.existe = existe;
    }

    public Venta(String matricula, String dni, double precio, String idVendedor, int existe) {
        this.matricula = matricula;
        this.dni = dni;
        this.precio = precio;
        this.idVendedor = idVendedor;
        this.existe = existe;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int isExiste() {
        return existe;
    }

    public void setExiste(int existe) {
        this.existe = existe;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "matricula='" + matricula + '\'' +
                ", dni='" + dni + '\'' +
                ", precio=" + precio +
                ", idVendedor=" + idVendedor +
                '}';
    }

    @Override
    public int compare(Venta v1, Venta v2) {
        return String.valueOf(v1.getIdVenta()).compareTo(String.valueOf(v2.getIdVenta()));
    }
}
