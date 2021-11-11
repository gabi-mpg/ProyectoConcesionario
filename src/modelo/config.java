package modelo;



import java.io.*;
import java.nio.Buffer;


public class config implements Serializable{



    public File ficheroConfig;
    private File ficheroTema;
    private String[] informacion = {"-", "-", "-"};
    private boolean modoNocturno;
    public final String NOCTURNO_ACTIVADO = "true";
    public final String NOCTURNO_DESACTIVADO = "false";

    public config() {
        String RUTA_CONFIG = System.getProperty("user.dir") + File.separator + "config.dat";
        String RUTA_CONFIGTEMA = System.getProperty("user.dir") + File.separator + "temaNocturno.txt";
        this.ficheroConfig = new File(RUTA_CONFIG);
        this.ficheroTema = new File(RUTA_CONFIGTEMA);
        configuracionInicial();
        configuracionTema();
    }

    private void configuracionTema(){
        if(!ficheroTema.exists()){
            try{
                ficheroTema.createNewFile();
                BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroTema));
                escritor.write("false");
                this.modoNocturno = false;
                escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
                this.modoNocturno = false;
            }
        }else{
            try {
                BufferedReader lector = new BufferedReader(new FileReader(ficheroTema));
                String s = lector.readLine();
                if(s.equals(NOCTURNO_DESACTIVADO)){
                    this.modoNocturno = false;
                }else{
                    this.modoNocturno = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public String getModoNocturno(){
        try {
            BufferedReader lector = new BufferedReader(new FileReader(ficheroTema));
            String s = lector.readLine();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setModoNocturno(String activo){
        if(activo.equals(NOCTURNO_ACTIVADO)){
            escribirFicheroTema(NOCTURNO_ACTIVADO);
        }else{
            escribirFicheroTema(NOCTURNO_DESACTIVADO);
        }

    }

    private void escribirFicheroTema(String modo){
        BufferedWriter escritor = null;
        try {
            escritor = new BufferedWriter(new FileWriter(ficheroTema));
            escritor.write(modo);
            escritor.close();
            if(modo.equals(NOCTURNO_ACTIVADO)){
                this.modoNocturno = true;
            }else{
                this.modoNocturno = false;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

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
