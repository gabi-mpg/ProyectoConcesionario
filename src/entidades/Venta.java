package entidades;

public class Venta {

    private String matricula;
    private String dni;
    private double precio;
    private String idVendedor;
    private int idVenta;

    public Venta(int idVenta, String matricula, String dni, double precio, String idVendedor) {
        this.idVenta = idVenta;
        this.matricula = matricula;
        this.dni = dni;
        this.precio = precio;
        this.idVendedor = idVendedor;
    }

    public Venta(String matricula, String dni, double precio, String idVendedor) {
        this.matricula = matricula;
        this.dni = dni;
        this.precio = precio;
        this.idVendedor = idVendedor;
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

    @Override
    public String toString() {
        return "Venta{" +
                "matricula='" + matricula + '\'' +
                ", dni='" + dni + '\'' +
                ", precio=" + precio +
                ", idVendedor=" + idVendedor +
                '}';
    }
}
