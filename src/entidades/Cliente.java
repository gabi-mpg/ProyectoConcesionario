package entidades;

public class Cliente {

    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private int existe;

    public Cliente(String dni, String nombre, String apellido, String direccion, int existe) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.existe = existe;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getExiste() {
        return existe;
    }

    public void setExiste(int existe) {
        this.existe = existe;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
