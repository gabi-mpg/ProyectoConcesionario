package entidades;

public class Usuario {

    private String nick;
    private String nombre;
    private String apellidos;
    private String contra;
    private int permiso;

    public Usuario(String nick, String nombre, String apellidos, String contra, int permiso) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contra = contra;
        this.permiso = permiso;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }
}
