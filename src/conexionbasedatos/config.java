package conexionbasedatos;



import java.io.*;


public class config implements Serializable{


    private final String RUTA_CONFIG =
            System.getProperty("user.dir") + File.separator + "config"
                    + File.separator + "config.dat";
    public File ficheroConfig;
    private String[] informacion = {"-", "-", "-"};

    public config() {
        this.ficheroConfig = new File(RUTA_CONFIG);
    }

    public String[] configuracionInicial() {
        try {
            if (!this.ficheroConfig.exists()) {
                ficheroConfig.createNewFile();
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheroConfig));
                os.writeObject(informacion);
                os.close();
                return informacion;
            } else {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(ficheroConfig));
                return (String[]) is.readObject();
            }
        } catch (Exception e) {
            return informacion;
        }
    }

    public boolean escribirFichero(String[] info) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheroConfig));
            os.writeObject(info);
            os.close();
            return true;
        } catch (Exception e) {
            return  false;
        }
    }

    public String[] getConfig(){
        return this.informacion;
    }

    public void setConfig(String[] informacion){
        escribirFichero(informacion);
        this.informacion = informacion;
    }
}
