package entidades;

public class Moto {

    private String matricula;
    private String marca;
    private String color;
    private int tanque;

    public Moto(String matricula, String marca, String color, int tanque) {
        this.matricula = matricula;
        this.marca = marca;
        this.color = color;
        this.tanque = tanque;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTanque() {
        return tanque;
    }

    public void setTanque(int tanque) {
        this.tanque = tanque;
    }
}
