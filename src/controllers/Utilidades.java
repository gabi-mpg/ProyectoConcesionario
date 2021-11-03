/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Component;

import java.awt.Image;
import javax.swing.*;


/**
 *
 * @author chris
 */
public class Utilidades {
 
    public static ImageIcon reescalarImagen(ImageIcon imagen, int h, int w){
        Image reescalada = imagen.getImage();
        return new ImageIcon(reescalada.getScaledInstance(h, w, Image.SCALE_SMOOTH));
    }

    /**
     *
     * @param parent
     * @param titulo
     * @param mensaje
     * @param tipoMensaje 0 - Error, 1 - Informacion, 2 - Aviso, 3 - Pregunta
     */
    public static void jMensaje(Component parent, String titulo, String mensaje, int tipoMensaje){
        switch (tipoMensaje){
            case 0:
                JOptionPane.showMessageDialog(parent,titulo,mensaje, JOptionPane.ERROR_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(parent,titulo,mensaje, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(parent,titulo,mensaje, JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(parent,titulo,mensaje, JOptionPane.QUESTION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(parent,titulo,mensaje, JOptionPane.PLAIN_MESSAGE);
                break;
        }

    }




}
