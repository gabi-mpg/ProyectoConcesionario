package entidades;

public class Venta {

    private String matricula;
    private String dni;
    private double precio;
    private int idVendedor;

    public Venta(String matricula, String dni, double precio, int idVendedor) {
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

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
}
