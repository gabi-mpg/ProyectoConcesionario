package conexionbasedatos;



import java.io.*;


public class config implements Serializable{


    private final String RUTA_CONFIG =
            System.getProperty("user.dir") + File.separator + "config.dat";
    public File ficheroConfig;
    private String[] informacion = {"-", "-", "-"};

    public config() {
        this.ficheroConfig = new File(RUTA_CONFIG);
        configuracionInicial();
    }

    public void configuracionInicial() {
        try {
            if (!this.ficheroConfig.exists()) {
                ficheroConfig.createNewFile();
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheroConfig));
                os.writeObject(informacion);
                os.close();
            } else {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(ficheroConfig));
                this.informacion = (String[]) is.readObject();
                is.close();
            }
        } catch (EOFException e){
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean escribirFichero(String[] info) {
        try {
            this.informacion = info;
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheroConfig));
            os.writeObject(info);
            os.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return  false;
        }
    }

    public String[] getConfig(){
        ObjectInputStream is = null;
        try {
            is = new ObjectInputStream(new FileInputStream(ficheroConfig));
            this.informacion = (String[]) is.readObject();
            return this.informacion;
        } catch (IOException e) {
            e.printStackTrace();
            return this.informacion;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return this.informacion;
        }

    }

    public void setConfig(String[] informacion){
        escribirFichero(informacion);
        this.informacion = informacion;
    }
}
