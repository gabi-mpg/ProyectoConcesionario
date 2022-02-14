package models;



import java.io.*;


public class Config implements Serializable{



    public File ficheroConfig;
    private File ficheroTema;
    private String[] informacion = {"-", "-", "-"};
    private boolean modoNocturno;
    public final String NOCTURNO_ACTIVADO = "true";
    public final String NOCTURNO_DESACTIVADO = "false";

    public Config() {
        String RUTA_CONFIG = System.getProperty("user.dir") + File.separator + "config.dat";
        String RUTA_CONFIGTEMA = System.getProperty("user.dir") + File.separator + "temaNocturno.txt";
        this.ficheroConfig = new File(RUTA_CONFIG);
        this.ficheroTema = new File(RUTA_CONFIGTEMA);
        configuracionInicial();
    }

    public void configuracionInicial() {
        try {
            if (!this.ficheroConfig.exists()) {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheroConfig));
                os.writeObject(informacion);
                os.close();
            } else {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(ficheroConfig));
                this.informacion = (String[]) is.readObject();
                is.close();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void escribirFichero(String[] info) {
        try {
            this.informacion = info;
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheroConfig));
            os.writeObject(info);
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String[] getConfig(){
        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream(ficheroConfig));
            this.informacion = (String[]) is.readObject();
            return this.informacion;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return this.informacion;
        }
    }

    public void setConfig(String[] informacion){//ESTE NUNCA SE USA
        escribirFichero(informacion);
        this.informacion = informacion;
    }
}
