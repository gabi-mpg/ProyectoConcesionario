package modelo;



import java.io.*;


public class config implements Serializable{

    private static final long serialVersionUID = 8799656478674716638L;

    public File ficheroConfig;
    private String[] informacion = {"-", "-", "-"};

    public config() {
        String RUTA_CONFIG = System.getProperty("user.dir") + File.separator + "config.dat";
        this.ficheroConfig = new File(RUTA_CONFIG);
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
