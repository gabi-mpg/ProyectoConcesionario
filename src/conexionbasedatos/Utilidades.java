/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbasedatos;

import java.awt.Image;
import javax.swing.ImageIcon;


/**
 *
 * @author chris
 */
public class Utilidades {
 
    public static ImageIcon reescalarImagen(ImageIcon imagen, int h, int w){
        Image reescalada = imagen.getImage();
        return new ImageIcon(reescalada.getScaledInstance(h, w, Image.SCALE_SMOOTH));
    }
    
    
}
